package com.eugenedatsenko.db.entity;

import java.math.BigDecimal;

/**
 * Publication entity.
 *
 * @author Y.Datsenko
 *
 */
public class Publication extends Entity  {

    private static final long serialVersionUID = 2379616089812213359L;

    private String name;

    private String Theme;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Periodicals[" +
                "name='" + name + '\'' +
                ", Theme='" + Theme + '\'' +
                ", price=" + price +
                ']';
    }
}
