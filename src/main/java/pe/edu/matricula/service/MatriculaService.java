package pe.edu.matricula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.matricula.entity.Matricula;
import pe.edu.matricula.repository.MatriculaRepository;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public List<Matricula> listarTodos() {
        return matriculaRepository.findAll();
    }

    public Matricula guardar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public Matricula buscarPorId(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula no encontrada"));
    }

    public Matricula actualizar(Long id, Matricula datosActualizados) {
        Matricula matricula = buscarPorId(id);

        matricula.setUsuario(datosActualizados.getUsuario());
        matricula.setPeriodo(datosActualizados.getPeriodo());
        matricula.setFechaMatricula(datosActualizados.getFechaMatricula());
        matricula.setEstado(datosActualizados.getEstado());

        return matriculaRepository.save(matricula);
    }

    public void eliminar(Long id) {
        Matricula matricula = buscarPorId(id);
        matriculaRepository.delete(matricula);
    }
}
