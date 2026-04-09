package kr.jonghyun.noticeboard;

import kr.jonghyun.noticeboard.global.config.JwtProperties;
import kr.jonghyun.noticeboard.global.config.SecurityProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties({JwtProperties.class, SecurityProperties.class})
public class NoticeboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeboardApplication.class, args);
    }

}
