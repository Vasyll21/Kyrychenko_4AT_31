package task_7.model;

import task_7.model.RelatedCar;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "relatedusers")
public class RelatedUser {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_users;
    private String name;
    private Integer age;
    private Date day_of_birdth;

    @OneToOne
    @JoinColumn(name = "id_cars")
    private RelatedCar relatedCar;

    @OneToMany(mappedBy = "user")
    public Set<Phone> phoneSet;

    public Set<Phone> getPhoneSet() {
        return phoneSet;
    }

    public void setPhoneSet(Set<Phone> phoneSet) {
        this.phoneSet = phoneSet;
    }

    public RelatedCar getRelatedCar() {
        return relatedCar;
    }

    public void setRelatedCar(RelatedCar relatedCar) {
        this.relatedCar = relatedCar;
    }

    public Long getId_users() {
        return id_users;
    }

    public void setId_users(Long id_users) {
        this.id_users = id_users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDay_of_birdth() {
        return day_of_birdth;
    }

    public void setDay_of_birdth(Date day_of_birdth) {
        this.day_of_birdth = day_of_birdth;
    }

    @Override
    public String toString() {
        return "RelatedUser{" +
                "id_users=" + id_users +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", day_of_birdth=" + day_of_birdth +
                ", phoneSet=" + phoneSet +
                '}';
    }

//`users` (
    //  `id_users` INT NOT NULL AUTO_INCREMENT,
    //  `name` VARCHAR(45) NOT NULL,
    //  `age` INT NOT NULL,
    //  `day_of_birdth` DATETIME NOT NULL,
    //  PRIMARY KEY (`id_users`));
}
