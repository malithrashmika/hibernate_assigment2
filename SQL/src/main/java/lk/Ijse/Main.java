package lk.Ijse;

import lk.Ijse.Entity.Student;
import lk.Ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*Laptop laptop1 = new Laptop();
        laptop1.setId(1);
        laptop1.setModel("DELL-Is-05");

        Laptop laptop2 = new Laptop();
        laptop2.setId(2);
        laptop2.setModel("HP-Is-05");

        List<Laptop>Laptops=new ArrayList<>();
        Laptops.add(laptop1);
        Laptops.add(laptop2);

        Student student = new Student();
        student.setStuID(1);
        student.setName("Lahiru");
        student.setPhone("074521345");
        student.setLaptops(Laptops);

        laptop1.setStudent(student);
        laptop2.setStudent(student);

        session.save(laptop1);
        session.save(laptop2);
        session.save(student);*/

        /*---------------------------------------INSERT----------------------------------------------------*/

        NativeQuery<?> query = session.createNativeQuery("INSERT INTO student values (?1 , ?2 ,?3)");
        query.setParameter(1, 1);
        query.setParameter(2, "Aki");
        query.setParameter(3, "078451212");

        NativeQuery<?> query1 = session.createNativeQuery("INSERT INTO laptop values (?1 , ?2 ,?3)");
        query1.setParameter(1, 1);
        query1.setParameter(2, "HP-IN05");
        query1.setParameter(3, 1);

        /*query.executeUpdate();
        query1.executeUpdate();*/

        /*-------------------------------------UPDATE-----------------------------------------------------*/
        NativeQuery<?> query3 = session.createNativeQuery("UPDATE student SET Name=?1 WHERE StuID=?2");
        query3.setParameter(1, "akintha chandinu");
        query3.setParameter(2, 1);
        query3.executeUpdate();


        /*-------------------------------------DELETE-----------------------------------------------------*/
        NativeQuery<?> query4 = session.createNativeQuery("DELETE FROM student WHERE StuID=?1");
        query4.setParameter(1, 1);
      /*  query4.executeUpdate();*/

        /*-------------------------------------Search by id-----------------------------------------------------*/
        NativeQuery<?> query5 = session.createNativeQuery("select * from student where StuID=?1" , Student.class);
        query5.setParameter(1, 1);
        Student studentSearchById = (Student) query5.uniqueResult();

        if (studentSearchById==null){
            System.out.println("Student Not Found");
        }else {
            System.out.println("Student Founded successfully  Student name is " + studentSearchById.getName());
        }


        /*-------------------------------------join Query-----------------------------------------------------*/
        NativeQuery<?> query6 = session.createNativeQuery("DELETE FROM student WHERE StuID=?1");



        transaction.commit();
        session.close();
    }
}