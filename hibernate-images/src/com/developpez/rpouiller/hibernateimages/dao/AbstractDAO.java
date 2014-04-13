package com.developpez.rpouiller.hibernateimages.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AbstractDAO {

    private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class);
    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            final Configuration lConfiguration = new Configuration();
            lConfiguration.configure();
            final StandardServiceRegistryBuilder lStandardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
            lStandardServiceRegistryBuilder.applySettings(lConfiguration.getProperties());
            final ServiceRegistry lServiceRegistry = lStandardServiceRegistryBuilder.build();
            SESSION_FACTORY = lConfiguration.buildSessionFactory(lServiceRegistry);
        } catch (final Throwable lThrowable) {
            LOGGER.error("Erreur lors de l'initialisation DAO", lThrowable);
            throw lThrowable;
        }
    }

    protected Session ouvrirTransaction() {
        final Session lSession = SESSION_FACTORY.openSession();
        lSession.beginTransaction();
        return lSession;
    }

    protected void fermerTransaction(final Session pSession) {
        pSession.getTransaction().commit();
        pSession.close();
    }
}