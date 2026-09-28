package pe.edu.matricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.matricula.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
