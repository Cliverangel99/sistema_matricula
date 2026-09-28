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

import pe.edu.matricula.entity.Matricula;
import pe.edu.matricula.service.MatriculaService;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public List<Matricula> listarTodos() {
        return matriculaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Matricula buscarPorId(@PathVariable Long id) {
        return matriculaService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Matricula> guardar(
            @RequestBody Matricula matricula) {

        Matricula matriculaGuardado = matriculaService.guardar(matricula);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(matriculaGuardado);
    }

    @PutMapping("/{id}")
    public Matricula actualizar(
            @PathVariable Long id,
            @RequestBody Matricula matricula) {

        return matriculaService.actualizar(id, matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        matriculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
