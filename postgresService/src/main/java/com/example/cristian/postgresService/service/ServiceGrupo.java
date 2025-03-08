package com.example.cristian.postgresService.service;

import com.example.cristian.postgresService.model.dto.GrupoDTO;
import com.example.cristian.postgresService.model.entity.Grupo;
import com.example.cristian.postgresService.repository.GrupoRepository;
import org.springframework.stereotype.Service;

/**
 * Clase servicio de los grupos
 * @author cristian
 * @version 1.0
 */
@Service
public class ServiceGrupo {

    //variable del repositorio
    private final GrupoRepository grupoRepository;

    /**
     * Constructor de la clase
     * @param grupoRepository el repositorio del grupo
     */
    public ServiceGrupo(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    /**
     * Metodo que inserta un objeto en la base de postgres
     * @param grupoDTO el grupoDT0
     */
    public void addGrupoService(GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo(grupoDTO.getNome(), grupoDTO.getXenero(),
                grupoDTO.getDstaFormacion());
        grupoRepository.save(grupo);
    }
}
