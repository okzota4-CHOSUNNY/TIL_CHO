```java
list, ArrayList란?
1. List의 선언과 생성(기차 만들기를 예로듬)
   ArrayList란? 데이터의 개수에 따라 자동으로 크기가 늘어나는 가변 배열
List<Human> humans = new ArrayList<>();
// 해석: Human 타입의 객체들을 담을 수 있는 리스트 humans를 ArrayList로 생성
// new ArrayList<>() : 실제로 사람을 태울 수 있는 칸이 있는 기차를 만들어!
// ArrayList란? 자바에서 제공하는 List 인터페이스를 구현한 가장 대표적인 클래스
1. 핵심 기능(add, get, size, remove)
List<Human> humans = new ArrayList<>();
 2-1. add: 사람 태우기(객체 추가)
      humans.add(new Human("철수"));
 2-2. get: 사람 확인하기(객체 조회)
      Human h = humans.get(0); // 자바는 0부터 시작
 2-3. size: 사람 수 확인하기(리스트 크기 조회)
      int count = humans.size(); // 현재 기차탑승 인원 체크 
 2-4. remove: 사람 내리기(객체 삭제)
      humans.remove(0); // 0번째 사람 내리기

```java
예시코드
1. 리스트 생성
List<String> list = new ArrayList<>();

2. 데이터 추가(뒤에 붙이기)
list.add("게시글1");
list.add("게시글2");

3. 특정 위치에 끼워넣기
list.add(1, "중간에 끼워넣기"); // 인덱스 1번 자리에 삽입

4. 데이터 조회
String title = list.get(0); // 인덱스 0번 데이터 조회

5. 데이터 수정
list.set(0, "수정된 제목"); // 인덱스 0번 데이터 수정

6. 데이터 삭제
list.remove(1); // 인덱스 1번 데이터 삭제

?어떤경우는 new를 붙이고 어떤경우는 안붙이나?
- new를 쓰지 않는경우 문자방식(리터럴) 지원 타입
종류: String, Integer, Long, Double, Boolean 등 기본형 래퍼 클래스
이유: 자바 언어 차원에서 " "혹은 숫자 값을 객체로 자동 변환해주는 기능제공하기 때문
예시:
1. List<String> list = new ArrayList<>();
    list.add("게시글1"); // " "안의 값 자체가 데이터이므로 new 불필요
2. List<Integer> list2 = new ArrayList<>();
    list2.add(100); // 숫자값 자체가 데이터이므로 new 불필요

new를 붙여야 하는 경우
- 사용자 정의 객체(Class)
종류: Board, User, Product 등 개발자가 직접 만든 클래스
이유: 자바 언어 차원에서 자동 변환 기능을 제공하지 않기 때문
예시:
1. List<Human> humans = new ArrayList<>();
    humans.add(new Human("철수")); // Human 객체를 생성해야 하므로 new 필요
2. List<Product> products = new ArrayList<>();
    products.add(new Product("노트북, 1500000")); // Product 객체를 생성해야 하므로 new 필요

```
