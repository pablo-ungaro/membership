FROM eclipse-temurin:19-jdk as builder
RUN addgroup membershipgroup; adduser  --ingroup membershipgroup --disabled-password membership
USER membership
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install


FROM eclipse-temurin:19-jdk
RUN addgroup membershipgroup; adduser  --ingroup membershipgroup --disabled-password membership
USER membership
WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/target/*.jar /app/*.jar
ENTRYPOINT ["java", "-jar", "/app/*.jar" ]