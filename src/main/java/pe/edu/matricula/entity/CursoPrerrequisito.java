package pe.edu.matricula.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "curso_prerrequisito", uniqueConstraints = {
        @UniqueConstraint(name = "uk_curso_prerrequisito", columnNames = { "id_curso", "id_prerrequisito" })
})
public class CursoPrerrequisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCursoPrerrequisito;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_prerrequisito", nullable = false)
    private Curso prerrequisito;

    public CursoPrerrequisito() {
    }

    public Long getIdCursoPrerrequisito() {
        return idCursoPrerrequisito;
    }

    public void setIdCursoPrerrequisito(Long idCursoPrerrequisito) {
        this.idCursoPrerrequisito = idCursoPrerrequisito;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getPrerrequisito() {
        return prerrequisito;
    }

    public void setPrerrequisito(Curso prerrequisito) {
        this.prerrequisito = prerrequisito;
    }
}
