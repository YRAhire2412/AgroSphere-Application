package com.app.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Product extends  BaseEntity
{
    private String prod_name;
    private Long  prod_qty;
    private String prod_description;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

}
