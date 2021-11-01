package com.iweb.taobao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.iweb.taobao.mapper")
public class TaobaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaobaoApplication.class, args);
    }

}
