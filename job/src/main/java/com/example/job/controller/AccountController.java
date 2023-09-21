package com.example.job.controller;

import com.example.job.model.AccountModel;
import com.example.job.service.AccountService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/account/*")
public class AccountController extends HttpServlet {
    AccountService accountService = new AccountService();
    AccountModel accountModel = new AccountModel();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String jsonData = req.getPathInfo();
        //PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        if(jsonData.equals("/login")){
            AccountModel accountModel = gson.fromJson(req.getReader(), AccountModel.class);
            AccountModel acc = accountService.findAccount(accountModel.getUserName(), accountModel.getPassword());
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
}
