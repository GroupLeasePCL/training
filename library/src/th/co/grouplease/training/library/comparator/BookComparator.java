package th.co.grouplease.training.library.comparator;

import th.co.grouplease.training.library.domain.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        var categoryCompVal = o1.getCategory().compareTo(o2.getCategory());
        if(categoryCompVal == 0){
            return o1.getName().compareTo(o2.getName());
        }
        return categoryCompVal;
    }
}
