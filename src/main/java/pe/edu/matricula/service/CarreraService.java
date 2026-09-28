package pe.edu.matricula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.matricula.entity.Carrera;
import pe.edu.matricula.repository.CarreraRepository;

@Service
public class CarreraService {

    private final CarreraRepository carreraRepository;

    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public List<Carrera> listarTodos() {
        return carreraRepository.findAll();
    }

    public Carrera guardar(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public Carrera buscarPorId(Long id) {
        return carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
    }

    public Carrera actualizar(Long id, Carrera datosActualizados) {
        Carrera carrera = buscarPorId(id);

        carrera.setFacultad(datosActualizados.getFacultad());
        carrera.setNombre(datosActualizados.getNombre());
        carrera.setDuracionCiclos(datosActualizados.getDuracionCiclos());
        carrera.setEstado(datosActualizados.getEstado());

        return carreraRepository.save(carrera);
    }

    public void eliminar(Long id) {
        Carrera carrera = buscarPorId(id);
        carreraRepository.delete(carrera);
    }
}
