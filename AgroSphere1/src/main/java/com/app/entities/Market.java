package com.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Market extends  BaseEntity
{
    @Column(length = 30, unique = true)
    private String name;
    private String address;
    private String district;
    private String state;

 /*   @OneToMany(mappedBy = "market", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude // To avoid circular references in toString()
   // @JoinColumn(name = "market_id")
    private List<MarketRate> marketRates;

//    @OneToMany
//    @JoinColumn(name = "appointment_id")
//    private  List<Appointment>appointments;
//
//    @OneToMany
//    @JoinColumn(name = "product_id")
//    private  List<Product> products;


    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Product> products;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
    private List<Product> products;
*/
    @OneToMany(mappedBy = "market", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MarketRate> marketRates;

    @OneToMany(mappedBy = "market", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "market", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products;

}
