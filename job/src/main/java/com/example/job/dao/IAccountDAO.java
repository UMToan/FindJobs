package com.example.job.dao;

import com.example.job.model.AccountModel;
import com.example.job.model.JobsModel;

import java.util.List;

public interface IAccountDAO extends GernericDAO<AccountModel>{
    AccountModel findAccount(String userName, String password);

    List<AccountModel> findAll();
}
