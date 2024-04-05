FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /land
COPY . .
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean bootJar

FROM eclipse-temurin:17-jre-alpine AS run
#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} app.jar
COPY --from=build /land/build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
