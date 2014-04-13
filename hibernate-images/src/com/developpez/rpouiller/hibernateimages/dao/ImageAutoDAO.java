package com.developpez.rpouiller.hibernateimages.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.developpez.rpouiller.hibernateimages.entites.ImageAuto;

public class ImageAutoDAO extends AbstractDAO {

    /**
     * Vide la table de ImageAuto.
     */
    public void purgerImageAuto() {
        final Session lSession = ouvrirTransaction();
        final Query lQuery = lSession.createQuery(
                "delete from " + ImageAuto.class.getCanonicalName());
        lQuery.executeUpdate();
        fermerTransaction(lSession);
    }
}