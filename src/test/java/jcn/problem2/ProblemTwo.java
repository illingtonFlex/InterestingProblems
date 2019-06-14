package jcn.problem2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProblemTwo {

    private List<String> expected;

    @Before
    public void init() {

        expected = Arrays.asList("QAIDS", "QOPHS", "QUADS", "QUAGS", "QUAIS", "QUAKY", "QUAYS", "QUERY",
                "QUEYS", "QUIDS", "QUINS", "QUIPS", "QUITS", "QUODS");
    }

    @Test
    public void test() {

        Problem2 p2 = new Problem2();

        List<String> actual = p2.generateWordListFromFile();

        assertThat(actual, is(expected));
    }
}
