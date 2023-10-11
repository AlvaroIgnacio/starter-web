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

Esto genera una imagen en 
docker.io/library/starter-web:0.0.1-SNAPSHOT 
que se puede ejecutar con
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

# Construyendo contenedores con Docker

## Contenedor para el Jar

Podemos crear un contenedor Docker para el jar generado en primer término usando el comando

docker build -f Dockerfile.jvm --build-arg APP_FILE=starter-web-0.0.1-SNAPSHOT.jar -t starter-web:jvm1 .

Esto genera una imagen de aprox 186MB
Se puede ejecutar con

docker run --rm --name graal -p 8080:8080 starter-web:jvm1

que arranca en 1.048 segundos aprox. 

## Contenedor para el ejecutable (Linux)
En Linux podemos crear un contenedor para el ejecutable creado en pasos previos con el comando:

docker build -f Dockerfile.native --build-arg APP_FILE=starter-web -t starter-web:native1 .

Esto genera un contenedor de aprox. 80 MB, que se puede ejecutar con

docker run --rm --name native -p 8080:8080 starter-web:native1

Arranca en 0.03 segundos aprox., un tiempo mucho menor que el del contenedor para jar.


## Contenedor para el ejecutable (Windows y Mac)

Podemos crear un contenedor para el ejecutable creado en pasos previos con el comando:

docker build -f Dockerfile --build-arg APP_FILE=starter-web -t starter-web:native2 .

Esto genera una imagen de aprox 190MB, que se puede ejecutar con

docker run --rm --name native2 -p 8080:8080 starter-web:native2

que arranca en 0.023 segundos aprox., un tiempo mucho menor que el del contenedor para jar.
 

### Reference Documentation
For further reference, please consider the following sections:
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html)
* [GraalVM Demos - Spring Native Image](https://github.com/graalvm/graalvm-demos/tree/master/spring-native-image)


