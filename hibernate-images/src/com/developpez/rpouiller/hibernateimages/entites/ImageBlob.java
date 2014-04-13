package com.developpez.rpouiller.hibernateimages.entites;

import java.awt.Image;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.developpez.rpouiller.hibernateimages.usertypes.ImageBlobUserType;

@Entity(name="IMAGE_BLOB")
@TypeDefs(value={@TypeDef(name="imageBlob", typeClass=ImageBlobUserType.class)})
public class ImageBlob {

    @Id
    private Integer id;
    private String libelle;
    @Type(type="imageBlob")
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