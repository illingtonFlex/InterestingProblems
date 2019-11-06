package jcn.problem1;

import java.util.List;
import java.util.stream.Collectors;

public class Problem1 {

    public static List<Thing> joinListsWithStreams(List<Thing> thingList, List<String> orderedStringIdList) {

        /*
            TODO: This method should return a list of distinct Things, which is the union of the two input parameters.
            The orderedStringIdList is an ordered list of IDs, correlating to the ID on the Thing class. The resulting
            list should maintain the order of orderedStringIdList, and only contain Thing objects found in the thingsList
            whose ID is also found in orderedStringIdList. No duplicates.

            Please utilize the Streams API to solve this problem.

            Validate this solution by executing the unit test.
         */

        List<Thing> retVal = orderedStringIdList.stream()
                .filter(id -> thingList.stream().anyMatch(thing -> thing.getId().toString().equals(id)))
                .map(id -> thingList.stream()
                        .filter(thing -> thing.getId().toString().equals(id))
                        .findAny()
                        .get())
                .distinct()
                .collect(Collectors.toList());

        return retVal;
    }
}