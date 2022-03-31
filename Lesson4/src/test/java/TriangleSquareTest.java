//import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class TriangleSquareTest {
    Triangle triangle;


    private Logger logger = LoggerFactory.getLogger(TriangleSquareTest.class);
    private org.slf4j.Logger logger2ForExample = LoggerFactory.getLogger("Example for log");
    private static final String FILENAME = "src/test/LOG/";


    @Test
    void squareCheck() throws ObjectIsNotTriangleException {

        assertThat(new Triangle(3, 4, 5).square()).isEqualTo(6);
        assertThat(new Triangle(3, 4, 5).square()).isNotEqualTo(6.00000000000001);
    }

    @Test
    void ThenObjectIsNullThatException() throws NullPointerException {
        System.out.println();
        Assertions.assertThrows(ObjectIsNotTriangleException.class, () -> triangle.square());
    }

    @Test
    void ThenObjectIsNotTriangleWhenSideIsZeroThatException() throws ObjectIsNotTriangleException {
        System.out.println();
        triangle = new Triangle(0, 1, 2);
        Assertions.assertThrows(ObjectIsNotTriangleException.class, () -> triangle.square());

    }
}
