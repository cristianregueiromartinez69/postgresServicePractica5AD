package com.example.cristian.postgresService.servicio_comunicacion;

import com.example.cristian.postgresService.model.dto.GrupoAuxDTO;
import com.example.cristian.postgresService.model.dto.GrupoDTO;
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
     * @param grupoAuxDTO el grupo a crear
     */
    @PostMapping("/Practica5MongoService/grupo/crear")
    void crearGrupoLlamada(@RequestBody GrupoAuxDTO grupoAuxDTO);

    /**
     * Metodo para comunicarse con mongoService y borrar un grupo por su id
     * @param id el id del grupo que queremos borrar
     */
    @DeleteMapping("/Practica5MongoService/grupo/borrar/{id}")
    void borrarGrupoLlamada(@PathVariable Integer id);

}
