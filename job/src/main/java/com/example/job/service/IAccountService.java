package com.example.job.service;

import com.example.job.model.AccountModel;

public interface IAccountService {

    AccountModel findAccount(String userName, String password);


}
