# Parallel Cucumber test runs

- Repository answers question how to run easily Cucumber tests in parallel / concurrent.
- Each feature is running in its own thread
- Technologies used : cucumber + maven-surefire-plugin + jupiter + java 11


## junit-platform.properties

To enable parallel execution

```
cucumber.execution.parallel.enabled=true
```

## Run log

```
2021-07-25 12:42:59.579  INFO 58942 --- [Pool-1-worker-3] c.s.p.p.c.j.test.CucumberTestRunner      : Started CucumberTestRunner in 1.303 seconds (JVM running for 4.142)
2021-07-25 12:42:59.839  INFO 58942 --- [Pool-1-worker-5] c.s.p.p.c.junit5.test.CucumberSteps      : Step A
2021-07-25 12:42:59.839  INFO 58942 --- [Pool-1-worker-3] c.s.p.p.c.junit5.test.CucumberSteps2     : Step A2
2021-07-25 12:43:03.865  INFO 58942 --- [Pool-1-worker-5] c.s.p.p.c.junit5.test.CucumberSteps      : Step B
2021-07-25 12:43:03.865  INFO 58942 --- [Pool-1-worker-3] c.s.p.p.c.junit5.test.CucumberSteps2     : Step B2
2021-07-25 12:43:03.870  INFO 58942 --- [Pool-1-worker-5] c.s.p.p.c.junit5.test.CucumberSteps      : Step C
2021-07-25 12:43:03.870  INFO 58942 --- [Pool-1-worker-3] c.s.p.p.c.junit5.test.CucumberSteps2     : Step C2
```

## maven-surefire-plugin

To control parallelization see pom.xml

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>${surefire.plugin.version}</version>
    <configuration>
        <parallel>methods</parallel>
        <useUnlimitedThreads>true</useUnlimitedThreads>
        <includes>
            <include>CucumberTestRunner.class</include>
        </includes>
    </configuration>
</plugin>
```


## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.2</version>
        <relativePath/>
    </parent>
    <groupId>com.szatmary.peter</groupId>
    <artifactId>parallel-cucumber-junit5-test</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>parallel-cucumber-junit5-test</name>
    <description>Spring Boot app parallel Cucumber test junit5 run</description>
    <properties>
        <java.version>11</java.version>
        <cucumber.version>6.10.4</cucumber.version>
        <surefire.plugin.version>3.0.0-M5</surefire.plugin.version>
        <lombok.version>1.18.20</lombok.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java8</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-spring</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit-platform-engine</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>${surefire.plugin.version}</version>
                <configuration>
                    <parallel>methods</parallel>
                    <useUnlimitedThreads>true</useUnlimitedThreads>
                    <includes>
                        <include>CucumberTestRunner.class</include>
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

```


## More information

- [Cucumber](https://cucumber.io/)
- [Junit5](https://junit.org/junit5/docs/current/user-guide/)
- [Maven surefire plugin](https://maven.apache.org/surefire/maven-surefire-plugin/)