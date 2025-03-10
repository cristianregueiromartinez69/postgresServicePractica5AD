package com.example.cristian.postgresService.servicio_comunicacion;

import com.example.cristian.postgresService.model.dto.AlbumAuxMongoServiceDTO;
import com.example.cristian.postgresService.model.dto.GrupoAuxMongoServiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Servicio de comunicacion con mongoService
 * @author cristian
 * @version 1.0
 */
@FeignClient(name = "Practica5MongoService", url = ("http://localhost:8081"))
public interface ServicioMongo {

    /**
     * Metodo para comunicarse con mongoService y crear un grupo
     * @param grupoAuxMongoServiceDTO el grupo a crear
     */
    @PostMapping("/Practica5MongoService/grupo/crear")
    void crearGrupoLlamada(@RequestBody GrupoAuxMongoServiceDTO grupoAuxMongoServiceDTO);

    /**
     * Metodo para comunicarse con mongoService y borrar un grupo por su id
     * @param id el id del grupo que queremos borrar
     */
    @DeleteMapping("/Practica5MongoService/grupo/borrar/{id}")
    void borrarGrupoLlamada(@PathVariable Integer id);

    /**
     * Metodo para crear un album llamando a mongoService
     * @param albumAuxMongoServiceDTO el objeto a crear en mongo
     */
    @PostMapping("/Practica5MongoService/album/crear")
    void crearAlbum(@RequestBody AlbumAuxMongoServiceDTO albumAuxMongoServiceDTO);

    /**
     * Metodo para comunicarse con mongoService y borrar un album por su id
     * @param id el id del album que queremos borrar
     */
    @DeleteMapping("/Practica5MongoService/album/borrar/{id}")
    void borrarAlbumLlamada(@PathVariable Integer id);


}
