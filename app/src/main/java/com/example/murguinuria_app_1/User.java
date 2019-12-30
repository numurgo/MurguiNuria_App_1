package com.example.murguinuria_app_1;

public class User {
    private String name, user, password;
    private int nivel;

    public User(String name, String user, String password, int nivel) {
        this.name = name;
        this.user = user;
        this.password = password;
        this.nivel = nivel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
