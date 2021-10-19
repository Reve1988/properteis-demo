package kr.revelope.demo.properties;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(properties = "app.message=SpringBootTest.properties") // 2) 테스트에 사용한 @TestPropertySource가 제공하는 프로퍼티
@TestPropertySource(properties = "app.message=TestPropertySource.properties") // 3) @SpringBootTest 어노테이션의 properties
class PropertiesDemoApplicationTests {
	@Test
	void contextLoads() {
	}
}
