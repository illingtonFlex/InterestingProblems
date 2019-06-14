package jcn.problem1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProblemOne {

    private List<Thing> listOfAllThings;
    private List<Thing> expectedResult;
    private List<String> listOfOrderedStringIds;

    @Before
    public void init() {

        listOfAllThings = Arrays.asList(new Thing(15),
                new Thing(152), new Thing(7), new Thing(477),
                new Thing(33), new Thing(1003), new Thing(0));

        listOfOrderedStringIds = Arrays.asList("1003", "64", "26", "152", "15", "television", null, "152", " ");

        expectedResult = Arrays.asList(new Thing(1003), new Thing(152), new Thing(15));

    }

    @Test
    public void test() {

        List<Thing> actual = Problem1.joinListsWithStreams(listOfAllThings, listOfOrderedStringIds);

        assertThat(actual, is(expectedResult));

    }
}
