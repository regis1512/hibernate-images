package com.developpez.rpouiller.hibernateimages.entites;

import java.awt.Image;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImageAuto {

    @Id
    private Integer id;
    private String libelle;
    private Image image;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer pId) {
        id = pId;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(final String pLibelle) {
        libelle = pLibelle;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(final Image pImage) {
        image = pImage;
    }
}