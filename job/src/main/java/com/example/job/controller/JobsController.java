package com.example.job.controller;

import com.example.job.model.AreaModel;
import com.example.job.model.JobsModel;
import com.example.job.service.JobsService;
import com.example.job.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/api-admin-jobs/*")
public class JobsController extends HttpServlet {
    private ObjectMapper mapper;

    JobsService jobsService = new JobsService();

    @Override
    public void init() throws ServletException {
        super.init();
        mapper = new ObjectMapper();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        JobsModel jobsModel = HttpUtil.of(req.getReader()).toModel(JobsModel.class);
        jobsModel = jobsService.save(jobsModel);
        mapper.writeValue(resp.getOutputStream(), jobsModel);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo = req.getPathInfo();
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        if(pathInfo == null){
            List<JobsModel> jobs = jobsService.findAll();
            String dataJson =gson.toJson(jobs);
            out.println(dataJson);
        }
        else {
            String path = pathInfo.substring(1);
            Long locationID = Long.parseLong(path);
            JobsModel jobs = jobsService.findOne(locationID);
            String dataJson = gson.toJson(jobs);
            out.println(dataJson);
        }
        out.close();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo = req.getPathInfo();
        if(pathInfo != null || pathInfo.equals("/")) {
            String id = pathInfo.substring(1);
            Long jobsID = Long.parseLong(id);
            JobsModel updateModel = mapper.readValue(req.getReader(), JobsModel.class);
            jobsService.update(jobsID, updateModel);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }
    }


}
