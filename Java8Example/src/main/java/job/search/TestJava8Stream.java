package job.search;

import job.search.util.*;

public class TestJava8Stream {
    public static void main(String[] args) {
        CharacterOperation.countEachCharacterInString();
        EvenOddOperation.extractEvenAndOddNumber();
        DuplicateRemoveOperation.removeDuplicateNumbers();
        SumNumberOperation.sumOfAllnumbers();
        FilterNumberList.multipleOfSpecifiedNumber(5);
        MaxMinStream.maxMinOfNumber();
        SortListStream.merge2UnsortedInto1SortedArray();
        SortListStream.merge2UnsortedInto1SortedList();
        MaxMinStream.approach3();
    }
}
