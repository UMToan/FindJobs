package com.example.job.model;

import java.util.Date;

public class ResumeModel extends AbstractModel<ResumeModel>{
    private Long resumeID;
    private Long accountID;
    private String name;
    private String mail;
    private Date dateOfBirth;
    private String phoneNumber;
    private String address;
    private String university;
    private String major;
    private String description;
    private Date graduationYear;
    private String skills;
    private String experience;
    private String certificate;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Date graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Long getResumeID() {
        return resumeID;
    }

    public void setResumeID(Long resumeID) {
        this.resumeID = resumeID;
    }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
