package kr.revelope.demo.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

@SpringBootApplication
@PropertySource("classpath:message.properties") // 16) @Configuration 클래스에 사용한 @PropertySource로 읽어들인 프로퍼티
public class PropertiesDemoApplication implements ApplicationRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesDemoApplication.class);

	private final String message;
	private final String systemPropertiesMessage;

	public PropertiesDemoApplication(
		@Value("${app.message}") String message,
		@Value("${message}") String systemPropertiesMessage
	) {
		this.message = message;
		this.systemPropertiesMessage = systemPropertiesMessage;
	}

	// 4) 커맨드 라인 Arguments : --app.message=commandLineArgs
	public static void main(String[] args) {
		// 1. System Properties에 값 넣고 꺼내기
		String propertiesKey = "message";
		System.setProperty(propertiesKey, "hello");
		System.out.printf("System Properties[%s] : %s%n", propertiesKey, System.getProperty(propertiesKey));

		// 2. System Properties 에는 무엇이 있을까?
		Properties properties = System.getProperties();
		properties.forEach((key, value) -> System.out.printf("System Properties[%s] : %s%n", key, value));

		// 17) 기본 프로퍼티 (SpringApplication.setDefaultProperties())
		Properties defualtProperties = new Properties();
		defualtProperties.put("message", "defaultProperties");

		SpringApplication springApplication = new SpringApplication(PropertiesDemoApplication.class);
		springApplication.setDefaultProperties(defualtProperties);
		springApplication.run(args);
	}

	@Override
	public void run(ApplicationArguments args) {
		// 3. Spring Properties 가져오기
		LOGGER.info("Spring Properties[{}] : {}", "app.message", message);
		// 9) 자바 시스템 프로퍼티 (System.getProperties())
		LOGGER.info("Spring Properties[{}] : {}", "message", systemPropertiesMessage);
	}
}
