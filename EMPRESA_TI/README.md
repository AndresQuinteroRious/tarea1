### Elaborado por

## Andres Mauricio Quintero Rios

## Oscar Rene Peñaloza Ardila

# EMPRESA_TI — Documentación de la aplicación

Esta es una aplicación de consola en Java para gestionar empresas y empleados de forma simple. Permite:

- Registrar empresas.
- Crear empleados asociados a una empresa.
- Listar empresas y empleados.
- Buscar empleados por documento.
- Calcular sueldo de un empleado según horas trabajadas.
- Contar cuántos empleados tiene una empresa (por NIT).

## Estructura del proyecto

Raíz del módulo: `EMPRESA_TI/`

- `src/` : código fuente Java.
  - `App.java` : clase principal con el menú de consola e interacción con el usuario.
  - `modelos/` : clases de dominio
    - `Empresa.java` : entidad empresa (nit, nombre, dirección, ciudad).
    - `Empleado.java` : extiende `Empresa` y añade documento, nombre del empleado y sueldo por hora.
  - `operaciones/` : lógica de negocio en memoria
    - `OperacionEmpresa.java` : registra y lista empresas.
    - `OperacionEmpleado.java` : registra, lista, busca empleados, calcula sueldo y cuenta empleados por empresa.

## Clases y métodos clave

- App
  - `main(String[] args)`: muestra un menú interactivo con las opciones enumeradas abajo.

- Empresa
  - `ingresarEmpresa()` : método auxiliar para leer datos por consola (no usado por la clase `OperacionEmpresa`).
  - getters/setters y `toString()`.

- Empleado
  - `crearEmpleado()` : lee desde consola los datos del empleado y la empresa asociada.
  - getters/setters y `toString()`.

- OperacionEmpresa
  - `registrarEmpresa(int nit, String nombre, String direccion, String ciudad)` : registra empresa si el NIT no existe.
  - `listarEmpresas()` : devuelve lista inmodificable de empresas en memoria.

- OperacionEmpleado
  - `registrarEmpleado(int nit, String nombreEmpresa, String direccion, String ciudad, int documento, String nombreEmpleado, double sueldoHora)` : registra empleado si el documento no existe.
  - `listarEmpleados()` : devuelve lista inmodificable de empleados en memoria.
  - `buscarEmpleadoPorDocumento(int documento)` : busca y devuelve un `Empleado` o `null`.
  - `calcularSueldoEmpleado(int documento, int horasTrabajadas)` : devuelve sueldo calculado o 0 si no existe.
  - `contarEmpleadosPorEmpresa(int nitEmpresa)` : cuenta empleados por NIT.

## Flujo de ejecución (menú)

Al ejecutar `App`, se presenta el siguiente menú:

1. Ingresar empresa — solicita NIT, nombre, dirección y ciudad y registra la empresa.
2. Mostrar todas las empresas — imprime las empresas registradas.
3. Crear empleado — solicita datos de empresa y empleado y registra un empleado.
4. Mostrar todos los empleados — imprime empleados registrados.
5. Buscar empleado por documento — ingresa documento y muestra el empleado si existe.
6. Calcular sueldo de empleado — ingresa documento y horas trabajadas; muestra el monto a pagar.
7. Contar empleados por empresa — ingresa NIT y muestra la cantidad de empleados asociados.
8. Salir.

## Cómo compilar y ejecutar (Windows, cmd.exe)

Abre una terminal (cmd.exe) y sitúate en la carpeta del proyecto `EMPRESA_TI`.

1) Compilar:

```bat
cd /d "d:\IU Digital\poo2\Tarea1\tarea1\EMPRESA_TI"
javac -d bin src\App.java src\modelos\*.java src\operaciones\*.java
```

2) Ejecutar:

```bat
cd /d "d:\IU Digital\poo2\Tarea1\tarea1\EMPRESA_TI"
java -cp bin App
```

Notas:
- `-d bin` indica que las clases compiladas se colocarán en la carpeta `bin`.
- Si usas un IDE (VS Code, IntelliJ, Eclipse), importa el proyecto como proyecto Java y usa las herramientas del IDE para compilar/ejecutar.

## Ejemplo de uso rápido

1. Ejecuta la aplicación.
2. Selecciona 1 y registra una empresa con NIT 12345.
3. Selecciona 3 y crea un empleado asociado al NIT 12345 (documento 555, sueldo/hora 10.0).
4. Selecciona 6, ingresa documento 555 y horas trabajadas 40. Deberías ver sueldo $400.0.

## Casos borde y consideraciones

- Las listas de empresas y empleados se mantienen en memoria (ArrayList). Los datos se pierden al terminar el programa.
- `OperacionEmpresa.registrarEmpresa` y `OperacionEmpleado.registrarEmpleado` hacen comprobaciones básicas (NIT/documento duplicado) y devuelven `null` si ya existe.
- `calcularSueldoEmpleado` devuelve `0` si el empleado no existe. Podrías preferir una excepción o un valor negativo para distinguir error vs sueldo 0.
- `Empleado.crearEmpleado()` y `Empresa.ingresarEmpresa()` cierran el `Scanner` que usan; cuidado: cerrar `System.in` puede afectar lecturas posteriores si se reutiliza el mismo flujo.

## queda a disposición para ser mejorado a futuro 
## muchas gracias

