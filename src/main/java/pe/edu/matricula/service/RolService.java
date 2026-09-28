package pe.edu.matricula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.matricula.entity.Rol;
import pe.edu.matricula.repository.RolRepository;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> listarTodos() {
        return rolRepository.findAll();
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol buscarPorId(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    public Rol actualizar(Long id, Rol datosActualizados) {
        Rol rol = buscarPorId(id);

        rol.setNombre(datosActualizados.getNombre());

        return rolRepository.save(rol);
    }

    public void eliminar(Long id) {
        Rol rol = buscarPorId(id);
        rolRepository.delete(rol);
    }
}
