package com.developpez.rpouiller.hibernateimages.test;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.developpez.rpouiller.hibernateimages.dao.ImageBlobDAO;

public class ImageBlobTest {

    private static final Logger LOGGER = Logger.getLogger(ImageBlobTest.class);
    private ImageBlobDAO dao = new ImageBlobDAO();

    @Before
    public void initialiser() {
        LOGGER.info("**************************************************************************");
        LOGGER.info("Purger les occurences");
        LOGGER.info("**************************************************************************");
        dao.purgerImageBlob();
    }

    @Test
    public void testInsererLire() throws IOException {
        LOGGER.info("**************************************************************************");
        LOGGER.info("Ins�rer une image");
        LOGGER.info("**************************************************************************");
        dao.insererImageBlob(1, "logo_hibernate", new File("images\\logo_hibernate.png"));
        LOGGER.info("**************************************************************************");
        LOGGER.info("Lire l'image");
        LOGGER.info("**************************************************************************");
        dao.lireImageBlob(1, new File("logo_hibernate_from_base_blob.png"));
    }

    @Test
    public void testInsererModiferLire() throws IOException {
        LOGGER.info("**************************************************************************");
        LOGGER.info("Ins�rer une image");
        LOGGER.info("**************************************************************************");
        dao.insererImageBlob(1, "logo_hibernate", new File("images\\logo_hibernate.png"));
        LOGGER.info("**************************************************************************");
        LOGGER.info("Modifier une image");
        LOGGER.info("**************************************************************************");
        dao.modifierImageBlob(1, "logo_dvp", new File("images\\logo_dvp.png"));
        LOGGER.info("**************************************************************************");
        LOGGER.info("Lire l'image apr�s modification");
        LOGGER.info("**************************************************************************");
        dao.lireImageBlob(1, new File("logo_dvp_from_base_blob.png"));
    }
}