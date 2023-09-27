package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SearchTest {


    @Test
    void testFndFirstDecimalFractionByUserName(){
        assertEquals(new Fraction(0,1).decimal(), new Search().findFirstDecimalFractionByUserName("Oscar"));
    }

}


