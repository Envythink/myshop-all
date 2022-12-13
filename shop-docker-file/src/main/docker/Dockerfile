# 指定该镜像所依赖的基础镜像
FROM openjdk:8u102
# 指定镜像的维护人
MAINTAINER kenbings
# 将当前目录下的jar包复制到docker容器中的/目录下
ADD shop-docker-file-0.0.1-SNAPSHOT.jar /shop-docker-file.jar
# 容器在运行过程中创建一个名为shop-docker-file.jar的文件
RUN bash -c 'touch /shop-docker-file.jar'
# 声明服务暴露在8080端口
EXPOSE 8080
# 指定容器启动时执行的命令
ENTRYPOINT ["java","-jar","/shop-docker-file.jar"]