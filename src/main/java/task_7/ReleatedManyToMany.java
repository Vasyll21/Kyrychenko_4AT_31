package task_7;

import org.hibernate.Session;
import task_7.model.Employee;
import task_7.model.Project;

import java.util.HashSet;
import java.util.Set;

public class ReleatedManyToMany {
    public static void main(String[] args) {
        Session session = RelatedHibernateUtil.getSessionFactory().openSession();

        Employee employee1 = new Employee();
        employee1.setEmployee_id(1L);
        employee1.setFirst_name("Vova");
        employee1.setLast_name("Papalo");

        Employee employee2 = new Employee();
        employee2.setEmployee_id(2L);
        employee2.setFirst_name("Primo");
        employee2.setLast_name("Victoria");

        Project project1 = new Project();
        project1.setProject_id(1L);
        project1.setTitle("some");

        Project project2 = new Project();
        project2.setProject_id(2L);
        project2.setTitle("another");

        Set<Project> projectSet = new HashSet<>();
        projectSet.add(project1);
        projectSet.add(project2);

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(employee1);
        employeeSet.add(employee2);

        employee1.setProjects(projectSet);
        employee2.setProjects(projectSet);
        project1.setEmployees(employeeSet);
        project2.setEmployees(employeeSet);

        session.beginTransaction();
        session.save(employee1);
        session.getTransaction().commit();

        session.beginTransaction();
        session.save(employee2);
        session.getTransaction().commit();

        session.beginTransaction();
        session.save(project1);
        session.getTransaction().commit();

        session.beginTransaction();
        session.save(project2);
        session.getTransaction().commit();

        //READ

        session.beginTransaction();

        Employee readEmployee = session.find(Employee.class, 1L);

        System.out.println(readEmployee);

        session.getTransaction().commit();

        //UPDATE

        session.beginTransaction();
        Project updateProject = session.find(Project.class, 1L);
        updateProject.setTitle("text");
        session.update(updateProject);
        session.getTransaction().commit();

        session.beginTransaction();
        Employee read = session.find(Employee.class, 1L);
        System.out.println(read);

        session.getTransaction().commit();

        session.close();
    }
}
