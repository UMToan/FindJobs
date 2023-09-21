package com.example.job.dao;

import com.example.job.model.AreaModel;
import com.example.job.model.JobsModel;

import java.util.List;

public interface IJobsDAO extends GernericDAO<JobsModel>{
    List<JobsModel> findAll();

    JobsModel findOne(Long jobsID);
    Long save(JobsModel jobsModel);

    void update(Long jobsID,JobsModel jobsModel);

    JobsModel search(String jobsTitle);
}
