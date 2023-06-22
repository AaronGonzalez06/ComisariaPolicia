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
import javax.swing.DefaultListModel;
import vista.VistaCasos;

/**
 *
 * @author Aaron
 */
public class ConsultasCaso extends Conexion {

    PreparedStatement ps;
    ResultSet rs;
    public boolean insertarCaso(Caso caso) {
        Connection conexion = getConnection();
        try {
            System.out.println("entro en el try");
            ps = conexion.prepareStatement("insert into caso (nombre,descripcion,estado) values (?,?,?);");
            ps.setString(1, caso.getNombre());
            ps.setString(2, caso.getDescripcion());
            ps.setString(3, caso.getEstado());
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
    
    public boolean insertarNuevoAgenteAlCaso(Caso caso,Policia policia) {
        Connection conexion = getConnection();
        try {
            System.out.println("entro en el try");
            ps = conexion.prepareStatement("insert into asignado (id_policia,id_caso) values ((select id from policia where DNI = ?), (select id from caso where nombre = ?));");
            ps.setString(1, policia.getDNI());
            ps.setString(2, caso.getNombre());
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
    
    public boolean insertarNuevoDelincuenteAlCaso(Caso caso,Delincuente delincuente) {
        Connection conexion = getConnection();
        try {
            System.out.println("entro en el try");
            ps = conexion.prepareStatement("insert into vinculado (id_delincuente,id_caso) values ((select id from delincuente where DNI = ?), (select id from caso where nombre = ?));");
            ps.setString(1, delincuente.getDNI());
            ps.setString(2, caso.getNombre());
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
    
    public void mostrarCasos(VistaCasos ventanaCasos) {
        Connection conexion = getConnection();
        String sql = "select distinct nombre from caso;";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);
            
            while(resultado.next()){
                ventanaCasos.jComboBox1.addItem(resultado.getString(1));
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
    
    public void mostrarCasosParaAgente(VistaCasos ventanaCasos) {
        Connection conexion = getConnection();
        String sql = "select distinct nombre from caso where lower (estado)='Abierto';";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);
            
            while(resultado.next()){
                ventanaCasos.jComboBox3.addItem(resultado.getString(1));
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
    
    public void mostrarDNIDelincuente(VistaCasos ventanaCasos) {
        Connection conexion = getConnection();
        String sql = "select distinct DNI from delincuente;";
        try {
            Statement s = conexion.createStatement();
            ResultSet resultado = s.executeQuery(sql);
            
            while(resultado.next()){
                ventanaCasos.jComboBox4.addItem(resultado.getString(1));
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
        
    public void buscadorCaso(VistaCasos ventanaCasos,Caso caso) {
        Connection conexion = getConnection();
        try {
            conexion = getConnection();

            ps = conexion.prepareStatement("select estado, descripcion from caso where lower(nombre) = ?");
            ps.setString(1, caso.getNombre());
            rs = ps.executeQuery();
                while (rs.next()) {
                   ventanaCasos.jTextArea2.setText(rs.getString("descripcion"));
                   ventanaCasos.jLabel8.setText(rs.getString("estado"));
                }
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    public void policiasAsociados(VistaCasos ventanaCasos,Caso caso) {
        Connection conexion = getConnection();
        try {
            conexion = getConnection();

            ps = conexion.prepareStatement("select concat(pol.nombre ,' ', pol.apellido, ' con DNI: ', pol.DNI) as nombre from policia pol inner join asignado asi on asi.id_policia = pol.id inner join caso cas on cas.id = asi.id_caso where cas.nombre = ?;");
            ps.setString(1, caso.getNombre());
            rs = ps.executeQuery();
            DefaultListModel modelo = new DefaultListModel();
                while (rs.next()) {
                    modelo.addElement(rs.getString("nombre"));
                    
                }     
                ventanaCasos.jList1.setModel(modelo); 
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    public void policiasAsociadosDNI(VistaCasos ventanaCasos,Caso caso) {
        Connection conexion = getConnection();
        try {
            conexion = getConnection();

            ps = conexion.prepareStatement("select pol.DNI as DNI from policia pol inner join asignado asi on asi.id_policia = pol.id inner join caso cas on cas.id = asi.id_caso where cas.nombre = ?;");
            ps.setString(1, caso.getNombre());
            rs = ps.executeQuery();
                while (rs.next()) {
                    ventanaCasos.jComboBox5.addItem(rs.getString(1));
                }     
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    
    
    public void delincuentesAsociados(VistaCasos ventanaCasos,Caso caso) {
        Connection conexion = getConnection();
        try {
            conexion = getConnection();

            ps = conexion.prepareStatement("select concat(del.nombre ,' ', del.apellido, ' con DNI: ', del.DNI) as nombre from delincuente del inner join vinculado vin on vin.id_delincuente = del.id inner join caso cas on cas.id = vin.id_caso where cas.nombre = ?;");
            ps.setString(1, caso.getNombre());
            rs = ps.executeQuery();
            DefaultListModel modeloDelincuente = new DefaultListModel();
                while (rs.next()) {                    
                    modeloDelincuente.addElement(rs.getString("nombre"));
                }
                ventanaCasos.jList2.setModel(modeloDelincuente);  
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    public void delincuentesAsociadosDNI(VistaCasos ventanaCasos,Caso caso) {
        Connection conexion = getConnection();
        try {
            conexion = getConnection();

            ps = conexion.prepareStatement("select del.DNI as DNI from delincuente del inner join vinculado vin on vin.id_delincuente = del.id inner join caso cas on cas.id = vin.id_caso where cas.nombre = ?;");
            ps.setString(1, caso.getNombre());
            rs = ps.executeQuery();
                while (rs.next()) {
                    ventanaCasos.jComboBox6.addItem(rs.getString(1));
                } 
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    public boolean eliminarAgenteDelCaso(Caso caso,Policia policia) {
        Connection conexion = getConnection();
        try {
            System.out.println("entro en el try");
            ps = conexion.prepareStatement("delete from asignado where id_policia = (select id from policia where DNI=?) and id_caso = ( select id from caso where nombre = ?);");
            ps.setString(1, policia.getDNI());
            ps.setString(2, caso.getNombre());
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
    
    public boolean eliminarDelincuenteDelCaso(Caso caso,Delincuente delincuente) {
        Connection conexion = getConnection();
        try {
            System.out.println("entro en el try");
            ps = conexion.prepareStatement("delete from vinculado where id_delincuente = (select id from delincuente where DNI=?) and id_caso = ( select id from caso where nombre = ?);");
            ps.setString(1, delincuente.getDNI());
            ps.setString(2, caso.getNombre());
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
