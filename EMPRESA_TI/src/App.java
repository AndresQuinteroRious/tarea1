import java.util.Scanner;
import modelos.Empleado;
import modelos.Empresa;
import operaciones.OperacionEmpleado;
import operaciones.OperacionEmpresa;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
        
            OperacionEmpresa operacionEmpresa = new OperacionEmpresa();
            OperacionEmpleado operacionEmpleado = new OperacionEmpleado();
            
            int opcion;

            do {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("=== EMPRESAS ===");
                System.out.println("1. Ingresar empresa");
                System.out.println("2. Mostrar todas las empresas");
                System.out.println("=== EMPLEADOS ===");
                System.out.println("3. Crear empleado");
                System.out.println("4. Mostrar todos los empleados");
                System.out.println("5. Buscar empleado por documento");
                System.out.println("6. Calcular sueldo de empleado");
                System.out.println("7. Contar empleados por empresa");
                System.out.println("8. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1 -> {
                        System.out.println("\n--- INGRESAR EMPRESA ---");
                        System.out.print("Ingrese NIT: ");
                        int nit = sc.nextInt();
                        sc.nextLine(); // limpiar buffer
                        
                        System.out.print("Ingrese Nombre: ");
                        String nombre = sc.nextLine();
                        
                        System.out.print("Ingrese Dirección: ");
                        String direccion = sc.nextLine();
                        
                        System.out.print("Ingrese Ciudad: ");
                        String ciudad = sc.nextLine();
                        
                        Empresa nuevaEmpresa = operacionEmpresa.registrarEmpresa(nit, nombre, direccion, ciudad);
                        if (nuevaEmpresa != null) {
                            System.out.println(" Empresa registrada correctamente.");
                        }
                    }

                    case 2 -> {
                        System.out.println("\n EMPRESAS REGISTRADAS:");
                        if (operacionEmpresa.listarEmpresas().isEmpty()) {
                            System.out.println("No hay empresas registradas.");
                        } else {
                            for (Empresa emp : operacionEmpresa.listarEmpresas()) {
                                System.out.println(emp);
                            }
                        }
                    }

                    case 3 -> {
                        System.out.println("\n--- CREAR EMPLEADO ---");
                        Empleado empleado = new Empleado();
                        empleado.crearEmpleado();
                        
                        Empleado nuevoEmpleado = operacionEmpleado.registrarEmpleado(
                            empleado.getNit(), 
                            empleado.getNombre(), 
                            empleado.getDireccion(), 
                            empleado.getCiudad(),
                            empleado.getDocumento(), 
                            empleado.getNombre(), 
                            empleado.getSueldoHora()
                        );
                        if (nuevoEmpleado != null) {
                            System.out.println("Empleado creado correctamente.");
                        }
                    }

                    case 4 -> {
                        System.out.println("\n EMPLEADOS REGISTRADOS:");
                        if (operacionEmpleado.listarEmpleados().isEmpty()) {
                            System.out.println("No hay empleados registrados.");
                        } else {
                            for (Empleado emp : operacionEmpleado.listarEmpleados()) {
                                System.out.println(emp);
                            }
                        }
                    }

                    case 5 -> {
                        System.out.println("\n--- BUSCAR EMPLEADO POR DOCUMENTO ---");
                        System.out.print("Ingrese documento del empleado: ");
                        int documentoBusqueda = sc.nextInt();
                        sc.nextLine(); // limpiar buffer
                        
                        Empleado empEncontrado = operacionEmpleado.buscarEmpleadoPorDocumento(documentoBusqueda);
                        if (empEncontrado != null) {
                            System.out.println("Empleado encontrado: " + empEncontrado);
                        } else {
                            System.out.println(" No se encontró ningún empleado con ese documento.");
                        }
                    }

                    case 6 -> {
                        System.out.println("\n--- CALCULAR SUELDO DE EMPLEADO ---");
                        System.out.print("Ingrese documento del empleado: ");
                        int documentoSueldo = sc.nextInt();
                        sc.nextLine(); // limpiar buffer
                        
                        System.out.print("Ingrese horas trabajadas: ");
                        int horasTrabajadas = sc.nextInt();
                        sc.nextLine(); // limpiar buffer
                        
                        double sueldo = operacionEmpleado.calcularSueldoEmpleado(documentoSueldo, horasTrabajadas);
                        if (sueldo > 0) {
                            System.out.println(" Sueldo a pagar: $" + sueldo);
                        } else {
                            System.out.println(" No se encontró ningún empleado con ese documento.");
                        }
                    }

                    case 7 -> {
                        System.out.println("\n--- CONTAR EMPLEADOS POR EMPRESA ---");
                        System.out.print("Ingrese NIT de la empresa: ");
                        int nitConteo = sc.nextInt();
                        sc.nextLine(); // limpiar buffer
                        
                        int cantidad = operacionEmpleado.contarEmpleadosPorEmpresa(nitConteo);
                        System.out.println(" Cantidad de empleados en la empresa: " + cantidad);
                    }

                    case 8 -> {
                        System.out.println(" Saliendo del programa...");
                    }

                    default -> {
                        System.out.println(" Opción inválida, intente nuevamente.");
                    }
                }
            } while (opcion != 8);
        }
    }
}
