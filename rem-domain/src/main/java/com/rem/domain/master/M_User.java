/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rem.domain.master;

import com.rem.domain.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author gelz
 */
@SuppressWarnings("serial")
@Entity
@Table (name="M_User")
public class M_User extends BaseEntity{
    @Column(nullable=false,unique=true)
    private String username;
    
    @Column(nullable=false)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
