package lk.Ijse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Student {
    @Id
    private int StuID;
    private String Name;
    private String Phone;

    @OneToMany(mappedBy = "student")
    private List<Laptop> laptops;

    public Student() {}

    public Student(int stuID, String name, String phone, List<Laptop> laptops) {
        StuID = stuID;
        Name = name;
        Phone = phone;
        this.laptops = laptops;
    }

    public int getStuID() {
        return StuID;
    }

    public void setStuID(int stuID) {
        StuID = stuID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
}
