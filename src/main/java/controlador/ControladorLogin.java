/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Policia;
import modelo.ConsultaLogin;
import vista.Login;
import vista.VistaDatos;

/**
 *
 * @author Aaron
 */
public class ControladorLogin implements ActionListener {
    
    private VistaDatos ventanaDatos;
    private Login Login;
    
    private Policia Policia = new Policia();
    private ConsultaLogin ConsultaLogin = new ConsultaLogin();

    public ControladorLogin(VistaDatos ventanaDatos, Login Login) {
        this.ventanaDatos = ventanaDatos;
        this.Login = Login;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
