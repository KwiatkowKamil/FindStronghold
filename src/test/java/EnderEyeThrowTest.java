import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EnderEyeThrowTest {

    @ParameterizedTest
    @DisplayName("should return an empty table when throws are parallel")
    @MethodSource("parallelProvider")
    void testParallel(double [] EXAMPLE_INPUT_1, double [] EXAMPLE_INPUT_2, double [] expected) {
        EnderEyeThrow eyeThrow1 = new EnderEyeThrow(EXAMPLE_INPUT_1);
        EnderEyeThrow eyeThrow2 = new EnderEyeThrow(EXAMPLE_INPUT_2);
        assertArrayEquals(expected, eyeThrow1.getIntersectionWith(eyeThrow2));
    }

    @ParameterizedTest
    @DisplayName("should return a double array designating the intersection of throws")
    @MethodSource("otherProvider")
    void testOther(double [] EXAMPLE_INPUT_1, double [] EXAMPLE_INPUT_2, double [] expected) {
        EnderEyeThrow eyeThrow1 = new EnderEyeThrow(EXAMPLE_INPUT_1);
        EnderEyeThrow eyeThrow2 = new EnderEyeThrow(EXAMPLE_INPUT_2);
        assertArrayEquals(expected, eyeThrow1.getIntersectionWith(eyeThrow2));
    }

    static Stream<Arguments> parallelProvider() {
        return Stream.of(
                Arguments.of((Object) new double[]{1.0, 3.0, 270.0},(Object) new double[]{-1.0, 3.0, 90.0}, new double [0]),
                Arguments.of((Object) new double[]{2.0, 6.0, 0.0},(Object) new double[]{-3.0, 1.0, 180.0}, new double [0])
        );
    }
    static Stream<Arguments> otherProvider() {
        return Stream.of(
                Arguments.of((Object) new double[]{7.0, 1.0, 315.0},(Object) new double[]{1.0, 1.0, 45.0}, new double [] {3.9999999999999996, 3.999999999999999}),
                Arguments.of((Object) new double[]{1.0, 1.0, 45.0},(Object) new double[]{7.0, 1.0, 315.0}, new double [] {3.9999999999999996, 3.999999999999999}),
                Arguments.of((Object) new double[]{0.5358983848, 2.0, 60.0},(Object) new double[]{7.0, 1.0, 315.0}, new double [] {3.999999999977215, 4.0000000000227836}),
                Arguments.of((Object) new double[]{7.0, 1.0, 315.0},(Object) new double[]{0.5358983848, 2.0, 60.0}, new double [] {3.999999999977215, 4.0000000000227836}),
                Arguments.of((Object) new double[]{7.0, 1.0, 225.0},(Object) new double[]{1.0, 1.0, 135.0}, new double [] {4.000000000000001, -2.0}),
                Arguments.of((Object) new double[]{1.0, 1.0, 135.0},(Object) new double[]{7.0, 1.0, 225.0}, new double [] {4.000000000000001, -2.0}),
                Arguments.of((Object) new double[]{4.0, 0.0, 120.0},(Object) new double[]{6.0, 0.0, 225.0}, new double [] {5.267949192431123, -0.7320508075688771}),
                Arguments.of((Object) new double[]{6.0, 0.0, 225.0},(Object) new double[]{4.0, 0.0, 120.0}, new double [] {5.267949192431123, -0.7320508075688771}),
                Arguments.of((Object) new double[]{0.0, 0.0, 120.0},(Object) new double[]{2.0, 0.0, 225.0}, new double [] {1.267949192431123, -0.7320508075688771})
        );
    }
}
