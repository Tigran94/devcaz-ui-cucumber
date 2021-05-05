package utils;

import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Utils {

    public static boolean isSorted(final List<WebElement> listOfStrings) {
        List<String> items = new LinkedList<>();
        for (WebElement item : listOfStrings) {
            items.add(item.getText());
        }
        Iterator<String> iter = items.iterator();
        String current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

}
