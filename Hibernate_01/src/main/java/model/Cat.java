package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cat")
public class Cat {
    private Integer id;
    private String name;
    private Date dateOfBirth;
    private boolean sex;

    public Cat() {
    }

    public Cat(Integer id, String name, Date dateOfBirth, boolean sex) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
