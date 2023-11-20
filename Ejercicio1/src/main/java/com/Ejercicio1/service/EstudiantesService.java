
package com.Ejercicio1.service;

import com.Ejercicio1.domain.Estudiantes;
import java.util.List;

public interface EstudiantesService {

    public void save(Estudiantes estudiantes);

    public void delete(Estudiantes estudiantes);

    public Estudiantes getEstudiantes(Estudiantes estudiantes);
    
     public List <Estudiantes> getEstudiantes();
}
