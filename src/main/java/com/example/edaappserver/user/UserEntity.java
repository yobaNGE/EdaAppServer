package com.example.edaappserver.user;


import com.example.edaappserver.restaurant.OrderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "userTable")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity implements UserDetails {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long id;
    private String name;
    private String surname;
    private String email;
    private String passwordus;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(targetEntity = OrderEntity.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<OrderEntity> orderEntityList;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getUserAuthorities();
    }
    @Override
    public String getPassword() {
        return passwordus;
    }

    @Override
    public String getUsername() {
        return email;
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordus() {
        return passwordus;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
