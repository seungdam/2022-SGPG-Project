# 2022 스마트폰 게임 프로그래밍 텀프로젝트

## - High Concept
* 픽셀 로그라이크 모바일 RPG 게임인 가이더스의 모작으로 버튼 컨트롤을 통해 랜덤한 배치 구조의 스테이지 내에 구현된 장애물을 피해가며 배치된
몬스터를 쓰러뜨리고 게임을 클리어하자.
* 몬스터를 처치할시 드랍되는 열쇠를 통해 보물방에 입장하여 플레이어를 더욱 강화시키는 아이템을 얻을 수 있음.


## - 핵심 메커니즘
* 버튼 컨트롤을 통해 플레이어의 기본적인 이동을 수행
* 플레이어가 이동 중 적과 조우했을 경우 버튼 컨트롤 클릭 시 이동이 아닌 공격을 수행함.
* 한 버튼을 꾹 누르면 차지하여 더 큰 데미지를 입힘.
* 여러 단계로 구성된 스테이지의 화면을 뷰 기능을 이용해 원할하게 변경이 가능함.


## - 주요 개발 요소

* 버튼 컨트롤을 이용한 플레이어의 이동과 차지 공격을 구현
* 원거리와 근거리 스타일의 플레이어를 구현
* 플레이어를 방해하는 함정들 (화살 혹은 가시가 박힌 타일 등)로 구성된 약 7 x 7 타일 사이즈의 스테이지을 디자인
* 몬스터와 플레이어의 충돌 체크를 통한 데미지 처리
* 2~3가지의 공격패턴을 가진 보스 몬스터의 구현
* 몬스터 사냥시 드랍되는 아이템과 보물방에서 흭득 가능한 플레이어 패시브를 구현
* 스테이지 클리어시 화면 변경


## - 게임 흐름
![image](https://user-images.githubusercontent.com/51450544/160407345-b4be1acb-9dc6-4e71-8e93-b56997392c31.png)



## - 인게임 이미지
![image](https://user-images.githubusercontent.com/51450544/160409639-30e43d41-efd4-4b76-a139-a97290277a7c.png)


## - 개발일정

* 1주차 :  리소스 제작 및 화면 UI 디자인과 플레이어의 이동 구현
* 2주차 : 맵의 레벨링 디자인과 스테이지 클리어 시 화면 전환 기능 구현 
* 3주차 : 플레이어와 타일간의 충돌 체크
* 4 - 5주차 : 일반 몬스터와 보스 몬스터의 구현
* 6 - 7주차 : 플레이어와 몬스터간의 충돌체크 및 공격 시스템 구현
* 8주차 : 각종 아이템 구현 및 아이템 드랍 시스템 구현
* 9주차 : 디버깅 

