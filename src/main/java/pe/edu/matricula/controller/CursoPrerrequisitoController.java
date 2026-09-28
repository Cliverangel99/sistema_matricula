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

import pe.edu.matricula.entity.CursoPrerrequisito;
import pe.edu.matricula.service.CursoPrerrequisitoService;

@RestController
@RequestMapping("/api/curso-prerrequisitos")
public class CursoPrerrequisitoController {

    private final CursoPrerrequisitoService cursoPrerrequisitoService;

    public CursoPrerrequisitoController(CursoPrerrequisitoService cursoPrerrequisitoService) {
        this.cursoPrerrequisitoService = cursoPrerrequisitoService;
    }

    @GetMapping
    public List<CursoPrerrequisito> listarTodos() {
        return cursoPrerrequisitoService.listarTodos();
    }

    @GetMapping("/{id}")
    public CursoPrerrequisito buscarPorId(@PathVariable Long id) {
        return cursoPrerrequisitoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<CursoPrerrequisito> guardar(
            @RequestBody CursoPrerrequisito cursoPrerrequisito) {

        CursoPrerrequisito cursoPrerrequisitoGuardado = cursoPrerrequisitoService.guardar(cursoPrerrequisito);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cursoPrerrequisitoGuardado);
    }

    @PutMapping("/{id}")
    public CursoPrerrequisito actualizar(
            @PathVariable Long id,
            @RequestBody CursoPrerrequisito cursoPrerrequisito) {

        return cursoPrerrequisitoService.actualizar(id, cursoPrerrequisito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoPrerrequisitoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
