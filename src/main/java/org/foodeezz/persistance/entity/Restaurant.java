package org.foodeezz.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by GALIB on 4/18/2015.
 */

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Restaurant extends Persistent {

    @NotEmpty
    @Column(nullable = false, length = 99)
    private String name;

    @NotEmpty
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Lob
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "category")
    private RestaurantCategory category;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "rating.overall DESC")
    private List<MenuItem> menuItems;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RestaurantReview> reviews;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Branch> branches;

    private RestaurantRating rating;

    @ManyToMany
    @JoinTable(name="restaurant_admins", joinColumns=@JoinColumn(name="restaurant_id"), inverseJoinColumns=@JoinColumn(name="user_id"))
    private List<User> admins;

    public Restaurant() {
        category = new RestaurantCategory();
        menuItems = new ArrayList<MenuItem>();
        reviews = new ArrayList<RestaurantReview>();
        branches = new ArrayList<Branch>();
        rating = new RestaurantRating();
        admins = new ArrayList<User>();
    }

    public void updateRating(RestaurantRating restaurantRating) {

        if (reviews.size() <= 1) {
            rating.setEnvironment(restaurantRating.getEnvironment());
            rating.setFoodQuality(restaurantRating.getFoodQuality());
            rating.setService(restaurantRating.getService());
            rating.setOverall(restaurantRating.getOverall());

        } else {
            rating.setEnvironment((rating.getEnvironment() + restaurantRating.getEnvironment()) / 2);
            rating.setFoodQuality((rating.getFoodQuality() + restaurantRating.getFoodQuality()) / 2);
            rating.setService((rating.getService() + restaurantRating.getService()) / 2);
            rating.setOverall((rating.getOverall() + restaurantRating.getOverall()) / 2);
        }
    }

    public RestaurantRating getRating() {
        return rating;
    }

    public void setRating(RestaurantRating rating) {
        this.rating = rating;
    }

    public RestaurantCategory getCategory() {
        return category;
    }

    public void setCategory(RestaurantCategory category) {
        this.category = category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public List<RestaurantReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<RestaurantReview> reviews) {
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void update(Restaurant updatedRestaurantInfo) {
        this.setName(updatedRestaurantInfo.getName());
        this.setCategory(updatedRestaurantInfo.getCategory());
        this.setDescription(updatedRestaurantInfo.getDescription());

        if (updatedRestaurantInfo.getPhoto() != null)
            this.setPhoto(updatedRestaurantInfo.getPhoto());
    }

    public List<User> getAdmins() {
        return admins;
    }

    public void setAdmins(List<User> admins) {
        this.admins = admins;
    }

    public boolean isNew() {
        return id == null || id.intValue() == 0;
    }
}
