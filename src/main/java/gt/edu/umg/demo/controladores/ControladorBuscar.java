/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demo.controladores;

import static gt.edu.umg.demo.ComisionesSpringBoot.empleados;
import java.util.Objects;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jeant
 */

@Controller
public class ControladorBuscar {
    
    @PostMapping("/buscarRegistro")
    public String buscar(Model model, @RequestParam("cantidad") String cantidad) {
        String resultado = null;
        if (!empleados.isNumeric(cantidad)) {
            resultado = "Debe ingresar una cantidad valida";
        } else {
            resultado = empleados.buscarCantidad(Double.valueOf(cantidad));
            if (Objects.equals(resultado, null)) {
                resultado = "La cantidad no ha sido encontrada";
            } 
        }
        model.addAttribute("empleados", empleados.listarEmpleados());
        model.addAttribute("resultado", resultado);
        return "buscar";
    }
}
