package artcode.spring.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by yurii on 05.03.17.
 */
public class MyConection {

    public static EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");
        return entityManagerFactory.createEntityManager();
    }
}
