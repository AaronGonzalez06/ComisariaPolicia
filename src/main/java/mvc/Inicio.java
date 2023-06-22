/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvc;

import java.sql.Connection;
import java.sql.DriverManager;

import vista.VistaDelincuente;
import vista.VistaCasos;
import vista.VistaDatos;
import controlador.ControladorDelincuente;
import controlador.ControladorCasos;

/**
 *
 * @author Aaron
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ControladorDelincuente Delincuente = new ControladorDelincuente();
        Delincuente.inicio();
    
    }
    
}
