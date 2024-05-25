FROM shoothzj/compile:jdk17-mvn AS build
COPY . /opt/compile
WORKDIR /opt/compile
RUN mvn clean package -DskiptTests

FROM baseimage:v1.1

WORKDIR /opt/smart-home

ENV HOME_DIR /opt/smart-home

COPY ./smart-starter/target/smart-start*.jar ./smart-home.jar
COPY ./smart-starter/target/lib ./lib
COPY ./script ./script

RUN sed -i 's/\r//' script/start.sh

CMD ["/opt/smart-home/script/start.sh", "run"]