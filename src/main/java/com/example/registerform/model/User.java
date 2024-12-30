package com.example.registerform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;



@Entity
@Table(name = "studentregform")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;


    @NotNull(message = "User name cannot be null")
    @Size(min = 3,max = 20,message = "user name must between 3 and 20 characters only")
    private String  UserName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "email is required")
    private String Email;


    @NotBlank(message = "password cannot be blank")
    @Size(min = 8,max = 20,message = "password must be between 8 and 20 characters")
    private  String Password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
