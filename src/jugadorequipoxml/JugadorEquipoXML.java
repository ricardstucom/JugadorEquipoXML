/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadorequipoxml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import tools.Fichero;
import tools.InputData;

/**
 *
 * @author 46989075y
 */
public class JugadorEquipoXML {

    private static listaEquipos misEquipos;
    private static Fichero mifichero;

    public static void main(String[] args) throws ParseException {
        Equipo equipo = new Equipo();
        mifichero = new Fichero("basket.xml");
        misEquipos = (listaEquipos) mifichero.leer();

        if (misEquipos == null) {
            misEquipos = new listaEquipos();
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = InputData.pedirEntero("Escoge una opción");
            switch (opcion) {
                case 1:
                    altaEquipo();
                    break;

                case 2:
                    altaJugador();
                    break;
                case 3:
                    do {
                        menuJugadores();
                        opcion = InputData.pedirEntero("Escoge una opción");
                        switch (opcion) {
                            case 1:
                                jugadoresNombre();
                                break;
                            case 2:
                                jugadoresCanastasNum();
                                break;
                            case 3:
                                jugadoresAsistenciasNum();
                                break;
                            case 4:
                                jugadoresPosicion();
                                break;
                            case 5:
                                jugadoresNacimiento();

                                break;
                            case 6:
                                agruparPosicion();
                                break;
                            case 7:
                                agruparPosicion2();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción incorrecta");
                        }
                    } while (opcion != 0);
                    break;
                case 4:
                    do {
                        menuEquipos();
                        opcion = InputData.pedirEntero("Escoge una opción");
                        switch (opcion) {
                            case 1:
                                equiposLocalidad();
                                break;
                            case 2:
                                jugadoresNombreEquipo();
                                break;
                            case 3:
                                jugadoresEquipoPosicion();
                                break;
                            case 4:
                                jugadorMaxCanastasEquipo();
                                break;

                            case 0:
                                break;
                            default:
                                System.out.println("Opción incorrecta");
                        }
                    } while (opcion != 0);
                    break;

                case 0:
                    System.out.println("Hasta luegooo!");
                    break;
                default:
                    System.out.println("Opción incorrecta");

            }
        } while (opcion != 0);

    }

    private static void mostrarMenu() {
        System.out.println("*****Jugador - Equipo****");
        System.out.println("1.Alta Equipo");
        System.out.println("2.Alta Jugador");
        System.out.println("3.Menú de consultas de jugadores ");

        System.out.println("4.Menú de consultas de equipos");

        System.out.println("0. Salir");

    }

    private static void menuJugadores() {
        System.out.println("*****Menú Jugadores****");
        System.out.println("1.Buscar jugadores por nombre");
        System.out.println("2.Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro");
        System.out.println("3.Buscar jugadores que hayan efectuado un número de asistencia dentro de un rango especificado como parámetro");
        System.out.println("4.Buscar jugadores que pertenezcan a una posición específica, ejemplo: ba se");
        System.out.println("5.Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro");
        System.out.println("6.Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: la media de canastas , asistencias rebotes");
        System.out.println("7.Lo mismo que el punto anterior pero devolviendo la media , el máximo y el mínimo de canastas , asistencias y rebotes");
        System.out.println("0. Salir");

    }

    private static void menuEquipos() {
        System.out.println("*****Menú Equipos****");
        System.out.println("1.Consulta los equipos existentes en una localidad determinada");
        System.out.println("2.Devuelve todos los jugadores de un equipo , a partir del nombre completo del equipo");
        System.out.println("3.Devuelve todos los jugadores de un equipo , que además jueguen la misma posición (parámetro adicional de la consulta) , por ejemplo alero");
        System.out.println("4.Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro");
        System.out.println("0. Salir");

    }

    private static void altaEquipo() {
        int id = 1;
        String nombre;
        String localidad;
        int dia = 0;
        int mes = 0;
        int año = 0;

        nombre = InputData.pedirCadena("Nombre del equipo: ");
        localidad = InputData.pedirCadena("Localidad: ");
        dia = InputData.pedirEntero("Dia de creación:");
        mes = InputData.pedirEntero("Mes de creación:");
        año = InputData.pedirEntero("Año de creación:");

        while (nombre.equals("")) {
            nombre = InputData.pedirCadena("Nombre del equipo: ");
        }
        while (localidad.equals("")) {
            localidad = InputData.pedirCadena("Localidad del equipo: ");
        }
        while (dia == 0) {
            dia = InputData.pedirEntero("Dia del equipo: ");
        }

        while (mes == 0) {
            mes = InputData.pedirEntero("Mes del equipo: ");
        }

        while (año == 0) {
            año = InputData.pedirEntero("Año del equipo: ");
        }

        Equipo nuevo = new Equipo(id, nombre, localidad, dia, mes, año);
        misEquipos.registrarEquipo(nuevo);
        mifichero.grabar(misEquipos);
    }

    private static void altaJugador() {

        String nombreEquipo;

        nombreEquipo = InputData.pedirCadena("Introduce el nombre del equipo al cual perteneces: ");

        Equipo equipo = misEquipos.encontrarEquipo(nombreEquipo);
        System.out.println(equipo);
        if (equipo == null) {
            System.out.println("Este equipo no existe");
        } else {
            int id = 1;
            String nombre;
            int dia2;
            int mes2;
            int año2;
            int canasTotal2;
            int asisTotal2;
            int reboTotal2;
            String posicion;
            nombre = InputData.pedirCadena("Introduce tu nombre: ");
            dia2 = InputData.pedirEntero("Introduce el dia de tu nacimiento: ");
            mes2 = InputData.pedirEntero("Introduce el mes de tu nacimiento: ");
            año2 = InputData.pedirEntero("Introduce el año de tu nacimiento: ");
            posicion = InputData.pedirCadena("Introduce tu posición (alero, base, pivot)");

            canasTotal2 = InputData.pedirEntero("Introduce el numero de canastas totales: ");
            asisTotal2 = InputData.pedirEntero("Introduce el numero de asistencias totales: ");
            reboTotal2 = InputData.pedirEntero("Introduce el numero de rebotes totales: ");

            Jugador c = new Jugador(id, nombre, dia2, mes2, año2, canasTotal2, asisTotal2, reboTotal2, posicion);
            equipo.getJugadores().registrarJugador(c);
            mifichero.grabar(misEquipos);

        }
    }

    private static void jugadoresNombre() {
        //Buscar jugadores por nombre , de manera que no sea necesario introducir el nombre completo 
        String nombre;
        System.out.println("-------BUSCADOR-------");
        nombre = InputData.pedirCadena("Nombre que quieres buscar : ");
        for (Equipo equipo : misEquipos.getLista_equipos()) {
            for (Jugador jugador : equipo.getJugadores().getLista_jugador()) {
                String name = equipo.getNombre();

                if (name.indexOf(nombre) > -1) {
                    System.out.println("Nombre del equipo :" + name);
                    System.out.println("Nombre del jugador : " + jugador.getNombre());

                    String fecha = jugador.getDia() + "/" + jugador.getMes() + "/" + jugador.getAño();
                    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                    // LocalDate nacimiento = LocalDate.parse(fecha, formatter);

                    //SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
                    // String nacimiento = newFormat.format(fecha);
                    System.out.println("Fecha de nacimiento :" + fecha);
                    System.out.println("Posición :" + jugador.getPosicion());
                    System.out.println("Canastas totales :" + jugador.getCanasTotal());
                    System.out.println("Asistencias Totales :" + jugador.getAsisTotal());
                    System.out.println("Rebotes totales :" + jugador.getReboTotal());
                    break;
                } else {
                    System.out.println("No existe este jugador ");
                }

            }

        }
    }

    private static void jugadoresCanastasNum() {

        //Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro 
        int canastas;
        canastas = InputData.pedirEntero("Introduce el número de canastas");
        for (Equipo equipo : misEquipos.getLista_equipos()) {
            for (Jugador jugador : equipo.getJugadores().getLista_jugador()) {
                String name = equipo.getNombre();
                String fecha = jugador.getDia() + "/" + jugador.getMes() + "/" + jugador.getAño();
                if (jugador.getCanasTotal() >= canastas) {
                    System.out.println("------------------");
                    System.out.println("Número introducido :" + canastas);
                    System.out.println("------------------");
                    System.out.println("Nombre del equipo :" + name);
                    System.out.println("Nombre del jugador : " + jugador.getNombre());
                    System.out.println("Fecha de nacimiento :" + fecha);
                    System.out.println("Posición :" + jugador.getPosicion());
                    System.out.println("Canastas totales :" + jugador.getCanasTotal());
                    System.out.println("------------------");
                }
            }
        }
    }

    private static void jugadoresAsistenciasNum() {
        //Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro
        int asistenciasMin;
        int asistenciasMax;

        asistenciasMax = InputData.pedirEntero("Introduce el número de asistencias máximo");
        asistenciasMin = InputData.pedirEntero("Introduce el número de asistencias mínimo");
        for (Equipo equipo : misEquipos.getLista_equipos()) {
            for (Jugador jugador : equipo.getJugadores().getLista_jugador()) {
                String name = equipo.getNombre();
                String fecha = jugador.getDia() + "/" + jugador.getMes() + "/" + jugador.getAño();
                if (jugador.getAsisTotal() >= asistenciasMin && jugador.getAsisTotal() <= asistenciasMax) {
                    System.out.println("------------------");
                    System.out.println("Número máximo introducido :" + asistenciasMax);
                    System.out.println("Número mínimo introducido :" + asistenciasMin);
                    System.out.println("------------------");
                    System.out.println("Nombre del equipo :" + name);
                    System.out.println("Nombre del jugador : " + jugador.getNombre());
                    System.out.println("Fecha de nacimiento :" + fecha);
                    System.out.println("Posición :" + jugador.getPosicion());
                    System.out.println("Canastas totales :" + jugador.getAsisTotal());
                    System.out.println("------------------");
                }
            }
        }

    }

    private static void jugadoresPosicion() {
        //Buscar jugadores que pertenezcan a una posición específica , por ejemplo: base.

        String posicion;

        posicion = InputData.pedirCadena("Introduce la posición que deseas buscar");

        for (Equipo equipo : misEquipos.getLista_equipos()) {
            for (Jugador jugador : equipo.getJugadores().getLista_jugador()) {
                String name = equipo.getNombre();
                String fecha = jugador.getDia() + "/" + jugador.getMes() + "/" + jugador.getAño();
                if (jugador.getPosicion().equals(posicion)) {
                    System.out.println("------------------");
                    System.out.println("Posición que has introducido :" + posicion);
                    System.out.println("------------------");
                    System.out.println("Nombre del equipo :" + name);
                    System.out.println("Nombre del jugador : " + jugador.getNombre());
                    System.out.println("Fecha de nacimiento :" + fecha);
                    System.out.println("Posición :" + jugador.getPosicion());
                    System.out.println("------------------");
                }
            }
        }
    }

    private static void jugadoresNacimiento() throws ParseException {
        //Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro

        int dia;
        int mes;
        int año;

        dia = InputData.pedirEntero("Introduce el dia de nacimiento");
        mes = InputData.pedirEntero("Introduce el mes de nacimiento");
        año = InputData.pedirEntero("Introduce el año de nacimiento");

        for (Equipo equipo : misEquipos.getLista_equipos()) {
            for (Jugador jugador : equipo.getJugadores().getLista_jugador()) {
                String name = equipo.getNombre();
                String fecha = jugador.getDia() + "/" + jugador.getMes() + "/" + jugador.getAño();
                String fechaIntroducida = dia + "/" + mes + "/" + año;

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha2 = null;
                Date fechaIntroducida2 = null;
                fecha2 = formato.parse(fecha);
                fechaIntroducida2 = formato.parse(fechaIntroducida);
                if (fecha2.before(fechaIntroducida2)) {
                    System.out.println("------------------");
                    System.out.println("Fecha introducida :" + fechaIntroducida2);
                    System.out.println("------------------");
                    System.out.println("Nombre del equipo :" + name);
                    System.out.println("Nombre del jugador : " + jugador.getNombre());
                    System.out.println("Fecha de nacimiento :" + fecha2);

                    System.out.println("------------------");
                } else {
                    System.out.println("No hay ningun jugador con una fecha anterior a la que has introducido");
                }
            }
        }

    }

    private static void agruparPosicion() {
        int contadorAlero = 0;
        int contadorPivot = 0;
        int contadorBase = 0;
        int mediaCanastasAlero = 0;
        int mediaCanastasPivot = 0;
        int mediaCanastasBase = 0;

        int mediaAsistenciasAlero = 0;
        int mediaAsistenciasPivot = 0;
        int mediaAsistenciasBase = 0;

        int mediaRebotesAlero = 0;
        int mediaRebotesPivot = 0;
        int mediaRebotesBase = 0;
        //Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: 
        //la media de canastas , asistencias y rebotes
        String nombre;
        ArrayList<Jugador> alero = new ArrayList<Jugador>();
        ArrayList<Jugador> pivot = new ArrayList<Jugador>();
        ArrayList<Jugador> base = new ArrayList<Jugador>();

        for (Equipo equipo : misEquipos.getLista_equipos()) {
            for (Jugador jugador : equipo.getJugadores().getLista_jugador()) {
                if (jugador.getPosicion().equalsIgnoreCase("alero")) {
                    alero.add(jugador);
                }
                if (jugador.getPosicion().equalsIgnoreCase("pivot")) {
                    pivot.add(jugador);
                }
                if (jugador.getPosicion().equalsIgnoreCase("base")) {
                    base.add(jugador);
                }
            }
        }

        for (Jugador jugador : alero) {
            mediaCanastasAlero += jugador.getCanasTotal();
            mediaAsistenciasAlero += jugador.getAsisTotal();
            mediaRebotesAlero += jugador.getReboTotal();
            contadorAlero++;
        }
        for (Jugador jugador : pivot) {
            mediaCanastasPivot += jugador.getCanasTotal();
            mediaAsistenciasPivot += jugador.getAsisTotal();
            mediaRebotesPivot += jugador.getReboTotal();
            contadorPivot++;
        }

        for (Jugador jugador : base) {
            mediaCanastasBase += jugador.getCanasTotal();
            mediaAsistenciasBase += jugador.getAsisTotal();
            mediaRebotesBase += jugador.getReboTotal();
            contadorBase++;
        }

        
        mediaCanastasAlero = mediaCanastasAlero/contadorAlero;
        mediaCanastasPivot = mediaCanastasPivot/contadorPivot;
        mediaCanastasBase = mediaCanastasBase/contadorBase;

        mediaAsistenciasAlero = mediaAsistenciasAlero/contadorAlero;
        mediaAsistenciasPivot = mediaAsistenciasPivot/contadorPivot;
        mediaAsistenciasBase = mediaAsistenciasBase/contadorBase;

         mediaRebotesAlero = mediaRebotesAlero/contadorAlero;
        mediaRebotesPivot = mediaRebotesPivot/contadorPivot;
        mediaRebotesBase = mediaRebotesBase/contadorBase;

        System.out.println("---------------");
        System.out.println("-----ALERO-----");
        System.out.println("Canastas :" + mediaCanastasAlero);
        System.out.println("Asistencias :" + mediaAsistenciasAlero);
        System.out.println("Rebotes :" + mediaRebotesAlero);
        System.out.println("---------------");
        System.out.println("-----PIVOT-----");
        System.out.println("Canastas :" + mediaCanastasPivot);
        System.out.println("Asistencias :" + mediaAsistenciasPivot);
        System.out.println("Rebotes :" + mediaRebotesPivot);
        System.out.println("---------------");
        System.out.println("-----BASE-----");
        System.out.println("Canastas :" + mediaCanastasBase);
        System.out.println("Asistencias :" + mediaAsistenciasBase);
        System.out.println("Rebotes :" + mediaRebotesBase);
        System.out.println("---------------");
    }
    
    private static void agruparPosicion2(){
    //Lo mismo que el punto anterior pero devolviendo la media , el máximo
//y el mínimo de canastas , asistencias y rebotes

int contadorAlero = 0;
        int maxCanastasAlero=0;
        int maxCanastasPivot=0;
        int maxCanastasBase=0;
        
        int maxAsistenciasAlero=0;
        int maxAsistenciasPivot=0;
        int maxAsistenciasBase=0;
        
        int maxRebotesAlero=0;
        int maxRebotesPivot=0;
        int maxRebotesBase=0;
        
         int minCanastasAlero=0;
        int minCanastasPivot=0;
        int minCanastasBase=0;
        
        int minAsistenciasAlero=0;
        int minAsistenciasPivot=0;
        int minAsistenciasBase=0;
        
        int minRebotesAlero=0;
        int minRebotesPivot=0;
        int minRebotesBase=0;
        
        
        int contadorPivot = 0;
        int contadorBase = 0;
        int mediaCanastasAlero = 0;
        int mediaCanastasPivot = 0;
        int mediaCanastasBase = 0;

        int mediaAsistenciasAlero = 0;
        int mediaAsistenciasPivot = 0;
        int mediaAsistenciasBase = 0;

        int mediaRebotesAlero = 0;
        int mediaRebotesPivot = 0;
        int mediaRebotesBase = 0;
        
        String nombre;
        ArrayList<Jugador> alero = new ArrayList<Jugador>();
        ArrayList<Jugador> pivot = new ArrayList<Jugador>();
        ArrayList<Jugador> base = new ArrayList<Jugador>();

        for (Equipo equipo : misEquipos.getLista_equipos()) {
            for (Jugador jugador : equipo.getJugadores().getLista_jugador()) {
                if (jugador.getPosicion().equalsIgnoreCase("alero")) {
                    alero.add(jugador);
                }
                if (jugador.getPosicion().equalsIgnoreCase("pivot")) {
                    pivot.add(jugador);
                }
                if (jugador.getPosicion().equalsIgnoreCase("base")) {
                    base.add(jugador);
                }
            }
        }

        for (Jugador jugador : alero) {
            mediaCanastasAlero += jugador.getCanasTotal();
            mediaAsistenciasAlero += jugador.getAsisTotal();
            mediaRebotesAlero += jugador.getReboTotal();
            if(jugador.getCanasTotal()>maxCanastasAlero) {
                maxCanastasAlero = jugador.getCanasTotal();
            }
            if(jugador.getCanasTotal()<minCanastasAlero){
                
                minCanastasAlero = jugador.getCanasTotal();
            }
            
            if(jugador.getAsisTotal()>maxAsistenciasAlero) {
                maxAsistenciasAlero = jugador.getAsisTotal();
            }
            if(jugador.getAsisTotal()<minAsistenciasAlero){
                
                minAsistenciasAlero = jugador.getAsisTotal();
            }
            
            if(jugador.getReboTotal()>maxRebotesAlero) {
                maxRebotesAlero = jugador.getReboTotal();
            }
            if(jugador.getReboTotal()<minRebotesAlero){
                
                minRebotesAlero = jugador.getReboTotal();
            }
            contadorAlero++;
        }
        for (Jugador jugador : pivot) {
            mediaCanastasPivot += jugador.getCanasTotal();
            mediaAsistenciasPivot += jugador.getAsisTotal();
            mediaRebotesPivot += jugador.getReboTotal();
            
              if(jugador.getCanasTotal()>maxCanastasPivot) {
                maxCanastasPivot = jugador.getCanasTotal();
            }
            if(jugador.getCanasTotal()<minCanastasPivot){
                
                minCanastasPivot = jugador.getCanasTotal();
            }
            
            if(jugador.getAsisTotal()>maxAsistenciasPivot) {
                maxAsistenciasPivot = jugador.getAsisTotal();
            }
            if(jugador.getAsisTotal()<minAsistenciasPivot){
                
                minAsistenciasPivot = jugador.getAsisTotal();
            }
            
            if(jugador.getReboTotal()>maxRebotesPivot) {
                maxRebotesPivot = jugador.getReboTotal();
            }
            if(jugador.getReboTotal()<minRebotesPivot){
                
                minRebotesPivot = jugador.getReboTotal();
            }
            contadorPivot++;
        }

        for (Jugador jugador : base) {
            mediaCanastasBase += jugador.getCanasTotal();
            mediaAsistenciasBase += jugador.getAsisTotal();
            mediaRebotesBase += jugador.getReboTotal();
            
            
            if(jugador.getCanasTotal()>maxCanastasBase) {
                maxCanastasBase = jugador.getCanasTotal();
            }
            if(jugador.getCanasTotal()<minCanastasBase){
                
                minCanastasBase = jugador.getCanasTotal();
            }
            
            if(jugador.getAsisTotal()>maxAsistenciasBase) {
                maxAsistenciasBase = jugador.getAsisTotal();
            }
            if(jugador.getAsisTotal()<minAsistenciasBase){
                
                minAsistenciasBase = jugador.getAsisTotal();
            }
            
            if(jugador.getReboTotal()>maxRebotesBase) {
                maxRebotesBase = jugador.getReboTotal();
            }
            if(jugador.getReboTotal()<minRebotesBase){
                
                minRebotesBase = jugador.getReboTotal();
            }
            contadorBase++;
        }

        
        mediaCanastasAlero = mediaCanastasAlero/contadorAlero;
        mediaCanastasPivot = mediaCanastasPivot/contadorPivot;
        mediaCanastasBase = mediaCanastasBase/contadorBase;

        mediaAsistenciasAlero = mediaAsistenciasAlero/contadorAlero;
        mediaAsistenciasPivot = mediaAsistenciasPivot/contadorPivot;
        mediaAsistenciasBase = mediaAsistenciasBase/contadorBase;

         mediaRebotesAlero = mediaRebotesAlero/contadorAlero;
        mediaRebotesPivot = mediaRebotesPivot/contadorPivot;
        mediaRebotesBase = mediaRebotesBase/contadorBase;

        System.out.println("---------------");
        System.out.println("-----ALERO-----");
        System.out.println("Canastas :" + mediaCanastasAlero);
        System.out.println("Máximo Canastas : "+maxCanastasAlero);
        System.out.println("Mínimo Canastas : "+minCanastasAlero);
        System.out.println("Asistencias :" + mediaAsistenciasAlero);
        System.out.println("Máximo Asistencias : "+maxAsistenciasAlero);
        System.out.println("Mínimo Asistencias : "+minAsistenciasAlero);
        System.out.println("Rebotes :" + mediaRebotesAlero);
        System.out.println("Máximo Rebotes : "+maxRebotesAlero);
        System.out.println("Mínimo Rebotes : "+minRebotesAlero);
        
        System.out.println("---------------");
        System.out.println("-----PIVOT-----");
        System.out.println("Canastas :" + mediaCanastasPivot);
        System.out.println("Máximo Canastas : "+maxCanastasPivot);
        System.out.println("Mínimo Canastas : "+minCanastasPivot);
        System.out.println("Asistencias :" + mediaAsistenciasPivot);
         System.out.println("Máximo Asistencias : "+maxAsistenciasPivot);
        System.out.println("Mínimo Asistencias : "+minAsistenciasPivot);
        System.out.println("Rebotes :" + mediaRebotesPivot);
         System.out.println("Máximo Rebotes : "+maxRebotesPivot);
        System.out.println("Mínimo Rebotes : "+minRebotesPivot);
        System.out.println("---------------");
        System.out.println("-----BASE-----");
        System.out.println("Canastas :" + mediaCanastasBase);
        System.out.println("Máximo Canastas : "+maxCanastasBase);
        System.out.println("Mínimo Canastas : "+minCanastasBase);
        System.out.println("Asistencias :" + mediaAsistenciasBase);
        System.out.println("Máximo Asistencias : "+maxAsistenciasBase);
        System.out.println("Mínimo Asistencias : "+minAsistenciasBase);
        System.out.println("Rebotes :" + mediaRebotesBase);
         System.out.println("Máximo Rebotes : "+maxRebotesBase);
        System.out.println("Mínimo Rebotes : "+minRebotesBase);
        System.out.println("---------------");
    }
    
    private static void equiposLocalidad(){
    //Consulta los equipos existentes en una localidad determinada
     String localidad;
     localidad = InputData.pedirCadena("Localidad que quieres buscar : ");
    for (Equipo equipo : misEquipos.getLista_equipos()) {
        if(equipo.getLocalidad().equalsIgnoreCase(localidad)){
            
            System.out.println(equipo);
        }
        else{
            System.out.println("Esta localidad no existe");
            break;
        }
        
        
    }
    }
    
    private static void jugadoresNombreEquipo(){
    //Devuelve todos los jugadores de un equipo , a partir del nombre completo del equipo
    String nombre;
     nombre = InputData.pedirCadena("Nombre del equipo : ");
    for (Equipo equipo : misEquipos.getLista_equipos()) {
        if(equipo.getNombre().equalsIgnoreCase(nombre)){
            for (Jugador jugador : equipo.getJugadores().getLista_jugador()) {
                
                System.out.println(jugador);
                
            }
        }
            }
    
    }
    
    
    
    private static void jugadoresEquipoPosicion(){
   //Devuelve todos los jugadores de un equipo , que además jueguen en
//la misma posición (parámetro adicional de la consulta) , por ejemplo ,alero

String nombre;
String posicion;
     nombre = InputData.pedirCadena("Nombre del equipo : ");
     posicion = InputData.pedirCadena("Posición de los jugadores : ");
    for (Equipo equipo : misEquipos.getLista_equipos()) {
        if(equipo.getNombre().equalsIgnoreCase(nombre)){
            
            for (Jugador jugador : equipo.getJugadores().getLista_jugador()) {
                if(jugador.getPosicion().equalsIgnoreCase(posicion)){
                System.out.println(jugador);
                }else{
                    System.out.println("Esta posición no existe");
                    break;
            }
        }
            }else{
            System.out.println("Este equipo no existe");
            break;
        }
    
    }


    }
    
    private static void jugadorMaxCanastasEquipo(){
    //Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro
    String nombre;
    Jugador maximo = new Jugador();
     nombre = InputData.pedirCadena("Nombre del equipo : ");
     int maxCanastas=0;
     for (Equipo equipo : misEquipos.getLista_equipos()) {
          for (Jugador jugador : equipo.getJugadores().getLista_jugador()) {
              
          if(jugador.getCanasTotal()>maxCanastas){
              maxCanastas = jugador.getCanasTotal();
              
              maximo = jugador;
          }
          }
          
     }
        System.out.println(maximo);
    }
}
