package jcn.problem2

import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import java.util.function.Predicate
import java.util.stream.Collectors

class Problem2 {
    fun generateWordListFromFile(): List<String>? {
        var retVal: List<String>? = null
        try {

            Files.lines(
                Paths.get(ClassLoader.getSystemResource("wordlist.txt").toURI()),
                Charset.defaultCharset()
            ).use { wordStream ->
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
                    .filter { s: String -> hasNoDuplicateCharacters(s) }
                    .filter { word: String ->
                        word.toUpperCase().endsWith("S") || word.toUpperCase().endsWith("Y")
                    }
                    .filter { word: String -> word.toUpperCase().contains("Q")
                    }
                    .map { obj: String -> obj.toUpperCase() }
                    .sorted { o1: String, o2: String -> o1.substring(1).compareTo(o2.substring(1), ignoreCase = true)
                    }
                    .collect(Collectors.toList())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return retVal
    }

    private val hasLengthOfFive =
        Predicate { s: String -> s.length == 5 }

    private fun hasNoDuplicateCharacters(s: String): Boolean {
        val charSet: MutableSet<Char> = HashSet()
        for (c in s.toCharArray()) {
            if (!charSet.add(c)) return false
        }
        return true
    }
}
