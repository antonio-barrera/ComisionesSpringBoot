/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demo.controladores;

import static gt.edu.umg.demo.ComisionesSpringBoot.empleados;
import gt.edu.umg.demo.dominio.Empleado;
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
public class ControladorAgregar {

    @PostMapping("/agregarRegistro")
    public String agregar(@ModelAttribute @Valid Empleado empleado, BindingResult result, Model model) {
        String msg = null;
        boolean agregar;
        if (result.hasErrors()) {
            msg = "Todos los campos deben estar llenos en el formato correcto.";
        } else {
            agregar = empleados.agregarEmpleado(empleado);
            if (agregar) {
                msg = "Registro agregado con éxito.";
            } else {
                msg = "Algo ha salido mal con el registro";
            }
        }
        model.addAttribute("msg", msg);
        return "agregar";
    }
}