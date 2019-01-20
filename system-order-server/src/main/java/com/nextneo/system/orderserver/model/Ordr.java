package com.nextneo.system.orderserver.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "ordr")
public class Ordr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Product required")
    private String product;

    @NotNull(message = "Price required")
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Ordr() {
    	super();
    }
    
    public Ordr(Ordr o) {
		super();
		this.id = o.getId();
		this.product = o.getProduct();
		this.price = o.getPrice();
	}

	public Ordr(Long id, String product, BigDecimal price) {
		super();
		this.id = id;
		this.product = product;
		this.price = price;
	}
    
}
