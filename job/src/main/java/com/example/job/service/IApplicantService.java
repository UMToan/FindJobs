package com.example.job.service;

import com.example.job.model.ApplicantModel;

import java.util.List;

public interface IApplicantService {
    Long save(Long jobsID, Long resumeID);

    List<ApplicantModel> findAll();

    ApplicantModel findOne(Long id);
}
