/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rem.test;

import com.rem.domain.master.M_Pegawai;
import com.rem.domain.service.MasterService;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author gelz
 */
public class MasterTest {
    private static AbstractApplicationContext ctx;
    private static MasterService masterService;
   

    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = new ClassPathXmlApplicationContext(
				"classpath*:com/**/applicationContext.xml");
         masterService = (MasterService) ctx.getBean("masterService");
		ctx.registerShutdownHook();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        ctx.stop();
    }
    
    @Test
    public void classtest(){
        List<M_Pegawai> listPegawai = masterService.allPegawai();
        for (M_Pegawai m : listPegawai) {
            System.out.println(m.getNama());
        }
    }
}
