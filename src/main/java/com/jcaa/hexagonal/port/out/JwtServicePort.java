package com.jcaa.hexagonal.port.out;

public interface JwtServicePort {
    String generarToken(String username);
    String extraerUsername(String token);
    boolean validarToken(String token);
    void invalidarToken(String token);
}

