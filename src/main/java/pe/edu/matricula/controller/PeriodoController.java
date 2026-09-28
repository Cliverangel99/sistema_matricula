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

import pe.edu.matricula.entity.Periodo;
import pe.edu.matricula.service.PeriodoService;

@RestController
@RequestMapping("/api/periodos")
public class PeriodoController {

    private final PeriodoService periodoService;

    public PeriodoController(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @GetMapping
    public List<Periodo> listarTodos() {
        return periodoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Periodo buscarPorId(@PathVariable Long id) {
        return periodoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Periodo> guardar(
            @RequestBody Periodo periodo) {

        Periodo periodoGuardado = periodoService.guardar(periodo);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(periodoGuardado);
    }

    @PutMapping("/{id}")
    public Periodo actualizar(
            @PathVariable Long id,
            @RequestBody Periodo periodo) {

        return periodoService.actualizar(id, periodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        periodoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
