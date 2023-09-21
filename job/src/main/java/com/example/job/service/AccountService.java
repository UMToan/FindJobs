package com.example.job.service;

import com.example.job.dao.AccountDAO;
import com.example.job.model.AccountModel;

import java.sql.SQLException;

public class AccountService implements IAccountService{

    AccountDAO accountDAO = new AccountDAO();

    @Override
    public AccountModel findAccount(String userName, String password) {
        if(userName.isEmpty() && password.isEmpty()){
            return null;
        }
        else{
            return accountDAO.findAccount(userName, password);
        }
    }

}
