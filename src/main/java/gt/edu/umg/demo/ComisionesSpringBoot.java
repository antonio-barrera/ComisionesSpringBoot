package gt.edu.umg.demo;

import gt.edu.umg.demo.negocio.NominaEmpleados;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComisionesSpringBoot {

    public static NominaEmpleados empleados = null;
    
    public static void main(String[] args) {
        empleados = new NominaEmpleados();
        SpringApplication.run(ComisionesSpringBoot.class, args);
    }

}
