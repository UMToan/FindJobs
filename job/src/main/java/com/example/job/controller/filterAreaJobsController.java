package com.example.job.controller;

import com.example.job.model.AreaModel;
import com.example.job.model.JobsModel;
import com.example.job.service.AreaService;
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

@WebServlet(urlPatterns = "/api-admin-filter/*")
public class filterAreaJobsController extends HttpServlet {

    private ObjectMapper mapper ;
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
        String pathInfo = req.getPathInfo();
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        if(pathInfo == null){
            List<JobsModel> area = jobsService.findAll();
            String dataJson =gson.toJson(area);
            out.println(dataJson);
        }
        else {
            String[] parts = pathInfo.substring(1).split("/");
            long id = Long.parseLong(parts[0]);
            List<JobsModel> list=jobsService.filterAreaJobs(id);
            String jsonData=gson.toJson(list);
            out.print(jsonData);
            out.close();
        }
        out.close();
    }
}
