package com.example.job.controller;

import com.example.job.model.AreaModel;
import com.example.job.service.AreaService;
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

@WebServlet(urlPatterns = "/api-admin-area/*")
public class AreaController extends HttpServlet {
    private  ObjectMapper mapper ;
    AreaService areaService = new AreaService();

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
        AreaModel areaModel = HttpUtil.of(req.getReader()).toModel(AreaModel.class);
        areaModel = areaService.save(areaModel);
        mapper.writeValue(resp.getOutputStream(), areaModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo = req.getPathInfo();
        if(pathInfo != null || pathInfo.equals("/")){
            String id = pathInfo.substring(1);
            Long locationID = Long.parseLong(id);
            AreaModel updateModel =  mapper.readValue(req.getReader(), AreaModel.class);
            areaService.update(locationID,updateModel);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        AreaModel deleteModel = HttpUtil.of(req.getReader()).toModel(AreaModel.class);
        areaService.delete(deleteModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String pathInfo = req.getPathInfo();
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        if(pathInfo == null){
            List<AreaModel> area = areaService.findAll();
            String dataJson =gson.toJson(area);
            out.println(dataJson);
        }
        else {
            String path = pathInfo.substring(1);
            Long locationID = Long.parseLong(path);
            AreaModel area = areaService.findOne(locationID);
            String dataJson = gson.toJson(area);
            out.println(dataJson);
        }
        out.close();
    }
}
