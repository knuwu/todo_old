package ch.inetware.openshift;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalTime;
import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .directModelSubstitute(LocalTime.class, String.class)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build().apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
            "Simple Todo-List REST API",
            "Eine Einfache API zur Verwaltung von Todo-Listen",
            "1.0",
            "API TOS",
            new Contact("Ralph Goebel",
                    "https://www.inetware.ch",
                    "ralph.goebel@inetware.ch"),
            "API License",
            "API License URL",
            new ArrayList<>()
    );
  }

}