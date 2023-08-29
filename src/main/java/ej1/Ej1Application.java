package ej1;

import com.example.ej2.Ej2Application;
import com.example.ej2.entidades.Persona;
import com.example.ej2.repositorios.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ej1Application {

    @Autowired
    RepositorioPersona rPersona;

    public static void main(String[] args) {
        SpringApplication.run(com.example.ej2.Ej2Application.class, args);
    }
    @Bean
    CommandLineRunner init(RepositorioPersona rPersona) {
        return args -> {
            System.out.println("-----------------ESTOY FUNCIONANDO---------");
            Persona persona = new Persona();
            persona.setNombre("Juan");
            persona.setApellido("Pérez");
            persona.setEdad(30);

            // Guardar el objeto Persona en la base de datos
            rPersona.save(persona);

            // Recuperar el objeto Persona desde la base de datos
            Persona personaRecuperada = rPersona.findById(persona.getId()).orElse(null);
            if (personaRecuperada != null) {
                System.out.println("Nombre: " + personaRecuperada.getNombre());
                System.out.println("Apellido: " + personaRecuperada.getApellido());
                System.out.println("Edad: " + personaRecuperada.getEdad());
            }
        };
    }
}

