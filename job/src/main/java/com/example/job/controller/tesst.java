package com.example.job.controller;

import com.example.job.dao.AccountDAO;
import com.example.job.dao.AreaDAO;
import com.example.job.dao.JobsDAO;
import com.example.job.dao.ResumeDAO;
import com.example.job.model.AccountModel;
import com.example.job.model.AreaModel;
import com.example.job.model.JobsModel;
import com.example.job.model.ResumeModel;

import java.sql.Timestamp;
import java.util.List;

public class tesst {
    public static void main(String[] args) {
//        AreaDAO dao = new AreaDAO();
//        Long id = 1L;
//        List<AreaModel> acc = dao.filterAreaJobs(id);
//        System.out.println(acc);
//        JobsDAO dao = new JobsDAO();
//        JobsModel job = dao.search("text3");
//        System.out.println(job);
        AccountDAO dao = new AccountDAO();
        AccountModel acc = dao.findAccount("minhtoan", "123");
        System.out.println(acc);
    }
}
