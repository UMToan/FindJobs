package com.example.job.mapper;

import com.example.job.model.JobsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobsMapper implements RowMapper<JobsModel>{
    @Override
    public JobsModel mapRow(ResultSet rs){
        try {
            JobsModel jobs = new JobsModel();
            jobs.setId(rs.getLong("id"));
            jobs.setAreaID(rs.getLong("areaID"));
            jobs.setJobsTitle(rs.getString("jobsTitle"));
            jobs.setJobsStatus(rs.getString("jobsStatus"));
            jobs.setCompany(rs.getString("company"));
            jobs.setThumbnail(rs.getString("thumbnail"));
            jobs.setJobsLocation(rs.getString("jobsLocation"));
            jobs.setJobsMail(rs.getString("jobsMail"));
            jobs.setJobsDescription(rs.getString("jobsDescription"));
            jobs.setJobsResponsibilities(rs.getString("jobsResponsibilities"));
            jobs.setSalary(rs.getString("salary"));
            jobs.setJobsType(rs.getString("jobsType"));
            jobs.setJobsSkill(rs.getString("jobsSkill"));
            jobs.setCreatedDate(rs.getTimestamp("createdDate"));
            jobs.setCreatedBy(rs.getString("createdBy"));
            if(rs.getTimestamp("modifiedDate") != null){
                jobs.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if(rs.getString("modifiedBy") != null){
                jobs.setModifiedBy(rs.getString("modifiedBy"));
            }
            jobs.setStatus(rs.getInt("status"));
            return jobs;
        }catch (SQLException e){
            return null;
        }
    }
}
