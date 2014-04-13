package com.developpez.rpouiller.hibernateimages.dao;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.developpez.rpouiller.hibernateimages.entites.ImageBlob;

public class ImageBlobDAO extends AbstractDAO {

    protected static final Logger LOGGER = Logger.getLogger(ImageBlobDAO.class);

    /**
     * Vide la table IMAGE_BLOB.
     */
    public void purgerImageBlob() {
        final Session lSession = ouvrirTransaction();
        final Query lQuery = lSession.createQuery(
                "delete from " + ImageBlob.class.getCanonicalName());
        lQuery.executeUpdate();
        fermerTransaction(lSession);
    }

    /**
     * Cette méthode lit une image depuis un champs Blob.
     */
    public void lireImageBlob(final Integer pId, final File pFile)
            throws IOException {

        final Session lSession = ouvrirTransaction();
        LOGGER.info("Lecture de l'image");
        final ImageBlob lImageBlobFromBase = (ImageBlob) lSession.get(ImageBlob.class, pId);
        LOGGER.info(new StringBuilder("- Id : ").append(lImageBlobFromBase.getId()));
        LOGGER.info(new StringBuilder("- Libelle : ").append(lImageBlobFromBase.getLibelle()));
        ImageIO.write((RenderedImage) lImageBlobFromBase.getImage(), "png", pFile);
        fermerTransaction(lSession);
    }

    /**
     * Cette méthode insère une image dans un champs Blob.
     */
    public void insererImageBlob(final Integer pId, final String pLibelle,
            final File pFile) throws IOException {

        final Session lSession = ouvrirTransaction();
        LOGGER.info("Insertion de l'image");
        final Image lImageHibernate = ImageIO.read(pFile);
        final ImageBlob lImageBlob = new ImageBlob();
        lImageBlob.setId(pId);
        lImageBlob.setLibelle(pLibelle);
        lImageBlob.setImage(lImageHibernate);
        lSession.save(lImageBlob);
        fermerTransaction(lSession);
    }

    /**
     * Cette méthode modifie une image dans un champs Blob.
     */
    public void modifierImageBlob(final Integer pId, final String pLibelle,
            final File pFile) throws IOException {

        final Session lSession = ouvrirTransaction();
        LOGGER.info("Modification de l'image");
        final Image lImageHibernate = ImageIO.read(pFile);
        final ImageBlob lImageBlob = new ImageBlob();
        lImageBlob.setId(pId);
        lImageBlob.setLibelle(pLibelle);
        lImageBlob.setImage(lImageHibernate);
        lSession.update(lImageBlob);
        fermerTransaction(lSession);
    }
}