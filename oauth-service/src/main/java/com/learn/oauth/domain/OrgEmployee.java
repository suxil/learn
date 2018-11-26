package com.learn.oauth.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;


/**
 * 业务员 实体
 */
@Data
@Entity
@Table(name = "ORG_EMPLOYEE")
public class OrgEmployee implements Serializable {
    @Id
    @Column(name="EMP_NUM")
    private String empNum;
    @Column(name="EMP_NAME")
    private String empName;
    @Column(name="LDAP_NAME")
    private String ldapName;
    @Column(name="LDAP_UID")
    private String ldapUid;
    @Column(name="NICK_NAME")
    private String nickName;
    @Column(name="EMP_DEPT")
    private String empDept;
    @Column(name="EMP_POSITION")
    private String empPosition;
    @Column(name="EMAIL")
    private String email;
    @Column(name="MOBILE")
    private String mobile;
    @Column(name="CREATE_TIME")
    private Date createTime;
    @Column(name="CREATOR")
    private String creator;
    @Column(name="UPDATE_TIME")
    private Date updateTime;
    @Column(name="UPDATE_BY")
    private String updateBy;
    @Column(name="PARENT_POSITION")
    private String parentposition;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="COMPANY_NUM")
    private String companyNum;
    @Column(name="DATES_EMPLOYED")
    private String datesEmployed;
    @Column(name="DEPARTURE_TIME")
    private String departureTime;
    @Column(name="EMP_EN_NAME")
    private String empEnName;
    @Column(name="GENDER")
    private String gender;
    @Column(name="IDENTITY_CARD")
    private String identityCard;
    @Column(name="JOB_NUMBER")
    private String jobNumber;
    @Column(name="NAME_PINYIN")
    private String namePinyin;
    @Column(name="NATION")
    private String nation;
    @Column(name="STATE")
    private String state;
    @Column(name="TELEPHONE")
    private String telephone;
    @Column(name="UPDATE_TYPE")
    private String updateType;
    @Column(name="EMP_MANAGER")
    private String empManager;
    @Column(name="PHONENUMBER")
    private String phonenumber;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="REGISTRATIONID")
    private String registrationid;
    @Column(name="AUDIT_STATUS")
    private String auditStatus;
    @Column(name="COMPANY_NAME")
    private String companyName;
    @Column(name="DEPARTMENT_CODE")
    private String departmentCode;
    @Column(name="USER_TYPE")
    private String userType;
    @Column(name="USERSOURCE")
    private String usersource;
    @Column(name="EMP_POSITION_DESCR")
    private String empPositionDescr;
    @Column(name="EMP_POSITION_NAME")
    private String empPositionName;
    @Column(name="TENENT_ID")
    private String tenentId;
    @Column(name="MOBILE_USER_TYPE")
    private String mobileUserType;
    @Column(name="IS_MOBILE_USER")
    private String isMobileUser;

}

