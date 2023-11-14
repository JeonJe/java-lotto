## 1단계 - 문자열 계산기
### 기능 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기 구현해야 한다.
- [x] 사용자에게 입력을 받는다.
  - [x] 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException을 발생시킨다.
  - [x] 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
  - [x] 문자열을 분리할 때는 split 메소드를 활용한다.
- [x] 사칙연산 기호가 아닌 경웅 IllegalArgumentException을 발생시킨다.
- [x] 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
- [x] 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.

### 클래스 설계
- [x] 계산기

- [x] 입력