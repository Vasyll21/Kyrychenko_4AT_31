package task_6;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_users;
    private String name;
    private Integer age;
    private Date day_of_birdth;

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

    //`users` (
    //  `id_users` INT NOT NULL AUTO_INCREMENT,
    //  `name` VARCHAR(45) NOT NULL,
    //  `age` INT NOT NULL,
    //  `day_of_birdth` DATETIME NOT NULL,
    //  PRIMARY KEY (`id_users`));
}
