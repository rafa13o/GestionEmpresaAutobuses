/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class GestoraEmpresa {

    Trabajador elTrabajador;
    Autobus elAutobus;
    Ruta laRuta;
    Cliente elCliente;
    Factura laFactura;
    Usuario elUsuario;

    //ALMACENAMIENTOS
    ArrayList<Trabajador> losTrabajadores = new ArrayList();
    ArrayList<Autobus> losAutobuses = new ArrayList();
    ArrayList<Ruta> lasRutas = new ArrayList();
    ArrayList<Cliente> losClientes = new ArrayList();
    ArrayList<Factura> lasFacturas = new ArrayList();
    ArrayList<Usuario> losUsuarios = new ArrayList();
    EnumSecciones[] lasSecciones = EnumSecciones.values();
    EnumCombustible[] losCombustibles = EnumCombustible.values();

    /**
     *
     */
    public GestoraEmpresa() {
        leerArchivos();
//        losTrabajadores.add(new Trabajador("12345678J", "TRECENIO RODRIGUEZ, RAFAEL", 2019, "CONDUCTOR"));
//        losTrabajadores.add(new Trabajador("12345678Z", "TRECENIO RODRIGUEZ, RAFAEL", 2016, "DIRECCION"));
//        losAutobuses.add(new Autobus("5188JSG", "IRIZAR", "I6S", "MECEDES-BENZ", "HIBRIDO", 55, 30000));
//        losAutobuses.add(new Autobus("3515BVW", "IRIZAR", "I6", "RENAULT", "GASOLINA", 55, 30000));
//        losAutobuses.add(new Autobus("9876JZP", "AYATS", "ATLANTIS", "SCANIA", "DIESEL", 70, 70000));
//        losClientes.add(new Cliente("RAF123", "RAFAEL", "VALLADOLID", 123654789));
//        losClientes.add(new Cliente("VAC123", "VACCEO CRAFT BEER S.L.", "MADRID", 917654321));
//        lasRutas.add(new Ruta("VM00184", "VALLADOLID", "MADRID", 184, "12345678J", "5188JSG", "VAC123"));
//        lasRutas.add(new Ruta("VP02262", "VALLADOLID", "POTSDAM", 2262, "12345678J", "9876JZP", "RAF123"));
//        LocalDate fecha = LocalDate.of(2019, 07, 10);
//        lasFacturas.add(new Factura(1, "RAFAEL", "VALLADOLID", 123654789, "VM00184", fecha, 36.8));
//        lasFacturas.add(new Factura(2, "VACCEO CRAFT BEER S.L.", "MADRID", 917654321, "VP02262", fecha, 452.4));
//        escribirArchivos();
    }

    //GENERAR NUEVOS DATOS******************************************************************************************************
    /**
     * Genera un nuevo trabajador
     *
     * @param dni
     * @param nomApe nombre y apellidos del trabajador
     * @param anio a�o de ingreso del trabajador
     * @param seccion secci�n en la que trabaja
     * @return true si se ha podido crear - false si ha ocurrido alg�n error
     */
    public boolean nuevoTrabajador(String dni, String nomApe, int anio, String seccion) {
        LocalDate fechaActual = LocalDate.now();
        int anioActual = fechaActual.getYear();
        ArrayList<String> losDni = new ArrayList();
        losDni.addAll(Arrays.asList(getTodosLosDNI()));
        if (losDni.contains(dni) == false) {
            if (anio <= anioActual) {
                elTrabajador = new Trabajador(dni, nomApe, anio, seccion);
                losTrabajadores.add(elTrabajador);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El a�o no puede ser posterior al actual.\n"
                        + "Por favor, revise los datos e int�ntelo de nuevo", "Error - GESTI�N DE EMPRESA �", 1);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El DNI pertenece a un trabajador ya existente.\n"
                    + "Por favor, revise los datos e int�ntelo de nuevo", "Error - GESTI�N DE EMPRESA �", 1);
        }
        return false;
    }

    /**
     * Genera un nuevo autob�s a partir de los par�metros obtenidos de la
     * ventana
     *
     * @param matricula
     * @param fabricante
     * @param modelo
     * @param motor
     * @param combustible
     * @param plazas
     * @param precio
     * @return true si se ha podido crear - false si ha ocurrido alg�n error
     */
    public boolean nuevoAutobus(String matricula, String fabricante, String modelo, String motor, String combustible, int plazas, int precio) {
        ArrayList<String> lasMatriculas = new ArrayList();
        try {
            for (Autobus unAutobus : losAutobuses) {
                lasMatriculas.add(unAutobus.getMatricula());
            }
        } catch (NullPointerException err1) {

        }
        if (lasMatriculas.contains(matricula) == false) {
            elAutobus = new Autobus(matricula, fabricante, modelo, motor, combustible, plazas, precio);
            losAutobuses.add(elAutobus);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La matr�cula pertenece a un autob�s ya existente.\n"
                    + "Por favor, revise los datos e int�ntelo de nuevo", "Error - GESTI�N DE EMPRESA �", 1);
        }
        return false;
    }

    /**
     * Genera un nuevo cliente con los datos recogidos por la ventana
     *
     * @param codigo
     * @param nombre
     * @param localidad
     * @param telefono
     * @return true si se ha podido crear - false si ha ocurrido alg�n error
     */
    public boolean nuevoCliente(String codigo, String nombre, String localidad, int telefono) {
        ArrayList<String> losCodigosCliente = new ArrayList();
        try {
            for (Cliente unCliente : losClientes) {
                losCodigosCliente.add(unCliente.getCodCLiente());
            }
        } catch (NullPointerException err1) {

        }

        if (losCodigosCliente.contains(codigo) == false) {
            elCliente = new Cliente(codigo, nombre, localidad, telefono);
            losClientes.add(elCliente);
            return true;
        }
        return false;
    }

    /**
     * Genera una nueva ruta con los datos recogidos de la ventana
     *
     * @param codigo
     * @param inicio
     * @param destino
     * @param distancia
     * @param conductor
     * @param autobus
     * @return true si se ha podido crear - false si ha ocurrido alg�n error
     */
    public boolean nuevaRuta(String codigo, String inicio, String destino, int distancia, String conductor, String autobus) {
        laRuta = new Ruta(codigo, inicio, destino, distancia, conductor, autobus);
        lasRutas.add(laRuta);
        return true;
    }

    /**
     * Genera una factura con los datos de la ventana
     *
     * @param cliente
     * @param ruta
     * @return true si se ha podido crear - false si ha ocurrido alg�n error
     */
    public boolean nuevaFactura(String cliente, String ruta) {
        ArrayList<Integer> numerosFacturas = new ArrayList();
        try {
            for (Factura unaFactura : lasFacturas) {
                numerosFacturas.add(unaFactura.getnFactura());
            }
        } catch (NullPointerException err1) {

        }
        int nFactura = numerosFacturas.size() + 1;
        int lugarClienteEnArray = 0;
        int lugarRutaEnArray = 0;
        String[] clientes = getLosCodClientes();
        System.out.println("coge los codigos de clientes");
        for (int i = 0; i < clientes.length; i++) {//Recoger c�digo de cliente
            if (clientes[i].equals(cliente)) {
                lugarClienteEnArray = i;
                break;
            }
        }
        String[] rutas = getLosCodRutas();
        System.out.println("coge los codigos de las rutas");
        for (int i = 0; i < rutas.length; i++) {//Recoger c�digo de ruta
            if (rutas[i].equals(ruta)) {
                lugarRutaEnArray = i;
                break;
            }
        }
        Cliente clienteFactura = losClientes.get(lugarClienteEnArray);
        Ruta rutaFactura = lasRutas.get(lugarRutaEnArray);
        LocalDate fechaFactura = LocalDate.now();
        double precio = (rutaFactura.getKmRecorridos()) * 0.2;
        double precioFinal = Math.round(precio * 100) / 100d;

        laFactura = new Factura(nFactura, clienteFactura.getNombre(),
                clienteFactura.getLocalidad(), clienteFactura.getTelefono(),
                rutaFactura.getCodRuta(), fechaFactura, precioFinal);
        lasFacturas.add(laFactura);
        return true;
    }

    //OBTENCI�N DE DATOS********************************************************************************************************
    /**
     * Crea un array con las secciones del enum secciones para utilizarlo en el
     * ComboBox de las secciones a la hora de a�adir un nuevo trabajador
     *
     * @return
     */
    public String[] getLasSecciones() {
        String[] secciones = new String[lasSecciones.length];
        for (int i = 0; i < secciones.length; i++) {
            secciones[i] = lasSecciones[i].toString();
        }
        return secciones;
    }

    /**
     * Crea un array con las secciones del enum de los combustibles para
     * utilizarlo en el ComboBox de los combustibles en la pesta�a de a�adir un
     * nuevo autob�s
     *
     * @return un array con los tipos de combustible
     */
    public String[] getLosCombustibles() {
        String[] combustibles = new String[losCombustibles.length];
        for (int i = 0; i < combustibles.length; i++) {
            combustibles[i] = losCombustibles[i].toString();
        }
        return combustibles;
    }

    /**
     * Devuelve los DNI de los conductores para formar el ComboBox de la ventana
     *
     * @return un array con los DNI de los conductores
     */
    public String[] getLosDNIdeConductores() {
        ArrayList<String> dniConductores = new ArrayList();
        try {
            for (Trabajador unTrabajador : losTrabajadores) {
                if ((unTrabajador.getSeccion()).equalsIgnoreCase("CONDUCTOR")) {
                    dniConductores.add(unTrabajador.getDni());
                }
            }
            String[] dni = new String[dniConductores.size()];
            for (int i = 0; i < dni.length; i++) {
                dni[i] = dniConductores.get(i);
            }
            return dni;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve todos los DNI
     * @return un array con todos los DNI
     */
    public String[] getTodosLosDNI() {
        ArrayList<String> losDni = new ArrayList();
        try {
            for (Trabajador unTrabajador : losTrabajadores) {
                losDni.add(unTrabajador.getDni());
            }
            String[] dnis = new String[losDni.size()];
            for (int i = 0; i < dnis.length; i++) {
                dnis[i] = losDni.get(i);
            }
            return dnis;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve las matr�culas de los autobuses ya registrados para utilizarlas
     * en los ComboBox de la ventana
     *
     * @return
     */
    public String[] getLasMatriculas() {
        ArrayList<String> lasMatriculas = new ArrayList();
        try {
            for (Autobus unAutobus : losAutobuses) {
                lasMatriculas.add(unAutobus.getMatricula());
            }
            String[] matricula = new String[lasMatriculas.size()];
            for (int i = 0; i < matricula.length; i++) {
                matricula[i] = lasMatriculas.get(i);
            }
            return matricula;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve los c�digos de los clientes ya registrados para utilizarlos en
     * los ComboBox de la ventana donde sean precisos
     *
     * @return
     */
    public String[] getLosCodClientes() {
        ArrayList<String> losCodClientes = new ArrayList();
        try {
            for (Cliente unCliente : losClientes) {
                losCodClientes.add(unCliente.getCodCLiente());
            }
            String[] cliente = new String[losCodClientes.size()];
            for (int i = 0; i < cliente.length; i++) {
                cliente[i] = losCodClientes.get(i);
            }
            return cliente;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve los c�digos de las rutas para utilizarlos en los ComboBox
     *
     * @return
     */
    public String[] getLosCodRutas() {
        ArrayList<String> losCodsRutas = new ArrayList();
        try {
            for (Ruta unaRuta : lasRutas) {
                losCodsRutas.add(unaRuta.getCodRuta());
            }
            String[] rutas = new String[losCodsRutas.size()];
            for (int i = 0; i < rutas.length; i++) {
                rutas[i] = losCodsRutas.get(i);
            }
            return rutas;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve los fabricante de carrocer�as de los autobuses para
     * posetriormente poder filtrar los autobuses siguiendo este criterio
     *
     * @return
     */
    public String[] getLosFabricantes() {
        ArrayList<String> losFabricantes = new ArrayList();
        try {
            losFabricantes.add("TODOS");
            for (Autobus unAutobus : losAutobuses) {
                String fCarroceria = unAutobus.getfCarroceria();
                if (losFabricantes.contains(fCarroceria) == false) {
                    losFabricantes.add(unAutobus.getfCarroceria());
                }
            }

            String[] fabricantes = new String[losFabricantes.size()];
            for (int i = 0; i < fabricantes.length; i++) {
                fabricantes[i] = losFabricantes.get(i);
            }
            return fabricantes;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    //ELIMINACI�N DE DATOS*******************************************************************************************************

    /**
     * Borra a los trabajadores seleccionados identific�ndolos por sus matr�culas
     *      1/ Hace una copia del arrayList losTrabajadores
     *      2/ Crea un arrayList con solo los DNI
     *      3/ Busca el lugar en el que est�n los DNI seleccionadas
     *      4/ Vac�a losTrabajadores
     *      5/ Va copiando todo a losTrabajadores.
     *          Si el arrayList lugarEnArray contiene la posici�n, la salta.
     * @param dni
     * @return true si lo ha conseguido hacer : false si ha habido alg�n error
     */
    public boolean borrarTrabajador(String[] dni) {
        try {
            ArrayList<Integer> lugarEnArray = new ArrayList();
            ArrayList<Trabajador> todosLosTrabajadores = new ArrayList();
            ArrayList<String> todosLosDNI = new ArrayList();

            todosLosDNI.addAll(Arrays.asList(getTodosLosDNI()));
            for (Trabajador trabajador : losTrabajadores) {//Hago una copia del arrayList losTrabajadores
                todosLosTrabajadores.add(trabajador);
            }
            for (String dni1 : dni) {//Relleno un arrayList s�lo con los DNI
                if (todosLosDNI.contains(dni1)) {
                    int lugar = todosLosDNI.indexOf(dni1);
                    lugarEnArray.add(lugar);
                }
            }

            losTrabajadores.clear();
            for (int rm = 0; rm < todosLosTrabajadores.size(); rm++) {
                if (lugarEnArray.contains(rm) == false) {
                    losTrabajadores.add(todosLosTrabajadores.get(rm));
                }
            }
            return true;
        } catch (NullPointerException err1) {

        }

        return false;
    }

    /**
     * Borra los autobuses seleccionados por sus matr�culas.
     *      1/ Hace una copia del arrayList losAutobuses
     *      2/ Crea un arrayList con solo las matr�culas
     *      3/ Busca el lugar en el que est�n las matr�culas seleccionadas
     *      4/ Vac�a losAutobuses
     *      5/ Va copiando todo a losAutobuses. 
     *          Si el arrayList lugarEnArray contiene la posici�n, la salta.
     * @param matricula
     * @return true si lo ha hecho : false si ha ocurrido alg�n problema
     */
    public boolean borrarAutobus(String[] matricula) {
        try {
            ArrayList<Autobus> todosLosAutobuses = new ArrayList();
            ArrayList<String> todasLasMatriculas = new ArrayList();
            ArrayList<Integer> lugarEnArray = new ArrayList();
            todasLasMatriculas.addAll(Arrays.asList(getLasMatriculas()));
            for (Autobus autobus : losAutobuses) {//Hago una copia del arrayList losAutobuses
                todosLosAutobuses.add(autobus);
            }
            for (String matricula1 : matricula) {//Relleno un arrayList s�lo con las matr�culas
                if (todasLasMatriculas.contains(matricula1)) {
                    int lugar = todasLasMatriculas.indexOf(matricula1);
                    lugarEnArray.add(lugar);
                }
            }

            losAutobuses.clear();
            for (int rm = 0; rm < todosLosAutobuses.size(); rm++) {
                if (lugarEnArray.contains(rm) == false) {
                    losAutobuses.add(todosLosAutobuses.get(rm));
                }
            }
            return true;
        } catch (NullPointerException err1) {

        }
        return false;
    }

    //MODELOS DE TABLAS**********************************************************************************************************

    /**
     * Devuelve todos los autobuses para pasarlos posteriormente al modelo de tabla.
     * El par�metro sirve para poder filtrar posteriormente
     * @param fabricante
     * @return un array con los autobuses
     */
    public Autobus[] getLosAutobuses(String fabricante) {
        ArrayList<Autobus> losBuses = new ArrayList();
        try {
            for (Autobus unAutobus : losAutobuses) {
                if (fabricante.equalsIgnoreCase("TODOS")) {
                    losBuses.add(unAutobus);
                } else {
                    String carroceria = unAutobus.getfCarroceria();
                    if (carroceria.equals(fabricante)) {
                        losBuses.add(unAutobus);
                    }
                }
            }
            Autobus[] bus = new Autobus[losBuses.size()];
            for (int i = 0; i < bus.length; i++) {
                bus[i] = losBuses.get(i);
            }
            return bus;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve todos los trabajadores para pasarlos al modelo de tabla
     * @return un array con todos los trabajadores
     */
    public Trabajador[] getLosTrabajadores() {
        Trabajador[] trabajadores = new Trabajador[losTrabajadores.size()];
        try {
            for (int i = 0; i < trabajadores.length; i++) {
                trabajadores[i] = losTrabajadores.get(i);
            }
            return trabajadores;
        } catch (NullPointerException err1) {

        }

        return null;
    }

    /**
     * Devuelve todos los clientes para pasarlos al modelo de tabla
     * @return un array con los clientes
     */
    public Cliente[] getLosClientes() {
        Cliente[] clientes = new Cliente[losClientes.size()];
        try {
            for (int i = 0; i < clientes.length; i++) {
                clientes[i] = losClientes.get(i);
            }
            return clientes;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve todas las rutas para luego pasarlas al modelo de tabla
     * @return un array con las rutas
     */
    public Ruta[] getLasRutas() {
        Ruta[] rutas = new Ruta[lasRutas.size()];
        try {
            for (int i = 0; i < rutas.length; i++) {
                rutas[i] = lasRutas.get(i);
            }
            return rutas;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve todas las facturas para luego pasarlas al modelo de tabla
     * @return un array con las facturas
     */
    public Factura[] getLasFacturas() {
        Factura[] facturas = new Factura[lasFacturas.size()];
        try {
            for (int i = 0; i < facturas.length; i++) {
                facturas[i] = lasFacturas.get(i);
            }
            return facturas;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    //LECTURA Y ESCRITURA DE DATOS***********************************************************************************************

    /**
     * Lee los datos de los los archivos y los guarda en los arrays.
     * @return true si ha podido leer : false si ha ocurrido alguna excepci�n
     */
    public boolean leerArchivos() {
        try {
            BufferedReader archivoTrabajadores = new BufferedReader(new FileReader("trabajadores.csv"));
            BufferedReader archivoAutobuses = new BufferedReader(new FileReader("autobuses.csv"));
            BufferedReader archivoClientes = new BufferedReader(new FileReader("clientes.csv"));
            BufferedReader archivoRutas = new BufferedReader(new FileReader("rutas.csv"));
            BufferedReader archivoFacturas = new BufferedReader(new FileReader("facturas.csv"));
            BufferedReader[] archivosParaLeer = {archivoTrabajadores, archivoAutobuses, archivoClientes, archivoRutas, archivoFacturas};

            for (int i = 0; i < archivosParaLeer.length; i++) {
                ArrayList listadoLeer = new ArrayList();
                String[] datos;
                String lineaLeida = archivosParaLeer[i].readLine();
                while (lineaLeida != null) {
                    listadoLeer.add(lineaLeida);
                    lineaLeida = archivosParaLeer[i].readLine();
                }
                for (int n = 0; n < listadoLeer.size(); n++) {
                    datos = String.valueOf(listadoLeer.get(n)).split(";");
                    switch (i) {
                        case 0://Trabajador
                            elTrabajador = new Trabajador(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3]);
                            losTrabajadores.add(elTrabajador);
                            break;
                        case 1://Autob�s
                            elAutobus = new Autobus(datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt(datos[5]), Integer.parseInt(datos[6]));
                            losAutobuses.add(elAutobus);
                            break;
                        case 2://Cliente
                            elCliente = new Cliente(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]));
                            losClientes.add(elCliente);
                            break;
                        case 3://Ruta
                            laRuta = new Ruta(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], datos[5]);
                            lasRutas.add(laRuta);
                            break;
                        case 4://Factura
                            laFactura = new Factura(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], LocalDate.parse(datos[5]), Double.parseDouble(datos[6]));
                            lasFacturas.add(laFactura);
                            break;
                    }
                }
                archivosParaLeer[i].close();

            }
            getLosTrabajadores();
            getLosAutobuses(null);
            getLosClientes();
            getLasRutas();
            getLasFacturas();
            return true;
        } catch (FileNotFoundException exFile) {

        } catch (IOException exIO) {

        }
        return false;
    }

    /**
     * Escribe los datos de los arrays en los archivos. 
     * @return true si ha podido escribir : false si ha ocurrido alguna excepci�n
     */
    public boolean escribirArchivos() {
        try {
            BufferedWriter archivoTrabajadores = new BufferedWriter(new FileWriter("trabajadores.csv"));
            BufferedWriter archivoAutobuses = new BufferedWriter(new FileWriter("autobuses.csv"));
            BufferedWriter archivoClientes = new BufferedWriter(new FileWriter("clientes.csv"));
            BufferedWriter archivoRutas = new BufferedWriter(new FileWriter("rutas.csv"));
            BufferedWriter archivoFacturas = new BufferedWriter(new FileWriter("facturas.csv"));
            BufferedWriter[] archivosParaEscribir = {archivoTrabajadores, archivoAutobuses, archivoClientes, archivoRutas, archivoFacturas};

            for (int i = 0; i < archivosParaEscribir.length; i++) {
                switch (i) {
                    case 0://Trabajador
                        for (Trabajador unTrabajador : losTrabajadores) {
                            archivosParaEscribir[i].write(unTrabajador.toString());
                        }
                        break;
                    case 1://Autobus
                        for (Autobus unAutobus : losAutobuses) {
                            archivosParaEscribir[i].write(unAutobus.toString());
                        }
                        break;
                    case 2://Cliente
                        for (Cliente unCliente : losClientes) {
                            archivosParaEscribir[i].write(unCliente.toString());
                        }
                        break;
                    case 3://Ruta
                        for (Ruta unaRuta : lasRutas) {
                            archivosParaEscribir[i].write(unaRuta.toString());
                        }
                        break;
                    case 4://Factura
                        for (Factura unaFactura : lasFacturas) {
                            archivosParaEscribir[i].write(unaFactura.toString());
                        }
                        archivoFacturas.close();
                        break;
                }
                archivosParaEscribir[i].close();
            }
            return true;

        } catch (FileNotFoundException exFile) {

        } catch (IOException exIO) {

        }
        return false;
    }

    //COTEJAMIENTO DE DATOS*****************************************************************************************************

    /**
     * Comprueba si la matr�cula introducida a la hora de dar de alta un autob�s es correcta
     *      Matr�culas nuevas: Deben estar formadas por:
     *          4 n�meros
     *          3 letras, no pudiendo ser estas una vocal o la �
     *      Matr�culas antiguas: Deben estar formadas por:
     *          1 � 2 letras
     *          4 n�meros
     *          2 letras, que pueden ser vocales o consonantes a excepci�n de la �
     * @param matricula
     * @return true si la matr�cula es correcta : false si no es correcta
     */
    public boolean comprobarMatricula(String matricula) {
        if (Pattern.matches("[0-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}", matricula)) {
            return true;
        } else if (Pattern.matches("[A-Z]{1,2}[0-9]{4}[A-Z]{2}", matricula)) {
            return true;
        }
        return false;
    }
}
