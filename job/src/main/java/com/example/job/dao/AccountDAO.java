package com.example.job.dao;

import com.example.job.mapper.AccountMapper;
import com.example.job.mapper.AreaMapper;
import com.example.job.model.AccountModel;
import com.example.job.model.AreaModel;

import java.util.List;

public class AccountDAO extends AbstractDAO<AccountModel> implements IAccountDAO{
    @Override
    public AccountModel findAccount(String userName, String password) {
        StringBuilder sql = new StringBuilder("SELECT * FROM account AS u");
        sql.append(" INNER JOIN role AS r ON r.id = u.roleId");
        sql.append(" WHERE userName = ? AND password = ?");
        List<AccountModel> acc = query(sql.toString(), new AccountMapper(), userName, password);
        return acc.isEmpty() ? null : acc.get(0);
    }
}
