package com.learn.core.web;

import com.learn.core.domain.BaseDomain;
import com.learn.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;

/**
 * <p>@Title: IntelliJ IDEA.</p>
 * Description:
 * Date: 2017/1/7 0007
 * Time: 20:13
 *
 * @author Administrator
 * @version 1.0
 */
public class BaseController<T extends BaseDomain> {

    @Autowired
    protected BaseService<T> service;

    /**
     * 分页查询数据
     * @param params
     * @param pageable
     * @return
     */
    public Page<T> list(Map<String, String> params, Pageable pageable) {
        return service.list(params, pageable);
    }

    /**
     * 根据复杂条件查找对象
     *
     * @param params
     * @return
     */
    public T findOne(Map<String, String> params) {
        return service.findOne(params);
    }

    /**
     * 根据复杂条件查找对象
     *
     * @param spec
     * @return
     */
    public T findOne(Specification<T> spec) {
        return service.findOne(spec);
    }

    /**
     * 根据id查找对象
     *
     * @param id
     * @return
     */
    public T findOne(String id) {
        return service.findOne(id);
    }

    /**
     * 通过Id查询数据
     * @param ids
     * @return
     */
    public List<T> findAll(Iterable<String> ids) {
        return service.findAll(ids);
    }

    /**
     * 查找所有数据
     *
     * @return
     */
    public List<T> findAll(Specification<T> spec) {
        return service.findAll(spec);
    }

    /**
     * 根据条件排序查找
     *
     * @param sort
     * @return
     */
    public List<T> findAll(Specification<T> spec, Sort sort) {
        return service.findAll(spec, sort);
    }

    /**
     * 根据条件分页查找
     *
     * @return
     */
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        return service.findAll(spec, pageable);
    }

    /**
     * 查找所有数据
     *
     * @return
     */
    public List<T> findAll() {
        return service.findAll();
    }

    /**
     * 根据条件排序查找
     *
     * @param sort
     * @return
     */
    public List<T> findAll(Sort sort) {
        return service.findAll(sort);
    }

    /**
     * 根据条件分页查找
     *
     * @param pageable
     * @return
     */
    public Page<T> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    /**
     * 单个保存
     *
     * @param object
     * @return
     */
    public T save(T object) {
        return service.save(object);
    }

    /**
     * 保存并持久化到数据库
     *
     * @param object
     * @return
     */
    public T saveAndFlush(T object) {
        return service.saveAndFlush(object);
    }

    /**
     * 批量保存
     *
     * @param iterable
     * @return
     */
    public List<T> save(Iterable<T> iterable) {
        return service.save(iterable);
    }

    /**
     * 单个更新
     *
     * @param t
     * @return
     */
    public T update(T t) {
        return service.update(t);
    }

    /**
     * 批量更新
     *
     * @param iterable
     */
    public Iterable<T> update(Iterable<T> iterable) {
        return service.update(iterable);
    }

    /**
     * 根据条件进行逻辑删除
     *
     * @param params
     * @return
     */
    public List<T> delete(Map<String, String> params) {
        return service.logicalDelete(params);
    }

    /**
     * 根据对象进行逻辑删除
     *
     * @param iterable
     * @return
     */
    public Iterable<String> delete(Iterable<String> iterable) {
        return service.logicalDelete(iterable);
    }

    /**
     * 根据主键进行逻辑删除
     *
     * @param id
     * @return
     */
    public T delete(String id) {
        return service.logicalDelete(id);
    }

    /**
     * 根据对象进行逻辑删除
     *
     * @param t
     * @return
     */
    public T delete(T t) {
        return service.logicalDelete(t);
    }

    /**
     * 根据条件判断对象是否存在
     *
     * @param params
     * @return
     */
    public Boolean exists(Map<String, String> params) {
        return service.exists(params);
    }

    /**
     * 根据条件判断对象是否存在
     *
     * @param spec
     * @return
     */
    public Boolean exists(Specification<T> spec) {
        return service.exists(spec);
    }

    /**
     * 对应表id是否存在
     *
     * @param id
     * @return
     */
    public Boolean exists(String id) {
        return service.exists(id);
    }

    /**
     * 根据条件查询数据总条数
     *
     * @param params
     * @return
     */
    public Long count(Map<String, String> params) {
        return service.count(params);
    }

    /**
     * 根据条件查询数据总条数
     *
     * @param spec
     * @return
     */
    public Long count(Specification<T> spec) {
        return service.count(spec);
    }

    /**
     * 对应表数据总条数
     *
     * @return
     */
    public Long count() {
        return service.count();
    }

    /**
     * 持久化数据到数据库
     */
    public void flush() {
        service.flush();
    }

}
