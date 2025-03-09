package com.example.cristian.postgresService.controller;

import com.example.cristian.postgresService.model.dto.AlbumAuxDTO;
import com.example.cristian.postgresService.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller de album
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/postgresService/album")
public class AlbumRestController {

    //variable del servicio de album
    public final AlbumService albumService;

    /**
     * Constructor de la clase
     * @param albumService el servicio de album
     */
    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    /**
     * Metodo para crear un album en postgreSQL
     * @param albumAuxDTO el album DTO
     * @return un mensaje indicando si se creo o no
     */
    @PostMapping("/add")
    public ResponseEntity<String> addNewAlbumPostgreSQLController(@RequestBody AlbumAuxDTO albumAuxDTO) {
        try{
            albumService.addAlbumService(albumAuxDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album añadido correctamente");
    }


}
