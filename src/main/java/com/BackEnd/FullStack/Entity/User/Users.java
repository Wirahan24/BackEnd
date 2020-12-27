package com.BackEnd.FullStack.Entity.User;

import com.BackEnd.FullStack.Entity.Profile.Profile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Users {

    @Id
    @NotNull
    @Column(unique = true)
    public String Username;

    @NotNull
    @Column(unique = true)
    public String Email;

    public String Password;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Profile profile;

    public Users() {
    }

    public Users(Long id, String username, String email, String password, Profile profile) {
        Username = username;
        Email = email;
        Password = password;
        this.profile = profile;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
