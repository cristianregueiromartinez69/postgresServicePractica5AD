package com.example.cristian.postgresService.model.dto;

import java.time.LocalDate;

/**
 * DTO de grupo
 * @author cristian
 * @version 1.0
 */
public class GrupoDTO {

    //variables de clase
    private String nome;
    private String xenero;
    private LocalDate dstaFormacion;

    /**
     * Constructor de la clase
     * @param nome el nombre del grupo
     * @param xenero el genero del grupo
     * @param dstaFormacion la fecha de formacion del grupo
     */
    public GrupoDTO(String nome, String xenero, LocalDate dstaFormacion) {
        this.nome = nome;
        this.xenero = xenero;
        this.dstaFormacion = dstaFormacion;
    }

    //getter y setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public LocalDate getDstaFormacion() {
        return dstaFormacion;
    }

    public void setDstaFormacion(LocalDate dstaFormacion) {
        this.dstaFormacion = dstaFormacion;
    }
}
