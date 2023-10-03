package com.example.job.model;

public class JobsModel extends AbstractModel<JobsModel>{
    private Long areaID;
    private String jobsTitle;
    private String jobsStatus;
    private String company;
    private String thumbnail;
    private String jobsLocation;
    private String jobsMail;
    private String jobsDescription;
    private String jobsResponsibilities;
    private String salary;
    private String jobsType;
    private String jobsSkill;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getAreaID() {
        return areaID;
    }

    public void setAreaID(Long areaID) {
        this.areaID = areaID;
    }

    public String getJobsTitle() {
        return jobsTitle;
    }

    public void setJobsTitle(String jobsTitle) {
        this.jobsTitle = jobsTitle;
    }

    public String getJobsStatus() {
        return jobsStatus;
    }

    public void setJobsStatus(String jobsStatus) {
        this.jobsStatus = jobsStatus;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getJobsLocation() {
        return jobsLocation;
    }

    public void setJobsLocation(String jobsLocation) {
        this.jobsLocation = jobsLocation;
    }

    public String getJobsMail() {
        return jobsMail;
    }

    public void setJobsMail(String jobsMail) {
        this.jobsMail = jobsMail;
    }

    public String getJobsDescription() {
        return jobsDescription;
    }

    public void setJobsDescription(String jobsDescription) {
        this.jobsDescription = jobsDescription;
    }

    public String getJobsResponsibilities() {
        return jobsResponsibilities;
    }

    public void setJobsResponsibilities(String jobsResponsibilities) {
        this.jobsResponsibilities = jobsResponsibilities;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobsType() {
        return jobsType;
    }

    public void setJobsType(String jobsType) {
        this.jobsType = jobsType;
    }

    public String getJobsSkill() {
        return jobsSkill;
    }

    public void setJobsSkill(String jobsSkill) {
        this.jobsSkill = jobsSkill;
    }
}
