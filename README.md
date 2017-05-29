# food-web
## tutorial
### 실행방법
- Java Application 실행
-- src/main/java/Example.java
- 브라우저로 접속 
-- http://localhost:8080/ 

## Spring Boot 2.0
[10.1.1 Maven installation](http://docs.spring.io/spring-boot/docs/2.0.0.M1/reference/htmlsingle/#getting-started-maven-installation)
[11. Developing your first Spring Boot application](http://docs.spring.io/spring-boot/docs/2.0.0.M1/reference/htmlsingle/#getting-started-first-application)

## Mongo DB
- http://docs.spring.io/spring-boot/docs/2.0.0.M1/reference/htmlsingle/#boot-features-mongodb
- https://spring.io/guides/gs/accessing-data-mongodb/
- https://github.com/spring-guides/gs-accessing-data-mongodb

### 리모트 억세스 허가
http://taker.hatenablog.com/entry/2017/01/30/080854

### 실행
```
docker exec -it fooddocker_food-mongo_1 mongo
```

```
db.createUser({ user: "fooduser", pwd: "foodpw", roles: [ { role: "userAdminAnyDatabase", db: "admin" } ] });
```