package com.example.cristian.postgresService.controller;

import com.example.cristian.postgresService.model.dto.GrupoDTO;
import com.example.cristian.postgresService.service.GrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> addNewGrupoPostgreSQLController(@RequestBody GrupoDTO grupoDTO) {
        try{
            grupoService.addGrupoService(grupoDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo añadido correctamente");
    }

    /**
     * Metodo para eliminar un grupo por id
     * @param id el id del grupo
     * @return un mensaje indicando si se eliminó el grupo o no
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGrupoByIdPostgreSQLController(@PathVariable Integer id) {
        try{
           boolean eliminado =  grupoService.deleteGrupoByIdService(id);
           if(!eliminado){
               return ResponseEntity.badRequest().body("Grupo no encontrado");
           }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo eliminado correctamente");
    }

    /**
     * Segundo metodo para crear el objeto en postgres pero usando una llamada a mongoService
     * @param grupoDTO el objeto a insertar en las bases de datos
     * @return un mensaje indicando si se creó o no
     */
    @PostMapping("/crear")
    public ResponseEntity<String> createGrupoLlmadaPostgreSQLController(@RequestBody GrupoDTO grupoDTO) {
        try{
            grupoService.createGrupoService(grupoDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo creado correctamente en llamada");
    }

    /**
     * Metodo para borrar un grupo por id en postgres y llamar a mongoService para que lo borre
     * @param id el id del grupo
     * @return un mensaje indicando si se borró o no el registro
     */
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarGrupoByIdLlamadaPostgreSQLController(@PathVariable Integer id) {
        try{
            boolean eliminado = grupoService.borrarGrupoByIdService(id);
            if(!eliminado){
                return ResponseEntity.badRequest().body("Grupo no encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo borrado correctamente en llamada");
    }
}
