package pe.edu.matricula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.matricula.entity.CursoPrerrequisito;
import pe.edu.matricula.repository.CursoPrerrequisitoRepository;

@Service
public class CursoPrerrequisitoService {

    private final CursoPrerrequisitoRepository cursoPrerrequisitoRepository;

    public CursoPrerrequisitoService(CursoPrerrequisitoRepository cursoPrerrequisitoRepository) {
        this.cursoPrerrequisitoRepository = cursoPrerrequisitoRepository;
    }

    public List<CursoPrerrequisito> listarTodos() {
        return cursoPrerrequisitoRepository.findAll();
    }

    public CursoPrerrequisito guardar(CursoPrerrequisito cursoPrerrequisito) {
        return cursoPrerrequisitoRepository.save(cursoPrerrequisito);
    }

    public CursoPrerrequisito buscarPorId(Long id) {
        return cursoPrerrequisitoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prerrequisito de curso no encontrado"));
    }

    public CursoPrerrequisito actualizar(Long id, CursoPrerrequisito datosActualizados) {
        CursoPrerrequisito cursoPrerrequisito = buscarPorId(id);

        cursoPrerrequisito.setCurso(datosActualizados.getCurso());
        cursoPrerrequisito.setPrerrequisito(datosActualizados.getPrerrequisito());

        return cursoPrerrequisitoRepository.save(cursoPrerrequisito);
    }

    public void eliminar(Long id) {
        CursoPrerrequisito cursoPrerrequisito = buscarPorId(id);
        cursoPrerrequisitoRepository.delete(cursoPrerrequisito);
    }
}
