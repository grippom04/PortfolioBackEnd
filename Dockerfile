
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM amazoncorretto:8-alpine-jdk
MAINTAINER Grippo_Miguel
ADD target/portfolio.jar portfolio.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/portfolio.jar"]
