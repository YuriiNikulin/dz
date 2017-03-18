package artcode.week6.jpaElectorat.testJpa;

import artcode.week6.jpaElectorat.model.Candidate;
import artcode.week6.jpaElectorat.model.Clan;
import artcode.week6.jpaElectorat.model.Region;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by yurii on 04.03.17.
 */
public class TestRelations {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");
        EntityManager manager = entityManagerFactory.createEntityManager();

        Clan svoboda = new Clan("Svoboda");
        Clan partia = new Clan("Partia");
        Clan freeLife = new Clan("FreeLife");

        Region kiev = new Region("Kiev", 400000);
        Region ternopil = new Region("Ternopil", 200000);

        Candidate candidate1 = new Candidate("Tolya", svoboda, kiev, 50);
        Candidate candidate2 = new Candidate("Dina", svoboda, kiev, 30);
        Candidate candidate3 = new Candidate("Anton", partia, ternopil, 45);
        Candidate candidate4 = new Candidate("Misha", freeLife, kiev, 50);

        manager.getTransaction().begin();

        manager.persist(svoboda);
        manager.persist(partia);
        manager.persist(freeLife);
        manager.persist(kiev);
        manager.persist(ternopil);
        manager.persist(candidate1);
        manager.persist(candidate2);
        manager.persist(candidate3);
        manager.persist(candidate4);

        manager.getTransaction().commit();
    }
}
