package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by chaturanu on 2/22/17.
 */
public interface AlbumRepository extends CrudRepository<AlbumEntity, String> {
}
