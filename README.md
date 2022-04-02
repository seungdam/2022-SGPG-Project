# 2022 스마트폰 게임 프로그래밍 텀프로젝트

## - High Concept
* Steam 원작 게임 좋은피자 위대한 피자  모작으로, 손님의 요구에 맞는 피자을 요리하고 이를 판매하여
수익을 버는 타이쿤 형식의 게임을 개발.
* 게임 내 UI를 안드로이드 VIEW를 적절히 활용하여 PC버전보다 간소화하여 제작할 것임.


## - 핵심 메커니즘
* 피자를 제작하는 과정에서 필요한 모든 액션(토핑, 오븐에 굽기)은 드래그앤 드랍을 이용.
* 손님이 제시한 요구사항의 기준을 정하여 이에 따른 판매금액을 정함.


## - 주요 개발 요소

* 게임에 사용할  4가지 화면 대한 UI 디자인(카운터 , 주방 , 테이블 , 정산 화면)
 주방과 테이블은 하나의 긴 이미지 리소스를 백그라운드 로서 사용하여 하나의 레이어를 사용해 스크롤의 방식으로 구현할 예정입니다.
 
* 피자의 조리과정에 필요한 모든 액션을 드래그앤 드랍 식으로 구현 (토핑은 약 4~5가지 종류)
  여기서 필요한 터치나 드래그의 과정을 GAME VIEW의 매소드를 이용해 처리할 예정입니다.
  피자조리 : 토핑을 드래그해서 피자위에 디자인 할 수 있습니다.
  컷팅 : 화면을 터치한 후 이를 회전시킬때마다 커팅을 하기위한 직선의 선이 그려지게 됩니다.
  
* 손님의 컨디션과 요구사항 부합에 따른 지급 금액 산책
  컨디션 : 음식이 늦게 나올 수록 줄어듭니다.
  컨디션이 0이되면 손님이 그냥 가게를 나가게됨.
* 정산시 적자가 나는 경우 게임오버가 됩니다. 이 정산 화면의 경우 게임 시작화면과 같이  ACTIVITY를 통해 구현할 예정입니다.

## - 게임 흐름
![image](https://user-images.githubusercontent.com/51450544/160392016-0673aa74-0192-48d8-bd02-3f1c1f9aeb7e.png)


## - 인게임 이미지
![image](https://user-images.githubusercontent.com/51450544/160385280-88e63fb4-7eee-426b-ba8c-058581223f37.png)

## - 개발일정

* 1 주차 :  리소스 수집/제작 
* 2 주차 : 화면 UI 디자인 (게임 시작 버튼 , 종료 버튼 등)
* 3 주차 : 화면의 전환을 위한 스크롤 구현
* 4 주차 : 스테이지의 레벨 디자인 (얼마나 많은 손님이 올 것인가? 손님의 컨디션이 얼마나 나빠지는가)
* 5 - 7주차 : 조리과정에서 필요한 드래그앤 드랍 , 터치의 액션을 액티비티를 통해 구현 (커팅, 토핑 올리기 등)
* 8주차 : 피자에 대한 가격 산책 및 정산시스템 과
* 9주차 : 디버깅
