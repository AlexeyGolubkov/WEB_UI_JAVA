//import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
public class TriangleSquareTest {
    private static Logger logger= LoggerFactory.getLogger(TriangleSquareTest.class);
    private static org.slf4j.Logger logger2ForExample=  LoggerFactory.getLogger("Example for log");
    private static final String FILENAME = "src/test/LOG/";

    @Test
    void squareCheck () {
        Triangle triangle = new Triangle(3, 4, 5);
        logger2ForExample.error(String.valueOf(triangle.square()));     //
        logger.error(" {}.", FILENAME);
        assertThat(new Triangle(3, 4, 5).square()).isEqualTo(6);
        assertThat(new Triangle(3, 4, 5).square()).isNotEqualTo(6.00000000000001);
    }
}

