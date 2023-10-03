package com.example.job.mapper;

import com.example.job.model.ResumeModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResumeMapper implements RowMapper<ResumeModel>{

    public ResumeModel mapRow(ResultSet rs){
        try{
            ResumeModel resume = new ResumeModel();
            resume.setId(rs.getLong("id"));
            resume.setAccountID(rs.getLong("accountID"));
            resume.setName(rs.getString("name"));
            resume.setMail(rs.getString("mail"));
            resume.setDateOfBirth(rs.getString("dateOfBirth"));
            resume.setPhoneNumber(rs.getString("phoneNumber"));
            resume.setAddress(rs.getString("address"));
            resume.setUniversity(rs.getString("university"));
            resume.setMajor(rs.getString("major"));
            resume.setDescription(rs.getString("description"));
            resume.setGraduationYear(rs.getString("graduationYear"));
            resume.setSkills(rs.getString("skills"));
            resume.setExperience(rs.getString("experience"));
            resume.setCertificate(rs.getString("certificate"));
            resume.setCreatedDate(rs.getTimestamp("createdDate"));
            resume.setCreatedBy(rs.getString("createdBy"));
            if(rs.getTimestamp("modifiedDate") != null){
                resume.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if(rs.getString("modifiedBy") != null){
                resume.setModifiedBy(rs.getString("modifiedBy"));
            }
            return resume;
        } catch (SQLException e){
            return null;
        }
    }
}
