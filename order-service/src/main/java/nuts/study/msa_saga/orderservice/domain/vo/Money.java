package nuts.study.msa_saga.orderservice.domain.vo;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public record Money(
        BigDecimal amount
) {

    public static Money zero() {
        return new Money(BigDecimal.ZERO);
    }

    public boolean isGreaterThan(Money money) {
        return this.amount != null && this.amount.compareTo(money.amount()) > 0;
    }

    public boolean isGreaterThanZero() {
        return this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public Money add(Money money) {
        return new Money(this.amount.add(money.amount()));
    }

    public Money subtract(Money money) {
        return new Money(this.amount.subtract(money.amount()));
    }

    public Money multiply(int multiplier) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(multiplier)));
    }
}
