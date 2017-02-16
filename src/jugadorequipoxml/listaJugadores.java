/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadorequipoxml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toreto
 */
public class listaJugadores implements Serializable {
    
//    private ArrayList<Jugador>lista_jugadores;
//    
//    public listaJugadores(){
//        lista_jugadores = new ArrayList<>();
//    }
//public void registrarJugador(Jugador p){
//        lista_jugadores.add(p);
//    }
//    public ArrayList<Jugador> getLista_jugadores() {
//        return lista_jugadores;
//    }
//
//    public void setLista_jugadores(ArrayList<Jugador> lista_jugadores) {
//        this.lista_jugadores = lista_jugadores;
//    }
//    public List<Jugador> found (){
//         return lista_jugadores;
//    }
    
    private ArrayList<Jugador>lista_jugador;
    
    public listaJugadores(){
        lista_jugador = new ArrayList<>();
    }
    public void registrarJugador(Jugador p){
        lista_jugador.add(p);
    }

    public ArrayList<Jugador> getLista_jugador() {
        return lista_jugador;
    }

    public void setLista_jugador(ArrayList<Jugador> lista_jugador) {
        this.lista_jugador = lista_jugador;
    }
    public Jugador encontrarJugador(String nombre){
     for(Jugador jugador : lista_jugador){
         if(jugador.getNombre() == nombre){
             return jugador;
         }
     }
return null;
 }
    public List<Jugador> found (){
         return lista_jugador;
    }
    
}
