package iterator;

import java.util.Iterator;
import java.util.List;

public class Worditerator implements Iterator{
    List <String> words;
    Integer index = 0;

    public Worditerator(List <String> words){
        this.words = words;
    }

    public boolean hasNext(){
        boolean next = false;
        if(index < words.size()){
            next = true;
        }else {
            resetIterator();
        }

        return next;
    }

    public String next(){
        String word = null;
        if(hasNext()){
            word = words.get(index++);
        }
        return word;
    }

    public void remove(){
        words.remove(index);
    }

    public void resetIterator(){
        this.index = 0;
    }
}
