import Customer.CDao;
import jpa.CustomerService;
import jpa.CustomerSvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kubkaray on 22.04.2015.
 */
@Controller
@EnableAutoConfiguration
public class MainCtrl {
    @Autowired
    CustomerService cusService;

    @RequestMapping("/")
    String mainCtrl() {
        cusService.saveCustomer(new CDao().setId(11));
        return "forward:/index.html";
    }



    public static void main(String[] args) throws Exception {

        SpringApplication.run(MainCtrl.class, args);

    }
}
