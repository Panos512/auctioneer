# auctioneer
Auctioneer project for the course "Web Application Technologies"


Developed in Spring MVC using Spring-Boot and AngularJS

<<<<<<<<<<<<<<<JPA>>>>>>>>>>>>>>>>>>>>

<dependency>
  <groupId>javax.persistence</groupId>
  <artifactId>persistence-api</artifactId>
  <version>1.0.2</version>
</dependency>
<dependency>
  <groupId>org.hibernate</groupId>
  <artifactId>hibernate-entitymanager</artifactId>
  <version>4.3.6.Final</version>
  <exclusions>
    <exclusion>
      <groupId>org.hibernate.javax.persistence</groupId>
      <artifactId>hibernate-jpa-2.1-api</artifactId>
    </exclusion>
  </exclusions>
</dependency>
