package com.eugenedatsenko.db.entity;

import java.math.BigDecimal;

public class Account extends Entity {

    private static final long serialVersionUID = -4716143601005759190L;

    private BigDecimal amount;

    private int userId;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account[" +
                "amount=" + amount +
                ", userId=" + userId +
                ']';
    }
}
