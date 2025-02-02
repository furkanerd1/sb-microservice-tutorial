# Notes

## Add Docker Images

### PostgreSQL
    PostgreSQL
    userName: postgres
    password: password
    DB: AuthDB

```bash
docker -run -d --name postgres -p 5432:5432
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