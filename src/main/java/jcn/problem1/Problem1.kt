package jcn.problem1

import java.util.stream.Collectors
import java.util.stream.Collectors.groupingBy
import java.util.stream.Stream

object Problem1 {
    @JvmStatic
    fun joinListsWithStreams(
        thingList: List<Thing>,
        orderedStringIdList: List<String>
    ): List<Thing> { /*
            TODO: This method should return a list of distinct Things, which is the union of the two input parameters.
            The orderedStringIdList is an ordered list of IDs, correlating to the ID on the Thing class. The resulting
            list should maintain the order of orderedStringIdList, and only contain Thing objects found in the thingsList
            whose ID is also found in orderedStringIdList. No duplicates.

            Please utilize the Streams API to solve this problem.

            Validate this solution by executing the unit test.
         */

        return orderedStringIdList.asSequence()
            .filter { id: String? ->
                thingList.asSequence()
                    .any { thing: Thing -> thing.id.toString() == id }
            }
            .map { id: String ->
                thingList.asSequence()
                    .filter { thing: Thing -> thing.id.toString() == id }
                    .first()
            }
            .distinct()
            .toList()
    }
}
