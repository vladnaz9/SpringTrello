package org.example.trello.web.config;

import org.example.trello.impl.config.SignUpImplConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
@Configuration
@Import(SignUpImplConfiguration.class)
public class WebConfig {
}
