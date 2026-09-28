# Sistema de Gestión de Matrícula

API REST desarrollada con Java y Spring Boot para gestionar la matrícula de estudiantes mediante datos JSON.

## Tecnologías

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- Git y GitHub

## Arquitectura por capas

- Controller
- Service
- Repository
- Entity

## Tablas

1. roles
2. usuarios
3. facultades
4. carreras
5. periodos
6. cursos
7. curso_prerrequisito
8. secciones
9. matriculas
10. detalle_matricula

Las tablas son generadas automáticamente desde las entidades Java mediante JPA e Hibernate.

## Relaciones principales

- usuarios -> roles (estudiante, docente, administrador)
- carreras -> facultades
- cursos -> carreras
- curso_prerrequisito -> cursos (curso y su prerrequisito)
- secciones -> cursos, periodos y usuarios (docente)
- matriculas -> usuarios (estudiante) y periodos
- detalle_matricula -> matriculas y secciones (cursos en los que se matricula el estudiante)

## Configuración

Crear en MySQL una base de datos vacía:

CREATE DATABASE matricula_db;

Configurar la contraseña de MySQL en PowerShell:

$env:DB_PASSWORD="contraseña_mysql"

Ejecutar el proyecto:

.\mvnw.cmd spring-boot:run

## API REST

La API funciona en:

http://localhost:8080/api

Endpoints:

- /api/roles
- /api/usuarios
- /api/facultades
- /api/carreras
- /api/periodos
- /api/cursos
- /api/curso-prerrequisitos
- /api/secciones
- /api/matriculas
- /api/detalles-matricula

Cada endpoint admite GET (listar), GET /{id}, POST, PUT /{id} y DELETE /{id}. Los datos se registran y consultan en formato JSON mediante Postman.

## Orden sugerido para registrar datos en Postman

1. roles
2. usuarios
3. facultades
4. carreras
5. periodos
6. cursos
7. curso-prerrequisitos
8. secciones
9. matriculas
10. detalles-matricula

Ejemplo de cuerpo JSON para POST /api/detalles-matricula:

{
  "matricula": { "idMatricula": 1 },
  "seccion": { "idSeccion": 1 },
  "notaFinal": null,
  "estado": "MATRICULADO"
}
