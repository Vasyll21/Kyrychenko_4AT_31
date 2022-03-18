package task_7;

import org.hibernate.Session;
import task_6.HibernateUtil;

import java.io.Serializable;
import java.util.Date;

public class RelatedHibertnateMain {
    public static void main(String[] args) {
        Session session = RelatedHibernateUtil.getSessionFactory().openSession();

        RelatedUser relatedUser = session.find(RelatedUser.class, 2L);

        RelatedCar relCar = new RelatedCar();
        relCar.setModel("A5");
        relCar.setBrand("Audi");
        relCar.setDescription("some");
        relCar.setId_cars(2L);
        relCar.setRelatedUser(relatedUser);

        //CRUD

        //Create
        session.beginTransaction();
        Serializable id = session.save(relCar);
        session.getTransaction().commit();
        System.out.println("Car " + relCar + " saved with id" + id);

        //READ
        session.beginTransaction();
        RelatedCar readRelCar = session.find(RelatedCar.class, id);
        System.out.println("User " + readRelCar + " read with id" + id);
        session.getTransaction().commit();

        //UPDATE
        session.beginTransaction();
        RelatedCar updateRelCar = session.find(RelatedCar.class, 1L);
        updateRelCar.setDescription("text");
        session.update(updateRelCar);
        session.getTransaction().commit();

        session.beginTransaction();
        RelatedCar updateReadRelCar = session.find(RelatedCar.class, 1L);
        System.out.println("User " + updateReadRelCar + " update with id" + 1);
        session.getTransaction().commit();
        //DELETE
        session.beginTransaction();
        RelatedCar deleteRelCar = session.find(RelatedCar.class, 1L);
        session.delete(deleteRelCar);
        System.out.println("User " + deleteRelCar + " delete with id" + 1);
        session.getTransaction().commit();

        session.close();

    }
}
