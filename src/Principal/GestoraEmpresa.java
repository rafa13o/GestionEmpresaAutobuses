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
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

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
    Map<String, String> losUsuarios = new TreeMap<>();
    EnumSecciones[] lasSecciones = EnumSecciones.values();
    EnumCombustible[] losCombustibles = EnumCombustible.values();

    /**
     *
     */
    public GestoraEmpresa() {
        leerArchivos();
    }

    //GENERAR NUEVOS DATOS******************************************************************************************************
    /**
     * Genera un nuevo trabajador
     *
     * @param dni
     * @param nomApe nombre y apellidos del trabajador
     * @param anio año de ingreso del trabajador
     * @param seccion sección en la que trabaja
     * @return true si se ha podido crear - false si ha ocurrido algún error
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
                Mensajes.mensajesDeError("ANIO_POSTERIOR");
            }
        } else {
            Mensajes.mensajesDeError("DNI_EXISTE");
        }
        return false;
    }

    /**
     * Genera un nuevo autobús a partir de los parámetros obtenidos de la
     * ventana
     *
     * @param matricula
     * @param fabricante
     * @param modelo
     * @param motor
     * @param combustible
     * @param plazas
     * @param precio
     * @return true si se ha podido crear - false si ha ocurrido algún error
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
            Mensajes.mensajesDeError("MATRICULA_EXISTE");
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
     * @return true si se ha podido crear - false si ha ocurrido algún error
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
     * @return true si se ha podido crear - false si ha ocurrido algún error
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
     * @return true si se ha podido crear - false si ha ocurrido algún error
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
        for (int i = 0; i < clientes.length; i++) {//Recoger código de cliente
            if (clientes[i].equals(cliente)) {
                lugarClienteEnArray = i;
                break;
            }
        }
        String[] rutas = getLosCodRutas();
        for (int i = 0; i < rutas.length; i++) {//Recoger código de ruta
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

    /**
     * Genera un nuevo usuario que puede acceder al programa
     *
     * @param usuario
     * @param clave
     * @param privilegios
     * @return
     */
    public boolean nuevoUsuario(String usuario, String clave) {
        try {
            String[] dnis = getTodosLosDNI();
            int lugar = -1;
            for (int i = 0; i < dnis.length; i++) {
                if (dnis[i].equals(usuario)) {
                    lugar = i;
                    break;
                }
            }
            Trabajador trabajadorUsuario = losTrabajadores.get(lugar);
            String nombreApellidos = trabajadorUsuario.getNombreApellidos();
            int coma = nombreApellidos.indexOf(",");
            String nombre = nombreApellidos.substring(coma + 2);

            elUsuario = new Usuario(usuario, clave);
            losUsuarios.put(usuario, clave);

            return true;
        } catch (NullPointerException err1) {

        }
        return false;
    }

    //OBTENCIÓN DE DATOS********************************************************************************************************
    /**
     * Crea un array con las secciones del enum secciones para utilizarlo en el
     * ComboBox de las secciones a la hora de añadir un nuevo trabajador
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
     * utilizarlo en el ComboBox de los combustibles en la pestaña de añadir un
     * nuevo autobús
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

    public String[] getLosDNIdeDireccion() {
        ArrayList<String> dniDireccion = new ArrayList();
        try {
            for (Trabajador unTrabajador : losTrabajadores) {
                if (unTrabajador.getSeccion().equalsIgnoreCase("DIRECCION")) {
                    dniDireccion.add(unTrabajador.getDni());
                }
            }
            String[] dni = new String[dniDireccion.size()];
            for (int i = 0; i < dni.length; i++) {
                dni[i] = dniDireccion.get(i);
            }
            return dni;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    /**
     * Devuelve todos los DNI
     *
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
     * Devuelve las matrículas de los autobuses ya registrados para utilizarlas
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
     * Devuelve los códigos de los clientes ya registrados para utilizarlos en
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
     * Devuelve los códigos de las rutas para utilizarlos en los ComboBox
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
     * Devuelve los fabricante de carrocerías de los autobuses para
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

    /**
     *
     * @param usuario
     * @return
     */
    public String getLaClaveUsuario(String usuario) {
        try {
            return losUsuarios.get(usuario);
        } catch (NullPointerException err1) {

        }
        return null;
    }

    //ELIMINACIÓN DE DATOS*******************************************************************************************************
    /**
     * Borra a los trabajadores seleccionados identificándolos por sus
     * matrículas 1/ Hace una copia del arrayList losTrabajadores 2/ Crea un
     * arrayList con solo los DNI 3/ Busca el lugar en el que están los DNI
     * seleccionadas 4/ Vacía losTrabajadores 5/ Va copiando todo a
     * losTrabajadores. Si el arrayList lugarEnArray contiene la posición, la
     * salta.
     *
     * @param dni
     * @return true si lo ha conseguido hacer : false si ha habido algún error
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
            for (String dni1 : dni) {//Relleno un arrayList sólo con los DNI
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
     * Borra los autobuses seleccionados por sus matrículas. 1/ Hace una copia
     * del arrayList losAutobuses 2/ Crea un arrayList con solo las matrículas
     * 3/ Busca el lugar en el que están las matrículas seleccionadas 4/ Vacía
     * losAutobuses 5/ Va copiando todo a losAutobuses. Si el arrayList
     * lugarEnArray contiene la posición, la salta.
     *
     * @param matricula
     * @return true si lo ha hecho : false si ha ocurrido algún problema
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
            for (String matricula1 : matricula) {//Relleno un arrayList sólo con las matrículas
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

    /**
     * Elimina el usuario seleccionado en el comboBox
     *
     * @param usuario
     * @return
     */
    public boolean eliminarUsuario(String usuario) {
        try {
            losUsuarios.remove(usuario);
            return true;
        } catch (NullPointerException err1) {

        }
        return false;
    }

    //MODIFICACIÓN DE DATOS******************************************************************************************************
    /**
     * Cambia la contraseña del usuario seleccionado en el comboBox
     *
     * @param usuario
     * @param clave
     * @return
     */
    public boolean cambiarUsuario(String usuario, String clave) {
        try {
            String claveAntigua = losUsuarios.get(usuario);
            losUsuarios.replace(usuario, claveAntigua, clave);
            escribirArchivos();
            return true;
        } catch (NullPointerException err1) {

        }
        return false;
    }

    //MODELOS DE TABLAS**********************************************************************************************************
    /**
     * Devuelve todos los autobuses para pasarlos posteriormente al modelo de
     * tabla. El parámetro sirve para poder filtrar posteriormente
     *
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
     *
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
     *
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
     *
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
     *
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

    public String[] getLosUsuarios() {
        try {
            String[] usuarios = new String[(losUsuarios.size()) * 2];
            String elMapa = losUsuarios.toString();
            elMapa = elMapa.substring(1, elMapa.length() - 1);
            String[] intermedio = elMapa.split(", ");
            int n = 0;
            for (int i = 0; i < losUsuarios.size(); i++) {
                String usuario = intermedio[i].substring(0, 9);
                String dni = intermedio[i].substring(10);
                usuarios[n] = usuario;
                n++;
                usuarios[n] = dni;
                n++;
            }
            return usuarios;
        } catch (NullPointerException err1) {

        }
        return null;
    }

    //LECTURA Y ESCRITURA DE DATOS***********************************************************************************************
    /**
     * Lee los datos de los los archivos y los guarda en los arrays.
     *
     * @return true si ha podido leer : false si ha ocurrido alguna excepción
     */
    public boolean leerArchivos() {
        try {
            BufferedReader archivoTrabajadores = new BufferedReader(new FileReader("trabajadores.csv"));
            BufferedReader archivoAutobuses = new BufferedReader(new FileReader("autobuses.csv"));
            BufferedReader archivoClientes = new BufferedReader(new FileReader("clientes.csv"));
            BufferedReader archivoRutas = new BufferedReader(new FileReader("rutas.csv"));
            BufferedReader archivoFacturas = new BufferedReader(new FileReader("facturas.csv"));
            BufferedReader archivoUsuarios = new BufferedReader(new FileReader("usuarios.csv"));
            BufferedReader[] archivosParaLeer = {archivoTrabajadores, archivoAutobuses, archivoClientes, archivoRutas, archivoFacturas, archivoUsuarios};

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
                        case 1://Autobús
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
                        case 5://Usuarios
                            losUsuarios.put(datos[0], datos[1]);
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
     *
     * @return true si ha podido escribir : false si ha ocurrido alguna
     * excepción
     */
    public boolean escribirArchivos() {
        try {
            BufferedWriter archivoTrabajadores = new BufferedWriter(new FileWriter("trabajadores.csv"));
            BufferedWriter archivoAutobuses = new BufferedWriter(new FileWriter("autobuses.csv"));
            BufferedWriter archivoClientes = new BufferedWriter(new FileWriter("clientes.csv"));
            BufferedWriter archivoRutas = new BufferedWriter(new FileWriter("rutas.csv"));
            BufferedWriter archivoFacturas = new BufferedWriter(new FileWriter("facturas.csv"));
            BufferedWriter archivoUsuarios = new BufferedWriter(new FileWriter("usuarios.csv"));
            BufferedWriter[] archivosParaEscribir = {archivoTrabajadores, archivoAutobuses, archivoClientes, archivoRutas, archivoFacturas, archivoUsuarios};

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
                        break;
                    case 5://Usuario
                        for (int n = 0; n < getLosUsuarios().length; n++) {
                            archivosParaEscribir[i].write(getLosUsuarios()[n] + ";");
                            n++;
                            archivosParaEscribir[i].write(getLosUsuarios()[n] + "\n");
                        }
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
     * Comprueba si la matrícula introducida a la hora de dar de alta un autobús
     * es correcta Matrículas nuevas: Deben estar formadas por: 4 números 3
     * letras, no pudiendo ser estas una vocal o la Ñ Matrículas antiguas: Deben
     * estar formadas por: 1 ó 2 letras 4 números 2 letras, que pueden ser
     * vocales o consonantes a excepción de la Ñ
     *
     * @param matricula
     * @return true si la matrícula es correcta : false si no es correcta
     */
    public boolean comprobarMatricula(String matricula) {
        if (Pattern.matches("[0-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}", matricula)) {
            return true;
        } else if (Pattern.matches("[A-Z]{1,2}[0-9]{4}[A-Z]{2}", matricula)) {
            return true;
        }
        return false;
    }

    /**
     * Comprueba que los datos de acceso sean correctos
     *
     * @param usuario
     * @param clave
     * @return
     */
    public boolean comprobarUsuario(String usuario, String clave) {
        try {
            if (losUsuarios.containsKey(usuario)) {
                String claveUsuario = losUsuarios.get(usuario);
                if (claveUsuario.equals(clave)) {
                    return true;
                } else {
                    Mensajes.mensajesDeError("ACCESO_INCORRECTO");
                }
            } else {
                Mensajes.mensajesDeError("USUARIO_INEXISTENTE");
            }
        } catch (NullPointerException err1) {
            Mensajes.mensajesDeError("ACCESO_INCORRECTO");
        } catch (ArrayIndexOutOfBoundsException err2) {
            Mensajes.mensajesDeError("ACCESO_INCORRECTO");
        }
        return false;
    }

}
