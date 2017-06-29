package org.foodeezz.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by bakhtiar.galib on 4/20/15.
 */
@Embeddable
public class RestaurantRating {

    @Column(nullable = true, columnDefinition = "double default 0")
    private double environment;

    @Column(nullable = true, columnDefinition = "double default 0")
    private double foodQuality;

    @Column(nullable = true, columnDefinition = "double default 0")
    private double service;

    @Column(nullable = true, columnDefinition = "double default 0")
    private double overall;


    public double getEnvironment() {
        return environment;
    }

    public void setEnvironment(double environment) {
        this.environment = environment;
    }

    public double getFoodQuality() {
        return foodQuality;
    }

    public void setFoodQuality(double foodQuality) {
        this.foodQuality = foodQuality;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getOverall() {
        return overall;
    }

    public void setOverall(double overall) {
        this.overall = overall;
    }
}
