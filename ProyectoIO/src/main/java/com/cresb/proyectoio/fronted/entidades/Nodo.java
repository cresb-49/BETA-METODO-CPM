package com.cresb.proyectoio.fronted.entidades;

import java.util.ArrayList;

public class Nodo {
    private String nombre;
    private int id;
    private int duracion;
    private ArrayList<Nodo> presendecia;
    private ArrayList<Nodo> siguiente;
    
    //DATOS DE TIEMPO
    public double iniTemprano;
    public double finTemprano;
    public double iniTardio;
    public double finTardio;
    public double holgura;
    //---------------
    
    public Nodo(String nombre,int id,int duracion){
        this.nombre = nombre;
        this.id = id;
        this.duracion = duracion;
        this.presendecia = new ArrayList<>();
        this.siguiente = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public ArrayList<Nodo> getPresendecia() {
        return presendecia;
    }

    public void setPresendecia(ArrayList presendecia) {
        this.presendecia = presendecia;
    }

    public ArrayList<Nodo> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ArrayList<Nodo> siguiente) {
        this.siguiente = siguiente;
    }

    public double getIniTemprano() {
        return iniTemprano;
    }

    public void setIniTemprano(double iniTemprano) {
        this.iniTemprano = iniTemprano;
    }

    public double getFinTemprano() {
        return finTemprano;
    }

    public void setFinTemprano(double finTemprano) {
        this.finTemprano = finTemprano;
    }

    public double getIniTardio() {
        return iniTardio;
    }

    public void setIniTardio(double iniTardio) {
        this.iniTardio = iniTardio;
    }

    public double getFinTardio() {
        return finTardio;
    }

    public void setFinTardio(double finTardio) {
        this.finTardio = finTardio;
    }

    public double getHolgura() {
        return holgura;
    }

    public void setHolgura(double holgura) {
        this.holgura = holgura;
    }    

    @Override
    public String toString() {
        return "Nodo{" +  "id=" + id + ", duracion=" + duracion + ", iniTemprano=" + iniTemprano + ", finTemprano=" + finTemprano + ", iniTardio=" + iniTardio + ", finTardio=" + finTardio + ", holgura=" + holgura + '}';
    }

    
}
