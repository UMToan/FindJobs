package com.example.job.controller;

import com.example.job.model.AreaModel;
import com.example.job.model.JobsModel;
import com.example.job.service.JobsService;
import com.example.job.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(urlPatterns = "/api-admin-jobs/*")
public class JobsController extends HttpServlet {
    private ObjectMapper mapper;
    JobsModel model = new JobsModel();

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
        String info=(String)req.getParameter("vnp_OrderInfo");
        Long status = Long.parseLong(info);
        jobsService.updateByStatus(status, 1);
//        JobsModel model = jobsService.updateByStatus(status);
//        System.out.println(model);
//        JobsModel jobsModel = HttpUtil.of(req.getReader()).toModel(JobsModel.class);
//        Long model = jobsService.save(jobsModel);
//        mapper.writeValue(resp.getOutputStream(), model);
        resp.sendRedirect("http://localhost:4200/jobs");
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
            String[] parts = pathInfo.substring(1).split("/");

            if(parts.length==1){
                long locationID = Long.parseLong(parts[0]);
                JobsModel jobs = jobsService.findOne(locationID);
                String dataJson = gson.toJson(jobs);
                out.println(dataJson);
            }
            else{
                //add 1 job

                model.setAreaID(Long.parseLong(parts[0]));
                model.setJobsTitle(parts[1]);
                model.setJobsStatus(parts[2]);
                model.setCompany(parts[3]);
                model.setThumbnail(parts[4]);
                model.setJobsLocation(parts[5]);
                model.setJobsMail(parts[6]);
                model.setJobsDescription(parts[7]);
                model.setJobsResponsibilities(parts[8]);
                model.setSalary(parts[9]);
                model.setJobsType(parts[10]);
                model.setJobsSkill(parts[11]);
                model.setCreatedBy(parts[12]);
                model.setStatus(0);
//                JobsModel jobsModel = HttpUtil.of(req.getReader()).toModel(JobsModel.class);
                Long tamp = jobsService.save(model);
                System.out.println(tamp);
//                mapper.writeValue(resp.getOutputStream(), jobsModel);
                //co id cua job
                //System.out.println(parts.length);
                req.setAttribute("amount", "10000");
                req.setAttribute("vnp_OrderInfo", tamp.toString());
                req.setAttribute("txt_inv_mobile", "0363397844");
                req.setAttribute("txt_inv_customer", "Toan");
                RequestDispatcher dispatch = req.getRequestDispatcher("/vnpay_pay.jsp");
                dispatch.forward(req, resp);
            }
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
