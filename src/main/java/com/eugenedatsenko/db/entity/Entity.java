package com.eugenedatsenko.db.entity;

import java.io.Serializable;

/**
 * Root of all entities which have identifier field.
 *
 * @author Y.Datsenko
 *
 */
public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 8808500989675774169L;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
