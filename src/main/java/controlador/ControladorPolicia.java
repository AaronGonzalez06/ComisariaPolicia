/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelo.Policia;
import modelo.ConsultasPolicia;
import vista.VistaPolicia;
import controlador.ControladorCasos;
import controlador.ControladorDelincuente;

/**
 *
 * @author Aaron
 */
public class ControladorPolicia implements ActionListener {
    
    private final Policia modelo_policia;
    private final ConsultasPolicia consultasPolicia;
    private final VistaPolicia vistaPolicia;
    int num =-1;
    ArrayList<Policia> policias;
    
    public ControladorPolicia(){
    this.consultasPolicia = new ConsultasPolicia();
    this.modelo_policia = new Policia();
    this.vistaPolicia = new VistaPolicia();
    }
    
    public void inicio() {
        vistaPolicia.setVisible(true);
        vistaPolicia.setTitle("agentes");
        vistaPolicia.setLocationRelativeTo(null);
        vistaPolicia.jButton3.addActionListener(this);
        vistaPolicia.jButton4.addActionListener(this);
        vistaPolicia.jButton6.addActionListener(this);
        vistaPolicia.jButton7.addActionListener(this);
        vistaPolicia.jButton8.addActionListener(this);
        vistaPolicia.jButton5.addActionListener(this);
        vistaPolicia.jButton9.addActionListener(this);
        vistaPolicia.jButton2.addActionListener(this);
        vistaPolicia.jButton10.addActionListener(this);
        consultasPolicia.mostrarComisaria(vistaPolicia);
        policias = consultasPolicia.listarPolicias();
        
        vistaPolicia.jButton1.setIcon((Icon) new ImageIcon("src/main/java/img/policia.png"));
        vistaPolicia.jButton2.setIcon((Icon) new ImageIcon("src/main/java/img/placa.png"));
        vistaPolicia.jButton3.setIcon((Icon) new ImageIcon("src/main/java/img/delincuente.png"));
        vistaPolicia.jButton9.setIcon((Icon) new ImageIcon("src/main/java/img/placa.png"));
        vistaPolicia.jButton4.setIcon((Icon) new ImageIcon("src/main/java/img/mas.png"));
        vistaPolicia.jButton6.setIcon((Icon) new ImageIcon("src/main/java/img/limpiar.png"));
        vistaPolicia.jButton5.setIcon((Icon) new ImageIcon("src/main/java/img/editar.png"));
        vistaPolicia.jButton10.setIcon((Icon) new ImageIcon("src/main/java/img/actualizar.png"));        
        vistaPolicia.jButton7.setIcon((Icon) new ImageIcon("src/main/java/img/atras.png"));
        vistaPolicia.jButton8.setIcon((Icon) new ImageIcon("src/main/java/img/adelante.png"));
        vistaPolicia.getContentPane().setBackground(Color.LIGHT_GRAY);
          
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPolicia.jButton4) {
            modelo_policia.setDNI(vistaPolicia.jTextField3.getText());
            modelo_policia.setNombre(vistaPolicia.jTextField4.getText());
            modelo_policia.setApellido(vistaPolicia.jTextField2.getText());
            modelo_policia.setDireccion(vistaPolicia.jTextField1.getText());
            modelo_policia.setEdad(Integer.parseInt(vistaPolicia.jTextField6.getText()));
            modelo_policia.setComisaria(vistaPolicia.jComboBox1.getSelectedItem().toString());
            
            if( consultasPolicia.insertarRespuesta(modelo_policia) ){
                JOptionPane.showMessageDialog(null, "Nuevo agente");
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        } else if (e.getSource() == vistaPolicia.jButton6) {
            vistaPolicia.jTextField2.setText(null);
            vistaPolicia.jTextField1.setText(null);
            vistaPolicia.jTextField3.setText(null);
            vistaPolicia.jTextField4.setText(null);
            vistaPolicia.jTextField6.setText(null);
        } else if (e.getSource() == vistaPolicia.jButton7) {            
            if(num != -1){num--;}
            System.out.println(num);
            if(num == -1){
                JOptionPane.showMessageDialog(null, "Estas al principio de la lista");
            }else{
                vistaPolicia.jTextField5.setText(policias.get(num).getDNI());
                vistaPolicia.jTextField7.setText(policias.get(num).getNombre());                
                vistaPolicia.jTextField11.setText(policias.get(num).getApellido());                
                vistaPolicia.jTextField8.setText(policias.get(num).getDireccion());
                vistaPolicia.jTextField9.setText(policias.get(num).getComisaria());
                vistaPolicia.jTextField10.setText(String.valueOf(policias.get(num).getEdad()));
            }
        } else if (e.getSource() == vistaPolicia.jButton8) {
            if(num != policias.size()){num++;} 
            System.out.println(num);
            if(num == policias.size()){
                JOptionPane.showMessageDialog(null, "Estas al final de la lista");
                num--;
            }else{
                vistaPolicia.jTextField5.setText(policias.get(num).getDNI());
                vistaPolicia.jTextField7.setText(policias.get(num).getNombre());                
                vistaPolicia.jTextField11.setText(policias.get(num).getApellido());                
                vistaPolicia.jTextField8.setText(policias.get(num).getDireccion());
                vistaPolicia.jTextField9.setText(policias.get(num).getComisaria());
                vistaPolicia.jTextField10.setText(String.valueOf(policias.get(num).getEdad()));
            }
        } else if (e.getSource() == vistaPolicia.jButton5) {
            modelo_policia.setDNI(vistaPolicia.jTextField5.getText());
            modelo_policia.setNombre(vistaPolicia.jTextField7.getText());
            modelo_policia.setApellido(vistaPolicia.jTextField11.getText());
            modelo_policia.setDireccion(vistaPolicia.jTextField8.getText());
            modelo_policia.setEdad(Integer.parseInt(vistaPolicia.jTextField10.getText()));
            modelo_policia.setComisaria(vistaPolicia.jTextField9.getText());
            
            if(consultasPolicia.actualizarPolicia(modelo_policia)){
                JOptionPane.showMessageDialog(null, "Datos actualizados");
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        } else if (e.getSource() == vistaPolicia.jButton10) {
            policias = consultasPolicia.listarPolicias();
            JOptionPane.showMessageDialog(null, "Lista Actualizada con exito");
            num=-1;
        } else if (e.getSource() == vistaPolicia.jButton9) {
                vistaPolicia.dispose();
                ControladorModificaciones CTRModificaciones = new ControladorModificaciones();
                CTRModificaciones.inicio();
                
                
                                            
            } else if (e.getSource() == vistaPolicia.jButton3) {
                vistaPolicia.dispose();
                ControladorDelincuente CTRDelin = new ControladorDelincuente();
                CTRDelin.inicio();
                
                
                                            
            } else if (e.getSource() == vistaPolicia.jButton2) {
                vistaPolicia.dispose();
                ControladorCasos CTRcasos = new ControladorCasos();
                CTRcasos.inicio();
                
                
                                            
            } 
    }
    
}
