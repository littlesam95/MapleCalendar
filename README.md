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
     <img style="width: 150px; margin: 8px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/b21b093c-6897-4941-8562-e56f3e28b57c">
  </p>

#### 특정 날짜에 진행할 이벤트 확인
 - 달력의 특정 날짜를 클릭해 진행하는 이벤트를 확인하자.
  <p>
     <img style="width: 150px; margin: 8px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/94d22044-c8cf-4379-af7c-44c24338f615">
  </p>

#### 이벤트 알리미로 당일 종료되는 이벤트 확인
 - 매일 00시마다 당일 종료되는 이벤트의 개수를 알림받자.
  <p>
     <img style="width: 150px; margin: 8px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/f370d34f-da7b-436c-b634-0029396df5bf">
  </p>

#### 특정 캐릭터의 상세 정보(종합 능력치 및 장비) 확인
 - 정보가 궁금한 캐릭터의 종합 능력치와 장비를 확인해보자.
  <p>
     <img style="width: 150px; margin: 8px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/575efbbb-6687-4c3a-b7c9-e227e633e203">
     <img style="width: 150px; margin: 8px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/130258a6-979f-4079-8492-7e1b8c10c805">
     <img style="width: 150px; margin: 8px" src="https://github.com/littlesam95/MapleCalendar/assets/55424662/f7dd12f9-bf66-4e22-b6f1-6cf0eb324e7b">
  </p>


### ⚒ 기술스택
| Category     | TechStack                                                                |
|--------------|--------------------------------------------------------------------------|
| Architecture | MVVM                                                                     | 
| Network      | Retrofit, OkHttp, Moshi                                                  | 
| DI           | Hilt                                                                     |
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

#### 3. Clean Architecture
 - UI Layer
   - UI Layer는 Domain Layer에서 작성한 비즈니스 로직의 UseCase를 의존하여 사용하는 역할을 한다.
   - 따라서 Domain Layer에 의존하게 된다.
   - Repository에 의존했었던 ViewModel은 Domain Layer의 UseCase에 의존하여, 사용자가 App을 사용하면서 수행할, Domain Layer에 정의된 모든 동작을 그저 사용하기만 하면 된다.
 - Domain Layer
   - Domain Layer의 특징으로는, 어떠한 Layer에도 의존하지 않는다는 것이며 그에 따라 Kotlin 코드로만 작성하게 된다. 또한 gradle에 다른 모듈에 대한 참조를 추가할 필요가 없게 된다.
   - Domain Layer에서는 UI을 그려내기 위해 사용할 Entity, 그리고 Entity를 통해 원하는 데이터를 가져오기 위한 Repository Interface, 마지막으로 UseCase로 구성되어 있다.
   - UseCase
     - 서비스를 사용하고 있는 User가 해당 서비스로 무언가를 하는 것을 UseCase라고 한다.
       - 예를 들면 어떤 앱을 켜서 로그인을 하거나, 어떤 상품 정보를 보거나 하는 등 서비스에서 수행하고자 하는 모든 것들이 UseCase가 될 수 있다.
     - Screaming Architecture : 어떤 서비스를 제공하는지 직관적으로 파악이 가능하도록 하는 Architecture이며, Android에서는 ViewModel이 어떤 UseCase에 의존하도록 구현함으로써 해당 ViewModel이 어떤 기능을 제공하는지를 직관적으로 알 수 있도록 한다.
     - 또한, UseCase에 의존하기 때문에 Repository에 직접 의존하지 않게 된다. UseCase에서 직접 Repository에 의존하여 비즈니스 로직을 갖게 되고, ViewModel은 의존하고 있는 UseCase 내부에 작성된 비즈니스 로직을 그대로 사용하기만 하면 되는 것이며, 이렇게 의존성을 줄임으로써 특정 로직에 대한 수정을 최소화할 수 있게 된다.
     - UseCase는 이름만 봐도 어떤 역할을 수행하는지를 알 수 있도록 명시하여야 한다.(예를 들면 로그인을 한다는 UseCase라면 LoginUseCase)
     - Repository 내부의 메소드를 호출하기만 하는 UseCase의 경우 invoke()라는 메소드를 작성함으로써 Class명만으로 호출하도록 할 수 있으며, UseCase 내부에서 많은 로직을 구현해야 하는 경우 execute() 메소드를 새로 정의한다.
 - Data Layer
   - Data Layer에서는 서버와의 통신 로직인 api, 데이터 클래스인 model, 그리고 Domain Layer에서 선언한 Repository Interface를 상속받은 RepositoryImpl과 API 등을 통해 데이터를 CRUD하는 DataSource로 구성되어 있다.
   - 여기서 API에 맞춰 구현하는 DataSource가 RemoteDataSource이다.

#### 4. Hilt
 - **의존성 역전 원칙**에 따른 프로그래밍을 위한 라이브러리로 Hilt를 사용하였다.
 - Hilt는 Dagger보다도 사용하기 쉽게 간소화되어있으며, Android 클래스에 최적화되어있다는 특징이 있다.
 - Hilt는 다음과 같은 방식으로 작동한다.
   - 가장 먼저 MainApplication에 @HiltAndroidApp 어노테이션을 지정한다. 해당 App은 의존성을 제공하는 Component의 역할을 하게 된다.
   - @InstallIn(SingletonComponent::class) 어노테이션을 지정함으로써 App 전역에서 하나의 인스턴스 형태로 사용할 것임을 나타내고, @Module 어노테이션을 지정함으로써 모듈을 생성하여 Component 역할을 하는 Android App에 저장할 수 있게 되고, Android App에 저장한 만큼 Android의 생명주기 동안 사용할 수 있게 된다.
   - @Provides 어노테이션을 지정한 모듈 내 메소드는 종속성을 제공하고 Hilt에 의해 주입될 수 있도록 한다.
   - Android의 Component에는 @AndroidEntryPoint 어노테이션을 지정하여 Hilt가 해당 클래스의 종속성을 주입할 수 있도록 한다.
   - @Inject 어노테이션을 지정한 생성자에 대한 인스턴스를 Hilt가 자동으로 주입하게 된다.

#### 5. Custom View로 스타포스 달아주기
 - 스타포스 View를 RecyclerView로 구현할 방법을 찾지 못 해서 Custom View를 사용하게 되었다.
   - 일단 스타포스는 별 간의 위치가 일정하지 않으며 간격도 다르다.
   - 따라서 RecyclerView로 구현하기에는 무리가 있다고 판단하였다.
 - 스타포스를 나타내는 별의 ViewGroup을 먼저 정의하고, 미리 정의한 속성을 바탕으로 ViewGroup에 추가해야 할 View의 최대 개수를 바탕으로 width와 height를 측정한다.
   - 여기서 5번째 View와 6번째 View 간의 간격이 조금 존재하기 때문에 View의 width의 절반만큼 ViewGroup의 width를 늘린다.
 - 아이템의 스타포스를 바탕으로 추가해야 할 노란 별과 회색 별의 개수를 정한다.

#### 6. ViewPager2와 TabLayout으로 프리셋을 좌우 스와이프로 확인하기
 - 하이퍼 스탯, 어빌리티 UI를 포함한 DialogFragment 내부에 ViewPager2와 TabLayout을 배치하였다.
 - ViewPager2에 사용할 Fragment 내부에 RecyclerView를 배치하여, List 형태의 프리셋 데이터를 RecyclerView Adapter로 보여준다.
 - ViewPager2와 TabLayout을 TabLayoutMediator로 연결하여 좌우 스와이프를 하면 프리셋 버튼의 상태도 바뀌고, 프리셋 버튼을 터치하면 좌우 스와이프 애니메이션으로 프리셋 화면을 바꾸도록 구현하였다.

### Document
<a href="https://www.notion.so/MapleCalendar-93f45dc10b384d749e5ab00950324035?pvs=4">
  <img alt="Static Badge" src="https://img.shields.io/badge/Notion-%2523000000.svg?style=for-the-badge&logo=notion&logoColor=white&labelColor=black&color=black">
</a>