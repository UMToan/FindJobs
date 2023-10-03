package com.example.job.service;

import com.example.job.model.AreaModel;
import com.example.job.model.JobsModel;

import java.util.List;

public interface IJobsService {
    List<JobsModel> findAll();

    JobsModel findOne(Long jobsID);

    Long save(JobsModel jobsModel);

    void update(Long jobsID,JobsModel jobsModel);

    void updateByStatus(Long jobsID, int so);

    JobsModel search(String jobsTitle);

    List<JobsModel> filterAreaJobs(Long locationID);
}
