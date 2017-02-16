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
public class Jugador {

    private int id;
    private String nombre;
    private int dia;
    private int mes;
    private int año;
    private int canasTotal;
    private int asisTotal;
    private int reboTotal;
    private String posicion;

    public Jugador() {
    }

    public Jugador(int id, String nombre, int dia, int mes, int año, int canasTotal, int asisTotal, int reboTotal, String posicion) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.canasTotal = canasTotal;
        this.asisTotal = asisTotal;
        this.reboTotal = reboTotal;
        this.posicion = posicion;
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

    public int getCanasTotal() {
        return canasTotal;
    }

    public void setCanasTotal(int canasTotal) {
        this.canasTotal = canasTotal;
    }

    public int getAsisTotal() {
        return asisTotal;
    }

    public void setAsisTotal(int asisTotal) {
        this.asisTotal = asisTotal;
    }

    public int getReboTotal() {
        return reboTotal;
    }

    public void setReboTotal(int reboTotal) {
        this.reboTotal = reboTotal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nombre=" + nombre + ", dia=" + dia + ", mes=" + mes + ", a\u00f1o=" + año + ", canasTotal=" + canasTotal + ", asisTotal=" + asisTotal + ", reboTotal=" + reboTotal + ", posicion=" + posicion + '}';
    }

    
}
