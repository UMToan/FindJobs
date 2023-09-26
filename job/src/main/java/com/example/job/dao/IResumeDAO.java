package com.example.job.dao;

import com.example.job.model.JobsModel;
import com.example.job.model.ResumeModel;

import java.util.List;

public interface IResumeDAO extends GernericDAO<ResumeModel>{
    List<ResumeModel> findAll();
    ResumeModel findOne(Long resumeID);
    Long save(ResumeModel resumeModel);
    void update(Long resumeID,ResumeModel resumeModel);
}
