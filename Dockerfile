FROM openjdk:11
EXPOSE 8090
ADD target/restapidemo.jar restapidemo.jar
ENTRYPOINT [ "java","-jar","restapidemo.jar" ]