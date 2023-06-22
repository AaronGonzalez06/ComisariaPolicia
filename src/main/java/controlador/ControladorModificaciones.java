/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Delincuente;
import modelo.ConsultasDelincuente;
import vista.VistaModificaciones;
import vista.VistaCasos;

/**
 *
 * @author Aaron
 */
public class ControladorModificaciones implements ActionListener {

    private final Delincuente delincuente;
    private final VistaModificaciones vistaModificaciones;
    private final ConsultasDelincuente consultasDelincuente;
    
    public ControladorModificaciones(){
        this.consultasDelincuente = new ConsultasDelincuente();
        this.delincuente = new Delincuente();
        this.vistaModificaciones = new VistaModificaciones();        
    }
    
    public void inicio() {
        vistaModificaciones.setVisible(true);
        vistaModificaciones.setTitle("Modificaciones");
        vistaModificaciones.setLocationRelativeTo(null);
        consultasDelincuente.mostrarTablaModificaciones(vistaModificaciones);
        movimientoRaton();
        vistaModificaciones.jButton3.addActionListener(this);
        vistaModificaciones.jButton2.addActionListener(this);
        vistaModificaciones.jButton4.addActionListener(this);
        vistaModificaciones.jButton5.addActionListener(this);
        vistaModificaciones.jButton6.addActionListener(this);
        
        vistaModificaciones.jButton4.setIcon((Icon) new ImageIcon("src/main/java/img/policia.png"));
        vistaModificaciones.jButton5.setIcon((Icon) new ImageIcon("src/main/java/img/placa.png"));
        vistaModificaciones.jButton6.setIcon((Icon) new ImageIcon("src/main/java/img/delincuente.png"));
        vistaModificaciones.jButton9.setIcon((Icon) new ImageIcon("src/main/java/img/placa.png"));
        vistaModificaciones.jButton2.setIcon((Icon) new ImageIcon("src/main/java/img/mas.png"));
        vistaModificaciones.jButton3.setIcon((Icon) new ImageIcon("src/main/java/img/limpiar.png"));
        
        vistaModificaciones.getContentPane().setBackground(Color.LIGHT_GRAY);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistaModificaciones.jButton3) {
                vistaModificaciones.jTextField9.setText(null);
                vistaModificaciones.jTextField1.setText(null);
                vistaModificaciones.jTextField2.setText(null);
                vistaModificaciones.jTextField3.setText(null);
                vistaModificaciones.jTextField4.setText(null);
                vistaModificaciones.jTextField5.setText(null);
                vistaModificaciones.jTextField6.setText(null);
                vistaModificaciones.jTextField7.setText(null);
                vistaModificaciones.jTextField8.setText(null);
        
        } else if (e.getSource() == vistaModificaciones.jButton2) {
            delincuente.setDNI(vistaModificaciones.jTextField9.getText());
            delincuente.setNombre(vistaModificaciones.jTextField1.getText());
            delincuente.setApellido(vistaModificaciones.jTextField2.getText());
            delincuente.setDireccion(vistaModificaciones.jTextField3.getText());
            delincuente.setLocalidad(vistaModificaciones.jTextField4.getText());
            delincuente.setProvincia(vistaModificaciones.jTextField5.getText());
            delincuente.setPaisOrigen(vistaModificaciones.jTextField6.getText());
            delincuente.setEdad(Integer.parseInt(vistaModificaciones.jTextField7.getText()));
            delincuente.setVecesDetenido(Integer.parseInt(vistaModificaciones.jTextField8.getText()));
            
            if(consultasDelincuente.actualizarDelincuente(delincuente)){
                JOptionPane.showMessageDialog(null, "Criminal actualizado");
            limpiarTabla(vistaModificaciones.jTable1);
            consultasDelincuente.mostrarTablaModificaciones(vistaModificaciones);
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        
        }  else if (e.getSource() == vistaModificaciones.jButton4) {
                vistaModificaciones.dispose();
                ControladorPolicia CTRPolicia = new ControladorPolicia();
                CTRPolicia.inicio();
                
                                            
            } else if (e.getSource() == vistaModificaciones.jButton6) {
            vistaModificaciones.dispose();
            ControladorDelincuente CTRdelincuente = new ControladorDelincuente();
            CTRdelincuente.inicio();
            
        } else if (e.getSource() == vistaModificaciones.jButton5) {
            vistaModificaciones.dispose();
            ControladorCasos CTRcasos = new ControladorCasos();
            CTRcasos.inicio();
            
        }                     
    }
    
    
    public void movimientoRaton(){
    
    
    MouseListener ratonOyente = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vistaModificaciones.jTable1.getSelectedRow();
            String DNI = vistaModificaciones.jTable1.getValueAt(fila, 0).toString();
            delincuente.setDNI(DNI);
            consultasDelincuente.mostrarInformacionDelincuente(vistaModificaciones, delincuente);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };
    
    vistaModificaciones.jTable1.addMouseListener(ratonOyente);
    
    }
    
    public void limpiarTabla(JTable tabla){
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = filas -1; i > -1; i--) {
                modelo.removeRow(i);
            }        
    }
    
}
