package com.example.cristian.postgresService.service;

import com.example.cristian.postgresService.excepciones.IdException;
import com.example.cristian.postgresService.model.dto.AlbumAuxDTO;
import com.example.cristian.postgresService.model.dto.AlbumDTO;
import com.example.cristian.postgresService.model.entity.Album;
import com.example.cristian.postgresService.model.entity.Grupo;
import com.example.cristian.postgresService.repository.AlbumRepository;
import com.example.cristian.postgresService.repository.GrupoRepository;
import org.springframework.stereotype.Service;

/**
 * Servicio de album
 * @author cristian
 * @version 1.0
 */
@Service
public class AlbumService {

    //variable de repositorio de album
    private final AlbumRepository albumRepository;
    private final GrupoRepository grupoRepository;

    /**
     * Constructor de la clase
     * @param albumRepository el repositorio de albumes
     */
    public AlbumService(AlbumRepository albumRepository, GrupoRepository grupoRepository) {
        this.albumRepository = albumRepository;
        this.grupoRepository = grupoRepository;
    }

    /**
     * Metodo para crear un album
     * @param albumAuxDTO el DTO del albumes
     */
    public void addAlbumService(AlbumAuxDTO albumAuxDTO) {
        Grupo grupo = grupoRepository.findByid(albumAuxDTO.getGrupoID());
        if(grupo == null) {
            throw new IdException("El grupo con el id " + albumAuxDTO.getGrupoID() + " no existe");
        }
        Album album = new Album(grupo, albumAuxDTO.getTitulo(),
                albumAuxDTO.getDataLanzamento(), albumAuxDTO.getPuntuacion());
        albumRepository.save(album);
    }



}
