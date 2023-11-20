
package com.Ejercicio1.Dao;

import com.Ejercicio1.domain.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantesDao extends JpaRepository<Estudiantes, Integer> {
    
}
