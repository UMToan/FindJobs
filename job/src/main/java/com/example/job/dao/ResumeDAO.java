package com.example.job.dao;

import com.example.job.mapper.JobsMapper;
import com.example.job.mapper.ResumeMapper;
import com.example.job.model.JobsModel;
import com.example.job.model.ResumeModel;

import java.util.List;

public class ResumeDAO extends AbstractDAO<ResumeModel> implements IResumeDAO {

    @Override
    public List<ResumeModel> findAll() {
        String sql = "SELECT * FROM resume";
        return query(sql, new ResumeMapper());
    }

    @Override
    public ResumeModel findOne(Long resumeID) {
        String sql = "SELECT * FROM resume WHERE id = ?";
        List<ResumeModel> resume = query(sql, new ResumeMapper(), resumeID);
        return resume.isEmpty() ? null : resume.get(0);
    }

    @Override
    public Long save(ResumeModel resumeModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO resume (accountID, name, mail, dateOfBirth, phoneNumber,");
        sql.append(" address, university, major, description, graduationYear, skills, experience, certificate,");
        sql.append(" createdDate, createdBy) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        return Add(sql.toString(), resumeModel.getAccountID(), resumeModel.getName(), resumeModel.getMail(),
                resumeModel.getDateOfBirth(), resumeModel.getPhoneNumber(), resumeModel.getAddress(),
                resumeModel.getUniversity(), resumeModel.getMajor(), resumeModel.getDescription(),
                resumeModel.getGraduationYear(), resumeModel.getSkills(), resumeModel.getExperience(),
                resumeModel.getCertificate(), resumeModel.getCreatedDate(), resumeModel.getCreatedBy());
    }

    @Override
    public void update(Long jobsID, ResumeModel resumeModel) {
        StringBuilder sql = new StringBuilder("UPDATE resume SET name = ?, mail = ?, dateOfBirth = ?, phoneNumber = ?,");
        sql.append(" address = ?, university = ?, major = ?, description = ?, graduationYear = ?, skills = ?,");
        sql.append(" experience = ?, certificate = ?, modifiedBy = ? WHERE id = ?");
        Update(sql.toString(), resumeModel.getName(), resumeModel.getMail(), resumeModel.getDateOfBirth(),
                resumeModel.getPhoneNumber(), resumeModel.getAddress(), resumeModel.getUniversity(),
                resumeModel.getMajor(), resumeModel.getDescription(), resumeModel.getGraduationYear(), resumeModel.getSkills(),
                resumeModel.getExperience(), resumeModel.getCertificate(), resumeModel.getModifiedBy(), jobsID);
    }
}
