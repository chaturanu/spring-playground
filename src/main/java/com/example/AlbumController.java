package com.example;

import org.springframework.web.bind.annotation.*;

/**
 * Created by chaturanu on 2/22/17.
 */
@RestController
@RequestMapping("/album")
public class AlbumController {

    private final AlbumRepository repository;

    public AlbumController(AlbumRepository repository) {
        this.repository = repository;
    }

    @PostMapping("")
    public AlbumEntity createAlbum(@RequestBody AlbumEntity album) {
        this.repository.save(album);
        return album;
    }

    @GetMapping("")
    public Iterable<AlbumEntity> findAllAlbums() {
        return this.repository.findAll();
    }
}
