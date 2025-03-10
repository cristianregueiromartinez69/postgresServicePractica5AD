package com.example.cristian.postgresService.service;

import com.example.cristian.postgresService.excepciones.IdException;
import com.example.cristian.postgresService.model.dto.AlbumAuxMongoServiceDTO;
import com.example.cristian.postgresService.model.dto.AlbumDTO;
import com.example.cristian.postgresService.model.entity.Album;
import com.example.cristian.postgresService.model.entity.Grupo;
import com.example.cristian.postgresService.repository.AlbumRepository;
import com.example.cristian.postgresService.repository.GrupoRepository;
import com.example.cristian.postgresService.servicio_comunicacion.ServicioMongo;
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
    private final ServicioMongo servicioMongo;

    /**
     * Constructor de la clase
     * @param albumRepository el repositorio de albumes
     */
    public AlbumService(AlbumRepository albumRepository, GrupoRepository grupoRepository, ServicioMongo servicioMongo) {
        this.albumRepository = albumRepository;
        this.grupoRepository = grupoRepository;
        this.servicioMongo = servicioMongo;
    }

    /**
     * Metodo para crear un album
     * @param albumDTO el DTO del albumes
     */
    public void addAlbumService(AlbumDTO albumDTO) {
        Grupo grupo = getGrupo(albumDTO);
        Album album = new Album(grupo, albumDTO.getTitulo(),
                albumDTO.getDataLanzamento(), albumDTO.getPuntuacion());
        albumRepository.save(album);
    }

    /**
     * Metodo para borrar un album por su id
     * @param id el id del album
     * @return un mensaje indicando si se borro o no
     */
    public boolean deleteAlbumByIdService(Integer id) {
        if(!albumRepository.existsById(id)) {
            return false;
        }
        albumRepository.deleteById(id);
        return true;
    }

    /**
     * Metodo para crear un album y que se cree en mongoService
     * @param albumDTO el ablum DTO a crear
     */
    public void createAlbumService(AlbumDTO albumDTO) {
        Grupo grupo = getGrupo(albumDTO);
        Album album = new Album(grupo, albumDTO.getTitulo(),
                albumDTO.getDataLanzamento(), albumDTO.getPuntuacion());
        albumRepository.save(album);

        Integer albumID = album.getId();
        Integer grupoID = grupo.getId();
        AlbumAuxMongoServiceDTO albumAuxMongoServiceDTO = new AlbumAuxMongoServiceDTO(
                albumID, grupoID, albumDTO.getTitulo(), albumDTO.getDataLanzamento(),
                albumDTO.getPuntuacion()
        );
        servicioMongo.crearAlbum(albumAuxMongoServiceDTO);
    }

    /**
     * metodo para borrar un album por id en postgreSQL y mongoService
     * @param id el id del album
     * @return un mensaje indicando si se borro o no
     */
    public boolean borrarAlbumByIdService(Integer id) {
        if(!albumRepository.existsById(id)) {
            return false;
        }
        albumRepository.deleteById(id);
        return true;
    }

    /**
     * Metodo para obtener un grupo y saber si existe por su id o no
     * @param albumDTO la DTO para buscar al grupo
     * @return el objeto Grupo
     */
    private Grupo getGrupo(AlbumDTO albumDTO) {
        Grupo grupo = grupoRepository.findByid(albumDTO.getGrupoID());
        if(grupo == null) {
            throw new IdException("El grupo con el id " + albumDTO.getGrupoID() + " no existe");
        }
        return grupo;
    }

}
