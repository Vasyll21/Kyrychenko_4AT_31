package task_7;

import org.hibernate.Session;
import task_7.model.RelatedCar;
import task_7.model.RelatedUser;

import java.io.Serializable;

public class RelatedHibertnateMain {
    public static void main(String[] args) {
        Session session = RelatedHibernateUtil.getSessionFactory().openSession();

        RelatedUser relatedUser = session.find(RelatedUser.class, 2L);

        RelatedCar relCar = new RelatedCar();
        relCar.setModel("A5");
        relCar.setBrand("Audi");
        relCar.setDescription("some");
        relCar.setId_cars(9L);
        relCar.setRelatedUser(relatedUser);

        relatedUser.setRelatedCar(relCar);

        //CRUD

        //Create
        session.beginTransaction();
        Serializable id = session.save(relCar);
        session.getTransaction().commit();
        System.out.println("Car " + relCar + " saved with id" + id);
        session.beginTransaction();
        session.update(relatedUser);
        session.getTransaction().commit();


        //READ
        session.beginTransaction();
        RelatedCar readRelCar = session.find(RelatedCar.class, id);
        System.out.println("Car " + readRelCar + " read with id" + id);
        session.getTransaction().commit();

        //UPDATE
        session.beginTransaction();
        RelatedCar updateRelCar = session.find(RelatedCar.class, 3L);
        updateRelCar.setDescription("text");
        session.update(updateRelCar);
        session.getTransaction().commit();

        session.beginTransaction();
        RelatedCar updateReadRelCar = session.find(RelatedCar.class, 3L);
        System.out.println("Car " + updateReadRelCar + " update with id" + 3);
        session.getTransaction().commit();
        //DELETE
        session.beginTransaction();
        RelatedCar deleteRelCar = session.find(RelatedCar.class, 3L);
        session.delete(deleteRelCar);
        System.out.println("Car " + deleteRelCar + " delete with id" + 3);
        session.getTransaction().commit();

        session.close();

    }
}
