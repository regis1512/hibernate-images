package com.developpez.rpouiller.hibernateimages.test;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.developpez.rpouiller.hibernateimages.dao.ImageOrdImageDAO;

public class ImageOrdImageTest {

    private static final Logger LOGGER = Logger.getLogger(ImageOrdImageTest.class);
    private ImageOrdImageDAO dao = new ImageOrdImageDAO();

    @Before
    public void initialiser() {
        LOGGER.info("**************************************************************************");
        LOGGER.info("Purger les occurences");
        LOGGER.info("**************************************************************************");
        dao.purgerImageOrdImage();
    }

    @Test
    public void testInsererLire() throws IOException {
        LOGGER.info("**************************************************************************");
        LOGGER.info("Insérer une image");
        LOGGER.info("**************************************************************************");
        dao.insererImageOrdImage(1, "logo_hibernate", new File("images\\logo_hibernate.png"));
        LOGGER.info("**************************************************************************");
        LOGGER.info("Lire l'image");
        LOGGER.info("**************************************************************************");
        dao.lireImageOrdImage(1, new File("logo_hibernate_from_base_ordimage.png"));
    }

    @Test
    public void testInsererModiferLire() throws IOException {
        LOGGER.info("**************************************************************************");
        LOGGER.info("Insérer une image");
        LOGGER.info("**************************************************************************");
        dao.insererImageOrdImage(1, "logo_hibernate", new File("images\\logo_hibernate.png"));
        LOGGER.info("**************************************************************************");
        LOGGER.info("Modifier une image");
        LOGGER.info("**************************************************************************");
        dao.modifierImageOrdImage(1, "logo_dvp", new File("images\\logo_dvp.png"));
        LOGGER.info("**************************************************************************");
        LOGGER.info("Lire l'image après modification");
        LOGGER.info("**************************************************************************");
        dao.lireImageOrdImage(1, new File("logo_dvp_from_base_ordimage.png"));
    }
}