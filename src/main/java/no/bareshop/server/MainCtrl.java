
package no.bareshop.server;

import no.bareshop.server.jpa.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kubkaray on 22.04.2015.
 */
@Controller
@EnableAutoConfiguration
@ComponentScan()
public class MainCtrl extends SpringBootServletInitializer{
    private static Class<MainCtrl> applicationClass = MainCtrl.class;

    @Autowired
    private CustomerService cusService;

    @RequestMapping("/")
    String mainCtrl() {
        //cusService.saveCustomer(new CDao().setId(11L).setUsername("KMan"));

        return "forward:/index.html";
    }
    @RequestMapping("/ssectrl")
    SseEmitter sendMessage(HttpServletResponse response) throws IOException {
        SseEmitter sseEmitter = new SseEmitter();
        try {
            sseEmitter.send("Message #1");
        } catch (IOException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
        return sseEmitter;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }



    public static void main(String... args) throws Exception {

        SpringApplication.run(MainCtrl.class, args);

    }
}
