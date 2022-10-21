package com.gmail.klewzow.Configurations;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@ComponentScan("com.gmail.klewzow")
@EnableAutoConfiguration
@EnableWebMvc
public class ThymeleafConfiguration implements  WebMvcConfigurer {

        private final ApplicationContext applicationContext;
        public ThymeleafConfiguration(ApplicationContext applicationContext)  {
            this.applicationContext = applicationContext;
        }

    /* ******************************************************************* */
        /* GENERAL CONFIGURATION ARTIFACTS */
        /* ******************************************************************* */
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/**").addResourceLocations("classpath:/src/img/");
            registry.addResourceHandler("/css/**").addResourceLocations("classpath:/src/css/");
            registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/src/fonts/");
            registry.addResourceHandler("/js/**").addResourceLocations("classpath:/src/js/");
            WebMvcConfigurer.super.addResourceHandlers(registry);
        }

        @Bean
        public SpringResourceTemplateResolver templateResolver() {
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
            templateResolver.setApplicationContext(applicationContext);
            templateResolver.setPrefix("classpath:/src/");
            templateResolver.setSuffix(".html");
            templateResolver.setTemplateMode(TemplateMode.HTML);
            templateResolver.setCharacterEncoding("UTF-8");
            templateResolver.setCacheable(false);
            return templateResolver;
        }

        @Bean
        public SpringTemplateEngine templateEngine() {
            SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
            springTemplateEngine.setTemplateResolver(templateResolver());
            springTemplateEngine.setEnableSpringELCompiler(true);
            return springTemplateEngine;
        }

        /*
         * CONFIGURATION Thymeleaf ViewResolverRegistry
         */
        @Override
        public void configureViewResolvers(ViewResolverRegistry registry) {
            ThymeleafViewResolver resolver = new ThymeleafViewResolver();
            resolver.setTemplateEngine(templateEngine());
            registry.viewResolver(resolver);
        }


}
