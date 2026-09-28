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

import pe.edu.matricula.entity.Carrera;
import pe.edu.matricula.service.CarreraService;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping
    public List<Carrera> listarTodos() {
        return carreraService.listarTodos();
    }

    @GetMapping("/{id}")
    public Carrera buscarPorId(@PathVariable Long id) {
        return carreraService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Carrera> guardar(
            @RequestBody Carrera carrera) {

        Carrera carreraGuardado = carreraService.guardar(carrera);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carreraGuardado);
    }

    @PutMapping("/{id}")
    public Carrera actualizar(
            @PathVariable Long id,
            @RequestBody Carrera carrera) {

        return carreraService.actualizar(id, carrera);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        carreraService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
