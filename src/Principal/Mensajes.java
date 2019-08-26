/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javax.swing.JOptionPane;

/**
 *
 * @author Rafa
 */
public class Mensajes {
    
    /**
     * Por cada par�metro que recibe en causa, muestra su mensaje
     * correspondiente
     *
     * @param causa
     */
    public static void mensajesDeError(String causa) {
        String mensaje = "";
        String mensaje2 = "Por favor, revise los datos e int�ntelo de nuevo";
        switch (causa) {
            case "GENERAL":
                mensaje = "Los datos introducidos son incorrectos";
                break;
            case "DNI":
                mensaje = "El n�mero de DNI introducido no es correcto";
                break;
            case "DNI_EXISTE":
                mensaje = "El DNI pertenece a un trabajador ya existente";
                break;
            case "ANIO":
                mensaje = "El a�o introducido es incorrecto";
                break;
            case "PRECIO":
                mensaje = "El precio no puede ser inferior a 20.000�";
                break;
            case "PLAZAS":
                mensaje = "El n�mero de plazas no puede ser menor de 10 ni exceder de 70";
                break;
            case "MATRICULA":
                mensaje = "La matr�cula es incorrecta.\n\n"
                        + "La matr�cula solo puede estar compuesta por:\n"
                        + "-->  2 letras, 4 n�meros y 2 letras (VA-2213-AB)\n"
                        + "-->  4 n�meros y 3 consonantes (3515-BVW).\n"
                        + "A su vez, estas �ltimas no pueden contener vocales.\n\n"
                        + "Introduzca los valores sin guiones (VA2213AB y 3515BVW)\n";
                break;
            case "MATRICULA_EXISTE":
                mensaje = "La matr�cula pertenece a un autob�s ya existente";
                break;
            case "KILOMETROS":
                mensaje = "Los kil�metros introducidos son incorrectos";
                break;
            case "TELEFONO":
                mensaje = "El tel�fono introducido es incorrecto.\n"
                        + "Introduzca el n�mero de tel�fono sin c�digo de pa�s (666555444)";
                break;
            case "FACTURA":
                mensaje = "Ha surgido un problema al generar la factura";
                break;
            case "ANIO_POSTERIOR":
                mensaje = "El a�o no puede ser posterior al actual";
                break;
            case "BAJA_TRABAJADOR":
                mensaje = "No se ha podido dar de baja a ning�n trabajador";
                mensaje2 = "Por favor, revise que ha seleccionado al menos uno e int�ntelo de nuevo";
                break;
            case "BAJA_AUTOBUS":
                mensaje = "No se ha podido dar de baja ning�n autob�s";
                mensaje2 = "Por favor, revise que ha seleccionado al menos uno e int�ntelo de nuevo";
                break;
            case "CLAVES_IGUALES":
                mensaje = "La nueva contrase�a no puede ser igual que la anterior";
                break;
            case "CLAVES_DISTINTAS":
                mensaje = "Las contrase�as no son iguales";
                break;
            case "ACCESO_INCORRECTO":
                mensaje = "El usuario o la contrase�a son incorrectos";
                break;
            case "USUARIO_EXISTE":
                mensaje = "El usuario ya est� registrado en la base";
                break;
            case "USUARIO_INEXISTENTE":
                mensaje = "El usuario no est� dado de alta en la base";
                break;
            case "BAJA_USUARIO":
                mensaje = "No se ha podido dar de baja a ning�n usuario";
                mensaje2= "Por favor, revise que ha seleccionado un usuario e int�ntelo de nuevo";
                break;
        }
        JOptionPane.showMessageDialog(null, mensaje + ".\n"
                + mensaje2, "Error - GESTI�N DE EMPRESA �", 0);
    }

    /**
     * Por cada par�metro que recibe causa, emite el mensaje de resultado
     * correspondiente
     *
     * @param causa
     */
    public static void mensajesDeResultado(String causa) {
        String mensaje = "";
        switch (causa) {
            case "TRABAJADOR1"://Cuando se elimina 1 trabajador
                mensaje = "El trabajador se ha dado de baja con �xito.";
                break;
            case "TRABAJADOR2"://Cuando se eliminan 2 o m�s trabajadores
                mensaje = "Los trabajadores se han dado de baja con �xito.";
                break;
            case "AUTOBUS1"://Cuando se elimina 1 autob�s
                mensaje = "El autob�s se ha dado de baja con �xito.";
                break;
            case "AUTOBUS2"://Cuando se eliminan 2 o m�s autobuses
                mensaje = "Los autobuses se han dado de baja con �xito";
                break;
            case "BAJA_USUARIO":
                mensaje = "El usuario se ha dado de baja con �xito";
                break;
            case "CLAVE_CAMBIADA":
                mensaje = "La clave ha sido cambiada con �xito";
                break;
        }
        JOptionPane.showMessageDialog(null, mensaje, "Resultado - GESTI�N DE EMPRESA �", 1);
    }
    
    /**
     * Proporciona el mensaje de salida
     */
    public static void mensajeDeSalida() {
        JOptionPane.showMessageDialog(null, "GRACIAS. HASTA PRONTO.", "GESTI�N DE EMPRESA �", -1);
    }
}
