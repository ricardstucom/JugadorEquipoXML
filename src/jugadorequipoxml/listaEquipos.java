/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadorequipoxml;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author toreto
 */
public class listaEquipos implements Serializable {
    private ArrayList<Equipo> lista_equipos;
    
    public listaEquipos(){
        lista_equipos = new ArrayList<>();
    }
  public void registrarEquipo(Equipo p){
       
     lista_equipos.add(p);
 }
    

    public void setLista_equipos(ArrayList<Equipo> lista_equipos) {
        this.lista_equipos = lista_equipos;
    }
   
     public ArrayList<Equipo> getLista_equipos() {
        return lista_equipos;
    }
     public Equipo encontrarEquipo(String nombre){
     for(Equipo equipo : lista_equipos){
         if(equipo.getNombre().equals(nombre) ){
             return equipo;
         }
     }
return null;
 }
}
