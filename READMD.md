[2025.02.08]

영화 예매 도메인을 통해 객체지향에 대해 학습을 진행합니다.<br/>
일반적인 mvc 패턴을 사용하여 결제 및 예약을 확인합니다. <br/>

```java
private DiscountCondition findDiscountCondition(Screening screening, List<DiscountCondition> conditions) {
        for(DiscountCondition condition : conditions) {
            if (condition.isPeriodCondition()) {
                if (screening.isPlayedIn(condition.getDayOfWeek(),
                                         condition.getStartTime(),
                                         condition.getEndTime())) {
                    return condition;
                }
            } else {
                if (condition.getSequence().equals(screening.getSequence())) {
                    return condition;
                }
            }
        }

        return null;
    }
```
위의 코드에서 condition의 정의된 값들이 추가되면 프로세스(서비스)가 반드시 수정되어야합니다.<br/>
이러한 


필드의 모호성을 개선할 수 있는 방법은 아래와 같을 때 사용할 수 있다


```java
    private LocalTime startTime;
    private LocalTime endTime;
    -> 아래와 같이 클래스를 생성한 후 사용한다.
    private Interval interval;
    
    public class Interval {
        private LocalTime startTime;
        private LocalTime endTime;
        
        
    }
    
```

필드를 private로 만들었다 한들 getter, setter를 사용하면 외부에\\ 접근이 가능하다. <br/>
처음 설계할 떄 데이터가 어떻게 사용될지 모르기 때문에 public 으로 데이터를 노출시킬 수 밖에 없다.

따라서 변경하기 쉬운 설계를 만들기 위해서는
데이터 변경으로 인한 파급효과를 막는것이다.

즉, 데이터를 사용하는 프로세스를 데이터 내부로 이동한다 (DDD)

----
<h2>리팩토링 규칙</h2>

데이터의 getter를 사용해서 판단하고 결정하는 로직을 그 데이터로 옮겨라

도메인 클래스의 로직을 통해 객체의 상태를 변경하고, 객체의 상태를 통해 다시 로직을 실행하는 방식으로 설계한다.

캡슐화의 진정한 의미를 고민하라

DiscountPolicy -> ReservationService <- DiscountCondition

위의 구조에서 

 ReservationService -> DiscountPolicy ->  DiscountCondition

로 이어질 수 있도록 의존성을 줄여야한다.

----

협력에 필요한 행동을 먼저 결정하고
행동에 적합한 객체를 나중에 선택하라

-> 데이터는 변하기 너무 쉬운 조건이다. 따라서 좀 더 추상적인 행동 즉, 메소드를 통해
데이터 변경에도 변함없이 동작할 수 있도록 설계해야한다.


----
할인정책에서
1. 비율할인
2. 정액할인
인 경우 할인한다는 행동은 동일하지만 서로 다른 행동을 하기에 같은 클래스에 두긴 응집도가 떨어질 수 있다.
이러한 경우 다형적인 메세지를 이용해서 행동이 변하는 타입들에게 각 행동을 다루기 위한 책임을 할당하자.

----

객체지향 설계 순서
협력에 필요한 <b>행동</b>을 <b>먼저</b> 결정하고 행동에 적합한 객체를 나중에 선택하라
-> 객체의 <b>행동</b>을 <b>먼저</b> 구현하고 행동에 필요한 <b>데이터</b>를 <b>나중</b>에 결정하라