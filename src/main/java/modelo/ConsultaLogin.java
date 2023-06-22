/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aaron
 */
public class ConsultaLogin extends Conexion {
    
    PreparedStatement ps;
    ResultSet rs;
    
    public String verificarUsuario(Policia policia) {
        Connection conexion = getConnection();
        String resultado = "";
        try {
            conexion = getConnection();

            ps = conexion.prepareStatement("select passwd from policia where usuario = ?;");
            ps.setString(1, policia.getUsuario());
            rs = ps.executeQuery();
                while (rs.next()) {
                    resultado = rs.getString("passwd");
                }                            
            return resultado;
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
            return " ";
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
}
