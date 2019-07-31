package evelynos;

import java.util.Vector;

public class ArbolBinario {

  
    Nodo raiz;
     Vector  lista;
    public ArbolBinario() {
        raiz = null;
        lista = new Vector();
    }

    //metodo para insertar un Nodo
    public void agregarNodoo(int d, String nom) {
        Nodo nuevo = new Nodo(d, nom);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo auxiliar = raiz;
            Nodo padre;
            while (true) {
                padre = auxiliar;
                if (d < auxiliar.dato) {
                    auxiliar = auxiliar.hijoizquierdo;
                    if (auxiliar == null) {
                        padre.hijoizquierdo = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.hijjoderecho;
                    if (auxiliar == null) {
                        padre.hijjoderecho = nuevo;
                        return;
                    }
                }
            }

        }

    }
    //Metodo para saber cuando esta vacio
    public boolean estaVacioo() {
        return raiz == null;
    }
    
    public Vector llamaInOrder(Nodo r){
        lista.clear();
        return inOrden(r);
    }
    public Vector llamaPreOrder(Nodo r){
        lista.clear();
        return preOrden(r);
    }
    public Vector llamaPosOrder(Nodo r){
        lista.clear();
         posOrden(r);
         
        return lista;
    }
    
    public Vector inOrden(Nodo r){      
        if(r!=null){
            inOrden(r.hijoizquierdo);
            System.out.print(r.dato + ", ");
            lista.add(r);
            inOrden(r.hijjoderecho);
        }
        return lista;
    }
    
    public Vector preOrden(Nodo r){
        if(r!=null){
            System.out.print(r.dato + ", ");
            lista.add(r);
            preOrden(r.hijoizquierdo);
            preOrden(r.hijjoderecho);
        }
        return lista;
    }
      public void posOrden(Nodo r){
        if(r!=null){
            posOrden(r.hijoizquierdo);
            posOrden(r.hijjoderecho);
            lista.add(r);
            System.out.print(r.dato + ", ");
         
        }
       
    }
    //Metodo para buscar un nodo en el arbol
      public Nodo buncarNodo(int d ){
          Nodo aux=raiz;
          while (aux.dato!=d){
              if(d<aux.dato){
                  aux=aux.hijoizquierdo;
              }else{
                  aux=aux.hijjoderecho;
              }
              if(aux==null){
                  return null;
              }
          } 
          return aux;
      }
      public boolean eliminar(int d){
          Nodo auxiliar=raiz;
          Nodo padre=raiz;
          boolean esHijoIzq=true;
          while(auxiliar.dato!=d){
              padre=auxiliar;
              if(d<auxiliar.dato){
                  esHijoIzq=true;
                  auxiliar=auxiliar.hijoizquierdo;
              }else{
                  esHijoIzq=false;
                  auxiliar=auxiliar.hijjoderecho;
              }
              if(auxiliar==null){
                  return false;
              }
          }//fin del while
          if(auxiliar.hijjoderecho==null && auxiliar.hijoizquierdo==null){
              if(auxiliar==raiz){
                  raiz=null;
              }else if(esHijoIzq){
                 padre.hijoizquierdo=null;
              }else{
                  padre.hijjoderecho=null;
              } 
          }else if(auxiliar.hijjoderecho==null){
              if(auxiliar==raiz){
                  raiz=auxiliar.hijoizquierdo;
              }else if(esHijoIzq){
                 padre.hijoizquierdo=auxiliar.hijoizquierdo;
              }else{
                  padre.hijjoderecho=auxiliar.hijjoderecho;
              }
          }else if(auxiliar.hijoizquierdo==null){
              
              if(auxiliar==raiz){
                  raiz=auxiliar.hijjoderecho;
              }else if(esHijoIzq){
                 padre.hijoizquierdo=auxiliar.hijjoderecho;
              }else{
                  padre.hijjoderecho=auxiliar.hijjoderecho;
              }
          }else{
            Nodo reemplazo=obtenerNodoReemplazo(auxiliar);
            if(auxiliar==raiz){
               raiz=reemplazo;
            }else if(esHijoIzq){
                padre.hijoizquierdo=reemplazo;
            }else{
                padre.hijjoderecho=reemplazo;
            }
            reemplazo.hijoizquierdo=auxiliar.hijoizquierdo;
          }
          return true;
      }
      //Metodo que regresa el Nodo reemplazo
      public Nodo obtenerNodoReemplazo(Nodo nodoReemp){
          Nodo reemplazarpadre =nodoReemp;
          Nodo reemplazo=nodoReemp;
          Nodo auxiliar=nodoReemp.hijjoderecho;
          while(auxiliar!=null){
              reemplazarpadre=reemplazo;
              reemplazo=auxiliar;
              auxiliar=auxiliar.hijoizquierdo;
          }if(reemplazo!=nodoReemp.hijjoderecho){
              reemplazarpadre.hijoizquierdo=reemplazo.hijjoderecho;
              reemplazo.hijjoderecho=nodoReemp.hijjoderecho;
          }
          System.out.println("El nodo reemplazo es " + reemplazo);
          return reemplazo;
      }
}
