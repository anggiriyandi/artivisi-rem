/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rem.service.impl;

import com.rem.domain.master.M_Pegawai;
import com.rem.domain.master.M_User;
import com.rem.domain.service.MasterService;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 *
 * @author gelz
 */
@Service @Transactional
public class MasterServiceImpl implements MasterService{
    @Autowired SessionFactory sessionFactory;
    
    //User
    @Override
    public void save(M_User u) {
        if (u == null){
            return;
        }
        sessionFactory.getCurrentSession().saveOrUpdate(u);  
    }

    @Override
    public void delete(M_User u) {
        if (u == null || !StringUtils.hasText(u.getId())){
        return;
        }
        sessionFactory.getCurrentSession().delete(u);
    }

    @Override
    public M_User getdById(String id) {
        return (M_User) sessionFactory.getCurrentSession().get(M_User.class,id);
    }

    @Override
    public List<M_User> allUser() {
        return sessionFactory.getCurrentSession().createQuery("from M_User").list();
    }

    
    //Pegawai
    @Override
    public void save(M_Pegawai p) {
        sessionFactory.getCurrentSession().save(p);
    }

    @Override
    public void delete(M_Pegawai p) {
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public M_Pegawai getById(String id) {
        return (M_Pegawai) sessionFactory.getCurrentSession().get(M_Pegawai.class, id);
    }

    @Override
    public List<M_Pegawai> allPegawai() {
        return (List<M_Pegawai>) sessionFactory.getCurrentSession().createQuery("from M_Pegwai").list();
    }
}
