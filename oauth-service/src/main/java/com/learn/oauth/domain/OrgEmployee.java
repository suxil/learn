package com.learn.oauth.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * 业务员 实体
 */
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

    public OrgEmployee(){}

    public String getEmpNum() {
        return empNum;
    }

    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getLdapName() {
        return ldapName;
    }

    public void setLdapName(String ldapName) {
        this.ldapName = ldapName;
    }

    public String getLdapUid() {
        return ldapUid;
    }

    public void setLdapUid(String ldapUid) {
        this.ldapUid = ldapUid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getUpdateBy() {
        return updateBy;
    }


    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getParentposition() {
        return parentposition;
    }

    public void setParentposition(String parentposition) {
        this.parentposition = parentposition;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(String companyNum) {
        this.companyNum = companyNum;
    }

    public String getDatesEmployed() {
        return datesEmployed;
    }

    public void setDatesEmployed(String datesEmployed) {
        this.datesEmployed = datesEmployed;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getEmpEnName() {
        return empEnName;
    }

    public void setEmpEnName(String empEnName) {
        this.empEnName = empEnName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getEmpManager() {
        return empManager;
    }

    public void setEmpManager(String empManager) {
        this.empManager = empManager;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(String registrationid) {
        this.registrationid = registrationid;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsersource() {
        return usersource;
    }

    public void setUsersource(String usersource) {
        this.usersource = usersource;
    }

    public String getEmpPositionDescr() {
        return empPositionDescr;
    }

    public void setEmpPositionDescr(String empPositionDescr) {
        this.empPositionDescr = empPositionDescr;
    }

    public String getEmpPositionName() {
        return empPositionName;
    }

    public void setEmpPositionName(String empPositionName) {
        this.empPositionName = empPositionName;
    }

    public String getTenentId() {
        return tenentId;
    }

    public void setTenentId(String tenentId) {
        this.tenentId = tenentId;
    }

    public String getMobileUserType() {
        return mobileUserType;
    }

    public void setMobileUserType(String mobileUserType) {
        this.mobileUserType = mobileUserType;
    }

    public String getIsMobileUser() {
        return isMobileUser;
    }

    public void setIsMobileUser(String isMobileUser) {
        this.isMobileUser = isMobileUser;
    }
}

