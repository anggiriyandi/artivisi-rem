/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rem.ui.controller;

import com.rem.domain.master.M_Pegawai;
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
@RequestMapping("/master/pegawai")
public class MasterPegawaiController {
    @Autowired
    private MasterService masterService;
    
    @RequestMapping(value="/{id}")
    @ResponseBody
    public M_Pegawai getByID(@PathVariable String id){
        M_Pegawai m_Pegawai = masterService.getById(id);
        if(m_Pegawai == null){
            throw  new IllegalStateException();
        }
      return m_Pegawai;
    }
    
    @RequestMapping(value="/",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    private void create(@RequestBody M_Pegawai m_Pegawai,HttpServletRequest request,HttpServletResponse response){
        masterService.save(m_Pegawai);
     String requestUrl=request.getRequestURI().toString();
       URI uri = new UriTemplate("{requesturl}{id}").expand(requestUrl,m_Pegawai.getId());
       response.setHeader("Location",uri.toASCIIString());
    }
    
    @RequestMapping(method= RequestMethod.PUT,value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id,@RequestBody M_Pegawai m_Pegawai){
        M_Pegawai mp = masterService.getById(id);
        if(mp == null){
            throw new IllegalStateException();
        }
        m_Pegawai.setId(mp.getId());
        masterService.save(mp);
    }
    
    @RequestMapping(method= RequestMethod.DELETE,value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        M_Pegawai m_Pegawai = masterService.getById(id);
        if(m_Pegawai == null){
            throw new IllegalStateException();
        }
        masterService.delete(m_Pegawai);
    }
    
    @RequestMapping(value="/",method= RequestMethod.GET)
    public List<M_Pegawai> allPegawai(HttpServletResponse response){
        return masterService.allPegawai();
    }
    
}
