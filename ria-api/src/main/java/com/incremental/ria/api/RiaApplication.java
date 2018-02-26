package com.incremental.ria.api;

import com.incremental.ria.repository.config.RiaJpaConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({RiaJpaConfiguration.class})
@ComponentScan({"com.incremental.ria.repository","com.incremental.ria.service","com.incremental.ria.api"})
public class RiaApplication extends SpringBootServletInitializer {
}
