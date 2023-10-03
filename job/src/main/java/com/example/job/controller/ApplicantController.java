package com.example.job.controller;

import com.example.job.model.AccountModel;
import com.example.job.model.ApplicantModel;
import com.example.job.model.AreaModel;
import com.example.job.service.AccountService;
import com.example.job.service.ApplicantService;
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

@WebServlet(urlPatterns = "/applicant/*")
public class ApplicantController extends HttpServlet {
    ApplicantService applicantService = new ApplicantService();
    ApplicantModel applicantModel = new ApplicantModel();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String jsonData = req.getPathInfo();
        Gson gson = new Gson();
            if(jsonData != null || jsonData.equals("/")){
                ApplicantModel applicantModel = gson.fromJson(req.getReader(), ApplicantModel.class);
                applicantService.save(applicantModel.getJobsID(), applicantModel.getResumeID());
                mapper.writeValue(resp.getOutputStream(), applicantModel);
            }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo = req.getPathInfo();
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        if(pathInfo == null){
            List<ApplicantModel> app = applicantService.findAll();
            String dataJson =gson.toJson(app);
            out.println(dataJson);
        }
        else {
            String path = pathInfo.substring(1);
            Long id = Long.parseLong(path);
            ApplicantModel area = applicantService.findOne(id);
            String dataJson = gson.toJson(area);
            out.println(dataJson);
        }
        out.close();
    }
}
