package artcode.week6.jpaElectorat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "clans")
public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String clan_name;

    /*@OneToMany(mappedBy = "clan")
    private List<Candidate_spring_aop> candidates = new ArrayList<>();*/

    public Clan() {
    }

    public Clan(String clan_name) {
        this.clan_name = clan_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClan_name() {
        return clan_name;
    }

    public void setClan_name(String clan_name) {
        this.clan_name = clan_name;
    }

    @Override
    public String toString() {
        return "Clan_spring_aop{" +
                "id=" + id +
                ", clan_name='" + clan_name + '\'' +
                '}';
    }
}
