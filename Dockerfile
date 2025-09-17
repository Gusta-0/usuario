FROM gradle:7.5-jdk17-alpine AS build
WORKDIR /app

COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

RUN ./gradlew dependencies --no-daemon || return 0

COPY . .

RUN ./gradlew clean build -x test --no-daemon


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia apenas o jar final
COPY --from=build /app/build/libs/*-SNAPSHOT.jar usuario.jar

# Expor porta
EXPOSE 8080

# Rodar como usuário não-root
USER 1000:1000

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "usuario.jar"]
