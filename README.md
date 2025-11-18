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
