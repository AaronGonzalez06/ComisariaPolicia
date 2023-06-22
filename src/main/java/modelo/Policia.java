/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aaron
 */
public class Policia {
    
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String comisaria;
    private String usuario;
    private String passwd;
    private int edad;
    private String DNI;
    
    
    public Policia() {
        this.id = 0;
        this.DNI = "";
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.comisaria = "";
        this.usuario = "";
        this.passwd = "";
        this.edad = 0;
    }
    
    

    public Policia(int id, String nombre, String apellido, String direccion, String comisaria, String usuario, String passwd, int edad,String DNI) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.comisaria = comisaria;
        this.usuario = usuario;
        this.passwd = passwd;
        this.edad = edad;
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComisaria() {
        return comisaria;
    }

    public void setComisaria(String comisaria) {
        this.comisaria = comisaria;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
}
