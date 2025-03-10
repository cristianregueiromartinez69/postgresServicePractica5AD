package com.example.cristian.postgresService.model.dto;

import java.time.LocalDate;

/**
 * Clase auxDTO para mandar la información del grupo al servicio de mongoService
 * @author cristian
 * @version 1.0
 */
public class GrupoAuxMongoServiceDTO {

    //variables de clase
    private Integer id;
    private String nome;
    private String xenero;
    private LocalDate dstaFormacion;

    /**
     * Constructor de la clase
     * @param id el id del grupo
     * @param nome el nombre del grupo
     * @param xenero el genero del grupo
     * @param dstaFormacion la fecha de formacion del grupo
     */
    public GrupoAuxMongoServiceDTO(Integer id, String nome, String xenero, LocalDate dstaFormacion) {
        this.id = id;
        this.nome = nome;
        this.xenero = xenero;
        this.dstaFormacion = dstaFormacion;
    }

    //getter y setter
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
