package com.example.job.service;

import com.example.job.dao.JobsDAO;
import com.example.job.model.JobsModel;

import java.sql.Timestamp;
import java.util.List;

public class JobsService implements IJobsService{

    JobsDAO jobsDAO = new JobsDAO();
    @Override
    public List<JobsModel> findAll() {
        return jobsDAO.findAll();
    }

    @Override
    public JobsModel findOne(Long jobsID) {
        return jobsDAO.findOne(jobsID);
    }

    @Override
    public JobsModel save(JobsModel jobsModel) {
        jobsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        Long jobsID = jobsDAO.save(jobsModel);
        return jobsDAO.findOne(jobsID);
    }

    @Override
    public void update(Long jobsID, JobsModel jobsModel) {
        jobsModel.setAreaID(jobsModel.getAreaID());
        jobsModel.setJobsTitle(jobsModel.getJobsTitle());
        jobsModel.setJobsStatus(jobsModel.getJobsStatus());
        jobsModel.setCompany(jobsModel.getCompany());
        jobsModel.setThumbnail(jobsModel.getThumbnail());
        jobsModel.setJobsLocation(jobsModel.getJobsLocation());
        jobsModel.setJobsMail(jobsModel.getJobsMail());
        jobsModel.setJobsDescription(jobsModel.getJobsDescription());
        jobsModel.setJobsResponsibilities(jobsModel.getJobsResponsibilities());
        jobsModel.setSalary(jobsModel.getSalary());
        jobsModel.setJobsType(jobsModel.getJobsType());
        jobsModel.setJobsSkill(jobsModel.getJobsSkill());
        jobsModel.setCreatedDate(jobsModel.getCreatedDate());
        jobsModel.setCreatedBy(jobsModel.getCreatedBy());
        jobsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        jobsModel.setModifiedBy("");
        jobsDAO.update(jobsID, jobsModel);
    }

    @Override
    public JobsModel search(String jobsTitle) {
        return jobsDAO.search(jobsTitle);
    }


}
