package cleancode.studycafe.tobe.model.order;

import static org.assertj.core.api.Assertions.assertThat;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafePassOrderTest {

    @DisplayName("이용권의 할인 금액을 알 수 있다.")
    @Test
    void getDiscountPrice() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);
        int discountPrice = order.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo(105000);
    }

    @DisplayName("사물함을 사용할 경우, 이용권의 총 할인 금액을 알 수 있다.")
    @Test
    void getTotalPrice() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);
        int totalPrice = order.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(625000);
    }

    @DisplayName("이용권 타입을 알 수 있다.")
    @Test
    void getSeatPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

        // then
        assertThat(order.getSeatPass()).isEqualTo(seatPass);
    }

    @DisplayName("사물함을 사용할 경우, 이용권 타입을 알 수 있다.")
    @Test
    void getLockerPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

        // then
        assertThat(order.getLockerPass()).isNotNull();
        assertThat(order.getLockerPass().get()).isEqualTo(lockerPass);
    }
}
