package com.example.job.service;

import com.example.job.dao.ResumeDAO;
import com.example.job.model.JobsModel;
import com.example.job.model.ResumeModel;

import java.sql.Timestamp;
import java.util.List;

public class ResumeService implements IResumeService{

    ResumeDAO resumeDAO = new ResumeDAO();


    @Override
    public List<ResumeModel> findAll() {
        return resumeDAO.findAll();
    }

    @Override
    public ResumeModel findOne(Long resumeID) {
        return resumeDAO.findOne(resumeID);
    }

    @Override
    public ResumeModel save(ResumeModel resumeModel) {
        resumeModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        Long resumeID = resumeDAO.save(resumeModel);
        return resumeDAO.findOne(resumeID);
    }

    @Override
    public void update(Long resumeID, ResumeModel resumeModel) {
        resumeModel.setName(resumeModel.getName());
        resumeModel.setMail(resumeModel.getMail());
        resumeModel.setDateOfBirth(resumeModel.getDateOfBirth());
        resumeModel.setPhoneNumber(resumeModel.getPhoneNumber());
        resumeModel.setAddress(resumeModel.getAddress());
        resumeModel.setUniversity(resumeModel.getUniversity());
        resumeModel.setMajor(resumeModel.getMajor());
        resumeModel.setDescription(resumeModel.getDescription());
        resumeModel.setGraduationYear(resumeModel.getGraduationYear());
        resumeModel.setSkills(resumeModel.getSkills());
        resumeModel.setExperience(resumeModel.getExperience());
        resumeModel.setCertificate(resumeModel.getCertificate());
        resumeModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        resumeDAO.update(resumeID, resumeModel);
    }
}
