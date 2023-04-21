package cherry.cworld.awsproxyrds;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
// import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

import cherry.cworld.awsproxyrds.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@MapperScan(basePackageClasses = AwsproxyrdsApplication.class)
@SpringBootApplication
public class AwsproxyrdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsproxyrdsApplication.class, args);
	}
}
