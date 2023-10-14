package com.gem.springboot.mashibing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(MyDeferredImportSelector.class)
@SpringBootApplication
public class SpringbootMashibingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMashibingApplication.class, args);
    }

}
