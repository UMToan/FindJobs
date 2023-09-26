package com.example.job.service;

import com.example.job.model.JobsModel;
import com.example.job.model.ResumeModel;

import java.util.List;

public interface IResumeService {
    List<ResumeModel> findAll();
    ResumeModel findOne(Long resumeID);
    ResumeModel save(ResumeModel resumeModel);
    void update(Long resumeID,ResumeModel resumeModel);
}
