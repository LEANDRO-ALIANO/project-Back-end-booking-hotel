package com.reservahotel.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Entity
@Table(name = "tb_reserve")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate bookingDate;
    private  String name;
    private String document;
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    public Reserve(LocalDate bookingDate, User user) {
        this.bookingDate = bookingDate;
        this.user = user;
        this.name= user.getFirstName() +" "+ user.getLastName();
        this.document= user.getDocument();
    }
}
