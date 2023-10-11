# Starter web
Proyecto para construir un ejecutable usando GraalVM
Se trata de un proyecto de webservice que expone un endpoint "hola", sin parámetros.
La respuesta que se envía es "Hola a todos!"

# Ejecutando usando un jar

## Construcción del jar
./mvnw clean package
Esto deja un jar ejecutable en la carpeta target

## Ejecutar el jar
java -jar target/starter-web-0.0.1-SNAPSHOT.jar
Esto levanta un microservicio en el puerto 8080

al cual se puede acceder con
curl http://localhost:8080/hola

La aplicación arranca en 
Started StarterWebApplication in 1.16 seconds (process running for 1.513)

# Construyendo un ejecutable nativo

## Usando Maven
./mvnw -Pnative spring-boot:build-image

Esto genera una imagen en docker.io/library/starter-web:0.0.1-SNAPSHOT que se puede ejecutar con
docker run --rm -p 8080:8080 docker.io/library/starter-web:0.0.1-SNAPSHOT
Esto levanta un microservicio en el puerto 8080 al cual se puede acceder con
curl http://localhost:8080/hola

## Usando Native Build Tools
./mvnw -Pnative native:compile
Esto produce un ejecutable en la carpeta target que podemos ejecutar con
target/starter-web
Esto levanta un microservicio en el puerto 8080 al cual se puede acceder con
curl http://localhost:8080/hola

Notar que la aplicación arranca en un tiempo drásticamente menor a la versión con jar ejecutable.
Started StarterWebApplication in 0.032 seconds


docker build -f Dockerfiles/Dockerfile.native --build-arg APP_FILE=benchmark-jibber -t jibber-benchmark:native.0.0.1-SNAPSHOT .

### Reference Documentation
For further reference, please consider the following sections:
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html)
* [GraalVM Demos - Spring Native Image](https://github.com/graalvm/graalvm-demos/tree/master/spring-native-image)


