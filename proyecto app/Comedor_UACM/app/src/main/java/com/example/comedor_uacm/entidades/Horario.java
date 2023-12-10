package com.example.comedor_uacm.entidades;

public class Horario {
    private int id;
    private String nombre;
    private int H_i,M_i,H_f,M_f;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getH_i() {
        return H_i;
    }

    public void setH_i(int h_i) {
        H_i = h_i;
    }

    public int getM_i() {
        return M_i;
    }

    public void setM_i(int m_i) {
        M_i = m_i;
    }

    public int getH_f() {
        return H_f;
    }

    public void setH_f(int h_f) {
        H_f = h_f;
    }

    public int getM_f() {
        return M_f;
    }

    public void setM_f(int m_f) {
        M_f = m_f;
    }
}
