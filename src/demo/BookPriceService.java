package demo;

import java.math.BigDecimal;
import java.util.Random;

public class BookPriceService {

    private Random random = new Random();

    public BigDecimal getPrice(BookStore store, String isbn) {
        int value = random.nextInt(1000) + 100;
        sleep();
        if (value % 3 == 0) {
            throw new RuntimeException(isbn + " not available in store");
        }
        return new BigDecimal(value);
    }

    private void sleep(){
        try {
            Thread.sleep(random.nextInt(1000) + 10);
        } catch (InterruptedException e) {
            //
        }
    }

}
