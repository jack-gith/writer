package com.winterchen.model;

import org.joda.time.DateTime;

public class AccountDomain {
    private Long id;
    private String token;
    private String name;
    private String password;
    private String team;
    private String creat_time;
    private int identifying;

    public int getIdentifying() {
        return identifying;
    }

    public void setIdentifying(int identifying) {
        this.identifying = identifying;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(String creat_time) {
        this.creat_time = creat_time;
    }
}
