package com.jcaa.hexagonal.adapter.databases.sql.config;

import com.jcaa.hexagonal.domain.Usuario;
import com.jcaa.hexagonal.port.in.UsuarioUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final UsuarioUseCase usuarioUseCase;

    @Override
    public void run(String... args) {
        try {
            // Crear usuario administrador por defecto
            if (usuarioUseCase.obtenerUsuarioPorUsername("admin").isEmpty()) {
                Usuario admin = Usuario.builder()
                        .username("admin")
                        .email("admin@example.com")
                        .password("admin123")
                        .nombre("Administrador")
                        .apellido("Sistema")
                        .activo(true)
                        .build();
                usuarioUseCase.crearUsuario(admin);
                log.info("Usuario administrador creado: admin / admin123");
            }
        } catch (Exception e) {
            log.error("Error inicializando datos: {}", e.getMessage());
        }
    }
}

