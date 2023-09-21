package com.example.job.mapper;

import com.example.job.model.AccountModel;
import com.example.job.model.AreaModel;
import com.example.job.model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<AccountModel>{
    @Override
    public AccountModel mapRow(ResultSet rs) {
        try{
            AccountModel acc = new AccountModel();
            acc.setId(rs.getLong("id"));
            acc.setUserName(rs.getString("userName"));
            acc.setPassword(rs.getString("password"));
            acc.setFullName(rs.getString("fullName"));
            acc.setStatus(rs.getInt("status"));
            acc.setRoleID(rs.getLong("roleID"));
            acc.setCreatedDate(rs.getTimestamp("createdDate"));
            acc.setCreatedBy(rs.getString("createdBy"));
            if(rs.getTimestamp("modifiedDate") != null){
                acc.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if(rs.getString("modifiedBy") != null){
                acc.setModifiedBy(rs.getString("modifiedBy"));
            }
            RoleModel role = new RoleModel();
            role.setName(rs.getString("name"));
            role.setCode(rs.getString("code"));
            acc.setRole(role);
            return acc;
        } catch (SQLException e){
            return null;
        }

    }
}
