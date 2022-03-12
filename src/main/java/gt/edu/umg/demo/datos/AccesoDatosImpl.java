/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demo.datos;

import gt.edu.umg.demo.dominio.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jeant
 */
public class AccesoDatosImpl implements AccesoDatos{
    private final List<Empleado> listaEmpleados = new ArrayList<>();
    private int contador = 0;
    
    @Override
    public List<Empleado> seleccionar() {
        return listaEmpleados;
    }
    
    @Override
    public void insertar(Empleado empleado) {
        contador++;
        empleado.setCodigo(contador);
        listaEmpleados.add(empleado);
    }

    @Override
    public void editar(Empleado empleado) {
        int codigo;
        try {
            codigo = empleado.getCodigo();
            for (Empleado registro : listaEmpleados) {
                if (Objects.equals(codigo, registro.getCodigo())) {
                    registro.setNombre(empleado.getNombre());
                    registro.setEnero(empleado.getEnero());
                    registro.setFebrero(empleado.getFebrero());
                    registro.setMarzo(empleado.getMarzo());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminar(Empleado empleado) {
        int codigo;
        try {
            codigo = empleado.getCodigo();
            for (Empleado registro : listaEmpleados) {
                if (Objects.equals(codigo, registro.getCodigo())) {
                    listaEmpleados.remove(listaEmpleados.indexOf(registro));
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}
