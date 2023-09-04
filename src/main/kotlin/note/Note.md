## 주석

### 주석은 나쁜 코드를 보완하지 못함
- 코드에 주석을 추가하는 일반적인 이유는 코드의 품질이 나쁘기 때문
```
    // 직원에게 복지 혜택을 받을 자격이 있는지 검사
    if ((employee.flags == HOURLY_FLAG) && (employee.age > 65))

    if (employee.isEligibleForFullBenefits())
```

### 코드의 의도를 표현하라
- 코드만으로 의도를 설명하기 어려운 경우가 존재
- 법적인 주석
  - 회사가 정립한 구현 표준에 맞춰 법적인 이유로 특정 주석을 넣으라고 명시함
  - 저작권 정보와 소유권 정보는 필요함
  ```
  // Copyright (C) 2003, 2004 ~
  ``` 
- 정보를 제공하는 주석
  - 기본적인 정보를 주석으로 제공하면 편리함
  - 이 또한, 함수에 이름을 잘 지음으로써 해결 가능
- 의도를 설명하는 주석
  - 결정에 깔린 의도가 필요함
- 의미를 명료하게 밝히는 주석 
  - 라이브러리를 사용할 떄 명료한 이름을 사용하지 못하는 경우 간단하게 주석 사용
- 결과를 경고하는 주석
  - 다른 프로그래머에게 결과를 경고할 목적으로 주석을 사용
  - ex) 특정 테스트 케이스를 꺼야하는 이유를 설명
  - TODO 사용
- 중요성을 강조하는 주석