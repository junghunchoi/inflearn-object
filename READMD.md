[2025.02.08]

영화 예매 도메인을 통해 객체지향에 대해 학습을 진행합니다.<br/>
일반적인 mvc 패턴을 사용하여 결제 및 예약을 확인합니다. <br/>

```
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




필드의 모호성을 개선할 수 있는 방법은 아래와 같을 때

