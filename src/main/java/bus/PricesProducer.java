package bus;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class PricesProducer {

    private Random random = new Random();

    @Outgoing("price")
    public Flowable<Price> producesPrice() {
        return Flowable.interval(1, TimeUnit.SECONDS)
                .map(it ->
                {
                    final Price price = new Price();
                    price.setName("first");
                    price.setPrice((long)random.nextInt(5000));
                    return price;
                });

    }
    }

