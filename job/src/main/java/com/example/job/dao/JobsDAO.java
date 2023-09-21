package com.example.job.dao;

import com.example.job.mapper.AreaMapper;
import com.example.job.mapper.JobsMapper;
import com.example.job.model.AreaModel;
import com.example.job.model.JobsModel;

import java.util.List;

public class JobsDAO extends AbstractDAO<JobsModel> implements IJobsDAO{
    @Override
    public List<JobsModel> findAll() {
        String sql = "SELECT * FROM jobs";
        return query(sql, new JobsMapper());
    }

    @Override
    public JobsModel findOne(Long jobsID) {
        String sql = "SELECT * FROM jobs WHERE id = ?";
        List<JobsModel> jobs = query(sql, new JobsMapper(), jobsID);
        return jobs.isEmpty() ? null : jobs.get(0);
    }

    @Override
    public Long save(JobsModel jobsModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO jobs (areaID, jobsTitle, jobsStatus, company, ");
        sql.append("thumbnail, jobsLocation, jobsMail, jobsDescription, jobsResponsibilities, ");
        sql.append("salary, jobsType, jobsSkill, createdDate, createdBy) ");
        sql.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        return Add(sql.toString(), jobsModel.getAreaID(), jobsModel.getJobsTitle(), jobsModel.getJobsStatus(),
                jobsModel.getCompany(), jobsModel.getThumbnail(), jobsModel.getJobsLocation(),
                jobsModel.getJobsMail(), jobsModel.getJobsDescription(), jobsModel.getJobsResponsibilities(),
                jobsModel.getSalary(), jobsModel.getJobsType(), jobsModel.getJobsSkill(),
                jobsModel.getCreatedDate(), jobsModel.getCreatedBy());
    }

    @Override
    public void update(Long jobsID, JobsModel jobsModel) {
        StringBuilder sql = new StringBuilder("UPDATE jobs SET areaID = ?, jobsTitle = ?, jobsStatus = ?,");
        sql.append(" company = ?, thumbnail = ?, jobsLocation = ?, jobsMail = ?, jobsDescription = ?, jobsResponsibilities = ?,");
        sql.append(" salary = ?, jobsType = ?, jobsSkill = ? WHERE id = ?");
        Update(sql.toString(), jobsModel.getAreaID(), jobsModel.getJobsTitle(), jobsModel.getJobsStatus(),
                jobsModel.getCompany(), jobsModel.getThumbnail(), jobsModel.getJobsLocation(), jobsModel.getJobsMail(),
                jobsModel.getJobsDescription(), jobsModel.getJobsResponsibilities(), jobsModel.getSalary(),
                jobsModel.getJobsType(), jobsModel.getJobsSkill(), jobsID);
    }

    @Override
    public JobsModel search(String jobsTitle) {
        String sql = "SELECT * FROM jobs WHERE jobsTitle = ?";
        List<JobsModel> jobs = query(sql, new JobsMapper(), jobsTitle);
        return jobs.isEmpty() ? null : jobs.get(0);
    }


}
