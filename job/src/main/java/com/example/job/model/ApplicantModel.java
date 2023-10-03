package com.example.job.model;

import java.sql.Timestamp;
import java.util.Date;

public class ApplicantModel extends AbstractModel<ApplicantModel>{
    private Long jobsID;
    private Long resumeID;
    private Timestamp applicantsDate;


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

    public Timestamp getApplicantsDate() {
        return applicantsDate;
    }

    public void setApplicantsDate(Timestamp applicantsDate) {
        this.applicantsDate = applicantsDate;
    }
}
