package com.example.hunter.model;

import java.util.Date;

public class UpdateMemberVin {
    private int memberId;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private String school;
    private String major;
    private String hopeWorkLoc;
    private int salary;
    private String company;
    private String mainSkill;
    private String secondSkill;
    private String role;
    private String language;
    private int seniority;
    private String hope;
    private String client;
    private Date createTime;
    private Date updateTime;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getHopeWorkLoc() {
        return hopeWorkLoc;
    }

    public void setHopeWorkLoc(String hopeWorkLoc) {
        this.hopeWorkLoc = hopeWorkLoc;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMainSkill() {
        return mainSkill;
    }

    public void setMainSkill(String mainSkill) {
        this.mainSkill = mainSkill;
    }

    public String getSecondSkill() {
        return secondSkill;
    }

    public void setSecondSkill(String secondSkill) {
        this.secondSkill = secondSkill;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public String getHope() {
        return hope;
    }

    public void setHope(String hope) {
        this.hope = hope;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UpdateMemberVin{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", hopeWorkLoc='" + hopeWorkLoc + '\'' +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                ", mainSkill='" + mainSkill + '\'' +
                ", secondSkill='" + secondSkill + '\'' +
                ", role='" + role + '\'' +
                ", language='" + language + '\'' +
                ", seniority=" + seniority +
                ", hope='" + hope + '\'' +
                ", client='" + client + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
