package com.example.cristian.postgresService.model.dto;

import java.time.LocalDate;

public class GrupoAuxDTO {

    private Integer id;
    private String nome;
    private String xenero;
    private LocalDate dstaFormacion;

    public GrupoAuxDTO(Integer id, String nome, String xenero, LocalDate dstaFormacion) {
        this.id = id;
        this.nome = nome;
        this.xenero = xenero;
        this.dstaFormacion = dstaFormacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
