package com.learn.api.domain.teamlog;

import com.learn.core.domain.BaseDomain;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/7/3 0003 22:41
 */
@Data
@Entity
@DynamicUpdate
@Table(name = "work_log")
public class WorkLog extends BaseDomain {

    @Column(name = "work_date", length = 10)
    private String workDate;

    @Column(name = "start_time", length = 8)
    private String startTime;

    @Column(name = "end_time", length = 8)
    private String endTime;

    @Column(name = "work_hours", length = 2)
    private String workHours;

    @Column(name = "content", length = 100)
    private String content;

    @Column(name = "note_taker", length = 15)
    private String noteTaker;

    @Column(name = "category", length = 32)
    private String category;

}
