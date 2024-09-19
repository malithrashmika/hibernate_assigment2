package lk.ijse;

import lk.ijse.Entity.Student;
import lk.ijse.confit.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();



        // HQL Insert Query
/*

        String hql = "insert into Student (StuID, name ,phone) values (:id, :name, :phone)"; ;
        Query Insertquery = session.createQuery(hql);
        Insertquery.setParameter("id", 2);
        Insertquery.setParameter("name", "von");
        Insertquery.setParameter("phone", "123456789");
        int result = Insertquery.executeUpdate();

        System.out.println("Rows affected: " + result);*/

        // Unique one Data from the customer table

        Query<Student> query = session.createQuery("FROM Student WHERE StuID = :id", Student.class);
        query.setParameter("id", 1);
        Student Student = query.uniqueResult();
        System.out.println("Student ID: " + Student.getStuID());

        // Update Query

        String updateHql = "UPDATE Student SET Name = :newName WHERE StuID = :id";
        Query updateQuery = session.createQuery(updateHql);
        updateQuery.setParameter("newName", "liiii");
        updateQuery.setParameter("id", 1);
        int updateResult = updateQuery.executeUpdate();
        System.out.println("Updated rows: " + updateResult);


        // Delete Query

        /*String deleteHql = "DELETE FROM Student WHERE StuID = :id";
        Query deleteQuery = session.createQuery(deleteHql);
        deleteQuery.setParameter("id", 2);
        int deleteResult = deleteQuery.executeUpdate();
        System.out.println("Deleted rows: " + deleteResult);*/



        // Load multiple columns

        Query<Object[]> query2 = session.createQuery("SELECT StuID, Name FROM Student WHERE StuID = :id", Object[].class);
        query2.setParameter("id", 1);
        Object[] objects = query2.getSingleResult();
        System.out.println("student ID: " + objects[0]);
        System.out.println("student Name: " + objects[1]);



        // Select specific columns for all customers

        Query<Object[]> query4 = session.createQuery("SELECT StuID, Name FROM Student ", Object[].class);
        List<Object[]> results2 = query4.getResultList();
        for (Object[] rst2 : results2) {
            System.out.println("Student ID: " + rst2[0] + ", Name: " + rst2[1]);
        }


        //Join query

        Query query3 = session.createQuery("SELECT a.id, a.model FROM Laptop a INNER JOIN a.student s");
        List<Object[]> result3 = query3.list();
        for (Object[] row : result3) {
            System.out.println("Laptop ID: " + row[0] + ", model: " + row[1] );
        }



        transaction.commit();
        session.close();
    }
}