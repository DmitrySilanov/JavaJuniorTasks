import javax.persistence.*;

@Entity
@Table(name = "test.person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Имя")
    private String Name;
    @Column (name = "Отчество")
    private String surName;
    @Column(name = "Возраст")
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.Name = Name;
        this.surName = surName;
        this.age = age;
    }

    public Person() {}
}