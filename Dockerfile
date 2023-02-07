<<<<<<< HEAD
FROM openjdk:17
=======
FROM openjdk:11
>>>>>>> branch 'master' of https://github.com/newvikram22/testapi.git
EXPOSE 8090
ADD target/restapidemo.jar restapidemo.jar
ENTRYPOINT [ "java","-jar","restapidemo.jar" ]