package com.incremental.ria.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories("com.incremental.ria.repository")
@EntityScan("com.incremental.ria.repository.com.incremental.ria.repository.model")
@Configuration
public class RiaJpaConfiguration {

}
