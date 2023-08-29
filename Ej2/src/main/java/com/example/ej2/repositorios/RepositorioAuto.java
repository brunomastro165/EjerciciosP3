package com.example.ej2.repositorios;

import com.example.ej2.entidades.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAuto extends JpaRepository<Auto, Long> {
}
