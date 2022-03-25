package task_7.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    private Long idphone;
    private String number;

    @ManyToOne
    @JoinColumn(name = "id_users", insertable = false, updatable = false)
    private RelatedUser user;

    public Long getIdphone() {
        return idphone;
    }

    public void setIdphone(Long idphone) {
        this.idphone = idphone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public RelatedUser getUser() {
        return user;
    }

    public void setUser(RelatedUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "idphone=" + idphone +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(idphone, phone.idphone) && Objects.equals(number, phone.number) && Objects.equals(user, phone.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idphone, number, user);
    }
}
