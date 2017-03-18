package artcode.spring.model;

import javax.persistence.*;

/**
 * Created by yurii on 04.03.17.
 */

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "region_name",nullable = false)
    private String name;

    @Column(nullable = false)
    private int population;

    /*@OneToMany(mappedBy = "region")
    private List<Candidate_spring_aop> candidates = new ArrayList<>();*/

    public Region() {
    }

    public Region(String name, int population) {
        this.name = name;
        this.population = population;
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Region_spring_aop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
