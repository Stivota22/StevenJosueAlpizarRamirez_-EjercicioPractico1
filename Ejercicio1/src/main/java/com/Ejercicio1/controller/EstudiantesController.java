
package com.Ejercicio1.controller;

import com.Ejercicio1.domain.Estudiantes;
import com.Ejercicio1.service.EstudiantesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class EstudiantesController {
    @Controller
    @RequestMapping("/estudiante")
    public class EstudianteController {

        @Autowired
        private EstudiantesService estudiantesService;

        @GetMapping("/listado")
        public String inicio(Model model) {
            List<Estudiantes> estudiante = estudiantesService.getEstudiantes();
            model.addAttribute("Estudiantes", estudiante);
            model.addAttribute("totalEstudiantes", estudiante.size());
            return "/estudiantes/listado";
        }

        @GetMapping("/nuevo")
        public String estudiantesNuevo(Estudiantes estudiantes) {
            return "/estudiantes/modifica";
        }
        //@Autowired
        //private FirebaseStorageServiceImpl firebaseStorageService;

        @PostMapping("/guardar")
        public String estudiantesGuardar(Estudiantes estudiantes) {

            estudiantesService.save(estudiantes);
            return "redirect:/estudiante/listado";
        }

        @GetMapping("/eliminar/{id}")
        public String estudianteEliminar(Estudiantes estudiantes) {
            estudiantesService.delete(estudiantes);
            return "redirect:/estudiante/listado";
        }

        @GetMapping("/modificar/{id}")
        public String categoriaModificar(Estudiantes estudiantes, Model model) {
            estudiantes = estudiantesService.getEstudiantes(estudiantes);
            model.addAttribute("estudiantes", estudiantes);
            return "/estudiantes/modifica";
        }
    }
}
