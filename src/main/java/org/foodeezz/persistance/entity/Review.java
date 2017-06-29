package org.foodeezz.persistance.entity;

import javax.persistence.*;

/**
 * Created by GALIB on 4/20/2015.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends Persistent {

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;

    @Column(nullable = false, columnDefinition = "TEXT")
    protected String comment;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
