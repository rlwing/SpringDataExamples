package oldschool;

import org.junit.Test;
import static org.junit.Assert.*;

public class OldSchoolJokesTests {

    @Test
    public void getRandomJokeOldSchool() {

        OldSchoolJokes osj = new OldSchoolJokes();

        String joke = osj.getRandomJoke();
        assertNotNull(joke);
        System.out.println("joke 1 = "+joke+"\n");

        String joke2 = osj.getRandomJoke();
        assertNotNull(joke2);
        assertNotEquals(joke2, joke);
        System.out.println("joke 2 = "+joke2);
    }
}
