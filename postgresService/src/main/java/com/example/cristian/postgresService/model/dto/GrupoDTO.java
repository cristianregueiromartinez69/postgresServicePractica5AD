package com.example.cristian.postgresService.model.dto;

import java.time.LocalDate;

public class GrupoDTO {

    private String nome;
    private String xenero;
    private LocalDate dstaFormacion;

    public GrupoDTO(String nome, String xenero, LocalDate dstaFormacion) {
        this.nome = nome;
        this.xenero = xenero;
        this.dstaFormacion = dstaFormacion;
    }

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
