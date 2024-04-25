# 🍄 메이플 캘린더

> "오늘 진행하는 이벤트가 뭐지? 이벤트가 너무 많아서 모르겠네…"
>

### 그런 메붕이들을 위한 이벤트 일정 알리미, 메이플 캘린더
- 수많은 이벤트 일정을 한 눈에 확인하자
- 오늘 무슨 이벤트가 종료되는지 알림받자
- 특정 날짜에 무슨 이벤트가 있는지 숙지하자
- 그 외에 간단하게 내 캐릭터의 현재 상태를 알아보자
  <p align="center">
     <img style="width: 200px; margin: 10px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/24366045-4458-4fbc-8af2-de22f6d671bd">
     <img style="width: 200px; margin: 10px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/38f9c0f2-5605-46dc-b24f-259c88cbca8c">
     <img style="width: 200px; margin: 10px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/cfceb1e4-98bc-47b0-ace5-34f9048a09a9">
     <img style="width: 200px; margin: 10px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/d9f54460-12a7-45f5-9904-0e0a881e0ccc">
  </p>

### 구글 플레이스토어에서 내부 테스트 가능
 - 내부 테스트 접속 링크
   <p>
      <img width=150 src="https://github.com/littlesam95/MapleCalendar/assets/55424662/169944e3-eb32-4182-a2b2-70102d1a8735">
   </p>

### 📒 주요 기능
#### 오늘 진행중인 이벤트 확인
 - 이벤트를 클릭하면 공식 홈페이지로 이동된다.
  <p>
     <img style="width: 150px; margin: 8px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/22d951b7-1c25-435d-a578-8c6fce326291">
  </p>

#### 특정 날짜에 진행할 이벤트 확인
 - 달력의 특정 날짜를 클릭해 진행하는 이벤트를 확인하자.
  <p>
     <img style="width: 150px; margin: 8px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/6eff9a08-95e7-44a6-ae18-9c3a14aa6946">
  </p>

#### 이벤트 알리미로 당일 종료되는 이벤트 확인
 - 매일 00시마다 당일 종료되는 이벤트의 개수를 알림받자.
  <p>
     <img style="width: 150px; margin: 8px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/95702161-c9c1-4845-b2b7-d9d216f4cf47">
  </p>

#### 특정 캐릭터의 상세 정보(종합 능력치 및 장비) 확인
 - 정보가 궁금한 캐릭터의 종합 능력치와 장비를 확인해보자.
  <p>
     <img style="width: 150px; margin: 8px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/634f896a-ac54-4ad9-baf4-829b984a9bf5">
     <img style="width: 150px; margin: 8px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/130258a6-979f-4079-8492-7e1b8c10c805">
  </p>


### ⚒ 기술스택
| Category     | TechStack                                                                |
|--------------|--------------------------------------------------------------------------|
| Architecture | MVVM                                                                     | 
| Network      | Retrofit, OkHttp, Moshi                                                  | 
| Asynchronous | Coroutines                                                               | 
| Jetpack      | DataBinding, Navigation, Fragment, Lifecycle, Material Design Components | 
| Image        | Coil                                                                     | 
| Notification | AlarmManager with BroadcastReceiver                                      |
| CI/CD        | Firebase App Distribution, Google Play Store                             |
| Logging      | Timber                                                                   | 

### 💬 기술적 고민과 선택
#### 1. AlarmManager with BroadcastReceiver
 - Service와 BroadcastReceiver로 앱이 켜져 있을 때뿐만 아니라 백그라운드 상태에서도, 앱이 꺼진 상태에서도, 심지어 기기가 잠금인 상태에서도 매일 00시에 거의 정확하게 알림을 받을 수 있도록 하였음.
 - AlarmManager의 setAlarmClock()과 PendingIntent를 정의해서 매일 00시에 BroadcastReceiver를 호출하고, BroadcastReceiver에서 NotificationManager를 정의하고 notify()로 알림을 보낼 수 있도록 하였음.
 - 하지만 setAlarmClock()은 반복이 불가능했고, 반복 알람을 구현하기 위해 onReceive()에서 다시 다음 날 00시에 알림을 예약하는 방식을 사용하였음.

#### 2. Calendar with Custom View
 - 좌우 스와이프가 되는 달력 View를 만들기 위하여 ViewPager2를 사용하였음.
 - ViewPager2에 사용할 Fragment는 연월을 나타내는 TextView와, 달력 UI를 나타내는 Custom ViewGroup으로 구성되어 있음.
 - ViewGroup은 요일이나 날짜를 나타내는 View들로 구성되어 있고, ViewGroup에서 요일 및 날짜를 나타내는 View의 layout을 구성함.
 - 요일 View는 회색 배경으로 이루어져 있고, 날짜 View는 터치가 가능하고 터치 시 해당 날짜를 캐릭터 조회 날짜로 초기화함.
   - View를 터치할 때 MotionEvent를 관찰하며, 터치 시작 시 해당 View의 배경색이 바뀌며 손가락을 떼거나 부모 View가 터치 이벤트를 가져가기 전까지 유지됨.

### References
<a href="https://www.notion.so/MapleCalendar-93f45dc10b384d749e5ab00950324035?pvs=4">
  <img alt="Static Badge" src="https://img.shields.io/badge/Notion-%2523000000.svg?style=for-the-badge&logo=notion&logoColor=white&labelColor=black&color=black">
</a>