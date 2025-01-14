package kr.co.basedevice.corebase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.co.basedevice.corebase.repository.cm.CmMenuRepository;
import kr.co.basedevice.corebase.security.service.SecurityResourceService;

@Configuration
public class AppConfig {

    @Bean
    SecurityResourceService securityResourceService(CmMenuRepository cmMenuRepository) {
        SecurityResourceService SecurityResourceService = new SecurityResourceService(cmMenuRepository);
        return SecurityResourceService;
    }    

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
