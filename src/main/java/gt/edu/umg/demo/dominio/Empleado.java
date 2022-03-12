/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demo.dominio;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author jeant
 */

@Data
public class Empleado {
    
    private int codigo;
    
    @NotBlank
    private String nombre;
    
    @NotNull
    private Double enero;
    
    @NotNull
    private Double febrero;
    
    @NotNull
    private Double marzo;
    
    private Double total;
    private Double promedio;
}