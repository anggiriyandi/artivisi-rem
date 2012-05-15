/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rem.ui.controller;

import com.rem.domain.master.M_User;
import com.rem.domain.service.MasterService;

import java.net.URI;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

/**
 *
 * @author gelz
 */
@Controller
@RequestMapping("/master/user")
public class MasterUserController {

    @Autowired
    private MasterService masterService;

    @RequestMapping("/{id}")
    @ResponseBody
    public M_User getById(@PathVariable String id) {
        M_User m_User = masterService.getdById(id);
        if (m_User == null) {
            throw new IllegalStateException();
        }
        return m_User;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody M_User m_User, HttpServletRequest request, HttpServletResponse response) {
       masterService.save(m_User);
       String requestUrl=request.getRequestURI().toString();
       URI uri = new UriTemplate("{requesturl}{id}").expand(requestUrl,m_User.getId());
       response.setHeader("Location",uri.toASCIIString());
    }
    
    @RequestMapping(method= RequestMethod.PUT,value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id,@RequestBody M_User m_User ){
        M_User mu = masterService.getdById(id);
        if(mu==null){
        throw new IllegalStateException();
        }
        m_User.setId(mu.getId());
        masterService.save(mu);
    }
    
    @RequestMapping(method= RequestMethod.DELETE,value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        M_User m_User = masterService.getdById(id);
            if(m_User== null){
                throw new IllegalStateException();
            }
           masterService.delete(m_User);
    }
    
    @RequestMapping(value="/",method= RequestMethod.GET)
    @ResponseBody
    public List<M_User> allUser(HttpServletResponse response){
        return masterService.allUser();
    }
}
