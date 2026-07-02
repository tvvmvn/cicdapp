# 스프링 프로젝트 빌드 (jar 생성)
./gradlew clean build -x test

# Docker 이미지 빌드 (내 도커 허브 계정명과 이미지 이름 지정)
docker build -t tvvmvndocker/cicdapp:latest .

# 도커 허브 로그인
docker login

# 도커 이미지 보기 (도커 이미지로 직접 접근이 불가해)
docker images

# 이미지 업로드
docker push tvvmvndocker/cicdapp:latest

# Test
EC2에 올리기 전에 내 컴퓨터에서 먼저 컨테이너를 띄워봅니다. 
스프링 로그를 보면서 잘 켜지는지 확인하기 위해, 일단은 -d(백그라운드) 옵션 없이 실행해 보겠습니다.

docker run -p 8080:8080 tvvmvndocker/cicdapp

# 도커 허브에서 내가 빌드한 스프링 이미지 다운로드 (Pull)
docker pull tvvmvndocker/cicdapp:latest

# 백그라운드(-d)에서 8080 포트로 스프링 컨테이너 실행하기
docker run -d -p 8080:8080 --name spring-web-app tvvmvndocker/cicdapp:latest

# 컨테이너가 잘 떠 있는지 확인:
docker ps

# 스프링 부트 로그 확인하기 (에러가 나거나 안 켜질 때):
docker logs -f spring-web-app


# MySQL 설치하기
docker run -d \
  --name mysql-container \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=your_password \
  -v /mysql/data:/var/lib/mysql \
  --restart always \
  mysql:latest