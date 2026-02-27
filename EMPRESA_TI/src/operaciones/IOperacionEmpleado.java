package operaciones;

import java.util.List;
import modelos.Empleado;

public interface IOperacionEmpleado {
    Empleado registrarEmpleado(int nit, String nombreEmpresa, String direccion, String ciudad, 
                              int documento, String nombreEmpleado, double sueldoHora);
    List<Empleado> listarEmpleados();
    Empleado buscarEmpleadoPorDocumento(int documento);
    double calcularSueldoEmpleado(int documento, int horasTrabajadas);
    int contarEmpleadosPorEmpresa(int nitEmpresa);
}
