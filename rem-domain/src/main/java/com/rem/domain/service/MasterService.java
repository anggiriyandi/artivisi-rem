/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rem.domain.service;

import com.rem.domain.master.M_Pegawai;
import com.rem.domain.master.M_User;
import java.util.List;

/**
 *
 * @author gelz
 */
public interface MasterService {
    public void save(M_User u);
    public void delete(M_User u);
    public M_User getdById(String id);
    public List<M_User> allUser();
    
    public void save (M_Pegawai p);
    public void delete(M_Pegawai p);
    public M_Pegawai getById(String id);
    public List<M_Pegawai> allPegawai();
}
