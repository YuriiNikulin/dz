package artcode.spring.utils;

import artcode.spring.model.Candidate;
import artcode.spring.model.Clan;
import artcode.spring.model.Region;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii on 05.03.17.
 */
public class MyDB {

    private static EntityManager manager = MyConection.getEntityManager();

    private static List<Region> regions = new ArrayList<>();
    private static List<Clan> clans = new ArrayList<>();
    private static List<Candidate> candidates = new ArrayList<>();
    private static int lengs;

    public static void generateDB(int size) {

        lengs=size;
        for (int i = 0; i < size; i++) {
            regions.add(new Region(i + "-region", (int) (1000 + Math.random() * 10000)));
            clans.add(new Clan(i + "-clan"));
            candidates.add(new Candidate(i + "-candidat", clans.get(i), regions.get(i), (int) (30 + Math.random() * 40)));
        }

        manager.getTransaction().begin();

        for (int i = 0; i < size; i++) {
            manager.persist(regions.get(i));
            manager.persist(clans.get(i));
            manager.persist(candidates.get(i));
        }

        manager.getTransaction().commit();
    }

    public static void clear() {
        manager.getTransaction().begin();

        /*for (Region_spring_aop region : regions) {
            Region_spring_aop dell = manager.find(Region_spring_aop.class, region);
            manager.remove(dell);
        }

        for (Clan_spring_aop clan : clans) {
            Clan_spring_aop dell = manager.find(Clan_spring_aop.class, clan);
            manager.remove(dell);
        }*/

        for (int i = 0; i < lengs; i++) {
            Candidate dell = manager.find(Candidate.class, candidates.get(i));
            manager.remove(dell);
        }

        manager.getTransaction().commit();
    }

}

