
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM amazoncorretto:8
MAINTAINER Grippo_Miguel
COPY target/portfolio.jar portfolio.jar
ENTRYPOINT ["java","-jar","/portfolio.jar"]
