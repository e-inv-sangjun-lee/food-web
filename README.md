# food-web
## 실행하기
아래의 순서대로 실행하여 어플리케이션을 기동할 수 있습니다.

- [food-docker](https://github.com/kodevops/food-docker/)를 실행합니다.
- 아래의 클래스를 Java Application으로 실행합니다
  - src/main/java/com/kodeveloper/food/FoodApplication.java

## 접속 가능한 URL
어플러케이션이 기동하면 브라우저를 통해 다음과 같은 URL에 접속할 수 있습니다.

- http://localhost:8080/ 
- http://localhost:8080/mongo/save/
  - Customer를 저장하는 샘플코드    
- http://localhost:8080/mongo/findAll/
  - 저장된 Customer 일람을 취득하는 샘플코드
- http://localhost:8080/reactivemongo/save/
  - Customer를 저장하는 샘플코드(reactive버전)   
- http://localhost:8080/reactivemongo/findAll/
  - 저장된 Customer 일람을 취득하는 샘플코드(reactive버전) 

## Used technologies
### Spring Boot 2.0.0.BUILD-SNAPSHOT
[10.1.1 Maven installation](http://docs.spring.io/spring-boot/docs/2.0.0.M1/reference/htmlsingle/#getting-started-maven-installation)
[11. Developing your first Spring Boot application](http://docs.spring.io/spring-boot/docs/2.0.0.M1/reference/htmlsingle/#getting-started-first-application)

#### Spring 5 
#### Spring Data MongoDB Reactive
#### Spring WebFlux

## Used technologies(middleware)
### Mongo DB
- http://docs.spring.io/spring-boot/docs/2.0.0.M1/reference/htmlsingle/#boot-features-mongodb
- https://spring.io/guides/gs/accessing-data-mongodb/
- https://github.com/spring-guides/gs-accessing-data-mongodb

※어플리케이션 종료시 데이터가 남지 않습니다(embeded버전 이용중).

## Used technologies(in test)
### JUnit 5
[Spring Framework 5.0 Test関連の主な変更点](http://qiita.com/kazuki43zoo/items/4a9ead225a9a9897af4a)

### Spring test
#### AssertJ
#### WebTestClient

### 리모트 억세스 허가
http://taker.hatenablog.com/entry/2017/01/30/080854

### TODO
docker command

```
docker exec -it fooddocker_food-mongo_1 mongo
```

```
db.createUser({ user: "fooduser", pwd: "foodpw", roles: [ { role: "userAdminAnyDatabase", db: "admin" } ] });
```

## 참고 URL
- [Reactive RESTful service with Spring 5, Spring Boot 2 and MongoDB part1](https://dserradji.wordpress.com/2017/04/28/reactive-restful-service-with-spring-5-spring-boot-2-and-mongodb-part-1/)