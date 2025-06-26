package lambda.functionalinterface.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BookService {

    public <T> List<T> filterPriceMoreThan(List<T> books, Predicate<T> condition){
        List<T> result = new ArrayList<>();
        for(T book : books){
            if(condition.test(book)){
                result.add(book);
            }
        }

        return result;
    }

    public <T> List<T> filterWithPrice(List<T> books, Predicate<T> condition1){
        List<T> result = new ArrayList<>();
        for(T book : books){
            if(condition1.test(book)){
                result.add(book);
            }
        }

        return result;
    }
}
