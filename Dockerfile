# Etapa 1: Build
FROM gradle:7.5-jdk17 AS build
WORKDIR /app

# Copia apenas arquivos do Gradle primeiro (para aproveitar cache)
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

# Baixa dependências (gera cache Gradle)
RUN ./gradlew build -x test --no-daemon || return 0

# Agora copia o restante do código
COPY . .

# Build do projeto (gera o .jar)
RUN ./gradlew clean build -x test --no-daemon

# Etapa 2: Runtime
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copia o jar gerado
COPY --from=build /app/build/libs/*.jar usuario.jar

# Expõe a porta
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "usuario.jar"]
