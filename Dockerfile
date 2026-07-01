# 1. Java 17 환경의 가벼운 리눅스 이미지 사용
FROM eclipse-temurin:24-jdk-alpine

# 2. 빌드 시 생성되는 jar 파일 경로 지정
ARG JAR_FILE=build/libs/*-SNAPSHOT.jar

# 3. jar 파일을 컨테이너 내부로 app.jar라는 이름으로 복사
COPY ${JAR_FILE} app.jar

# 4. 컨테이너 시작 시 실행할 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]