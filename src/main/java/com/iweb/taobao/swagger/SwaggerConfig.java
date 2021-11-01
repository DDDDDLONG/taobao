package com.iweb.taobao.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        Docket docket = null;
        ApiInfo apiInfo = new ApiInfoBuilder().description("").contact(new Contact("隔壁老王", "http://gebilaowang.com", "gebilaowang@163.com"))/*作者信息*/
                .version("v1.0")/*版本号*/
                .title("电商系统后台API文档")/*标题*/
                .license("Apache2.0")/*证书版本*/
                .licenseUrl("http://www.apache.org/licenses/LICENCE-2.0")/*证书地址*/
                .build();
        DocumentationType documentationType;
        docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.iweb.taobao.controller"))/*填写包名*/
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo);
        return docket;
    }

}
