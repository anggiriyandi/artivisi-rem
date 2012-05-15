/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rem.domain;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author gelz
 */

@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity implements Serializable{
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid2")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }   
}
