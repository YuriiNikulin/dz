package artcode.spring_aop.utils;

import artcode.spring_aop.model.Candidate_spring_aop;
import artcode.spring_aop.model.Clan_spring_aop;
import artcode.spring_aop.model.Region_spring_aop;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii on 05.03.17.
 */
public class MyDB {

    private static EntityManager manager = MyConection.getEntityManager();

    private static List<Region_spring_aop> regions = new ArrayList<>();
    private static List<Clan_spring_aop> clans = new ArrayList<>();
    private static List<Candidate_spring_aop> candidates = new ArrayList<>();
    private static int lengs;

    public static void generateDB(int size) {

        lengs=size;
        for (int i = 0; i < size; i++) {
            regions.add(new Region_spring_aop(i + "-region", (int) (1000 + Math.random() * 10000)));
            clans.add(new Clan_spring_aop(i + "-clan"));
            candidates.add(new Candidate_spring_aop(i + "-candidat", clans.get(i), regions.get(i), (int) (30 + Math.random() * 40)));
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
            Candidate_spring_aop dell = manager.find(Candidate_spring_aop.class, candidates.get(i));
            manager.remove(dell);
        }

        manager.getTransaction().commit();
    }

}

