/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import vista.VistaDelincuente;
import vista.VistaModificaciones;

/**
 *
 * @author Aaron
 */
public class ConsultasDelincuente extends Conexion {
    
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertarRespuesta(Delincuente delincuente) {
        Connection conexion = getConnection();
        try {
            System.out.println("entro en el try");
            ps = conexion.prepareStatement("insert into delincuente (DNI,nombre,apellido,direccion,Localidad,provincia,PaisOrigen,edad,VecesDetenido) values (?,?,?,?,?,?,?,?,?);");
            ps.setString(1, delincuente.getDNI());
            ps.setString(2, delincuente.getNombre());
            ps.setString(3, delincuente.getApellido());
            ps.setString(4, delincuente.getDireccion());
            ps.setString(5, delincuente.getLocalidad());
            ps.setString(6, delincuente.getProvincia());
            ps.setString(7, delincuente.getPaisOrigen());
            ps.setInt(8, delincuente.getEdad());
            ps.setInt(9, delincuente.getVecesDetenido());
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
    
    public void mostrarTabla(VistaDelincuente ventanaDelincuente) {
        Connection conexion = getConnection();
        String sql = "select * from delincuente;";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);            
            DefaultTableModel model = (DefaultTableModel) ventanaDelincuente.jTable1.getModel();
            
            while(resultado.next()){                        
            model.addRow(new Object[]{resultado.getString(11),resultado.getString(2), resultado.getString(3), resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7),resultado.getInt(8),resultado.getInt(9)});
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
    
    public void mostrarTablaModificaciones(VistaModificaciones VistaModificaciones) {
        Connection conexion = getConnection();
        String sql = "select * from delincuente;";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);            
            DefaultTableModel model = (DefaultTableModel) VistaModificaciones.jTable1.getModel();
            
            while(resultado.next()){                        
            model.addRow(new Object[]{resultado.getString(11),resultado.getString(2), resultado.getString(3), resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7),resultado.getInt(8),resultado.getInt(9)});
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
    
    
    public void mostrarProvincias(VistaDelincuente ventanaDelincuente) {
        Connection conexion = getConnection();
        String sql = "select distinct provincia from delincuente;";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);
            
            while(resultado.next()){
                ventanaDelincuente.jComboBox1.addItem(resultado.getString(1));
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
    
    public void mostrarPaisOrigen(VistaDelincuente ventanaDelincuente) {
        Connection conexion = getConnection();
        String sql = "select distinct PaisOrigen from delincuente;";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);
            
            while(resultado.next()){
                ventanaDelincuente.jComboBox2.addItem(resultado.getString(1));
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
    public void mostrarNumDetenciones(VistaDelincuente ventanaDelincuente) {
        Connection conexion = getConnection();
        String sql = "select distinct VecesDetenido from delincuente order by VecesDetenido desc;";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);
            
            while(resultado.next()){
                ventanaDelincuente.jComboBox3.addItem(resultado.getString(1));
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
    
    public void mostrarLocalidad(VistaDelincuente ventanaDelincuente) {
        Connection conexion = getConnection();
        String sql = "select distinct Localidad from delincuente;";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);
            
            while(resultado.next()){
                ventanaDelincuente.jComboBox4.addItem(resultado.getString(1));
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
    
    public void filtroTabla(VistaDelincuente ventanaDelincuente,Delincuente delincuente ,int identificador) {
        Connection conexion = getConnection(); 
        String columna ="";
        String dato = "";
        if(identificador == 1){
            columna = "provincia";
            dato = delincuente.getProvincia();
        }else if(identificador == 2){
            columna = "PaisOrigen";
            dato = delincuente.getPaisOrigen();
        } else if(identificador == 3){
            columna = "VecesDetenido";
            dato = String.valueOf(delincuente.getVecesDetenido());
        } else if(identificador == 4){
            columna = "Localidad";
            dato = delincuente.getLocalidad();
        }
        String sql = "select * from delincuente where "+ columna +" = '" + dato +"'" ;
        
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);            
            DefaultTableModel model = (DefaultTableModel) ventanaDelincuente.jTable1.getModel();
            
            while(resultado.next()){                        
            model.addRow(new Object[]{resultado.getString(11),resultado.getString(2), resultado.getString(3), resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7),resultado.getInt(8),resultado.getInt(9)});
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
    
    public void mostrarTablaDNI(VistaDelincuente ventanaDelincuente,Delincuente delincuente) {
        Connection conexion = getConnection();
        String sql = "select * from delincuente where DNI='"+delincuente.getDNI()+"';";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);            
            DefaultTableModel model = (DefaultTableModel) ventanaDelincuente.jTable1.getModel();
            
            while(resultado.next()){                        
            model.addRow(new Object[]{resultado.getString(11),resultado.getString(2), resultado.getString(3), resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7),resultado.getInt(8),resultado.getInt(9)});
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
    
    public void mostrarInformacionDelincuente(VistaModificaciones vistaModificaciones,Delincuente delincuente) {
        Connection conexion = getConnection();
        String sql = "select * from delincuente where DNI= '"+ delincuente.getDNI()+"';";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);
            
            while(resultado.next()){
                vistaModificaciones.jTextField9.setText(resultado.getString(11));
                vistaModificaciones.jTextField1.setText(resultado.getString(2));
                vistaModificaciones.jTextField2.setText(resultado.getString(3));
                vistaModificaciones.jTextField3.setText(resultado.getString(4));
                vistaModificaciones.jTextField4.setText(resultado.getString(5));
                vistaModificaciones.jTextField5.setText(resultado.getString(6));
                vistaModificaciones.jTextField6.setText(resultado.getString(7));
                vistaModificaciones.jTextField7.setText(resultado.getString(8));
                vistaModificaciones.jTextField8.setText(resultado.getString(9));
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
    
    public boolean actualizarDelincuente(Delincuente delincuente) {
        Connection conexion = getConnection();
        try {
            System.out.println("entro en el try");
            ps = conexion.prepareStatement("update delincuente set nombre=?, apellido=?, direccion=?, edad=?, VecesDetenido=?, PaisOrigen=?,Localidad=?,provincia=? where DNI = ?;");            
            ps.setString(1, delincuente.getNombre());
            ps.setString(2, delincuente.getApellido());
            ps.setString(3, delincuente.getDireccion());
            ps.setInt(4, delincuente.getEdad());
            ps.setInt(5, delincuente.getVecesDetenido());
            ps.setString(6, delincuente.getPaisOrigen());
            ps.setString(7, delincuente.getLocalidad());
            ps.setString(8, delincuente.getProvincia());
            ps.setString(9, delincuente.getDNI());
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
