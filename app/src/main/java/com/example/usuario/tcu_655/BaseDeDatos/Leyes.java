package com.example.usuario.tcu_655.BaseDeDatos;


import android.support.annotation.NonNull;

public class Leyes extends Datos implements Comparable{
    String articulo;

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
    public int compareTo(Object o) {
        Leyes ley = (Leyes) o;
        int comp = ley.getNombre().compareTo(this.getNombre());
        if( comp == 0){
            comp = ley.getArticulo().compareTo(this.getArticulo());
        }
        return comp;

    }

    @Override
    public String toString() {
        return "[]";
    }
}

