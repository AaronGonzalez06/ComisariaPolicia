/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aaron
 */
public class Delincuente {
    
    private int id;
    private String DNI;
    private String nombre;
    private String apellido;
    private String direccion;
    private String localidad;
    private String provincia;
    private String paisOrigen;
    private int edad;
    private int vecesDetenido;
    private String imagen;
    
    public Delincuente() {
        this.id = 0;
        this.DNI = "";
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.localidad = "";
        this.provincia = "";
        this.paisOrigen = "";
        this.edad = 0;
        this.vecesDetenido = 0;
        this.imagen = "";
    }

    public Delincuente(String DNI ,int id, String nombre, String apellido, String direccion, String localidad, String provincia, String paisOrigen, int edad, int vecesDetenido, String imagen) {
        this.DNI = DNI;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.paisOrigen = paisOrigen;
        this.edad = edad;
        this.vecesDetenido = vecesDetenido;
        this.imagen = imagen;
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getVecesDetenido() {
        return vecesDetenido;
    }

    public void setVecesDetenido(int vecesDetenido) {
        this.vecesDetenido = vecesDetenido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
}
