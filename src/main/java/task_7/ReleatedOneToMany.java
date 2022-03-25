package task_7;

import org.hibernate.Session;
import task_7.model.Phone;
import task_7.model.RelatedCar;
import task_7.model.RelatedUser;

public class ReleatedOneToMany {

    public static void main(String[] args) {
        Session session = RelatedHibernateUtil.getSessionFactory().openSession();

        /*
        session.beginTransaction();
        RelatedUser relatedUser = session.find(RelatedUser.class, 1L);
        session.getTransaction().commit();

        Phone phone1 = new Phone();
        phone1.setIdphone(7L);
        phone1.setNumber("092819385");
        phone1.setUser(relatedUser);

        session.beginTransaction();
        session.save(phone1);
        session.getTransaction().commit();

        Phone phone2 = new Phone();
        phone2.setIdphone(8L);
        phone2.setNumber("053566475");
        phone2.setUser(relatedUser);

        session.beginTransaction();
        session.save(phone2);
        session.getTransaction().commit();

         */

        session.beginTransaction();
        RelatedUser user = session.find(RelatedUser.class, 1L);
        System.out.println("readUser: " + user);
        session.getTransaction().commit();

        //UPDATE
        session.beginTransaction();
        Phone updatePhone = session.find(Phone.class, 3L);
        updatePhone.setNumber("125784");
        session.update(updatePhone);
        session.getTransaction().commit();

        session.beginTransaction();
        Phone updateReadPnone = session.find(Phone.class, 3L);
        System.out.println("Phone " + updateReadPnone + " update with id" + 3);
        session.getTransaction().commit();
        //DELETE
        session.beginTransaction();
        Phone deletePhone = session.find(Phone.class, 2L);
        session.delete(deletePhone);
        System.out.println("Car " + deletePhone + " delete with id" + 2);
        session.getTransaction().commit();

        session.beginTransaction();
        RelatedUser user2 = session.find(RelatedUser.class, 1L);
        System.out.println("readUser: " + user2);
        session.getTransaction().commit();

        session.close();
    }
}
