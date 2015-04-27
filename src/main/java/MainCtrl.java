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
    @RequestMapping("/")

    String mainCtrl() {
        return "forward:/index.html";
    }



    public static void main(String[] args) throws Exception {

        SpringApplication.run(MainCtrl.class, args);

    }
}
