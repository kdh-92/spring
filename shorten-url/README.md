# 문제 & 설계 범위
- url이 주어지면 단축 URL을 결과로 제공
  - 단축 URL에 접속하면 원래 URL로 갈 수도 있어야 한다.
- 트래픽 규모 : 매일 1억 개의 단축 URL 생성
## 단축 URL
- 길이 : 최대한 짧게
- 포함될 문자 제한 : 숫자(0 ~ 9), 영문자(a-zA-Z)
- 갱신이나 삭제되지 않는다.
- 10년 동안 매일 1억개 데이터 => 1억 x 365 x 10 => 3650억 (저장 용량 : 100바이트 기준 36.5TB)
  - base 62를 이용해 62^7이면 위 데이터를 처리할 수 있다.
---

### 조회 및 저장 성능 향상으로 생각해본 방법
- DB : mongoDB, redis 사용
  - 데이터 누적 : mongoDB
  - 조회 : mongoDB -> redis
    - 데이터 없을 시 redis 에 저장
  - 매일 특정 시간 batch or scheduler 통해 redis 데이터 mongoDB에 저장

# Url 테이블 설계
- originalUrl : 고유한 값일 것이라 생각하여 id로 설정

## 위 설계 고려사항
- URL 길어지면 인덱싱 효율 감소
  - id - @GeneratedValue로 두고 originalUrl, shortenUrl은 Unique 설정
- Join 연산 필요해지면 성능적으로 문제있을 수 있음
