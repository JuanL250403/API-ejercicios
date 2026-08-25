package udb.edu.sv.controller.dto.request.usuario;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRequest {
    private String nombre;

    private String correo;

    private String contrasenia;

    private LocalDate fechaNacimiento;

    private Double peso;

    private Integer altura;
}
