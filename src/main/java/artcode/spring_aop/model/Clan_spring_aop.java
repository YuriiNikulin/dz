package artcode.spring_aop.model;

import javax.persistence.*;


@Entity
@Table(name = "clans")
public class Clan_spring_aop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String clan_name;

    /*@OneToMany(mappedBy = "clan")
    private List<Candidate_spring_aop> candidates = new ArrayList<>();*/

    public Clan_spring_aop() {
    }

    public Clan_spring_aop(String clan_name) {
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
