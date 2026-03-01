package modelos;

import java.util.Scanner;

public class Empleado extends Empresa {
    private int documento;
    private String nombre;
    private double sueldoHora;


    public int getDocumento() {
        return documento;
    }
    public void setDocumento(int documento) {
        this.documento = documento;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSueldoHora() {
        return sueldoHora;
    }
    public void setSueldoHora(double sueldoHora) {
        this.sueldoHora = sueldoHora;
    }
    
    // constructor
    public Empleado(int nit, String nombreEmpresa, String direccion, String ciudad, int documento, String nombreEmpleado, double sueldoHora) {
        super(nit, nombreEmpresa, direccion, ciudad);
        this.documento = documento;
        this.nombre = nombreEmpleado;
        this.sueldoHora = sueldoHora;
    }

    // constructor vacío
    public Empleado() {
        super(0, "", "", "");
    }

    // método para crear empleado por consola - usa el Scanner proporcionado por quien llama
    public void crearEmpleado(Scanner sc) {
        System.out.println("=== Crear Empleado ===");

        System.out.print("Ingrese NIT de la empresa: ");
        int nit = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        setNit(nit);

        System.out.print("Ingrese nombre de la empresa: ");
        String nombreEmpresa = sc.nextLine();
        setNombre(nombreEmpresa);

        System.out.print("Ingrese dirección de la empresa: ");
        String direccion = sc.nextLine();
        setDireccion(direccion);

        System.out.print("Ingrese ciudad de la empresa: ");
        String ciudad = sc.nextLine();
        setCiudad(ciudad);

        System.out.print("Ingrese documento del empleado: ");
        this.documento = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        System.out.print("Ingrese nombre del empleado: ");
        this.nombre = sc.nextLine();

        System.out.print("Ingrese sueldo por hora: ");
        this.sueldoHora = sc.nextDouble();
        sc.nextLine(); // limpiar buffer
    }

    @Override
    public String toString() {
        return "Documento: " + documento + " | Nombre: " + nombre + 
               " | Sueldo/Hora: " + sueldoHora + " | Empresa: " + getNombre() + 
               " | NIT: " + getNit();
    }




}
