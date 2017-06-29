package org.foodeezz.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by GALIB on 4/18/2015.
 */
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class User extends Persistent {

    @NotEmpty
    @Length(min = 5, max = 99)
    @Column(nullable = false, length = 99, unique = true)
    private String userId;

    @NotEmpty
    @Length(min = 5, max = 99)
    @Column(nullable = true, length = 99, unique = true)
    private String firstName;

    @NotEmpty
    @Length(min = 5, max = 99)
    @Column(nullable = true, length = 99, unique = true)
    private String lastName;

    @NotEmpty
    @Email
    @Column(nullable = false, length = 99, unique = true)
    private String email;

    @NotEmpty
    @Length(min = 5, max = 99)
    @Column(nullable = false, length = 99)
    private String password;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @Lob
    private byte[] photo;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 11 digits")
    @Column(nullable = true, length = 11)
    private String phone;

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isNew() {
        return id == null || id.intValue() == 0;
    }
}
