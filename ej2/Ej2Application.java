package com.example.ej2;

import com.example.ej2.entidades.PersonaEj2;
import com.example.ej2.repositorios.RepositorioPersonaEj2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ej2Application {

    @Autowired
    RepositorioPersonaEj2 rPersona;

    public static void main(String[] args) {
        SpringApplication.run(Ej2Application.class, args);
    }

    @Bean
    CommandLineRunner init(RepositorioPersonaEj2 rPersona) {
        return args -> {
            System.out.println("-----------------ESTOY FUNCIONANDO---------");
            PersonaEj2 personaEj2 = new PersonaEj2();
            personaEj2.setNombre("Juan");
            personaEj2.setApellido("Pérez");
            personaEj2.setEdad(30);

            // Guardar el objeto Persona en la base de datos
            rPersona.save(personaEj2);

            // Recuperar el objeto Persona desde la base de datos
            PersonaEj2 personaEj2Recuperada = rPersona.findById(personaEj2.getId()).orElse(null);
            if (personaEj2Recuperada != null) {
                System.out.println("Nombre: " + personaEj2Recuperada.getNombre());
                System.out.println("Apellido: " + personaEj2Recuperada.getApellido());
                System.out.println("Edad: " + personaEj2Recuperada.getEdad());
                System.out.println("Domicilio: " + personaEj2Recuperada.getDomicilio());
                System.out.println("Auto: "+ personaEj2Recuperada.getAuto());
            }
        };
    }
}
