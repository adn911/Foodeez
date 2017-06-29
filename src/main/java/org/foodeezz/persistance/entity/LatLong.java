package org.foodeezz.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by galib on 4/30/2015.
 */
@Embeddable
public class LatLong {

    @Column(nullable = true, length = 99)
    private String latitude;

    @Column(nullable = true, length = 99)
    private String longtitude;


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }
}
