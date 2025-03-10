package com.example.cristian.postgresService.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO de album para insertar datos
 * @author cristian
 * @version 1.0
 */
public class AlbumDTO {

    //atributos de clase
    private Integer grupoID;
    private String titulo;
    private LocalDate dataLanzamento;
    private BigDecimal puntuacion;

    /**
     * Constructor de la clase
     * @param grupoID el id del grupo
     * @param titulo el titulo del album
     * @param dataLanzamento la fecha de lanzamiento del album
     * @param puntuacion la puntuacion del album
     */
    public AlbumDTO(Integer grupoID, String titulo, LocalDate dataLanzamento, BigDecimal puntuacion) {
        this.grupoID = grupoID;
        this.titulo = titulo;
        this.dataLanzamento = dataLanzamento;
        this.puntuacion = puntuacion;
    }

    //getter y setter
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
