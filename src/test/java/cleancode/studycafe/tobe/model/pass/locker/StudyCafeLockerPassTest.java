package cleancode.studycafe.tobe.model.pass.locker;

import static org.assertj.core.api.Assertions.assertThat;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeLockerPassTest {

    @DisplayName("사물함 이용권의 타입을 비교할 수 있다.")
    @Test
    void isSamePassType() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        boolean result = lockerPass.isSamePassType(StudyCafePassType.FIXED);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("사물함 이용권의 기간을 비교할 수 있다.")
    @Test
    void isSameDurationType() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        boolean result = lockerPass.isSameDurationType(12);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("사물함 이용권의 타입을 알 수 있다.")
    @Test
    void getPassType() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        StudyCafePassType passType = lockerPass.getPassType();

        // then
        assertThat(passType).isEqualTo(StudyCafePassType.FIXED);
    }

    @DisplayName("사물함 이용권의 기간을 알 수 있다.")
    @Test
    void getDuration() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        int duration = lockerPass.getDuration();

        // then
        assertThat(duration).isEqualTo(12);
    }

    @DisplayName("사물함 이용권의 가격을 알 수 있다.")
    @Test
    void getPrice() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        // when
        int price = lockerPass.getPrice();

        // then
        assertThat(price).isEqualTo(30000);
    }
}
