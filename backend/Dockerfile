FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

## Docker commands:
# Build:
#docker build --build-arg JAR_FILE=build/libs/\*.jar -t todolist/backend .

# Build with tagged docker image:
#./gradlew bootBuildImage --imageName=todolist/backend

# Run docker image (production):
#docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t todolist/backend

# Run docker image (dev):
#docker run -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 -t todolist/backend

# Run with debugger:
#docker run -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p 8080:8080 -p 5005:5005 -t todolist/backend