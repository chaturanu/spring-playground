package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by chaturanu on 2/22/17.
 */
@Entity
public class AlbumEntity {

    @Id()
    private String name;

    private String bandName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
}
