package com.example.cristian.postgresService.repository;

import com.example.cristian.postgresService.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la entidad de album
 * @author cristian
 * @version 1.0
 */
@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
