## 1. properties란?
- 네이버 영어사전 : 물질의 성질 또는 특징
- 어플리케이션의 성질을 나타내기 위한 값
- 쉽게 이야기하면 어플리케이션이 동작할 때 어떤 성질을 가지고 동작해야하는지를 판단하기 위해 참고해야 하는 값들.
```
  어플리케이션을 어떤 언어로 실행을 해야하나?
  로그는 어느 경로에 쌓을까?
  서버를 실행할 때 포트는 몇번을 사용할 것인가?
  DB접속주소는 무엇으로 할까?
```
## 2. Spring에서 properties를 사용할 때 주의해야 할 점
#### 1) System Properties
- Spring과 상관 없이 Java에서 사용 가능한 Properties
- Java를 실행하면 기본적으로 운영체제의 보와 Java의 정보가 들어있어 어플리케이션에서 참고할 수 있다.
```
os.name , os.version , user.country , user.language , java.version 등..
```
- Properties 넣기
```
System.setProperty("message", "hello");
```
- Properties 꺼내기
```
String message = System.getProperty("message");
```

#### 2) Spring Properties
- Spring에서 관리하는 Properties로 생성 및 관리, 주입을 Spring이 제어한다.
- @Value어노테이션을 통해 properties값을 주입받을 수 있다.

## 3. Sprign Properties를 만드는 방법과 우선순위
- Spring은 낮은 우선순위에 있는 Properties부터 불러온다
- 나중에 불러와진 Properties 키가 이미 있으면 덮어쓴다.
- 즉, 우선순위가 높은 곳에 있는 값이 우선순위가 낮은 곳에 있는 값을 덮어쓴다.
```
1) spring-boot-devtools를 활성화 시켰을 때 $HOME/.config/spring-boot 디렉토리에 안에서 제공하는 프로퍼티
*2) 테스트에 사용한 @TestPropertySource가 제공하는 프로퍼티
*3) @SpringBootTest 어노테이션의 properties
*4) 커맨드 라인 Arguments
5) SPRING_APPLICATION_JSON (환경 변수 또는 시스템 프로퍼티) 에 있는 프로퍼티
6) ServletConfig 초기 매개변수
7) ServletContext 초기 매개변수
8) java:comp/env에 들어있는 JNDI 애트리뷰트
*9) 자바 시스템 프로퍼티 (System.getProperties())
10) OS 환경 변수
11) RandomValuePropertySource : 값을 렌덤으로 만들어서 프로퍼티에 주입해주는 기능
*12) JAR 패키지 외부에 있는 특정 프로파일용 애플리케이션 프로퍼티. (application-{profile}.properties 또는 YAML)
*13) JAR 패키지 내부에 있는 특정 프로파일용 애플리케이션 프로퍼티. (application-{profile}.properties 또는 YAML)
*14) JAR 패키지 외부에 있는 애플리케이션 프로퍼티. (application.properteis 또는 YAML)
*15) JAR 패키지 내부에 있는 애플리케이션 프로퍼티. (application.properteis 또는 YAML)
*16) @Configuration 클래스에 사용한 @PropertySource로 읽어들인 프로퍼티
*17) 기본 프로퍼티 (SpringApplication.setDefaultProperties())
```
