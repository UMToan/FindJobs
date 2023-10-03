package com.example.job.dao;

import com.example.job.model.ApplicantModel;
import com.example.job.model.AreaModel;
import com.example.job.model.JobsModel;

import java.util.List;

public interface IApplicantsDAO extends GernericDAO<ApplicantModel>{
    Long save(Long jobsID, Long resumeID);

    List<ApplicantModel> findAll();

    ApplicantModel findOne(Long id);
}
