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

### 📒 주요 기능
#### 오늘 진행중인 이벤트 확인
 - 이벤트를 클릭하면 공식 홈페이지로 이동된다.
  <p>
     <img width=150 src="https://github.com/littlesam95/MapleCalendar/assets/55424662/22d951b7-1c25-435d-a578-8c6fce326291">
  </p>

#### 특정 날짜에 진행할 이벤트 확인
 - 달력의 특정 날짜를 클릭해 진행하는 이벤트를 확인하자.
  <p>
     <img width=150 src="https://github.com/littlesam95/MapleCalendar/assets/55424662/6eff9a08-95e7-44a6-ae18-9c3a14aa6946">
  </p>

#### 이벤트 알리미로 당일 종료되는 이벤트 확인
 - 매일 00시마다 당일 종료되는 이벤트의 개수를 알림받자.
  <p>
     <img width=150 src="https://github.com/littlesam95/MapleCalendar/assets/55424662/95702161-c9c1-4845-b2b7-d9d216f4cf47">
  </p>

#### 특정 캐릭터의 간단한 정보 확인
 - 이건 화면이 허전한 것 같아서 그냥 넣어봤다.
  <p>
     <img width=150 src="https://github.com/littlesam95/MapleCalendar/assets/55424662/634f896a-ac54-4ad9-baf4-829b984a9bf5">
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