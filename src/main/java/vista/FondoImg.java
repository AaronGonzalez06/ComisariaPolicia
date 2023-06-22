/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Aaron
 */
public class FondoImg extends javax.swing.JPanel {
    
    private String ruta;
    
    public FondoImg (int ancho, int alto, String ruta){
        this.setSize(ancho,alto);
        this.ruta = ruta;
    }
    
    
    @Override
    public void paint(Graphics g){
        Dimension tamano =  getSize();
        ImageIcon img = new ImageIcon(getClass().getResource(ruta));
        g.drawImage(img.getImage(),0,0,tamano.width,tamano.height,null);
        setOpaque(false);
        super.paintComponent(g);
    }    
}
