package com.example.job.controller;

import com.example.job.model.JobsModel;
import com.example.job.model.ResumeModel;
import com.example.job.service.JobsService;
import com.example.job.service.ResumeService;
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

@WebServlet(urlPatterns = "/api-admin-resume/*")
public class ResumeController extends HttpServlet {
    private ObjectMapper mapper;

    ResumeService resumeService = new ResumeService();

    @Override
    public void init() throws ServletException {
        super.init();
        mapper = new ObjectMapper();

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
            List<ResumeModel> jobs = resumeService.findAll();
            String dataJson =gson.toJson(jobs);
            out.println(dataJson);
        }
        else {
            String path = pathInfo.substring(1);
            Long resumeID = Long.parseLong(path);
            ResumeModel jobs = resumeService.findOne(resumeID);
            String dataJson = gson.toJson(jobs);
            out.println(dataJson);
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ResumeModel resumeModel = HttpUtil.of(req.getReader()).toModel(ResumeModel.class);
        resumeModel = resumeService.save(resumeModel);
        mapper.writeValue(resp.getOutputStream(), resumeModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo = req.getPathInfo();
        if(pathInfo != null || pathInfo.equals("/")) {
            String id = pathInfo.substring(1);
            Long resumeID = Long.parseLong(id);
            ResumeModel resumeModel = mapper.readValue(req.getReader(), ResumeModel.class);
            resumeService.update(resumeID, resumeModel);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }
    }
}
