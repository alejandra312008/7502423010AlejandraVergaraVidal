# Proyecto: Gestión de Partidos Políticos con Arquitectura Hexagonal

## Informe de Actividad

**Estudiante:** Alejandra Vergara Vidal  
**Código:** 7502324010  
**Fecha:** Noviembre 2025

---

## Página de Presentación

Este documento presenta el desarrollo de un sistema de gestión de partidos políticos implementado con Spring Boot 3.2+ y arquitectura hexagonal. El proyecto incluye funcionalidades completas de seguridad, gestión de usuarios y gestión de la entidad PartidoPolitico asignada en la Unidad 1.

---

## Introducción

Este informe documenta el desarrollo de una aplicación web RESTful para la gestión de partidos políticos, implementada siguiendo los principios de la arquitectura hexagonal (también conocida como arquitectura de puertos y adaptadores). 

El proyecto está estructurado en las siguientes secciones:

1. **Arquitectura del Sistema**: Descripción de la arquitectura hexagonal implementada
2. **Tecnologías Utilizadas**: Stack tecnológico y herramientas empleadas
3. **Estructura del Proyecto**: Organización de paquetes y componentes
4. **Funcionalidades Implementadas**: Detalle de las características desarrolladas
5. **Configuración y Despliegue**: Instrucciones para ejecutar el proyecto
6. **Pruebas**: Colección de Postman y documentación de API

---

## Objetivos de Aprendizaje

Al finalizar esta actividad, se espera haber alcanzado los siguientes objetivos:

1. **Arquitectura Hexagonal**: Comprender e implementar los principios de la arquitectura hexagonal, separando la lógica de negocio de los detalles de implementación.

2. **Spring Boot Avanzado**: Dominar el uso de Spring Boot 3.2+ con sus características principales:
   - Spring Security para autenticación y autorización
   - Spring Data JPA para persistencia
   - Validación de datos
   - Manejo de excepciones

3. **Gestión de Seguridad**: Implementar un sistema completo de seguridad que incluya:
   - Autenticación mediante JWT (JSON Web Tokens)
   - Login y logout de usuarios
   - Recuperación de contraseña mediante tokens

4. **API RESTful**: Desarrollar una API REST completa y bien documentada con:
   - Endpoints para CRUD de entidades
   - Documentación con Swagger/OpenAPI
   - Manejo adecuado de errores y validaciones

5. **Gestión de Datos**: Implementar operaciones CRUD completas para:
   - Usuarios del sistema
   - Partidos políticos con todos sus atributos

6. **Buenas Prácticas**: Aplicar principios de desarrollo de software:
   - Separación de responsabilidades
   - Inversión de dependencias
   - Código limpio y mantenible
   - Documentación adecuada

---

## Tecnologías Utilizadas

- **Java 21**: Lenguaje de programación
- **Spring Boot 3.2.0**: Framework principal
- **Spring Security**: Seguridad y autenticación
- **Spring Data JPA**: Persistencia de datos
- **H2 Database**: Base de datos en memoria para desarrollo
- **JWT (JSON Web Tokens)**: Autenticación stateless
- **MapStruct**: Mapeo entre objetos
- **Lombok**: Reducción de código boilerplate
- **Swagger/OpenAPI**: Documentación de API
- **Maven**: Gestor de dependencias

---

## Estructura del Proyecto

```
src/main/java/com/jcaa/hexagonal/
├── domain/                    # Capa de dominio (entidades de negocio)
│   ├── PartidoPolitico.java
│   ├── Usuario.java
│   └── TokenRecuperacion.java
├── port/                      # Puertos (interfaces)
│   ├── in/                    # Puertos de entrada (casos de uso)
│   │   ├── PartidoPoliticoUseCase.java
│   │   ├── UsuarioUseCase.java
│   │   └── AutenticacionUseCase.java
│   └── out/                   # Puertos de salida (repositorios, servicios externos)
│       ├── PartidoPoliticoRepositoryPort.java
│       ├── UsuarioRepositoryPort.java
│       ├── TokenRecuperacionRepositoryPort.java
│       └── JwtServicePort.java
├── service/                    # Servicios (implementación de casos de uso)
│   ├── PartidoPoliticoService.java
│   ├── UsuarioService.java
│   └── AutenticacionService.java
└── adapter/                    # Adaptadores
    ├── databases/              # Adaptadores de persistencia
    │   └── sql/
    │       ├── entity/         # Entidades JPA
    │       ├── repository/     # Repositorios JPA
    │       ├── mapper/         # Mappers dominio-entity
    │       └── *RepositoryAdapter.java
    └── rest/                   # Adaptadores REST
        ├── config/             # Configuraciones
        ├── dto/                # Data Transfer Objects
        ├── mappers/            # Mappers dominio-DTO
        └── controller/         # Controladores REST
```

---

## Funcionalidades Implementadas

### 1. Gestión de Seguridad

- **Login**: Autenticación de usuarios mediante username y password, retorna token JWT
- **Logout**: Invalidación de tokens JWT
- **Recuperación de Contraseña**: 
  - Solicitud de token de recuperación por email
  - Restablecimiento de contraseña usando el token

### 2. Gestión de Usuarios

- Crear usuario
- Obtener usuario por ID
- Listar todos los usuarios
- Actualizar usuario
- Eliminar usuario
- Validación de credenciales

### 3. Gestión de Partidos Políticos

La entidad PartidoPolitico incluye los siguientes campos:
- nombre
- eslogan
- presidente
- secretario
- tesorero
- pais
- numPresidentes
- numGobernadores
- numAlcaldes
- numConcejales
- numCongresistas

Operaciones CRUD completas:
- Crear partido político
- Obtener partido político por ID
- Listar todos los partidos políticos
- Actualizar partido político
- Eliminar partido político
- Buscar por país
- Buscar por nombre

---

## Configuración y Ejecución

### Requisitos Previos

- JDK 21 o superior
- Maven 3.6 o superior

### Ejecutar el Proyecto

1. Clonar o descargar el proyecto
2. Navegar a la carpeta del proyecto
3. Ejecutar: `mvn spring-boot:run`
4. La aplicación estará disponible en: `http://localhost:8080`

### Endpoints Principales

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **API Docs**: `http://localhost:8080/api-docs`
- **H2 Console**: `http://localhost:8080/h2-console`

### Configuración de Base de Datos

La aplicación utiliza H2 (base de datos en memoria) por defecto. La configuración se encuentra en `application.properties`.

---

## Pruebas con Postman

Se incluye una colección de Postman (`Postman_Collection.json`) con todos los endpoints configurados. Para usarla:

1. Importar la colección en Postman
2. Configurar la variable `baseUrl` (por defecto: `http://localhost:8080`)
3. Ejecutar el endpoint de Login para obtener el token
4. El token se guardará automáticamente en la variable `token` para las siguientes peticiones

---

## Documentación de API

La documentación completa de la API está disponible mediante Swagger/OpenAPI en:
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`

Todos los endpoints están documentados con descripciones, parámetros requeridos y ejemplos de respuestas.

---

## Conclusión

Este proyecto demuestra la implementación exitosa de una arquitectura hexagonal con Spring Boot, incluyendo todas las funcionalidades requeridas: gestión de seguridad, usuarios y la entidad PartidoPolitico. El código sigue buenas prácticas de desarrollo y está completamente documentado.

