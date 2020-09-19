package io.sudarykov.liqubasefirs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
//@EnableFeignClients
//@EnableAutoConfiguration
//@EnableFeignClients(clients = InventoryServiceFeignClient.class)
public class LiqubaseFirsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiqubaseFirsApplication.class, args);
    }

}
