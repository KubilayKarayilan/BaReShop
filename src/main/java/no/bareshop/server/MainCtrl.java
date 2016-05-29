
package no.bareshop.server;

import no.bareshop.server.jpa.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * Created by kubkaray on 22.04.2015.
 */
@Controller
@EnableAutoConfiguration
@EnableWebSocket
@ComponentScan()
public class MainCtrl extends SpringBootServletInitializer implements WebSocketConfigurer {
    private static Class<MainCtrl> applicationClass = MainCtrl.class;

    @Autowired
    private CustomerService cusService;

    @RequestMapping("/")
    String mainCtrl() {
        //cusService.saveCustomer(new CDao().setId(11L).setUsername("KMan"));

        return "forward:/index.html";
    }
/*
    @RequestMapping("/ssectrl")
    SseEmitter sendMessage(HttpServletRequest request) throws IOException {
        SseEmitter sseEmitter = new SseEmitter();
        try {
            sseEmitter.send("Message #1");
        } catch (IOException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
        return sseEmitter;
    }
*/


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        return registrationBean;
    }

    public static void main(String... args) throws Exception {

        SpringApplication.run(MainCtrl.class, args);

    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(getHandler(),"/wsctrl");
    }
    @Bean
    public WebSocketHandler getHandler() {
        return new MyHandler();
    }
}
