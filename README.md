# dubbo-service-demo

dubbo spring zookeeper

dubbo 多协议 hessian下载文件 dubbo 其它

common: api

provider: service provider

comsumer: service consumer


dubbo:

    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>dubbo</artifactId>
      <version>2.8.4-SNAPSHOT</version>
      <exclusions>
        <exclusion>
          <artifactId>spring-expression</artifactId>
          <groupId>org.springframework</groupId>
        </exclusion>
        <exclusion>
          <artifactId>spring-beans</artifactId>
          <groupId>org.springframework</groupId>
        </exclusion>
        <exclusion>
          <artifactId>spring-aop</artifactId>
          <groupId>org.springframework</groupId>
        </exclusion>
      </exclusions>
    </dependency>
  </dependencies>

slf4j log4j：

    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>1.7.14</version>
    </dependency>

    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-slf4j-impl</artifactId>
      <version>2.5</version>
    </dependency>

    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.5</version>
    </dependency>

zookeeper内包含的log4：

      <exclusions>
        <exclusion>
          <groupId>org.slf4j</groupId>
          <artifactId>slf4j-log4j12</artifactId>
        </exclusion>
        <exclusion>
          <groupId>log4j</groupId>
          <artifactId>log4j</artifactId>
        </exclusion>
      </exclusions>
