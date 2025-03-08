package com.example.cristian.postgresService.controller;

import com.example.cristian.postgresService.model.dto.GrupoDTO;
import com.example.cristian.postgresService.service.GrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller de los grupos
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/postgresService/grupo")
public class GrupoRestController {

    //variable del servicio de grupos
    private final GrupoService grupoService;

    /**
     * Constructor de la clase
     * @param grupoService el servicio de grupos
     */
    public GrupoRestController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    /**
     * Metodo post para crear un grupo en la base de datos
     * @param grupoDTO la dto de grupos
     * @return un mensaje indicando el exito o no de la creacion del grupo
     */
    @PostMapping("/add")
    public ResponseEntity<String> addNewObjectPostgreSQLController(@RequestBody GrupoDTO grupoDTO) {
        try{
            grupoService.addGrupoService(grupoDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo añadido correctamente");
    }
}
