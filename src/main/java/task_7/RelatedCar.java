package task_7;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class RelatedCar {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cars;
    private String model;
    private String brand;
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id")
    private RelatedUser relatedUser;

    public void setRelatedUser(RelatedUser relatedUser) {
        this.relatedUser = relatedUser;
    }

    public Long getId_cars() {
        return id_cars;
    }

    public void setId_cars(Long id_cars) {
        this.id_cars = id_cars;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
//`cars` (
//  `id_cars` INT NOT NULL AUTO_INCREMENT,
//  `model` VARCHAR(45) NOT NULL,
//  `brand` VARCHAR(45) NOT NULL,
//  `description` VARCHAR(60) NULL,
//  PRIMARY KEY (`id_cars`));