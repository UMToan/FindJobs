package com.example.job.model;

import java.util.Date;

public class ApplicantModel extends AbstractModel<ApplicantModel>{
    private Long applicantID;
    private Long jobsID;
    private Long resumeID;
    private Date applicantsDate;

    public Long getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Long applicantID) {
        this.applicantID = applicantID;
    }

    public Long getJobsID() {
        return jobsID;
    }

    public void setJobsID(Long jobsID) {
        this.jobsID = jobsID;
    }

    public Long getResumeID() {
        return resumeID;
    }

    public void setResumeID(Long resumeID) {
        this.resumeID = resumeID;
    }

    public Date getApplicantsDate() {
        return applicantsDate;
    }

    public void setApplicantsDate(Date applicantsDate) {
        this.applicantsDate = applicantsDate;
    }
}
