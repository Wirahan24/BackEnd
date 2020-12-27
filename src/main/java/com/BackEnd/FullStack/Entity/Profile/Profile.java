package com.BackEnd.FullStack.Entity.Profile;

import com.BackEnd.FullStack.Entity.User.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "profile")
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String FirstName;
    private String Address;
    private Date BOD;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_detail")
    private Users users;

    public Profile() {
    }

    public Profile(Integer id, String firstName, String address, Date BOD) {
        Id = id;
        FirstName = firstName;
        Address = address;
        this.BOD = BOD;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Date getBOD() {
        return BOD;
    }

    public void setBOD(Date BOD) {
        this.BOD = BOD;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
