package com.app.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Appointment extends  BaseEntity {

    @CreationTimestamp
    private LocalDate created_on;

    @UpdateTimestamp
    private  LocalDate updated_on;

    @ManyToOne
    @JoinColumn(name = "farmerId")
    private  UserEntity farmer;

    @ManyToOne
    @JoinColumn(name = "marketID")
    private  Market market;

    @ManyToOne
    @JoinColumn(name = "productId")
    private  Product product;


    private LocalDate date;
}
