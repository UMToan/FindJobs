package com.example.job.controller;

import com.example.job.model.AccountModel;
import com.example.job.model.AreaModel;
import com.example.job.service.AccountService;
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

@WebServlet(urlPatterns = "/account/*")
public class AccountController extends HttpServlet {
    AccountService accountService = new AccountService();
    AccountModel account = new AccountModel();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String jsonData = req.getPathInfo();
        //PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        if(jsonData.equals("/login")){
            AccountModel account = gson.fromJson(req.getReader(), AccountModel.class);
            AccountModel acc = accountService.findAccount(account.getUserName(), account.getPassword());
            PrintWriter out = resp.getWriter();
            if(acc != null){
                Gson gs = new Gson();
                String jsonPass = gs.toJson(acc);
                out.println(jsonPass);
                out.close();
            }
            else {
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
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
            List<AccountModel> area = accountService.findAll();
            String dataJson =gson.toJson(area);
            out.println(dataJson);

        out.close();
    }
}
