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

import pe.edu.matricula.entity.DetalleMatricula;
import pe.edu.matricula.service.DetalleMatriculaService;

@RestController
@RequestMapping("/api/detalles-matricula")
public class DetalleMatriculaController {

    private final DetalleMatriculaService detalleMatriculaService;

    public DetalleMatriculaController(DetalleMatriculaService detalleMatriculaService) {
        this.detalleMatriculaService = detalleMatriculaService;
    }

    @GetMapping
    public List<DetalleMatricula> listarTodos() {
        return detalleMatriculaService.listarTodos();
    }

    @GetMapping("/{id}")
    public DetalleMatricula buscarPorId(@PathVariable Long id) {
        return detalleMatriculaService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<DetalleMatricula> guardar(
            @RequestBody DetalleMatricula detalleMatricula) {

        DetalleMatricula detalleMatriculaGuardado = detalleMatriculaService.guardar(detalleMatricula);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(detalleMatriculaGuardado);
    }

    @PutMapping("/{id}")
    public DetalleMatricula actualizar(
            @PathVariable Long id,
            @RequestBody DetalleMatricula detalleMatricula) {

        return detalleMatriculaService.actualizar(id, detalleMatricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleMatriculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
