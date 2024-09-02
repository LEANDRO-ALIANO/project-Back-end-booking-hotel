package com.reservahotel.entities;

import com.reservahotel.Dtos.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "user")

    List<Reserve>reserves= new ArrayList<>();

    public User(String firstName,String lastName, String document, String email,String password){
        this.firstName =firstName;
        this.lastName= lastName;
        this.document=document;
        this.email=email;
        this.password=password;
    }
    public User(UserDto dto){
        this.firstName= dto.firstName();
        this.lastName= dto.lastName();
        this.document = dto.document();
        this.email= dto.email();
        this.password= dto.password();
    }



}
