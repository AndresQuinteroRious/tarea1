package modelos;

import java.util.Scanner;

public class Empresa {
    private int nit;
    private String nombre;
    private String direccion;
    private String ciudad;


    // getters y setters
    public int getNit() {
        return nit;
    }
    public void setNit(int nit) {
        this.nit = nit;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    // constructor
    public Empresa(int nit, String nombre, String direccion, String ciudad) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    // constructor vacío
    public Empresa() {
        this.nit = 0;
        this.nombre = "";
        this.direccion = "";
        this.ciudad = "";
    }

    //metodo ingresar empresa
    // Método para ingresar datos por consola
    public void ingresarEmpresa() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese NIT: ");
        this.nit = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        System.out.print("Ingrese Nombre: ");
        this.nombre = sc.nextLine();

        System.out.print("Ingrese Dirección: ");
        this.direccion = sc.nextLine();

        System.out.print("Ingrese Ciudad: ");
        this.ciudad = sc.nextLine();
        
    // No cerrar el Scanner que envuelve System.in aquí para evitar cerrar System.in
    }

    @Override
    public String toString() {
        return "NIT: " + nit + " | Nombre: " + nombre +
               " | Dirección: " + direccion + " | Ciudad: " + ciudad;
    }


}


    

