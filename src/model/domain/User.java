/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mateu
 */
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @Column(name="name",nullable=false)
    private String name;
    @Column(name="email",unique = true,nullable=false)
    private String email;
    @Column(name="login",unique = true,nullable=false)
    private String login;
    @Column(name="password",nullable=false)
    private String password;
    
    @OneToMany
    private List<PlayList> playLists;
    
    public User(String nome,String email,String login,String senha){
       this.playLists = new ArrayList<>();
       this.name = nome;
       this.email  = email;
       this.login = login;
       this.password = senha;
        
    }
    public User(String login,String senha){
       this.playLists = new ArrayList<>();
       this.login = login;
       this.password = senha;
        
    }
    public User(){
        this.playLists = new ArrayList<>();
    }
   
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void HashPassword(){
        this.password = BCrypt.hashpw(this.password, BCrypt.gensalt(12));
    }
    public boolean VerifyPasswordHash(String Password,String PasswordHashed){
        return BCrypt.checkpw(Password, PasswordHashed);
    }

    
}
