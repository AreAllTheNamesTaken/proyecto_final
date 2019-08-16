package evelynos;

// Esto lo subiria IVAN//
public class Nodo
{  int dato;
    String nombre;
    Nodo hijoizquierdo;
    Nodo hijjoderecho;

    public Nodo(int dato) {
        this.dato = dato;
        this.hijoizquierdo = null;
        this.hijjoderecho = null;
    }
    
    public String toString(){
        return nombre + " El dato es  : " + dato;
    }
}
