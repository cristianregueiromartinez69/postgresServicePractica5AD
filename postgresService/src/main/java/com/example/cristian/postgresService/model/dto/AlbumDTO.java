package com.example.cristian.postgresService.model.dto;

import com.example.cristian.postgresService.model.entity.Grupo;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DT0 de album
 * @author cristian
 * @version 1.0
 */
public class AlbumDTO {

    //atributos de clase
    private Grupo grupo;
    private String titulo;
    private LocalDate dataLanzamento;
    private BigDecimal puntuacion;

    /**
     * Constructor de la clase
     * @param grupo el grupo al que pertenece el album
     * @param titulo el titulo del album
     * @param dataLanzamento la fecha de lanzamiento del album
     * @param puntuacion la puntuacion del album
     */
    public AlbumDTO(Grupo grupo, String titulo, LocalDate dataLanzamento, BigDecimal puntuacion) {
        this.grupo = grupo;
        this.titulo = titulo;
        this.dataLanzamento = dataLanzamento;
        this.puntuacion = puntuacion;
    }

    //getter y setter del album

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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
