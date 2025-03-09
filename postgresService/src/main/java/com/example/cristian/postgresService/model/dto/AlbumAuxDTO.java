package com.example.cristian.postgresService.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAuxDTO {

    private Integer grupoID;
    private String titulo;
    private LocalDate dataLanzamento;
    private BigDecimal puntuacion;

    public AlbumAuxDTO(Integer grupoID, String titulo, LocalDate dataLanzamento, BigDecimal puntuacion) {
        this.grupoID = grupoID;
        this.titulo = titulo;
        this.dataLanzamento = dataLanzamento;
        this.puntuacion = puntuacion;
    }

    public Integer getGrupoID() {
        return grupoID;
    }

    public void setGrupoID(Integer grupoID) {
        this.grupoID = grupoID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataLanzamento() {
        return dataLanzamento;
    }

    public void setDataLanzamento(LocalDate dataLanzamento) {
        this.dataLanzamento = dataLanzamento;
    }

    public BigDecimal getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(BigDecimal puntuacion) {
        this.puntuacion = puntuacion;
    }
}
