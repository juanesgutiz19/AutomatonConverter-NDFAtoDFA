/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaunoteoria;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class UtilMethods {

    private static String lector;

    private UtilMethods() {
    }

    public static void mostrarMensaje(String menInterno, String menWindow) {
        JOptionPane.showMessageDialog(null, menInterno, menWindow, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarMensajeError(String menInterno, String menWindow) {
        JOptionPane.showMessageDialog(null, menInterno, menWindow, JOptionPane.ERROR_MESSAGE);
    }

    public static String leerString(String mensaje) {
        lector = JOptionPane.showInputDialog(mensaje);
        return lector;
    }

    public static double leerDouble(String mensaje) {
        double dato;
        try {
            lector = JOptionPane.showInputDialog(mensaje);
            dato = (double) Double.parseDouble(lector);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "tipo de dato no valido, por favor ingrese el dato de nuevo", "error", JOptionPane.ERROR_MESSAGE);
            leerDouble(mensaje);
            return 0;
        }
        return dato;
    }

    public static int leerInt(String mensaje) {
        int dato;
        try {
            lector = JOptionPane.showInputDialog(mensaje);
            dato = (int) Integer.parseInt(lector);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "tipo de dato no valido, por favor ingrese el dato de nuevo", "error", JOptionPane.ERROR_MESSAGE);
            leerInt(mensaje);
        }
        return (int) Integer.parseInt(lector);
    }

    public static long leerLong(String mensaje) {
        long dato;

        lector = JOptionPane.showInputDialog(mensaje);
        dato = (long) Long.parseLong(lector);

        return (long) Long.parseLong(lector);
    }

    public static char leerChar(String mensaje) {
        lector = JOptionPane.showInputDialog(mensaje);
        return lector.charAt(0);
    }

    public static String comboString(String menInterno, String menWindow, String[] opciones) {
        Object lectura = JOptionPane.showInputDialog(null, menInterno, menWindow, JOptionPane.QUESTION_MESSAGE, null, opciones, "seleccione");
        return (String) lectura;
    }

    public static int opcionYN(String menInterno, String menWidow) {
        int respuesta = JOptionPane.showOptionDialog(null, menInterno, menWidow, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        return respuesta;

    }
    
    public static String concatString(String text, String symbol) {
        String[] array = text.split(symbol);
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result = result + array[i];
        }
        return result;
    }
    
    public static String toString(String[] array) {
        String result = "";
        for (String array1 : array) {
            result = result + array1;
        }
        return result;
    }
}
