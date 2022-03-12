/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demo.controladores;

import static gt.edu.umg.demo.ComisionesSpringBoot.empleados;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jeant
 */

@Controller
public class ControladorEliminar {
    
    @PostMapping("/eliminarRegistro")
    public String eliminar(Model model, @RequestParam("codigo") String codigo) {
        String msg = null;
        boolean eliminar = false;
        if (!empleados.isNumeric(codigo)) {
            msg = "Debe ingresar un entero positivo";
        } else {
            eliminar = empleados.eliminarEmpleado(Integer.valueOf(codigo));
            if (eliminar) {
                msg = msg = "El registro se ha eliminado con exito";
            } else {
                msg = "Debe ingresar un codigo existente";
            }
        }
        model.addAttribute("empleados", empleados.listarEmpleados());
        model.addAttribute("msg", msg);
        return "eliminar";
    }
}
