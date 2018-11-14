package com.learn.core.dao;

import com.learn.core.domain.BaseDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * <p>@Title: IntelliJ IDEA.</p>
 * Description:
 * Date: 2017/1/17 0017
 * Time: 21:55
 *
 * @author Administrator
 * @version 1.0
 */
@NoRepositoryBean
public interface IBaseRepository<T extends BaseDomain, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    T findByIdAndIsDelete(String id, Integer isDelete);

    List<T> findByIdInAndIsDelete(Iterable<String> ids, Integer isDelete);

}
