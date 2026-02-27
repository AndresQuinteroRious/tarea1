package operaciones;

import java.util.List;
import modelos.Empresa;

public interface IOperacionEmpresa {
    Empresa registrarEmpresa(int nit, String nombre, String direccion, String ciudad);
    List<Empresa> listarEmpresas();
}
