package com.learn.api.domain;

import com.learn.core.domain.BaseDomain;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
@Data
@Entity
@DynamicUpdate
@Table(name = "L_RECORD_SEGMENT")
public class RecordSegment extends BaseDomain {

    private String hour;
    private String segment;
    private String zodiac;
    private String description;

}
