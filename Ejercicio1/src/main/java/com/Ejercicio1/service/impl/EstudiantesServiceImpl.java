package com.Ejercicio1.service.impl;

import com.Ejercicio1.Dao.EstudiantesDao;
import com.Ejercicio1.domain.Estudiantes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudiantesServiceImpl {
    @Autowired
    private EstudiantesDao estudiantesDao;
    
    @Transactional(readOnly=true)
    public List<Estudiantes> getEstudiantes() {
        return estudiantesDao.findAll();
    }
    @Transactional(readOnly = true)
    public Estudiantes getEstudiantes(Estudiantes estudiantes) {
        return estudiantesDao.findById(estudiantes.getId()).orElse(null);
    }

    @Transactional
    public void save(Estudiantes estudiantes) {
        estudiantesDao.save(estudiantes);
    }

    @Transactional
    public void delete(Estudiantes estudiantes) {
        estudiantesDao.delete(estudiantes);
    }
}
