package pe.edu.matricula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.matricula.entity.Curso;
import pe.edu.matricula.repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    public Curso actualizar(Long id, Curso datosActualizados) {
        Curso curso = buscarPorId(id);

        curso.setCarrera(datosActualizados.getCarrera());
        curso.setCodigo(datosActualizados.getCodigo());
        curso.setNombre(datosActualizados.getNombre());
        curso.setCreditos(datosActualizados.getCreditos());
        curso.setCiclo(datosActualizados.getCiclo());
        curso.setEstado(datosActualizados.getEstado());

        return cursoRepository.save(curso);
    }

    public void eliminar(Long id) {
        Curso curso = buscarPorId(id);
        cursoRepository.delete(curso);
    }
}
