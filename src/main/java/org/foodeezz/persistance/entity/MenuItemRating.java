package org.foodeezz.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by bakhtiar.galib on 4/20/15.
 */
@Embeddable
public class MenuItemRating {

    @Column(nullable = true,columnDefinition = "double default 0")
    private double overall;

    public double getOverall() {
        return overall;
    }

    public void setOverall(double overall) {
        this.overall = overall;
    }
}
