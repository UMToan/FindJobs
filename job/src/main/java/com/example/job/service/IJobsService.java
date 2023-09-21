package com.example.job.service;

import com.example.job.model.AreaModel;
import com.example.job.model.JobsModel;

import java.util.List;

public interface IJobsService {
    List<JobsModel> findAll();

    JobsModel findOne(Long jobsID);

    JobsModel save(JobsModel jobsModel);

    void update(Long jobsID,JobsModel jobsModel);

    JobsModel search(String jobsTitle);
}
