package com.epam.upskill.task4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @className: MethodSecurityConfig  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 5:57 PM 59 $
 * @author: Qudratjon Komilov
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig {
}
