package com.example.job.controller;

import com.example.job.model.AccountModel;
import com.example.job.model.JobsModel;
import com.example.job.service.JobsService;
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

@WebServlet(urlPatterns = "/api-admin-search/*")
public class SearchController extends HttpServlet {

    private ObjectMapper mapper;

    JobsService jobsService = new JobsService();

    @Override
    public void init() throws ServletException {
        super.init();
        mapper = new ObjectMapper();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String jsonData = req.getPathInfo();
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        if(jsonData == null){
            List<JobsModel> jobs = jobsService.findAll();
            String dataJson =gson.toJson(jobs);
            out.println(dataJson);
        }
        else {
            String jobsTitle = jsonData.substring(1);
            JobsModel jobs = jobsService.search(jobsTitle);
            String dataJson = gson.toJson(jobs);
            out.println(dataJson);
        }
        out.close();
    }
}
