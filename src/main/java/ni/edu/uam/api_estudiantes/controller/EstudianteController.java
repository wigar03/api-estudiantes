package ni.edu.uam.api_estudiantes.controller;

import ni.edu.uam.api_estudiantes.model.Estudiante;
import ni.edu.uam.api_estudiantes.repository.EstudianteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteRepository estudianteRepository;

    public EstudianteController(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    /**
     *
     *
     *
     * **/

    @GetMapping
    public List<Estudiante> listar(){
        return estudianteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante estudiante){
        estudiante.setId(null);
        Estudiante nuevoEst = estudianteRepository.save(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEst);
    }

}
