package com.kodilla.stream.person;

import java.util.ArrayList;
import java.util.List;

public final class People {

    public static List<String> getList() {
        final List<String> theList = new ArrayList<String>();

        theList.add("John Smith");
        theList.add("Dorothy Newman");
        theList.add("John Wolkowitz");
        theList.add("Owen Roger");
        theList.add("Matilda Davies");
        theList.add("John Smith");
        theList.add("Declan Both");
        theList.add("Corinne Foster");
        theList.add("Khole Fry");
        theList.add("Martin Valenzuela");

        return new ArrayList(theList);
    }
}
