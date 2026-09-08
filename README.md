# simple-back
Spring Boot 4 기반의 간단한 사용자 조회 REST API 실습 프로젝트입니다.
## 기술 스택
![Java 17](https://img.shields.io/badge/Java-17-007396?logo=openjdk&logoColor=white) ![Spring Boot 4](https://img.shields.io/badge/Spring_Boot-4.1.1-6DB33F?logo=springboot&logoColor=white) ![Gradle](https://img.shields.io/badge/Gradle-Wrapper-02303A?logo=gradle&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white) ![Lombok](https://img.shields.io/badge/Lombok-BC4521?logoColor=white) ![Prometheus](https://img.shields.io/badge/Prometheus-E6522C?logo=prometheus&logoColor=white)

`ui`, `app`, `domain`, `infra` 계층으로 구성된 클린 아키텍처를 적용합니다.
설정은 12-Factor 원칙에 따라 환경변수를 사용하며 `local`, `prod`, `test` 프로필로 분리합니다.
`GET /`은 애플리케이션 상태를, `GET /users`는 JPA 기반 사용자 목록을 반환합니다.
MockMvc 슬라이스 테스트와 Gradle Wrapper 기반 실행 가능한 fat JAR 빌드를 지원합니다.

로컬 실행 전 `.env.example`을 `.env`로 복사하고 Aiven MySQL 연결 정보를 입력합니다.

```sh
cp .env.example .env
# .env에 연결 정보를 입력한 뒤 실행
./gradlew bootRun
```

기본 `local` 프로필은 프로젝트 루트의 `.env`를 자동으로 읽습니다. 파일은 Java properties 형식이므로 값에 따옴표나 `export`를 붙이지 않습니다.
`AIVEN_MYSQL_HOST`, `AIVEN_MYSQL_PORT`, `AIVEN_MYSQL_DB`, `AIVEN_MYSQL_USER`, `AIVEN_MYSQL_PASSWORD`를 모두 입력해야 하며, MySQL 연결에는 TLS를 사용합니다.
`.env`는 Git에 포함하지 않습니다.

운영 환경에서는 `SPRING_PROFILES_ACTIVE=prod`와 동일한 다섯 환경변수를 배포 환경에 설정합니다.
운영 프로필의 스키마 검증 기본값은 `validate`이므로 DB 스키마를 미리 준비해야 합니다.
# simple-back-ghcr
