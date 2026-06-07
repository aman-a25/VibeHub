package com.myorg.vibehub.model;

import com.myorg.vibehub.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users") //But here it is because the name of the class is User and the name of the table is Users (plural)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true , nullable = false)
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
    private ProfilePicture profilePicture;
    // Here mapping by user basically user is the name of the variable profilePicture model
    // This tells system that user is parent ,and it is being mapped one to one two profile picture by that one variable or attribute user
    // Now something very strange will happen
    //  in User table there will be no column for profile picture at all
    //  Why because that was a redundant data it was not needed at all

    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
    private Wallet wallet;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL ,  fetch = FetchType.LAZY)
//    private Post post;
    // Because the mapping is one too many as the user is going to store more than one post so we need list of post
    private List<Post> post;

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;


    @ManyToMany(mappedBy = "users" ,  cascade = CascadeType.DETACH , fetch = FetchType.LAZY)
    private List<Group> groups;



//    All the code below is actually the getter setters for the above data members, but we don't need these Gator setters because we are using project lombok'
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public Gender getGender() {
//        return Gender;
//    }
//
//    public void setGender(Gender Gender) {
//        this.Gender = Gender;
//    }
}
