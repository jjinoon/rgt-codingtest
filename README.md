# rgt-codingtest

## 개발환경
SpringBoot, Java 17, Gradle, Mysql

## 1. REST API
src/main/java/com/codingtest/rgt/order/controller/OrderController.java

```
### 주문 조회
GET ec2-3-37-89-125.ap-northeast-2.compute.amazonaws.com:8080/codingTest/order


### 주문 저장
POST ec2-3-37-89-125.ap-northeast-2.compute.amazonaws.com:8080/codingTest/order
Content-Type: application/json

{
  "orderId": "0009",
  "productName": "카페테리아",
  "options": "",
  "tableNo": 3,
  "quantity": 1,
  "orderDate": "2023-08-01",
  "orderTime": "20:11:28",
  "dateTime": "2023-08-01 20:11:28",
  "robotStatus": "",
  "dong": "120",
  "ho": "1701",
  "seq": "23071701000074",
  "ordererName": "홍길동"
}
```

## 2. 중복 데이터 처리 및 데이터 수정
src/test/java/com/codingtest/rgt/RgtApplicationTests.java

## 3. Google OAuth 2.0 로그인
src/main/java/com/codingtest/rgt/account/controller/AccountController.java

호출 결과
<img width="1222" alt="image" src="https://github.com/jjinoon/rgt-codingtest/assets/133078696/24586bdd-bd26-4f9e-b486-e46b77ea3b61">
