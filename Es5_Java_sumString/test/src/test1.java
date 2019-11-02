
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class test1 {
    @Test

    public void parseOneNumber(){
        Calculator calculator = new Calculator();
        int result =calculator.parse("1");

        assertThat(result, is(1));
    }
    @Test
    public void parseTwoNumbers(){
        Calculator calculator = new Calculator();
        int result = calculator.parse("2,1");

        assertThat(result, is(3));
    }

    @Test
    public void parseManyNumbers(){
        Calculator calculator = new Calculator();
        int result = calculator.parse("1,2,3,4");

        assertThat(result, is(10));
    }

    @Test
    public void parseEmptyString(){
        Calculator calculator = new Calculator();
        int result = calculator.parse("");

        assertThat(result, is(0));
    }

    @Test
    public void parseNotANumber(){
        Calculator calculator = new Calculator();
        int result = calculator.parse("1,ABC");

        assertThat(result, is(7));
    }

    @Test
    public void parseTwoNotANumbers(){
        Calculator calculator = new Calculator();
        int result = calculator.parse("a,AbC");

        assertThat(result, is(7));
    }

    @Test
    public void parseThreeNotANumbers(){
        Calculator calculator = new Calculator();
        int result = calculator.parse("2,Bd,z");

        assertThat(result, is(36));
    }

}
