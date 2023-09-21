package com.example.job.model;

public class AccountModel extends AbstractModel<AccountModel>{
    private String userName;
    private String password;
    private String fullName;

    private int status;
    private Long roleID;
    private RoleModel role = new RoleModel();

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }
}
