/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demo.datos;

import gt.edu.umg.demo.dominio.Empleado;
import java.util.List;

/**
 *
 * @author jeant
 */
public interface AccesoDatos {
    public List<Empleado> seleccionar();
    public void insertar(Empleado empleado);
    public void editar(Empleado empleado);
    public void eliminar(Empleado empleado);
}
