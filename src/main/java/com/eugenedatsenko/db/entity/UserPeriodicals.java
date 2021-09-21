package com.eugenedatsenko.db.entity;

public class UserPeriodicals extends Entity {

    private static final long serialVersionUID = 6986230711542987941L;

    private int userId;

    private int publicationId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    @Override
    public String toString() {
        return "UserPeriodicals[" +
                "userId=" + userId +
                ", publicationId=" + publicationId +
                ']';
    }
}
