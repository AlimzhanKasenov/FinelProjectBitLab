package com.example.FinelProjectBitLab.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "t_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "role")
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
