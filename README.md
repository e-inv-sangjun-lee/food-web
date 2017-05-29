# food-web
## tutorial
### 실행방법
- [food-docker](https://github.com/kodevops/food-docker/)를 먼저 실행합니다.
- Java Application을 실행합니다
  - src/main/java/com/kodeveloper/food/FoodApplication.java
- 브라우저를 기동하여, 아래의 URL에 접속합니다.

### 접속 URL
- http://localhost:8080/ 
- http://localhost:8080/mongo/save/
  - 저장하는 샘플코드    
- http://localhost:8080/mongo/findAll/
  - 취득하는 샘플코드

## Spring Boot 2.0
[10.1.1 Maven installation](http://docs.spring.io/spring-boot/docs/2.0.0.M1/reference/htmlsingle/#getting-started-maven-installation)
[11. Developing your first Spring Boot application](http://docs.spring.io/spring-boot/docs/2.0.0.M1/reference/htmlsingle/#getting-started-first-application)

## Mongo DB
- http://docs.spring.io/spring-boot/docs/2.0.0.M1/reference/htmlsingle/#boot-features-mongodb
- https://spring.io/guides/gs/accessing-data-mongodb/
- https://github.com/spring-guides/gs-accessing-data-mongodb

### 리모트 억세스 허가
http://taker.hatenablog.com/entry/2017/01/30/080854

### TODO
아래 내용은 아직 신경쓰지 않으셔도 됩니다.
```
docker exec -it fooddocker_food-mongo_1 mongo
```

```
db.createUser({ user: "fooduser", pwd: "foodpw", roles: [ { role: "userAdminAnyDatabase", db: "admin" } ] });
```