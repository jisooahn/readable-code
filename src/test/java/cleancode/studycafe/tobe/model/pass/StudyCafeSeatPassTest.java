package cleancode.studycafe.tobe.model.pass;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeSeatPassTest {

    @DisplayName("고정석 이용권은 사물함을 사용할 수 있다.")
    @Test
    void canUseLocker() {
        // given
        StudyCafePassType passType = StudyCafePassType.FIXED;

        // when
        boolean lockerType = passType.isLockerType();

        // then
        assertThat(lockerType).isTrue();
    }

    @DisplayName("시간 단위 이용권은 사물함을 사용할 수 없다.")
    @Test
    void cannotUseLocker() {
        // given
        StudyCafePassType passType = StudyCafePassType.HOURLY;

        // when
        boolean lockerType = passType.isLockerType();

        // then
        assertThat(lockerType).isFalse();
    }

    @DisplayName("주 단위 이용권은 사물함을 사용할 수 없다.")
    @Test
    void cannotUseLocker2() {
        // given
        StudyCafePassType passType = StudyCafePassType.WEEKLY;

        // when
        boolean lockerType = passType.isLockerType();

        // then
        assertThat(lockerType).isFalse();
    }

    @DisplayName("이용권의 타입을 알 수 있다.")
    @Test
    void getPassType() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 2, 4000, 0);

        // when
        StudyCafePassType passType = seatPass.getPassType();

        // then
        assertThat(passType).isEqualTo(StudyCafePassType.FIXED);
    }

    @DisplayName("이용권의 기간을 알 수 있다.")
    @Test
    void getDuration() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 2, 4000, 0);

        // when
        int duration = seatPass.getDuration();

        // then
        assertThat(duration).isEqualTo(2);
    }

    @DisplayName("이용권의 가격을 알 수 있다.")
    @Test
    void getPrice() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 2, 4000, 0);

        // when
        int price = seatPass.getPrice();

        // then
        assertThat(price).isEqualTo(4000);
    }
}
