package evelynos;

// Esto lo subiria IVAN//
public class Nodo
{  int dato;
    String nombre;
    Nodo hijoizquierdo;
    Nodo hijjoderecho;

    public Nodo(int dato, String nom) {
        this.dato = dato;
        this.nombre = nom;
        this.hijoizquierdo = null;
        this.hijjoderecho = null;
    }
    
    public String toString(){
        return nombre + " Su dato es " + dato;
    }
}
