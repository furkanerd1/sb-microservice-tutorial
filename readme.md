# Notes

## Add Docker Images

### PostgreSQL
    PostgreSQL
    userName: postgres
    password: password
    DB: AuthDB

```bash
docker run -d --name postgres -p 5432:5432
```
### MongoDB
    MongoDB
    userName: root
    password: password
    DB: UserProfileDB

```bash
 docker run -d --name mongodb -p 27017:27017 mongo
```
```bashh
mongod:
db.createUser({user:"springstudent", pwd: "root", roles:["readWrite","dbAdmin"]})
```

## Create Redis Single Node on Docker
```bash
docker run --name some-redis -p 6379:6379 -d redis
```

```bash
docker run --name redis-gui -d -p  8001:8001 redislabs/redisinsight:latest
```

## Redis Spring Configuration
- Add relevant dependencies
- implementation ```org.springframework.boot:spring-boot-starter-data-redis:3.2.2```
- #### Redis can be used as a repository or as a cache . Therefore, it would be appropriate to add the necessary annotations to Config to activate Cache and Redis Repository in Spring.
  -  ```java
      @Configuration
      @EnableRedisRepositories
      @EnableCaching

## Create image with Dockerfile
```bash
FROM amazoncorretto:22.0.2-alpine3.20
COPY build/libs/'microservice'-v.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```
### **1-usage of images which will run on your local**
```bash
docker build -t tutorialconfigserver:v01 .
```
### **2- if you will publish on docker hub**
```bash
docker build -t username/tutorialconfigserver:v01 .
```
```bash
docker build -t username/tutorialauth:v01 .
```
```bash
docker build -t username/tutorialuser:v01 .
```
