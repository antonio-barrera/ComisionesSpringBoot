/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demo.controladores;

import gt.edu.umg.demo.dominio.Empleado;
import static gt.edu.umg.demo.ComisionesSpringBoot.empleados;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jeant
 */

@Controller
public class ControladorEditar {
    
    @PostMapping("/editarRegistro")
    public String editar(@ModelAttribute @Valid Empleado empleado, BindingResult result, Model model) {
        String msg = null;
        boolean editar;
        if (result.hasErrors()) {
            msg = "Todos los campos deben estar llenos en el formato correcto.";
        } else {
            editar = empleados.editarEmpleado(empleado);
            if (editar) {
                msg = "El registro se ha editado con exito.";
            } else {
                msg = "Debe ingresar un codigo existente";
            }
        }
        model.addAttribute("empleados", empleados.listarEmpleados());
        model.addAttribute("msg", msg);
        return "editar";
    }
}
