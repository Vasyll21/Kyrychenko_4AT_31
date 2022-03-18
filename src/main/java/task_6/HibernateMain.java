package task_6;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.Date;

public class HibernateMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        User user = new User();
        user.setName("Ivan");
        user.setAge(22);
        user.setDay_of_birdth(new Date());
        user.setId_users(3L);

        //CRUD

        //Create
        session.beginTransaction();
        Serializable id = session.save(user);
        session.getTransaction().commit();
        System.out.println("User " + user + " saved with id" + id);


        //READ
        session.beginTransaction();
        User readUser = session.find(User.class, id);
        System.out.println("User " + readUser + " read with id" + id);
        session.getTransaction().commit();
        //UPDATE
        session.beginTransaction();
        User updateUser = session.find(User.class, 2L);
        updateUser.setAge(21);
        session.update(updateUser);
        session.getTransaction().commit();

        session.beginTransaction();
        User updateReadUser = session.find(User.class, 2L);
        System.out.println("User " + updateReadUser + " update with id" + 2);
        session.getTransaction().commit();
        //DELETE
        session.beginTransaction();
        User deleteUser = session.find(User.class, 1L);
        session.delete(deleteUser);
        System.out.println("User " + deleteUser + " delete with id" + 1);
        session.getTransaction().commit();

        session.close();
    }
}
