package pe.edu.matricula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.matricula.entity.Facultad;
import pe.edu.matricula.repository.FacultadRepository;

@Service
public class FacultadService {

    private final FacultadRepository facultadRepository;

    public FacultadService(FacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    public List<Facultad> listarTodos() {
        return facultadRepository.findAll();
    }

    public Facultad guardar(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    public Facultad buscarPorId(Long id) {
        return facultadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facultad no encontrada"));
    }

    public Facultad actualizar(Long id, Facultad datosActualizados) {
        Facultad facultad = buscarPorId(id);

        facultad.setNombre(datosActualizados.getNombre());
        facultad.setDescripcion(datosActualizados.getDescripcion());

        return facultadRepository.save(facultad);
    }

    public void eliminar(Long id) {
        Facultad facultad = buscarPorId(id);
        facultadRepository.delete(facultad);
    }
}
