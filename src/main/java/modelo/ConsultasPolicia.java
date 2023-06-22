/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import vista.VistaCasos;
import vista.VistaPolicia;

/**
 *
 * @author Aaron
 */
public class ConsultasPolicia extends Conexion {
    
    PreparedStatement ps;
    ResultSet rs;
    
    public void mostrarDNI(VistaCasos ventanaCasos) {
        Connection conexion = getConnection();
        String sql = "select distinct DNI from policia;";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);
            
            while(resultado.next()){
                ventanaCasos.jComboBox2.addItem(resultado.getString(1));
            }
            s.close();
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
           // return CasoResultado;
        } finally {
            try {
                conexion.close();
                
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    public boolean insertarRespuesta(Policia policia) {
        Connection conexion = getConnection();
        try {
            System.out.println("entro en el try");
            ps = conexion.prepareStatement("insert into policia (DNI,nombre,apellido,direccion,comisaria,edad) values (?,?,?,?,?,?);");
            ps.setString(1, policia.getDNI());
            ps.setString(2, policia.getNombre());
            ps.setString(3, policia.getApellido());
            ps.setString(4, policia.getDireccion());
            ps.setString(5, policia.getComisaria());
            ps.setInt(6, policia.getEdad());
            int resultado = ps.executeUpdate();            
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    public void mostrarComisaria(VistaPolicia vistaPolicia) {
        Connection conexion = getConnection();
        String sql = "select distinct comisaria from policia;";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);
            
            while(resultado.next()){
                vistaPolicia.jComboBox1.addItem(resultado.getString(1));
            }
            s.close();
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
           // return CasoResultado;
        } finally {
            try {
                conexion.close();
                
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    public ArrayList<Policia> listarPolicias() {
        Connection conexion = getConnection();
        ArrayList<Policia> Policias = new ArrayList<Policia>();
        try {
            conexion = getConnection();
            int contador = 0;            
            ps = conexion.prepareStatement("Select * from policia");                       
            rs = ps.executeQuery();

            while (rs.next()) {
                Policias.add(new Policia());
                Policias.get(contador).setDNI(rs.getString("DNI"));
                Policias.get(contador).setNombre(rs.getString("nombre"));
                Policias.get(contador).setApellido(rs.getString("apellido"));
                Policias.get(contador).setDireccion(rs.getString("direccion"));
                Policias.get(contador).setComisaria(rs.getString("comisaria"));
                Policias.get(contador).setEdad(rs.getInt("edad"));
                contador++;
            }
            return Policias;
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
            return Policias;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    public boolean actualizarPolicia(Policia policia) {
        Connection conexion = getConnection();
        try {
            System.out.println("entro en el try");
            ps = conexion.prepareStatement("update policia set nombre=?, apellido=?, direccion=?, edad=? where DNI = ?;");            
            ps.setString(1, policia.getNombre());
            ps.setString(2, policia.getApellido());
            ps.setString(3, policia.getDireccion());
            ps.setInt(4, policia.getEdad());
            ps.setString(5, policia.getDNI());
            int resultado = ps.executeUpdate();            
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
}
