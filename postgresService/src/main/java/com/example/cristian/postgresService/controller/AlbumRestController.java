package com.example.cristian.postgresService.controller;

import com.example.cristian.postgresService.model.dto.AlbumDTO;
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
     * @param albumDTO el album DTO
     * @return un mensaje indicando si se creo o no
     */
    @PostMapping("/add")
    public ResponseEntity<String> addNewAlbumPostgreSQLController(@RequestBody AlbumDTO albumDTO) {
        try{
            albumService.addAlbumService(albumDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album añadido correctamente");
    }

    /**
     * Metodo para borrar un album en postgreSQL
     * @param id el id del album a borrar
     * @return un mensaje indicando si se borró o no
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAlbumByIdPostgreSQLController(@PathVariable Integer id) {
        try{
            boolean eliminado = albumService.deleteAlbumByIdService(id);
            if(!eliminado){
                return ResponseEntity.badRequest().body("Album no encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album eliminado correctamente");
    }

    /**
     * Metodo para crear un album en postgreSQL y llamar a mongoService
     * @param albumDTO el album DTO a crear en postgreSQL y mongoService
     * @return un mensaje indicando si se creo o no
     */
    @PostMapping("/crear")
    public ResponseEntity<String> createNewAlbumLlamadaPostgreSQLController(@RequestBody AlbumDTO albumDTO) {
        try{
            albumService.createAlbumService(albumDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album creado correctamente en llamada");
    }

    /**
     * Metodo para borrar un album en postgreSQL y mongoService
     * @param id el id del album a borrar en ambas bases de datos
     * @return un mensaje indicando si se borró o no
     */
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarAlbumByIdLlamadaPostgreSQLController(@PathVariable Integer id) {
        try{
            boolean eliminado = albumService.borrarAlbumByIdService(id);
            if(!eliminado){
                return ResponseEntity.badRequest().body("Album no encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album borrado correctamente en llamada");
    }
}
