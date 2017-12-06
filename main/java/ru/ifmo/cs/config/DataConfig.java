package ru.ifmo.cs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Богдана on 12.11.2017.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ru.ifmo.cs")
public class DataConfig {}
