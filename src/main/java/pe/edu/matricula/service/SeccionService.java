package pe.edu.matricula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.matricula.entity.Seccion;
import pe.edu.matricula.repository.SeccionRepository;

@Service
public class SeccionService {

    private final SeccionRepository seccionRepository;

    public SeccionService(SeccionRepository seccionRepository) {
        this.seccionRepository = seccionRepository;
    }

    public List<Seccion> listarTodos() {
        return seccionRepository.findAll();
    }

    public Seccion guardar(Seccion seccion) {
        return seccionRepository.save(seccion);
    }

    public Seccion buscarPorId(Long id) {
        return seccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seccion no encontrada"));
    }

    public Seccion actualizar(Long id, Seccion datosActualizados) {
        Seccion seccion = buscarPorId(id);

        seccion.setCurso(datosActualizados.getCurso());
        seccion.setPeriodo(datosActualizados.getPeriodo());
        seccion.setDocente(datosActualizados.getDocente());
        seccion.setCodigo(datosActualizados.getCodigo());
        seccion.setVacantes(datosActualizados.getVacantes());
        seccion.setHorario(datosActualizados.getHorario());
        seccion.setAula(datosActualizados.getAula());
        seccion.setEstado(datosActualizados.getEstado());

        return seccionRepository.save(seccion);
    }

    public void eliminar(Long id) {
        Seccion seccion = buscarPorId(id);
        seccionRepository.delete(seccion);
    }
}
