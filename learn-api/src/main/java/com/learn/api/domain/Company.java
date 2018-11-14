package com.learn.api.domain;

import com.learn.core.domain.BaseDomain;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@Data
@Entity
@DynamicUpdate
@Table(name = "L_COMPANY")
public class Company extends BaseDomain {

    private String name;
    private String address;

}
