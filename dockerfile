# Usa la imagen de Amazon Corretto como base
FROM amazoncorretto:17-alpine-jdk

# Establece el directorio de trabajo
WORKDIR /sp32

# Copia el archivo pom.xml y el código fuente
COPY pom.xml .
COPY src ./src

# Instala Maven y construye el archivo JAR
RUN apk add --no-cache maven \
    && mvn clean package

# Copia el archivo JAR generado en la imagen final
COPY target/apisp32-0.0.1-SNAPSHOT.jar apisp32.jar

# Define el comando de entrada
ENTRYPOINT ["java", "-jar", "apisp32.jar"]
