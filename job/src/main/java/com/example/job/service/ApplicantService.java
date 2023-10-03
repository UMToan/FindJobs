package com.example.job.service;

import com.example.job.dao.ApplicantDAO;
import com.example.job.dao.IApplicantsDAO;
import com.example.job.model.ApplicantModel;

import java.util.List;

public class ApplicantService implements IApplicantService {

    ApplicantDAO app = new ApplicantDAO();

    @Override
    public Long save(Long jobsID, Long resumeID) {
        return app.save(jobsID, resumeID);
    }

    @Override
    public List<ApplicantModel> findAll() {
        return app.findAll();
    }

    @Override
    public ApplicantModel findOne(Long id) {
        return app.findOne(id);
    }
}
