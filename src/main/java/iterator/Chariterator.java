package iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Chariterator implements Iterator{
    List<String> letters;
    Integer index = 0;

    public Chariterator(List <String> letters) {
        this.letters = letters;
    }

    public boolean hasNext() {
        boolean next = false;
        while(index < letters.size()){
            if(Pattern.matches("[A-Z]", letters.get(index))){
                next = true;
                break;
            }
            ++index;
        }

        return next;
    }

    public String next() {
        String letter = null;
        if(hasNext()){
            letter = letters.get(index++);
        }

        return letter;
    }

    public void remove() {
        letters.remove(index);
    }
}
