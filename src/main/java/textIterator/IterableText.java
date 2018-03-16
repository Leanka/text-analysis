package textIterator;

import java.util.Iterator;

public interface IterableText {
    Iterator<String> chariterator();
    Iterator<String> worditerator();
}
