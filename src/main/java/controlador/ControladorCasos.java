/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import vista.VistaDelincuente;
import vista.VistaCasos;
import vista.VistaDatos;
import vista.FondoImg;

import modelo.Delincuente;
import modelo.ConsultasCaso;
import modelo.ConsultasPolicia;
import modelo.Caso;
import modelo.Policia;

import controlador.ControladorPolicia;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Aaron
 */
public class ControladorCasos implements ActionListener {

    //private VistaDelincuente ventanaDelincuente;
    private VistaCasos VentanaCasos;
    //private VistaDatos VentanaDatos;
    
    
    /**/
    private final Caso caso;
    private final ConsultasCaso consultascasos;
    /**/

    private Caso Caso = new Caso();
    private Policia policia = new Policia();
    private Delincuente Delincuente = new Delincuente();
    private ConsultasCaso ConsultasCaso = new ConsultasCaso();
    private ConsultasPolicia ConsultasPolicia = new ConsultasPolicia();

   /* public ControladorCasos(VistaDelincuente ventanaDelincuente, VistaCasos VentanaCasos, VistaDatos VentanaDatos) {
        this.ventanaDelincuente = ventanaDelincuente;
        this.VentanaDatos = VentanaDatos;
        this.VentanaCasos = VentanaCasos;
    }*/
    
    /*public ControladorCasos() {
        this.ventanaDelincuente = new VistaDelincuente();
        this.VentanaDatos = new VistaDatos();
        this.VentanaCasos = new VistaCasos();
    }*/
    public ControladorCasos(){    
        this.caso = new Caso();
        this.consultascasos = new ConsultasCaso();
        this.VentanaCasos = new VistaCasos();
    }

    public void inicio() {
        VentanaCasos.setVisible(true);
        VentanaCasos.setTitle("Casos");
        VentanaCasos.setLocationRelativeTo(null);
        
        ConsultasCaso.mostrarCasos(VentanaCasos);  
        ConsultasCaso.mostrarCasosParaAgente(VentanaCasos);
        ConsultasPolicia.mostrarDNI(VentanaCasos);
        ConsultasCaso.mostrarDNIDelincuente(VentanaCasos);
        VentanaCasos.jButton5.addActionListener(this);
        VentanaCasos.jButton4.addActionListener(this);
        VentanaCasos.jButton6.addActionListener(this);
        VentanaCasos.jButton3.addActionListener(this);
        VentanaCasos.jButton9.addActionListener(this);
        VentanaCasos.jButton8.addActionListener(this);
        VentanaCasos.jButton7.addActionListener(this);
        VentanaCasos.jButton1.addActionListener(this);
        VentanaCasos.jButton10.addActionListener(this);
        VentanaCasos.jButton11.addActionListener(this);
        
        VentanaCasos.jButton1.setIcon((Icon) new ImageIcon("src/main/java/img/policia.png"));
        VentanaCasos.jButton2.setIcon((Icon) new ImageIcon("src/main/java/img/placa.png"));
        VentanaCasos.jButton3.setIcon((Icon) new ImageIcon("src/main/java/img/delincuente.png"));
        VentanaCasos.jButton8.setIcon((Icon) new ImageIcon("src/main/java/img/placa.png"));
        VentanaCasos.jButton4.setIcon((Icon) new ImageIcon("src/main/java/img/mas.png"));
        VentanaCasos.jButton7.setIcon((Icon) new ImageIcon("src/main/java/img/mas.png"));
        VentanaCasos.jButton9.setIcon((Icon) new ImageIcon("src/main/java/img/mas.png"));
        VentanaCasos.jButton6.setIcon((Icon) new ImageIcon("src/main/java/img/buscar.png"));
        VentanaCasos.jButton5.setIcon((Icon) new ImageIcon("src/main/java/img/limpiar.png"));
        VentanaCasos.jButton10.setIcon((Icon) new ImageIcon("src/main/java/img/eliminar.png"));
        VentanaCasos.jButton11.setIcon((Icon) new ImageIcon("src/main/java/img/eliminar.png"));
        VentanaCasos.getContentPane().setBackground(Color.LIGHT_GRAY);
        VentanaCasos.jPanel1.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == VentanaCasos.jButton4) {
            Caso.setNombre(VentanaCasos.jTextField1.getText());
            Caso.setDescripcion(VentanaCasos.descripcion.getText());
            Caso.setEstado("Abierto");                        
            if (ConsultasCaso.insertarCaso(Caso)) {                
                JOptionPane.showMessageDialog(null, "Nuevo caso añadido");
                VentanaCasos.jComboBox3.removeAllItems();   
                VentanaCasos.jComboBox1.removeAllItems(); 
                ConsultasCaso.mostrarCasos(VentanaCasos);                 
                ConsultasCaso.mostrarCasosParaAgente(VentanaCasos);
            } else {
                JOptionPane.showMessageDialog(null, "error al añadir el caso");
            }
        } else if (e.getSource() == VentanaCasos.jButton5) {
            VentanaCasos.jTextField1.setText(null);
            VentanaCasos.descripcion.setText(null);

        } else if (e.getSource() == VentanaCasos.jButton6) {
             Caso.setNombre(VentanaCasos.jComboBox1.getSelectedItem().toString());
              ConsultasCaso.buscadorCaso(VentanaCasos,Caso);                            
            /*policias asociados*/
            VentanaCasos.jComboBox5.removeAllItems();
             ConsultasCaso.policiasAsociados(VentanaCasos,Caso);  
             ConsultasCaso.policiasAsociadosDNI(VentanaCasos, Caso);
            /*fin policias asociados*/            
            /*delincuentes asociados*/           
            VentanaCasos.jComboBox6.removeAllItems();
            ConsultasCaso.delincuentesAsociados(VentanaCasos,Caso);
            ConsultasCaso.delincuentesAsociadosDNI(VentanaCasos, Caso);
            /*fin delincuentes*/
                                          
        } else if (e.getSource() == VentanaCasos.jButton7) {
            Caso.setNombre(VentanaCasos.jComboBox3.getSelectedItem().toString());
            policia.setDNI(VentanaCasos.jComboBox2.getSelectedItem().toString());
            
            if(ConsultasCaso.insertarNuevoAgenteAlCaso(Caso, policia)){
                JOptionPane.showMessageDialog(null, "Nuevo agente al caso");
            }else{
                JOptionPane.showMessageDialog(null, "error");
            }
                    
        } else if (e.getSource() == VentanaCasos.jButton9) {
            Caso.setNombre(VentanaCasos.jComboBox3.getSelectedItem().toString());
            Delincuente.setDNI(VentanaCasos.jComboBox4.getSelectedItem().toString());
            
            if(ConsultasCaso.insertarNuevoDelincuenteAlCaso(Caso, Delincuente)){
                JOptionPane.showMessageDialog(null, "Nuevo delincuente al caso");
            }else{
                JOptionPane.showMessageDialog(null, "error");
            }
                    
        } else if (e.getSource() == VentanaCasos.jButton1) {
            VentanaCasos.dispose();
            ControladorPolicia CTRpolicia = new ControladorPolicia();
            CTRpolicia.inicio();
        } else if (e.getSource() == VentanaCasos.jButton10) {
            policia.setDNI(VentanaCasos.jComboBox5.getSelectedItem().toString());
            Caso.setNombre(VentanaCasos.jComboBox1.getSelectedItem().toString());
            if (ConsultasCaso.eliminarAgenteDelCaso(Caso, policia)) {
                JOptionPane.showMessageDialog(null, "Agente " + policia.getDNI() + " eliminado del caso: " + Caso.getNombre() + ".");

                ConsultasCaso.buscadorCaso(VentanaCasos, Caso);
                /*policias asociados*/
                VentanaCasos.jComboBox5.removeAllItems();
                ConsultasCaso.policiasAsociados(VentanaCasos, Caso);
                ConsultasCaso.policiasAsociadosDNI(VentanaCasos, Caso);
                /*fin policias asociados*/
                /*delincuentes asociados*/
                VentanaCasos.jComboBox6.removeAllItems();
                ConsultasCaso.delincuentesAsociados(VentanaCasos, Caso);
                ConsultasCaso.delincuentesAsociadosDNI(VentanaCasos, Caso);

            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } else if (e.getSource() == VentanaCasos.jButton11) {
            Delincuente.setDNI(VentanaCasos.jComboBox6.getSelectedItem().toString());
            Caso.setNombre(VentanaCasos.jComboBox1.getSelectedItem().toString());
            if (ConsultasCaso.eliminarDelincuenteDelCaso(Caso, Delincuente)) {
                JOptionPane.showMessageDialog(null, "Delincuente " + Delincuente.getDNI() + " eliminado del caso: " + Caso.getNombre() + ".");

                ConsultasCaso.buscadorCaso(VentanaCasos, Caso);
                /*policias asociados*/
                VentanaCasos.jComboBox5.removeAllItems();
                ConsultasCaso.policiasAsociados(VentanaCasos, Caso);
                ConsultasCaso.policiasAsociadosDNI(VentanaCasos, Caso);
                /*fin policias asociados*/
                /*delincuentes asociados*/
                VentanaCasos.jComboBox6.removeAllItems();
                ConsultasCaso.delincuentesAsociados(VentanaCasos, Caso);
                ConsultasCaso.delincuentesAsociadosDNI(VentanaCasos, Caso);

            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } else if (e.getSource() == VentanaCasos.jButton8) {
            VentanaCasos.dispose();
            ControladorModificaciones CTRmodifi = new ControladorModificaciones();
            CTRmodifi.inicio();
            
        } else if (e.getSource() == VentanaCasos.jButton3) {
            System.out.println("entro");
            VentanaCasos.dispose();
            ControladorDelincuente CTRdelin = new ControladorDelincuente();
            CTRdelin.inicio();
            
        }
    }

}
