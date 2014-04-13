package com.developpez.rpouiller.hibernateimages.dao;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.developpez.rpouiller.hibernateimages.entites.ImageOrdImage;

public class ImageOrdImageDAO extends AbstractDAO {

    protected static final Logger LOGGER = Logger.getLogger(ImageOrdImageDAO.class);

    /**
     * Vide la table IMAGE_ORDIMAGE.
     */
    public void purgerImageOrdImage() {
        final Session lSession = ouvrirTransaction();
        final Query lQuery = lSession.createQuery(
                "delete from " + ImageOrdImage.class.getCanonicalName());
        lQuery.executeUpdate();
        fermerTransaction(lSession);
    }

    /**
     * Cette méthode lit une image depuis un champs OrdImage.
     */
    public void lireImageOrdImage(final Integer pId, final File pFile) throws IOException {
        final Session lSession = ouvrirTransaction();
        LOGGER.info("Lecture de l'image");
        final ImageOrdImage lImageOrdImageFromBase = (ImageOrdImage) lSession.get(ImageOrdImage.class, pId);
        LOGGER.info(new StringBuilder("- Id : ").append(lImageOrdImageFromBase.getId()));
        LOGGER.info(new StringBuilder("- Libelle : ").append(lImageOrdImageFromBase.getLibelle()));
        ImageIO.write((RenderedImage) lImageOrdImageFromBase.getImage(), "png", pFile);
        fermerTransaction(lSession);
    }

    /**
     * Cette méthode insère une image dans un champs OrdImage.
     */
    public void insererImageOrdImage(final Integer pId,
            final String pLibelle, final File pFile) throws IOException {

        final Session lSession = ouvrirTransaction();
        LOGGER.info("Insertion de l'image");
        final Image lImageHibernate = ImageIO.read(pFile);
        final ImageOrdImage lImageOrdImage = new ImageOrdImage();
        lImageOrdImage.setId(pId);
        lImageOrdImage.setLibelle(pLibelle);
        lImageOrdImage.setImage(lImageHibernate);
        lSession.save(lImageOrdImage);
        fermerTransaction(lSession);
    }

    /**
     * Cette méthode modifie une image dans un champs OrdImage.
     */
    public void modifierImageOrdImage(final Integer pId,
            final String pLibelle, final File pFile) throws IOException {

        final Session lSession = ouvrirTransaction();
        LOGGER.info("Modification de l'image");
        final Image lImageHibernate = ImageIO.read(pFile);
        final ImageOrdImage lImageOrdImage = new ImageOrdImage();
        lImageOrdImage.setId(pId);
        lImageOrdImage.setLibelle(pLibelle);
        lImageOrdImage.setImage(lImageHibernate);
        lSession.update(lImageOrdImage);
        fermerTransaction(lSession);
    }
}