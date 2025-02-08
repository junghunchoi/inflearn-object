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
리팩토링 규칙
데이터의 getter를 사용해서 판단하고 결정하는 로직을 그 데이터로 옮겨라

도메인 클래스의 로직을 통해 객체의 상태를 변경하고, 객체의 상태를 통해 다시 로직을 실행하는 방식으로 설계한다.

캡슐화의 진정한 의미를 고민하라


----

