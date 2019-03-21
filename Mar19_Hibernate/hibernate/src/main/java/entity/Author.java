package entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Author {

    //  Exercise9
    //  @GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    //  Exercise7
    @Transient
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    //  Exercise8
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    //  Exercise11
    @Embedded
    private Address address;

    //   Exercise12
    @ElementCollection
    private Set<String> subjects = new HashSet<>();

//    Exercise14
//    public Author(String firstName, String lastName, int age, Date dateOfBirth, Book book) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.dateOfBirth = dateOfBirth;
//        this.book = book;
//    }
//
//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

//    Exercise15
//    @OneToOne
//    @JoinColumn(name = "book_id")
//    private Book book;

    //    Exercise16.1
//    @JoinTable
//    @OneToMany(cascade = CascadeType.PERSIST)

//    //  Exercise16.3
//    @OneToMany(mappedBy = "authors")

    //    Exercise17
    @ManyToMany
    private Collection<Book> books;

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public Author(String firstName, String lastName, int age, Date dateOfBirth, Collection<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.books = (List<Book>) books;
    }


    public Set<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<String> subjects) {
        this.subjects = subjects;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                ", subjects=" + subjects +
                '}';
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Author(String firstName, String lastName, int age, Date dateOfBirth, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Author(String firstName, String lastName, int age, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public Author() {
    }
}
