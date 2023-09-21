package com.example.job.dao;

import com.example.job.model.AccountModel;

public interface IAccountDAO extends GernericDAO<AccountModel>{
    AccountModel findAccount(String userName, String password);
}
