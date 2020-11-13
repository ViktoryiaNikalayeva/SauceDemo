package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

@Log4j2
public class CarTest {


    @Test
    public void carComparison() {
        Car car1 = Car.builder()
                .make("bmw")
                .model("x7")
                .speed(280)
                .build();
        Car car2 = Car.builder()
                .make("bmw")
                .model("x7")
                .speed(280)
                .build();

        log.fatal("fatal");
        log.error("error");
        log.warn ("warn");
        log.info("info");
        log.debug("debug");
        log.trace("trace");

        assertEquals(car1, car2);


    }
}
