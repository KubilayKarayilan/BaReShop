package no.bareshop.server;

import no.bareshop.server.Customer.CDao;
import no.bareshop.server.jpa.CustomerService;
import no.bareshop.server.jpa.CustomerSvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kubkaray on 22.04.2015.
 */
@Controller
@EnableAutoConfiguration
@ComponentScan
public class MainCtrl {

    @Autowired
    private CustomerService cusService;

    @RequestMapping("/")
    String mainCtrl() {
        cusService.saveCustomer(new CDao().setId(11));
        return "forward:/index.html";
    }



    public static void main(String[] args) throws Exception {

        SpringApplication.run(MainCtrl.class, args);

    }
}
