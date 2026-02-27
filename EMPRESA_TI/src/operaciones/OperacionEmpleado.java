package operaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelos.Empleado;

public class OperacionEmpleado implements IOperacionEmpleado {
    private final List<Empleado> empleados;

    public OperacionEmpleado() {
        this.empleados = new ArrayList<>();
    }

    @Override
    public Empleado registrarEmpleado(int nit, String nombreEmpresa, String direccion, String ciudad, 
                                    int documento, String nombreEmpleado, double sueldoHora) {
        // Verificar si ya existe un empleado con el mismo documento
        for (Empleado empleado : empleados) {
            if (empleado.getDocumento() == documento) {
                System.out.println(" Ya existe un empleado con el documento: " + documento);
                return null;
            }
        }
        
        Empleado empleado = new Empleado(nit, nombreEmpresa, direccion, ciudad, documento, nombreEmpleado, sueldoHora);
        empleados.add(empleado);
        return empleado;
    }

    @Override
    public List<Empleado> listarEmpleados() {
        return Collections.unmodifiableList(empleados);
    }

    @Override
    public Empleado buscarEmpleadoPorDocumento(int documento) {
        for (Empleado empleado : empleados) {
            if (empleado.getDocumento() == documento) {
                return empleado;
            }
        }
        return null;
    }

    @Override
    public double calcularSueldoEmpleado(int documento, int horasTrabajadas) {
        Empleado empleado = buscarEmpleadoPorDocumento(documento);
        if (empleado != null) {
            return empleado.getSueldoHora() * horasTrabajadas;
        }
        return 0;
    }

    @Override
    public int contarEmpleadosPorEmpresa(int nitEmpresa) {
        int contador = 0;
        for (Empleado empleado : empleados) {
            if (empleado.getNit() == nitEmpresa) {
                contador++;
            }
        }
        return contador;
    }
}