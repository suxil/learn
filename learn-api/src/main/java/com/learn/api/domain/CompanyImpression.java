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
@Table(name = "L_COMPANY_IMPRESSION")
public class CompanyImpression extends BaseDomain {

    private String companyId;
    private String impression;
    private String knowledge;

}
