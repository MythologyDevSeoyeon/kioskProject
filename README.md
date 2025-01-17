# kioskProject
내일배움캠프 Spring 5기 키오스크 만들기 개인 프로젝트 입니다.
<br><br><br>

## 목차
* [프로젝트 설명](#프로젝트-설명)
* [주요 기능](#주요-기능)
* [사용 방법](#사용-방법)
* [파일 구조](#파일-구조)
* [사용된 기술](#사용된-기술)
* [Contact](#contact)
<br><br><br>

## 프로젝트 설명
이 프로젝트는 자바 기반의 키오스크 시스템을 구현한 것입니다.
<br>애플리케이션은 키오스크를 통해 사용자가 메뉴를 확인하고 항목을 장바구니에 추가한 후 주문을 완료할 수 있도록합니다.
<br><br><br>

## 주요 기능
### 메뉴 관리
- **카테고리별 메뉴** : Hamburgers, Drinks, Desserts 등의 카테고리로 구성된 메뉴 제공
- **카테고리별 세부 메뉴** : 각 메뉴의 항목, 이름, 가격 설명을 제공
- **장바구니 메뉴** : 장바구니가 채워져 있을 때, 주문과 취소 메뉴 제공
### 장바구니 작업
- **항목 추가** : 선택한 메뉴 항목을 장바구니에 추가
- **항목 확인** : 장바구니에 추가된 항목을 확인
- **장바구니 비우기** : 진행 중인 주문을 취소하고 장바구니를 초기화
### 주문 처리
- **주문 확인** : 장바구니에 있는 항목과 총 금액 확인
- **주문 완료** : 주문을 확정하고 장바구니를 초기화
<br><br><br>

## 사용 방법
### 기본 사용 방법
1. 애플리케이션 실행
2. 메인 메뉴에서 카테고리 선택
3. 카테고리 내 항목 확인 및 장바구니 추가
4. 장바구니 확인 및 주문완료
5. 종료 선택시 애플리케이션 종료
   
```
[ Main Menu ]
1. Hamburgers     
2. Drinks         
3. Desserts       
0. 종료하기
메뉴를 선택하세요 : 1
[Hamburgers]
1. ShackBurger     | W 6.9  | 토마토, 양상추, 쉑소스가 토핑된 치즈버거 
2. SmokeShack      | W 8.9  | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거 
3. Cheeseburger    | W 6.9  | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거 
4. Hamburger       | W 5.4  | 비프패티를 기반으로 야채가 들어간 기본버거 
0. 뒤로가기
주문하실 항목을 선택하세요 : 1
== 1번 메뉴를 선택 하였습니다.
== ShackBurger     | W 6.9  | 토마토, 양상추, 쉑소스가 토핑된 치즈버거 
위 메뉴를 장바구니에 추가하겠습니까?
1. 확인      | 2. 취소 
1
ShackBurger이(가) 추가되었습니다.
[ Main Menu ]
1. Hamburgers     
2. Drinks         
3. Desserts       
 [ Order Menu ]
4. Orders       | 장바구니를 확인 후 주문합니다.
5. Cancel       | 진행중인 주문을 취소합니다.
0. 종료하기
메뉴를 선택하세요 : 4
[ Orders ]
ShackBurger     | W 6.9  | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
 [ Total ] 
W 6.9
1. 주문      | 2. 메뉴판
1
[ Orders ]
ShackBurger     | W 6.9  | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
 [ Total ] 
W 6.9
주문이 완료되었습니다. 총 금액은 W 6.9입니다.
[ Main Menu ]
1. Hamburgers     
2. Drinks         
3. Desserts       
0. 종료하기
메뉴를 선택하세요 : 0
키오스크를 종료합니다.
```
<br><br><br>

## 파일 구조
```
├── Level6
│   ├── Controller
│   │     ├── KioskController.java  # 컨트롤러: 로직 및 사용자 입력 처리
│   ├── Model
│   │     ├── Cart.java             # 모델: 장바구니 작업 관리
│   │     ├── Menu.java             # 모델: 메뉴 카테고리 관리
│   │     ├── MenuItem.java         # 모델: 개별 메뉴 항목 관리
│   ├── View
│   │     ├── KioskView.java        # 뷰: 사용자에게 메뉴 및 메시지 표시
│   ├── Main.java                   # 애플리케이션 시작
```
<br><br><br>

## 사용된 기술
<div align=center> 
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"> 
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
</div>

<br><br><br>

## Contact
질문이나 제안사항은 [@Seoyeon](https://github.com/MythologyDevSeoyeon)으로 연락주세요
<br><br><br>
