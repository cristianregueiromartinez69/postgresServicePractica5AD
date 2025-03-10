package com.example.cristian.postgresService.service;

import com.example.cristian.postgresService.model.dto.GrupoDTO;
import com.example.cristian.postgresService.model.entity.Grupo;
import com.example.cristian.postgresService.repository.GrupoRepository;
import com.example.cristian.postgresService.servicio_comunicacion.ServicioMongo;
import org.springframework.stereotype.Service;

/**
 * Clase servicio de los grupos
 * @author cristian
 * @version 1.0
 */
@Service
public class GrupoService {

    //variable del repositorio
    private final GrupoRepository grupoRepository;
    private final ServicioMongo servicioMongo;

    /**
     * Constructor de la clase
     * @param grupoRepository el repositorio del grupo
     */
    public GrupoService(GrupoRepository grupoRepository, ServicioMongo servicioMongo) {
        this.grupoRepository = grupoRepository;
        this.servicioMongo = servicioMongo;
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

    /**
     * Metodo para borrar un grupo por id
     * @param id el id del grupo a borrar
     */
    public boolean deleteGrupoByIdService(Integer id) {
        if(!grupoRepository.existsById(id)) {
            return false;
        }
        grupoRepository.deleteById(id);
        return true;
    }

    /**
     * Metodo que inserta un objeto en la base de postgres y llamará al de mongo
     * @param grupoDTO el grupoDT0
     */
    public void createGrupoService(GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo(grupoDTO.getNome(), grupoDTO.getXenero(),
                grupoDTO.getDstaFormacion());
        grupoRepository.save(grupo);
        servicioMongo.crearGrupoLlamada(grupoDTO);
    }

    /**
     * Metodo para borrar un grupo por id en postgres y borrará el de mongo
     * @param id el id del grupo a borrar
     */
    public boolean borrarGrupoByIdService(Integer id) {
        if(!grupoRepository.existsById(id)) {
            return false;
        }
        grupoRepository.deleteById(id);
        servicioMongo.borrarGrupoLlamada(id);
        return true;
    }


}
