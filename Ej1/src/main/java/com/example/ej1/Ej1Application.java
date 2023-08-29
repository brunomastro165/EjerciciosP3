package com.example.ej1;

import com.example.ej1.entidades.Persona;
import com.example.ej1.repositorios.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ej1Application {

    @Autowired
    RepositorioPersona respositorioPersona;

    public static void main(String[] args) {


        SpringApplication.run(Ej1Application.class, args);
        System.out.println("Funciona");
    }

    @Bean
    CommandLineRunner init(RepositorioPersona repositorioPersona) {
        return args -> {
            System.out.println("-----------------ESTOY FUNCIONANDO---------");
            Persona persona = new Persona();
            persona.setNombre("Juan");
            persona.setApellido("Pérez");
            persona.setEdad(30);

            // Guardar el objeto Persona en la base de datos
            repositorioPersona.save(persona);

            // Recuperar el objeto Persona desde la base de datos
            Persona personaRecuperada = repositorioPersona.findById(persona.getId()).orElse(null);
            if (personaRecuperada != null) {
                System.out.println("Nombre: " + personaRecuperada.getNombre());
                System.out.println("Apellido: " + personaRecuperada.getApellido());
                System.out.println("Edad: " + personaRecuperada.getEdad());
            }
        };
    }
}
