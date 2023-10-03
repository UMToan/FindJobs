package com.example.job.service;

import com.example.job.model.AccountModel;

import java.util.List;

public interface IAccountService {

    AccountModel findAccount(String userName, String password);

    List<AccountModel> findAll();
}
