/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadorequipoxml;

/**
 *
 * @author toreto
 */
public class Equipo {

    private int id;
    private String nombre;
    private String localidad;
    private int dia;
    private int mes;
    private int año;
    private listaJugadores jugadores;

    public Equipo(int id, String nombre, String localidad, int dia, int mes, int año) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        jugadores = new listaJugadores();
    }

    public Equipo() {
    }

    public listaJugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(listaJugadores jugadores) {
        this.jugadores = jugadores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + ", dia=" + dia + ", mes=" + mes + ", a\u00f1o=" + año + ", jugadores=" + jugadores + '}';
    }

}
