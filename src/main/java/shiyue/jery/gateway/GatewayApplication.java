package shiyue.jery.gateway;

import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GatewayApplication {

    @Autowired
    Environment environment;
//	@NacosInjected
//	private NamingService namingService;
//
//	@Value(value = "${spring.application.name}")
//	private String applicationName;
//
//	@Value(value = "${server.port}")
//	private int serverPort;

    @GetMapping(value = "/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

    @GetMapping(value = "/gateway/hi")
    public Mono<String> hi() {
        return Mono.just("hi");
    }
//    @GetMapping(value = "/hello/hello")
//    public String hello(){
//        return"hello";
//    }


//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        String uri = "http://httpbin.org:80";
//        return builder.routes()
//                .route(p -> p.path("/get")
//                        .filters(f -> f.addRequestHeader("hello", "world"))
//                        .uri(uri))
//                .route(p -> p.host("*.hystrix.com")
//                        .filters(f -> f.hystrix(config -> config.setName("mycmd")
//                                .setFallbackUri("forward:/fallback")))
//                        .uri(uri))
//                .build();
//    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @PostConstruct
    public void init() throws NacosException {
        System.out.println("1111111");
        System.out.println(environment.getProperty("spring.application.name"));
//		namingService.registerInstance(applicationName,"127.0.0.1",serverPort);
    }

}
