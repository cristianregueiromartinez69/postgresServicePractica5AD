package com.example.cristian.postgresService.repository;

import com.example.cristian.postgresService.model.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la entidad de grupo
 * @author cristian
 * @version 1.0
 */
@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

    /**
     * Metodo para encontrar un grupo por id
     * @param id el id del grupo
     * @return el objeto grupo
     */
    Grupo findByid(Integer id);

}
