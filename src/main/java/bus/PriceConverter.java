package bus;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PriceConverter {

    @Incoming("prices")
    @Outgoing("converted-prices")
    @Broadcast
    public double convert(long price){
        return price * 0.23d;
    }
}
