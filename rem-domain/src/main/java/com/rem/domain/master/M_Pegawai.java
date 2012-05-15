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
@Table(name="M_Pegawai")
public class M_Pegawai extends BaseEntity{
    @Column(nullable=false,unique=true)
    private String nip;
    
    @Column(nullable=false)
    private String nama;
    private String alamat;
    private String noTelepon;
    private String jabatan;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }   
}
