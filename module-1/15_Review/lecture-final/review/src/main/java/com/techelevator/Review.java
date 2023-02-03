package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Review {

    public List<Integer> interleavedLists(List<Integer> listOne, List<Integer> listTwo) {
        final List<Integer> merged = new ArrayList<>();

        int sizeOfSmallestList = 0;
        List<Integer> longerList = null;
        if (listOne.size() < listTwo.size()) {
            sizeOfSmallestList = listOne.size();
            longerList = listTwo;
        } else {
            sizeOfSmallestList = listTwo.size();
            longerList = listOne;
        }

        for (int i = 0; i < sizeOfSmallestList; i++) {
            merged.add(listOne.get(i));
            merged.add(listTwo.get(i));
        }

        for (int i = sizeOfSmallestList; i < longerList.size(); i++) {
            merged.add(longerList.get(i));
        }

        return merged;
    }

    /*
     * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
     * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
     * current worth.
     *
     * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
     * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
     *
     */
    public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
        final int petersMoney = peterPaul.get("Peter");
        final int paulsMoney =peterPaul.get("Paul");

        if (petersMoney > 5000 && paulsMoney > 10000) {
            final int peterContribution = petersMoney / 4;
            final int paulContribution = paulsMoney / 4;

            peterPaul.put("PeterPaulPartnership", peterContribution + paulContribution);
            peterPaul.put("Peter", petersMoney - peterContribution);
            peterPaul.put("Paul", paulsMoney - paulContribution);
        }

        return peterPaul;
    }

}
