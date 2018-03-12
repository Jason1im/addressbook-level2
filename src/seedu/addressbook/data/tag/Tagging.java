package seedu.addressbook.data.tag;

import com.sun.corba.se.spi.ior.TaggedComponentFactoryFinder;
import javafx.util.Pair;
import java.util.ArrayList;

import seedu.addressbook.data.person.Person;

public class Tagging {

    // A class level list to keep track of all tagging instances.
    private static final ArrayList<Tagging> taggingList = new ArrayList<Tagging>();

    private final Person person;
    private final Tag tag;
    private final Action action;

    public enum Action {
        ADD, REMOVE
    }

    public Tagging(Person person, Tag tag, Action action) {
        this.person = person;
        this.tag = tag;
        this.action = action;
        Tagging.storeTagging(this);
    }

    public static void storeTagging(Tagging tagging) {
        taggingList.add(tagging);
    }

    public static ArrayList<Tagging> getTaggingList() {
        return taggingList;
    }

    /**
     * @return a list of all taggings from the start of session
     */
    public static String printTaggingList() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taggingList.size(); i++) {
            result.append(taggingList.get(i).toString());
        }
        return result.toString();
    }

    /**
     * @return a string representation of the tagging object.
     */
    public String toString() {
        String line = "";
        if (this.action == Action.ADD) {
            line.concat("+");
        } else if (this.action == Action.REMOVE) {
            line.concat("-");
        }
        line.concat(" " + this.person + " [" + this.tag + "]\n");
        return line;
    }


}
