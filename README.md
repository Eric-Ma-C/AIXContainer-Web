# Getting Started

## 部署步骤
### 1.构建镜像
Dockerfile:
```dockerfile
FROM openjdk:8-jdk-alpine

# 设置时区
ENV TZ=Asia/Shanghai
RUN set -eux; \
    apk add --no-cache --update tzdata; \
    ln -snf /usr/share/zoneinfo/$TZ /etc/localtime; \
    echo $TZ > /etc/timezone

EXPOSE 8081

ENTRYPOINT ["java","-jar","/app.jar"]
```
```shell script
dock build -t aix-dubbo-backend:1.3 .
```
### 2.编译jar包
修改aix.properties中的编译选项,Maven会自动打包上传至服务器对应文件夹,生成alpha测试包或beta测试包
### 3.运行容器

##### 207 beta测试
```shell
dock run -d -p 8081:8081 --name aix-spring-backend-beta --restart=always \
-v /nfs2/aix-container/web_dubbo_backend/container-0.0.1-SNAPSHOT.jar:/app.jar \
aix-dubbo-backend:1.3
```

##### 205 alpha测试
```shell
dock run -d -p 8081:8081 --name aix-spring-backend-alpha --restart=always \
-v /nfs/aix-container/web_dubbo_backend/container-0.0.1-SNAPSHOT.jar:/app.jar \
aix-dubbo-backend:1.3
```
