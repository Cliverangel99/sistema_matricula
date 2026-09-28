package pe.edu.matricula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.matricula.entity.Periodo;
import pe.edu.matricula.repository.PeriodoRepository;

@Service
public class PeriodoService {

    private final PeriodoRepository periodoRepository;

    public PeriodoService(PeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }

    public List<Periodo> listarTodos() {
        return periodoRepository.findAll();
    }

    public Periodo guardar(Periodo periodo) {
        return periodoRepository.save(periodo);
    }

    public Periodo buscarPorId(Long id) {
        return periodoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Periodo no encontrado"));
    }

    public Periodo actualizar(Long id, Periodo datosActualizados) {
        Periodo periodo = buscarPorId(id);

        periodo.setNombre(datosActualizados.getNombre());
        periodo.setFechaInicio(datosActualizados.getFechaInicio());
        periodo.setFechaFin(datosActualizados.getFechaFin());
        periodo.setEstado(datosActualizados.getEstado());

        return periodoRepository.save(periodo);
    }

    public void eliminar(Long id) {
        Periodo periodo = buscarPorId(id);
        periodoRepository.delete(periodo);
    }
}
