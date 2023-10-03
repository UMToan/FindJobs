package com.example.job.mapper;

import com.example.job.model.AccountModel;
import com.example.job.model.ApplicantModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicantsMapper implements RowMapper<ApplicantModel>{
    @Override
    public ApplicantModel mapRow(ResultSet rs){
        try{
            ApplicantModel applicantModel = new ApplicantModel();
            applicantModel.setId(rs.getLong("id"));
            applicantModel.setJobsID(rs.getLong("jobsID"));
            applicantModel.setResumeID(rs.getLong("resumeID"));
            applicantModel.setApplicantsDate(rs.getTimestamp("applicantsDate"));
            applicantModel.setCreatedDate(rs.getTimestamp("createdDate"));
            applicantModel.setCreatedBy(rs.getString("createdBy"));
            if(rs.getTimestamp("modifiedDate") != null){
                applicantModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if(rs.getString("modifiedBy") != null){
                applicantModel.setModifiedBy(rs.getString("modifiedBy"));
            }
            return applicantModel;
        }
        catch (SQLException e){
            return null;
        }
    }
}
