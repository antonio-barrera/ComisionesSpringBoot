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
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author jeant
 */

@Controller
public class ControladorInicio {
    @GetMapping("/")
    public String inicio() {
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar() {
        return "agregar";
    }
    
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("empleados", empleados.listarEmpleados());
        return "listar";
    }
    
    @GetMapping("/editar")
    public String editar(Model model) {
        model.addAttribute("empleados", empleados.listarEmpleados());
        return "editar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Model model) {
        model.addAttribute("empleados", empleados.listarEmpleados());
        return "eliminar";
    }
    
    @GetMapping("/mayor-vendedor")
    public String mayorVendedor(Model model) {
        String msg = empleados.mayorVendedor();
        if (Objects.equals(msg, null)) {
            msg = "No hay registros.";
        }
        model.addAttribute("msg", msg);
        return "mayor-vendedor";
    }
    
    @GetMapping("/buscar")
    public String buscar() {
        return "buscar";
    }
}