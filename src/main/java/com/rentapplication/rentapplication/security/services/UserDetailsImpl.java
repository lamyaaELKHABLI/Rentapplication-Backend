package com.rentapplication.rentapplication.security.services;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.rentapplication.rentapplication.entities.City;
import com.rentapplication.rentapplication.entities.Functionality;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rentapplication.rentapplication.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private int id;

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    @JsonIgnore
    private String password;
    private String address;
    private String image;
    private String phone;
    private Date birthdate;

    public Date getCreatedAt() {
        return createdAt;
    }

    private Date createdAt;

    private City city;
    private Functionality functionality;

    private Collection<? extends GrantedAuthority> authorities;



    private String role;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public String getPhone() {
        return phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public City getCity() {
        return city;
    }

    public Functionality getFunctionality() {
        return functionality;
    }


    public String getRole() {
        return role;
    }


    public UserDetailsImpl(int id, String username, String firstname, String lastname, String email, String password,
                           String address, String image, String phone, Date birthdate, Date createdAt,City city, Functionality functionality,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.image = image;
        this.phone = phone;
        this.birthdate = birthdate;
        this.createdAt = createdAt;
        this.city = city;
        this.functionality = functionality;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleTitle()))
                .collect(Collectors.toList());


        return new UserDetailsImpl(
                user.getUserId(),
                user.getUsername(),
                user.getUserFirstname(),
                user.getUserLastname(),
                user.getUserEmail(),
                user.getUserPassword(),
                user.getUserAddress(),
                user.getUserImage(),
                user.getUserAddress(),
                user.getUserBirthdate(),
                user.getCreatedAt(),
                user.getCity(),
                user.getFunctionality(),

                authorities
                );
    }




    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}