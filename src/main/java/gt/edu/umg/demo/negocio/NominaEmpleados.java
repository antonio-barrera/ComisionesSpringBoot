/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demo.negocio;

import gt.edu.umg.demo.dominio.Empleado;
import gt.edu.umg.demo.datos.AccesoDatos;
import gt.edu.umg.demo.datos.AccesoDatosImpl;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jeant
 */
public class NominaEmpleados {

    private AccesoDatos datos = null;

    public NominaEmpleados() {
        datos = new AccesoDatosImpl();
    }

    private Empleado calcularEmpleado(Empleado empleado) {
        Double total;
        Double promedio;
        try {
            total = empleado.getEnero() + empleado.getFebrero() + empleado.getMarzo();
            promedio = Math.round((total / 3) * 100.0) / 100.0;
            empleado.setTotal(total);
            empleado.setPromedio(promedio);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return empleado;
    }
    
    public boolean isNumeric(String number) {
        boolean resultado;
        try {
            Integer.valueOf(number);
            resultado =  true;
        } catch (NumberFormatException ex) {
            resultado = false;
        }
        return resultado;
    }

    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = null;
        try {
            empleados = datos.seleccionar();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return empleados;
    }

    public boolean agregarEmpleado(Empleado empleado) {
        boolean result = false;
        try {
            empleado = calcularEmpleado(empleado);
            datos.insertar(empleado);
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return result;
    }

    public boolean editarEmpleado(Empleado empleado) {
        boolean result = false;
        List<Empleado> empleados = null;
        try {
            empleados = datos.seleccionar();
            for (Empleado registro : empleados) {
                if (empleado.getCodigo() == registro.getCodigo()) {
                    empleado = calcularEmpleado(empleado);
                    datos.editar(empleado);
                    result = true;
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return result;
    }

    public boolean eliminarEmpleado(int codigo) {
        boolean result = false;
        Empleado empleado = null;
        List<Empleado> empleados = null;
        try {
            empleados = datos.seleccionar();
            for (Empleado registro : empleados) {
                if (codigo == registro.getCodigo()) {
                    empleado = new Empleado();
                    empleado.setCodigo(codigo);
                    datos.eliminar(empleado);
                    result = true;
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return result;
    }

    public String mayorVendedor() {
        String nombre = null;
        String resultado = null;
        Double cantidad = 0.0;
        List<Empleado> empleados;
        try {
            empleados = datos.seleccionar();
            if (empleados.isEmpty()) {
                return null;
            } else {
                for (Empleado empleado : empleados) {
                    if (empleado.getTotal() > cantidad) {
                        cantidad = empleado.getTotal();
                        nombre = empleado.getNombre();
                    }
                }
                resultado = "El mayor vendedor es " + nombre + " con un total de " + cantidad;
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return resultado;
    }

    public String buscarCantidad(Double cantidad) {
        String resultado = null;
        List<Empleado> empleados;
        try {
            empleados = datos.seleccionar();
            for (Empleado empleado : empleados) {
                if (Objects.equals(empleado.getEnero(), cantidad)) {
                    resultado = "La cantidad fue vendida por " + empleado.getNombre() + " en el mes de enero";
                    break;
                } else if (Objects.equals(empleado.getFebrero(), cantidad)) {
                    resultado = "La cantidad fue vendida por " + empleado.getNombre() + " en el mes de febrero";
                    break;
                } else if (Objects.equals(empleado.getMarzo(), cantidad)) {
                    resultado = "La cantidad fue vendida por " + empleado.getNombre() + " en el mes de marzo";
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return resultado;
    }
}
