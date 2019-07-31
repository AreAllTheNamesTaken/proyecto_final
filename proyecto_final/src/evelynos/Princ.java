package evelynos;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Princ {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int opcion=0, elemento;
      String nombre;
      ArbolBinario arbolito = new ArbolBinario();
      do{
          try{
              opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Agregar un nodo\n" + "2. Recorrer el arbol InOrden\n" + "3. Recorer el arbol en PreOrden\n" + "4. Recorer el arbol en PosOrden\n" + "5. Buscar un Nodo en el arbol\n"+ "6. Eliminar un Nodo del arbol\n" + "7. Salir\n" 
                      + "Elige una opcion...","Arboles Binarios", JOptionPane.QUESTION_MESSAGE));
              switch(opcion){
                  case 1:
                      elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero del nodo...","Agregando nodo"
                              , JOptionPane.QUESTION_MESSAGE));
                      nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del nodo...","Agregando nodo"
                              , JOptionPane.QUESTION_MESSAGE);
                      arbolito.agregarNodo(elemento, nombre);
                     break;
                  case 2:
                      if(!arbolito.estaVacio()){
                          System.out.println();
                          arbolito.inOrden(arbolito.raiz);
                      }else{
                          JOptionPane.showMessageDialog(null, "El arbol esta vacio","!CUIDADO¡",JOptionPane.INFORMATION_MESSAGE);
                      }
                      break; 
                  case 3:
                      if(!arbolito.estaVacio()){
                          System.out.println();
                          arbolito.preOrden(arbolito.raiz);
                      }else{
                          JOptionPane.showMessageDialog(null, "El arbol esta vacio","!CUIDADO¡",JOptionPane.INFORMATION_MESSAGE);
                      }
                      break;
                  case 4:
                      if(!arbolito.estaVacio()){
                          System.out.println();
                          arbolito.posOrden(arbolito.raiz);
                      }else{
                          JOptionPane.showMessageDialog(null, "El arbol esta vacio","!CUIDADO¡",JOptionPane.INFORMATION_MESSAGE);
                      }
                      break;
                  case 5:
                      if(!arbolito.estaVacio()){
                          
                      elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero del nodo a buscar...","buscando nodo"
                              , JOptionPane.QUESTION_MESSAGE));
                              if(arbolito.buncarNodo(elemento)==null){
                               JOptionPane.showMessageDialog(null, "El nodo solicitado no se encuentra en el arbol ","!Nodo no encontrado¡",JOptionPane.INFORMATION_MESSAGE);   
                              }else{
                                  System.out.println("Nodo encontrado, sus datos son: " + arbolito.buncarNodo(elemento));
                              }
                      }else{
                          JOptionPane.showMessageDialog(null, "El arbol esta vacio","!CUIDADO¡",JOptionPane.INFORMATION_MESSAGE);
                      }
                      break;
                      case 6:
                      if(!arbolito.estaVacio()){
                          
                      elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero del nodo a eliminar...","Eliminando nodo"
                              , JOptionPane.QUESTION_MESSAGE));
                              if(arbolito.eliminar(elemento)==false){
                               JOptionPane.showMessageDialog(null, "El nodo solicitado no se encuentra en el arbol ","!Nodo no encontrado¡",JOptionPane.INFORMATION_MESSAGE);   
                              }else{
                                  JOptionPane.showMessageDialog(null, "El nodo a sido eliminado del arbol ","!Nodo eliminado¡",JOptionPane.INFORMATION_MESSAGE);
                              }
                      }else{
                          JOptionPane.showMessageDialog(null, "El arbol esta vacio","!CUIDADO¡",JOptionPane.INFORMATION_MESSAGE);
                      }
                      break;
                   case 7:
                      JOptionPane.showMessageDialog(null, "Aplicacion finalizada","FIN",JOptionPane.INFORMATION_MESSAGE);
                      break;
                  default:
                       JOptionPane.showMessageDialog(null, "Opcion incorrecta","¡Cuidado!",JOptionPane.INFORMATION_MESSAGE);
               }
          }catch(NumberFormatException n){
              JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
          }
      }while(opcion!=7);
      }
    
}
