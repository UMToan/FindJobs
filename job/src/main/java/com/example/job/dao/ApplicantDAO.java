package com.example.job.dao;

import com.example.job.mapper.AccountMapper;
import com.example.job.mapper.ApplicantsMapper;
import com.example.job.mapper.AreaMapper;
import com.example.job.model.AccountModel;
import com.example.job.model.ApplicantModel;
import com.example.job.model.AreaModel;

import java.util.List;

public class ApplicantDAO extends AbstractDAO<ApplicantModel> implements IApplicantsDAO{

    @Override
    public Long save(Long jobsID, Long resumeID) {
        String sql = "INSERT INTO applicants(jobsID, resumeID) VALUES(?,?)";
        return Add(sql, jobsID, resumeID);
    }

    @Override
    public List<ApplicantModel> findAll() {
        String sql = "SELECT * FROM applicants";
        return query(sql, new ApplicantsMapper());
    }

    @Override
    public ApplicantModel findOne(Long id) {
        String sql = "SELECT * FROM applicants WHERE id = ?";
        List<ApplicantModel> app = query(sql, new ApplicantsMapper(), id);
        return app.isEmpty() ? null : app.get(0);
    }
}
