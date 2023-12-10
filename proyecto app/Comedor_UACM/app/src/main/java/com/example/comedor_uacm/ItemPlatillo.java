package com.example.comedor_uacm;

public class ItemPlatillo {

    private String titulo1;
    private String descripcion1;
    private int imgResource1;


    public ItemPlatillo(String titulo1, String descripcion1, int imgResource1) {
        this.titulo1 = titulo1;
        this.descripcion1 = descripcion1;
        this.imgResource1 = imgResource1;
    }

    public String getTitulo1() { return titulo1; }

    public String getDescripcion1() { return descripcion1; }

    public int getImgResource1() { return imgResource1; }
}

