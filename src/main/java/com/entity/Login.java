package com.entity;

import java.sql.Date;

/**
 * @Author: EvenHuang
 * @Date: 2019/4/27 15:49
 */
public class Login {
    private String loginId;
    private Date lastLogin;
    private Integer duration;
    private String manager;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
