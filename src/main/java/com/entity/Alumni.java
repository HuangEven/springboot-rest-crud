package com.entity;

import java.sql.Date;

/**
 * @Author: EvenHuang
 * @Date: 2019/4/27 15:39
 */
public class Alumni {
    private String graduateId;
    private String name;
    private String gender;
    private Date birthday;
    private String enrollmentYear;
    private String graduationYear;
    private String workCity;
    private String workUnit;
    private String address;
    private String phoneNumber;
    private String mailAddress;
    private String wechat;

    public Alumni(){}

    public Alumni(int id){
        this.graduateId=String.valueOf(id);
    }

    public String getGraduateId() {
        return graduateId;
    }

    public void setGraduateId(String graduateId) {
        this.graduateId = graduateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Override
    public String toString() {
        return "Alumni [id="+graduateId+", name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", enrollmentYear=" + enrollmentYear
                + ", graduationYear=" + graduationYear + ", workCity=" + workCity + ", workUnit=" + workUnit
                + ", address=" + address+ ", phoneNumber=" + phoneNumber+ ", mailAddress=" + mailAddress + ", wechat=" + wechat+"]";
    }
}
