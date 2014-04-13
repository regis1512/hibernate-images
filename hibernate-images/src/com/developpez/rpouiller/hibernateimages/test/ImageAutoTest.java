package com.developpez.rpouiller.hibernateimages.test;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.developpez.rpouiller.hibernateimages.dao.ImageAutoDAO;

public class ImageAutoTest {

    protected static final Logger LOGGER = Logger.getLogger(ImageAutoTest.class);
    private ImageAutoDAO dao = new ImageAutoDAO();

    @Before
    public void initialiser() {
        LOGGER.info("**************************************************************************");
        LOGGER.info("Purger les occurences");
        LOGGER.info("**************************************************************************");
        dao.purgerImageAuto();
    }

    @Test
    public void test() {

    }
}