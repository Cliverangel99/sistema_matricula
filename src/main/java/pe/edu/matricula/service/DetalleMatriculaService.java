package pe.edu.matricula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.matricula.entity.DetalleMatricula;
import pe.edu.matricula.repository.DetalleMatriculaRepository;

@Service
public class DetalleMatriculaService {

    private final DetalleMatriculaRepository detalleMatriculaRepository;

    public DetalleMatriculaService(DetalleMatriculaRepository detalleMatriculaRepository) {
        this.detalleMatriculaRepository = detalleMatriculaRepository;
    }

    public List<DetalleMatricula> listarTodos() {
        return detalleMatriculaRepository.findAll();
    }

    public DetalleMatricula guardar(DetalleMatricula detalleMatricula) {
        return detalleMatriculaRepository.save(detalleMatricula);
    }

    public DetalleMatricula buscarPorId(Long id) {
        return detalleMatriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de matricula no encontrado"));
    }

    public DetalleMatricula actualizar(Long id, DetalleMatricula datosActualizados) {
        DetalleMatricula detalleMatricula = buscarPorId(id);

        detalleMatricula.setMatricula(datosActualizados.getMatricula());
        detalleMatricula.setSeccion(datosActualizados.getSeccion());
        detalleMatricula.setNotaFinal(datosActualizados.getNotaFinal());
        detalleMatricula.setEstado(datosActualizados.getEstado());

        return detalleMatriculaRepository.save(detalleMatricula);
    }

    public void eliminar(Long id) {
        DetalleMatricula detalleMatricula = buscarPorId(id);
        detalleMatriculaRepository.delete(detalleMatricula);
    }
}
