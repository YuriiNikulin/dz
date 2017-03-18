package artcode.spring_aop.utils;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@Component
public class MyConection {

    public MyConection() {
    }

    public static EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");
        return entityManagerFactory.createEntityManager();
    }
}
