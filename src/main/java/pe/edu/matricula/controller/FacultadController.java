package pe.edu.matricula.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.matricula.entity.Facultad;
import pe.edu.matricula.service.FacultadService;

@RestController
@RequestMapping("/api/facultades")
public class FacultadController {

    private final FacultadService facultadService;

    public FacultadController(FacultadService facultadService) {
        this.facultadService = facultadService;
    }

    @GetMapping
    public List<Facultad> listarTodos() {
        return facultadService.listarTodos();
    }

    @GetMapping("/{id}")
    public Facultad buscarPorId(@PathVariable Long id) {
        return facultadService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Facultad> guardar(
            @RequestBody Facultad facultad) {

        Facultad facultadGuardado = facultadService.guardar(facultad);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(facultadGuardado);
    }

    @PutMapping("/{id}")
    public Facultad actualizar(
            @PathVariable Long id,
            @RequestBody Facultad facultad) {

        return facultadService.actualizar(id, facultad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        facultadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
