package artcode.week6.jpaElectorat.model;


import javax.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, name = "cndidate_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "clan_id",referencedColumnName = "id")
    private Clan clan;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "region_id",referencedColumnName = "id")
    private Region region;

    @Column(nullable = false)
    private int age;


    public Candidate() {
    }

    public Candidate(String name, Clan clan, Region region, int age) {
        this.name = name;
        this.clan = clan;
        this.region = region;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Candidate_spring_aop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clan=" + clan +
                ", region=" + region +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        return id == candidate.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
