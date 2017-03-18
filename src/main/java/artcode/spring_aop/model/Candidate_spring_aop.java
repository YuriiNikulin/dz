package artcode.spring_aop.model;


import javax.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate_spring_aop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, name = "cndidate_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "clan_id",referencedColumnName = "id")
    private Clan_spring_aop clan;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "region_id",referencedColumnName = "id")
    private Region_spring_aop region;

    @Column(nullable = false)
    private int age;


    public Candidate_spring_aop() {
    }

    public Candidate_spring_aop(String name, Clan_spring_aop clan, Region_spring_aop region, int age) {
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

    public Clan_spring_aop getClan() {
        return clan;
    }

    public void setClan(Clan_spring_aop clan) {
        this.clan = clan;
    }

    public Region_spring_aop getRegion() {
        return region;
    }

    public void setRegion(Region_spring_aop region) {
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

        Candidate_spring_aop candidate = (Candidate_spring_aop) o;

        return id == candidate.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
