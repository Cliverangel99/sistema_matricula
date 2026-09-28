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

import pe.edu.matricula.entity.Seccion;
import pe.edu.matricula.service.SeccionService;

@RestController
@RequestMapping("/api/secciones")
public class SeccionController {

    private final SeccionService seccionService;

    public SeccionController(SeccionService seccionService) {
        this.seccionService = seccionService;
    }

    @GetMapping
    public List<Seccion> listarTodos() {
        return seccionService.listarTodos();
    }

    @GetMapping("/{id}")
    public Seccion buscarPorId(@PathVariable Long id) {
        return seccionService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Seccion> guardar(
            @RequestBody Seccion seccion) {

        Seccion seccionGuardado = seccionService.guardar(seccion);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(seccionGuardado);
    }

    @PutMapping("/{id}")
    public Seccion actualizar(
            @PathVariable Long id,
            @RequestBody Seccion seccion) {

        return seccionService.actualizar(id, seccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        seccionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
