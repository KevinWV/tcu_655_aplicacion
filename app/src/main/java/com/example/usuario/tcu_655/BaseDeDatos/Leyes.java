package com.example.usuario.tcu_655.BaseDeDatos;


import android.support.annotation.NonNull;

public class Leyes implements Comparable<Leyes>{
    private String articulo;
    private String nombre;
    private String texto;


    public Leyes(String nombre, String articulo, String texto) {
        this.setArticulo(articulo);
        this.setNombre(nombre);
        this.setTexto(texto);
    }

    public Leyes(){

    }

    public void setArticulo( String articulo){
        this.articulo = articulo;
    }

    public String getArticulo(){
        return articulo;
    }

    @Override
    public int compareTo(Leyes o) {
        int comp = o.getNombre().compareTo(this.getNombre());
        if( comp == 0){
            comp = o.getArticulo().compareTo(this.getArticulo());
        }
        return comp;

    }

    @Override
    public String toString() {
        return "[]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

