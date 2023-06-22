/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.VistaDelincuente;
import vista.VistaCasos;
import vista.VistaDatos;
import vista.FondoImg;
import controlador.ControladorModificaciones;
import controlador.ControladorPolicia;
import java.awt.Color;
import javax.swing.Icon;

import modelo.Delincuente;
import modelo.ConsultasDelincuente;

/**
 *
 * @author Aaron
 */
public class ControladorDelincuente implements ActionListener {
    
    private final VistaDelincuente ventanaDelincuente;
    //private VistaCasos VentanaCasos;
    //private VistaDatos VentanaDatos;
    
    //private  Delincuente Delincuente = new Delincuente();
    //private  ConsultasDelincuente ConsultasDelincuente = new ConsultasDelincuente();
    private final Delincuente Delincuente;
    private final ConsultasDelincuente ConsultasDelincuente;
    
    /*public ControladorDelincuente(VistaDelincuente ventanaDelincuente,VistaCasos VentanaCasos,VistaDatos VentanaDatos){
    this.ventanaDelincuente = ventanaDelincuente;
    this.VentanaDatos = VentanaDatos;
    this.VentanaCasos = VentanaCasos;
    }*/
    
    
    /* descomentar  ya que es una prueba
    public ControladorDelincuente(){
    this.ventanaDelincuente = new VistaDelincuente();
    this.VentanaDatos = new VistaDatos();
    this.VentanaCasos = new VistaCasos();
    }*/
    public ControladorDelincuente(){
    this.ventanaDelincuente = new VistaDelincuente();
    this.Delincuente = new Delincuente();
    this.ConsultasDelincuente = new ConsultasDelincuente();
    }
    
    
    public void inicio(){
        ventanaDelincuente.setTitle("Delincuentes");
        //quitar si error
        ventanaDelincuente.setVisible(true);
        //VentanaDatos.setTitle("Datos");
        //VentanaCasos.setTitle("Casos");
        ventanaDelincuente.setLocationRelativeTo(null);
        //VentanaCasos.setLocationRelativeTo(null);
        //VentanaDatos.setLocationRelativeTo(null);       

        ConsultasDelincuente.mostrarTabla(ventanaDelincuente);
        ConsultasDelincuente.mostrarProvincias(ventanaDelincuente);
        ConsultasDelincuente.mostrarPaisOrigen(ventanaDelincuente);
        ConsultasDelincuente.mostrarNumDetenciones(ventanaDelincuente);
        ConsultasDelincuente.mostrarLocalidad(ventanaDelincuente);
        
        ventanaDelincuente.jButton1.addActionListener(this);
        ventanaDelincuente.jButton2.addActionListener(this);        
        ventanaDelincuente.jButton4.addActionListener(this);
        ventanaDelincuente.jButton5.addActionListener(this);
        ventanaDelincuente.jButton6.addActionListener(this);
        ventanaDelincuente.jButton7.addActionListener(this);
        ventanaDelincuente.jButton8.addActionListener(this);
        ventanaDelincuente.jButton9.addActionListener(this);
        ventanaDelincuente.filtrarProvincia.addActionListener(this);        
        ventanaDelincuente.filtrarPais.addActionListener(this);
        ventanaDelincuente.filtrarDetenciones.addActionListener(this);        
        
        ventanaDelincuente.jButton1.setIcon((Icon) new ImageIcon("src/main/java/img/policia.png"));
        ventanaDelincuente.jButton8.setIcon((Icon) new ImageIcon("src/main/java/img/actualizar.png"));
        ventanaDelincuente.jButton6.setIcon((Icon) new ImageIcon("src/main/java/img/buscar.png"));
        ventanaDelincuente.jButton3.setIcon((Icon) new ImageIcon("src/main/java/img/delincuente.png"));
        ventanaDelincuente.jButton2.setIcon((Icon) new ImageIcon("src/main/java/img/placa.png"));
        ventanaDelincuente.jButton9.setIcon((Icon) new ImageIcon("src/main/java/img/placa.png"));        
        ventanaDelincuente.jButton4.setIcon((Icon) new ImageIcon("src/main/java/img/mas.png"));
        ventanaDelincuente.jButton5.setIcon((Icon) new ImageIcon("src/main/java/img/limpiar.png"));        
        ventanaDelincuente.jButton7.setIcon((Icon) new ImageIcon("src/main/java/img/buscar.png"));
        ventanaDelincuente.filtrarDetenciones.setIcon((Icon) new ImageIcon("src/main/java/img/buscar.png"));
        ventanaDelincuente.filtrarPais.setIcon((Icon) new ImageIcon("src/main/java/img/buscar.png"));
        ventanaDelincuente.filtrarProvincia.setIcon((Icon) new ImageIcon("src/main/java/img/buscar.png"));
        
        ventanaDelincuente.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        }
    
    
    public void limpiarTabla(JTable tabla){
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = filas -1; i > -1; i--) {
                modelo.removeRow(i);
            }        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == ventanaDelincuente.jButton4) {
            Delincuente.setNombre(ventanaDelincuente.jTextField1.getText());
            Delincuente.setApellido(ventanaDelincuente.jTextField2.getText());
            Delincuente.setDireccion(ventanaDelincuente.jTextField3.getText());
            Delincuente.setLocalidad(ventanaDelincuente.jTextField4.getText());
            Delincuente.setProvincia(ventanaDelincuente.jTextField5.getText());
            Delincuente.setPaisOrigen(ventanaDelincuente.jTextField6.getText());
            Delincuente.setDNI(ventanaDelincuente.jTextField9.getText());
            Delincuente.setEdad(Integer.parseInt(ventanaDelincuente.jTextField7.getText()));
            Delincuente.setVecesDetenido(1);
            
            if(ConsultasDelincuente.insertarRespuesta(Delincuente)){
                JOptionPane.showMessageDialog(null, "Nuevo criminal añadido");
                limpiarTabla(ventanaDelincuente.jTable1);
                ConsultasDelincuente.mostrarTabla(ventanaDelincuente);
            }else{
                JOptionPane.showMessageDialog(null, "error al añadir al criminal");
            }
        } else if (e.getSource() == ventanaDelincuente.jButton5) {
            ventanaDelincuente.jTextField1.setText(null);
            ventanaDelincuente.jTextField2.setText(null);
            ventanaDelincuente.jTextField3.setText(null);
            ventanaDelincuente.jTextField4.setText(null);
            ventanaDelincuente.jTextField5.setText(null);
            ventanaDelincuente.jTextField6.setText(null);
            ventanaDelincuente.jTextField7.setText(null);
            ventanaDelincuente.jTextField9.setText(null);
                    
            } else if (e.getSource() == ventanaDelincuente.jButton2) {
                ventanaDelincuente.dispose();
                //VentanaCasos.setVisible(true);
                ControladorCasos CTRcaso = new ControladorCasos();
                CTRcaso.inicio();
                                            
            } else if (e.getSource() == ventanaDelincuente.filtrarProvincia) {
                
                String dato = ventanaDelincuente.jComboBox1.getSelectedItem().toString();
                Delincuente.setProvincia(dato);
                limpiarTabla(ventanaDelincuente.jTable1);
                ConsultasDelincuente.filtroTabla(ventanaDelincuente,Delincuente,1);
                
            } else if (e.getSource() == ventanaDelincuente.filtrarPais) { 
                
                String dato = ventanaDelincuente.jComboBox2.getSelectedItem().toString();
                Delincuente.setPaisOrigen(dato);
                limpiarTabla(ventanaDelincuente.jTable1);
                ConsultasDelincuente.filtroTabla(ventanaDelincuente,Delincuente,2);
                
            } else if (e.getSource() == ventanaDelincuente.filtrarDetenciones) {
                
                String dato = ventanaDelincuente.jComboBox3.getSelectedItem().toString();
                Delincuente.setVecesDetenido(Integer.parseInt(dato));
                limpiarTabla(ventanaDelincuente.jTable1);
                ConsultasDelincuente.filtroTabla(ventanaDelincuente,Delincuente,3);   
                
            } else if (e.getSource() == ventanaDelincuente.jButton7) {
                
                String dato = ventanaDelincuente.jComboBox4.getSelectedItem().toString();
                Delincuente.setLocalidad(dato);
                limpiarTabla(ventanaDelincuente.jTable1);
                ConsultasDelincuente.filtroTabla(ventanaDelincuente,Delincuente,4);             
            } else if (e.getSource() == ventanaDelincuente.jButton8) {
                limpiarTabla(ventanaDelincuente.jTable1);
                ConsultasDelincuente.mostrarTabla(ventanaDelincuente);
            } else if (e.getSource() == ventanaDelincuente.jButton6) {
                limpiarTabla(ventanaDelincuente.jTable1);
                Delincuente.setDNI(ventanaDelincuente.jTextField8.getText());
                ConsultasDelincuente.mostrarTablaDNI(ventanaDelincuente,Delincuente);
            } else if (e.getSource() == ventanaDelincuente.jButton9) {
            ventanaDelincuente.dispose();
            ControladorModificaciones CTRmodificaciones = new ControladorModificaciones();
            CTRmodificaciones.inicio();
        } else if (e.getSource() == ventanaDelincuente.jButton1) {
                ventanaDelincuente.dispose();
                ControladorPolicia CTRPolicia = new ControladorPolicia();
                CTRPolicia.inicio();
                
                                            
            } 
      }
    
}
