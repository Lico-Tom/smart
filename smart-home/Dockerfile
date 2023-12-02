FROM shoothzj/compile:jdk17-mvn AS build
COPY . /opt/compile
WORKDIR /opt/compile
RUN mvn clean package -DskiptTests

FROM shoothzj/base:jdk17

WORKDIR /opt/smart-home

ENV HOME_DIR /opt/smart-home

COPY --from=build /opt/compile/smart-starter/target/smart-start*.jar ./smart-home.jar
COPY --from=build /opt/compile/smart-starter/target/conf /opt/paas-dashboard/conf
COPY --from=build /opt/compile/smart-starter/target/lib /opt/paas-dashboard/lib

CMD ["/opt/smart-home/script/start.sh", "run"]