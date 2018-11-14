package com.learn.core.service;

import com.learn.core.domain.BaseDomain;
import com.learn.core.dao.IBaseRepository;
import com.learn.core.dto.SearchType;
import com.learn.core.enums.NoYesEnum;
import com.learn.core.utils.BeanUtils;
import com.learn.core.utils.DateUtils;
import com.learn.core.utils.ParamUtils;
import com.learn.core.utils.ReflectUtils;
import com.learn.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
public abstract class BaseService<T extends BaseDomain> {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    protected IBaseRepository<T, ? extends Serializable> repository;
    private Map<String, Field> FIELE_CACHE = new HashMap<>();

    /**
     * 获取EntityManager对象
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    private <Y extends Comparable<? super Y>> Y getSearchValue(Class<Y> clazz, String value) {
        Y val;
        if (clazz.equals(Date.class)) {
            val = (Y) DateUtils.parseDate(value);
        } else if (clazz.equals(Integer.class)) {
            val = (Y) Integer.valueOf(value);
        } else if (clazz.equals(Long.class)) {
            val = (Y) Long.valueOf(value);
        } else {
            val = (Y) value;
        }
        return val;
    }

    private <Y extends Comparable<? super Y>> List<Y> getSearchList(Class<Y> clazz, String value) {
        List<Y> list = new ArrayList<>();
        if (value.indexOf(",") > -1) {
            Arrays.asList(value.split(",")).forEach(val -> list.add(getSearchValue(clazz, val)));
        }
        return list;
    }

    /**
     * 获取查询条件
     *
     * @return
     */
    public Specification<T> getSpecification(Map<String, String> params) {
        Class thatClazz = getClass();
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                // 初始化字段值的缓存
                if (FIELE_CACHE.size() == 0) {
                    Class clazz = ReflectUtils.getFieldGeneric(thatClazz);
                    FIELE_CACHE.putAll(ReflectUtils.getClassFieldCache(clazz));
                }
                // 初始化查询条件
                if (params != null) {
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        if (StringUtils.isNotEmpty(entry.getValue())) {
                            SearchType type = ParamUtils.getFieldName(entry.getKey());
                            if (type.getSearch()) {
                                Field field = FIELE_CACHE.get(type.getField());
                                Class fieldClazz = field.getType();
                                Path<String> x = root.get(type.getField());
                                String value = entry.getValue();
                                switch (type.getType()) {
                                    case ParamUtils.EQ:
                                        predicates.add(criteriaBuilder.equal(x, entry.getValue()));
                                        break;
                                    case ParamUtils.NOT:
                                    case ParamUtils.NE:
                                    case ParamUtils.NEQ:
                                        predicates.add(criteriaBuilder.notEqual(x, value));
                                        break;
                                    case ParamUtils.GT:
                                        predicates.add(criteriaBuilder.greaterThan(x.as(fieldClazz), getSearchValue(fieldClazz, value)));
                                        break;
                                    case ParamUtils.LT:
                                        predicates.add(criteriaBuilder.lessThan(x.as(fieldClazz), getSearchValue(fieldClazz, value)));
                                        break;
                                    case ParamUtils.GTE:
                                    case ParamUtils.GE:
                                        predicates.add(criteriaBuilder.greaterThanOrEqualTo(x.as(fieldClazz), getSearchValue(fieldClazz, value)));
                                        break;
                                    case ParamUtils.LTE:
                                    case ParamUtils.LE:
                                        predicates.add(criteriaBuilder.lessThanOrEqualTo(x.as(fieldClazz), getSearchValue(fieldClazz, value)));
                                        break;
                                    case ParamUtils.NULL:
                                        predicates.add(criteriaBuilder.isNull(x));
                                        break;
                                    case ParamUtils.LIKE:
                                        predicates.add(criteriaBuilder.like(x, type.getLeft() + value + type.getRight()));
                                        break;
                                    case ParamUtils.L_LIKE:
                                        predicates.add(criteriaBuilder.like(x, type.getLeft() + value));
                                        break;
                                    case ParamUtils.R_LIKE:
                                        predicates.add(criteriaBuilder.like(x, value + type.getRight()));
                                        break;
                                    case ParamUtils.OR:
                                        String filed = entry.getValue();
                                        if (filed.indexOf(",") <= 0) {
                                            break;
                                        }
                                        String filed1 = filed.substring(0, filed.indexOf(","));
                                        String filed2 = filed.substring(filed.indexOf(",") + 1);
                                        predicates.add(criteriaBuilder.or(criteriaBuilder.equal(x, filed1), criteriaBuilder.equal(x, filed2)));
                                        break;
                                    case ParamUtils.IN:
                                        predicates.add(criteriaBuilder.in(x.as(fieldClazz)).value(getSearchList(fieldClazz, value)));
                                        break;
                                }
                            }
                        } else {
                            if (FIELE_CACHE.containsKey(entry.getKey())) {
                                predicates.add(criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue()));
                            }
                        }
                    }
                }

                predicates.add(criteriaBuilder.equal(root.get("isDelete"), NoYesEnum.NO.ordinal()));
                criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

    /**
     * 通过id获取查询条件
     *
     * @return
     */
    public Specification getSpecification() {
        return getSpecification(null);
    }

    /**
     * 查询所有数据，并排序
     *
     * @param params
     * @param sort
     * @return
     */
    public List<T> list(Map<String, String> params, Sort sort) {
        return findAll(getSpecification(params), sort);
    }

    /**
     * 查询所有数据并排序
     *
     * @param params
     * @return
     */
    public List<T> list(Map<String, String> params) {
        return findAll(getSpecification(params));
    }

    /**
     * 分页查询数据
     *
     * @param params
     * @param pageable
     * @return
     */
    public Page<T> list(Map<String, String> params, Pageable pageable) {
        return findAll(getSpecification(params), pageable);
    }

    /**
     * 根据id查找对象
     *
     * @param id
     * @return
     */
    public T findOne(String id) {
        return repository.findByIdAndIsDelete(id, NoYesEnum.NO.ordinal());
    }

    /**
     * 根据复杂条件查找对象
     *
     * @param params
     * @return
     */
    public T findOne(Map<String, String> params) {
        List<T> result = findAll(params);
        return result != null ? (result.size() > 0 ? result.get(0) : null) : null;
    }

    /**
     * 根据复杂条件查找对象
     *
     * @param spec
     * @return
     */
    public T findOne(Specification<T> spec) {
        List<T> result = findAll(spec);
        return result != null ? (result.size() > 0 ? result.get(0) : null) : null;
    }

    /**
     * 通过Id查询数据
     *
     * @param ids
     * @return
     */
    public List<T> findAll(Iterable<String> ids) {
        return repository.findByIdInAndIsDelete(ids, NoYesEnum.NO.ordinal());
    }

    /**
     * 查找所有数据
     *
     * @return
     */
    public List<T> findAll(Map<String, String> params) {
        return findAll(getSpecification(params));
    }

    /**
     * 查找所有数据
     *
     * @return
     */
    public List<T> findAll(Specification<T> spec) {
        return repository.findAll(spec);
    }

    /**
     * 根据条件排序查找
     *
     * @param sort
     * @return
     */
    public List<T> findAll(Specification<T> spec, Sort sort) {
        return repository.findAll(spec, sort);
    }

    /**
     * 根据条件分页查找
     *
     * @return
     */
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        return repository.findAll(spec, pageable);
    }

    /**
     * 查找所有数据
     *
     * @return
     */
    public List<T> findAll() {
        return repository.findAll(getSpecification());
    }

    /**
     * 根据条件排序查找
     *
     * @param sort
     * @return
     */
    public List<T> findAll(Sort sort) {
        return repository.findAll(getSpecification(), sort);
    }

    /**
     * 根据条件分页查找
     *
     * @param pageable
     * @return
     */
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(getSpecification(), pageable);
    }

    /**
     * 单个保存
     *
     * @param object
     * @return
     */
    public T save(T object) {
        if (object.getId() != null) {
            return update(object);
        }
        object.setIsDelete(NoYesEnum.NO.ordinal());
        return (T) repository.save(object);
    }

    /**
     * 保存并持久化到数据库
     *
     * @param object
     * @return
     */
    public T saveAndFlush(T object) {
        object.setIsDelete(NoYesEnum.NO.ordinal());
        return (T) repository.saveAndFlush(object);
    }

    /**
     * 批量保存
     *
     * @param iterable
     * @return
     */
    public List<T> save(Iterable<T> iterable) {
        for (T t : iterable) {
            t.setIsDelete(NoYesEnum.NO.ordinal());
        }
        return repository.saveAll(iterable);
    }

    /**
     * 单个更新
     *
     * @param t
     * @return
     */
    public T update(T t) {
        if (t == null) {
            return t;
        }

        String id = t.getId();
        T findT = findOne(id);

        if (findT == null) {
            return findT;
        }

        BeanUtils.beanCopy(t, findT);

        return repository.save(findT);
    }

    /**
     * 批量更新
     *
     * @param iterable
     */
    public Iterable<T> update(Iterable<T> iterable) {
        for (T t : iterable) {
            update(t);
        }
        return iterable;
    }

    /**
     * 根据条件进行逻辑删除
     *
     * @param params
     * @return
     */
    public List<T> logicalDelete(Map<String, String> params) {
        List<T> iterable = findAll(getSpecification(params));
        for (T t : iterable) {
            logicalDelete(t);
        }
        return iterable;
    }

    /**
     * 根据对象进行逻辑删除
     *
     * @param iterable
     * @return
     */
    public Iterable<String> logicalDelete(Iterable<String> iterable) {
        for (String id : iterable) {
            logicalDelete(id);
        }
        return iterable;
    }

    /**
     * 根据主键进行逻辑删除
     *
     * @param id
     * @return
     */
    public T logicalDelete(String id) {
        T t = findOne(id);
        return logicalDelete(t);
    }

    /**
     * 根据对象进行逻辑删除
     *
     * @param t
     * @return
     */
    public T logicalDelete(T t) {
        if (t == null) {
            return t;
        }
        t.setIsDelete(NoYesEnum.YES.ordinal());
        return repository.save(t);
    }

    /**
     * 根据条件判断对象是否存在
     *
     * @param params
     * @return
     */
    public Boolean exists(Map<String, String> params) {
        T t = findOne(params);
        if (t == null) {
            return false;
        }
        return true;
    }

    /**
     * 根据条件判断对象是否存在
     *
     * @param spec
     * @return
     */
    public Boolean exists(Specification<T> spec) {
        T t = findOne(spec);
        if (t == null) {
            return false;
        }
        return true;
    }

    /**
     * 对应表id是否存在
     *
     * @param id
     * @return
     */
    public Boolean exists(String id) {
        T t = findOne(id);
        if (t == null) {
            return false;
        }
        return true;
    }

    /**
     * 根据条件查询数据总条数
     *
     * @param params
     * @return
     */
    public Long count(Map<String, String> params) {
        return repository.count(getSpecification(params));
    }

    /**
     * 根据条件查询数据总条数
     *
     * @param spec
     * @return
     */
    public Long count(Specification<T> spec) {
        return repository.count(spec);
    }

    /**
     * 对应表数据总条数
     *
     * @return
     */
    public Long count() {
        return repository.count(getSpecification());
    }

    /**
     * 持久化数据到数据库
     */
    public void flush() {
        repository.flush();
    }

}
