# Domain Driven Design

---

`Order Service` 의 도메인 로직을 도메인 주도 설계의 패턴을 따라 구현하고자 한다. 
가장 먼저 주문을 처리하는 Aggregate를 정의하고, 그 안에 도메인 엔티티와 밸류 오브젝트를 배치한다.

## Aggregate Root: Order

Aggregate를 설계할 떄는 Aggregate Root를 먼저 정의하고, 그 안에 포함될 엔티리를 순차적으로 정의하는 것이 좋다.
Order Aggregate의 루트는 `Order` 엔티티이다. 

```java
   public class Order {

