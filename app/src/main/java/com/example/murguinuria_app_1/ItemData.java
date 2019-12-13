package com.example.murguinuria_app_1;

public class ItemData {

    private String nivel, tituloNivel, instrucciones;
    private int imageUrl;
    boolean active;

    public ItemData(String nivel, String tituloNivel, String instrucciones, int imageUrl, boolean active) {
        this.nivel = nivel;
        this.tituloNivel = tituloNivel;
        this.instrucciones = instrucciones;
        this.imageUrl = imageUrl;
        this.active= true;
    }

    public String getNivel() {
        return nivel;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public String getTituloNivel() {
        return tituloNivel;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public void setTituloNivel(String tituloNivel) {
        this.tituloNivel = tituloNivel;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}