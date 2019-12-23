package za.co.chrispie.demo.vending.machine.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserInteraction {

    private BigDecimal moneyDeposited = BigDecimal.ZERO;

    public BigDecimal depositMoney(final BigDecimal money) {
        moneyDeposited = moneyDeposited.add(money);
        return moneyDeposited;
    }

    public void setMoneyDeposited(final BigDecimal moneyDeposited) {
        this.moneyDeposited = moneyDeposited;
    }

    public BigDecimal getMoneyDeposited() {
        return moneyDeposited;
    }

    public void reset() {
        moneyDeposited = BigDecimal.ZERO;
    }

    public Boolean deductPurchaseAmount(final BigDecimal amount) {
        //In real life scenario double lock needs to be implemented in multithreaded env
        moneyDeposited = moneyDeposited.subtract(amount);
        return true;
    }
}
