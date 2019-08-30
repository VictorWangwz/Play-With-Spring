package com.victorwangzhen.coolapp.repsitory.entity;




import com.victorwangzhen.coolapp.repsitory.jpa.converters.StringListConverter;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    @Id
    private String id;

    @Column(length = 32)
    private String username;

    @Column(length = 64)
    private String password;

    @Convert(converter = StringListConverter.class)
    private List<String> roles;

    @Column(length = 64)
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority>  authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("USER"));
//
//        return authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
