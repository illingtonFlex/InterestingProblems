package jcn.problem2;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {

    public List<String> generateWordListFromFile() {

        List<String> retVal = null;

        try(Stream<String> wordStream = Files.lines(Paths.get(ClassLoader.getSystemResource("wordlist.txt").toURI()), Charset.defaultCharset()))
        {
            /*

                The wordStream variable contains a stream of all entries in the wordlist.txt file found in
                src/main/resources. Please use wordStream to generate and return a list of words from wordStream
                adhering to the following criteria:

                1. Words with only five letters.
                2. Words with no repeated letters.
                3. Words which end with the letters S or Y.
                4. Words which contain the letter Q.
                5. Converted to upper case.
                6. Words sorted in alphabetical order BASED ON THE SECOND LETTER OF THE WORD.
                    e.g. ZAMBO comes before AZMOD

                The words list is large (over 170,000 words) Can you also observe and compare the performance of parallel
                processing vs serial?

                Validate the solution by running the unit test.

            */

            retVal = wordStream.filter(hasLengthOfFive)
                    .filter(this::hasNoDuplicateCharacters)
                    .filter(word -> word.toUpperCase().endsWith("S") || word.toUpperCase().endsWith("Y"))
                    .filter(word -> word.toUpperCase().contains("Q"))
                    .map(String::toUpperCase)
                    .sorted((o1, o2) -> o1.substring(1).compareToIgnoreCase(o2.substring(1)))
                    .collect(Collectors.toList());

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return retVal;
    }

    private Predicate<String> hasLengthOfFive = s -> s.length() == 5;

    private boolean hasNoDuplicateCharacters(String s)
    {
        Set<Character> charSet = new HashSet<>();

        for(Character c : s.toCharArray())
        {
            if(!charSet.add(c))
                return false;
        }

        return true;
    }
}
