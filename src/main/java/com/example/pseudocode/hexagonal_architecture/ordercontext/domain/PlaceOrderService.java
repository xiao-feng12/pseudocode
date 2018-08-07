package hexagonal_architecture.ordercontext.domain;

import com.sun.javafx.geom.transform.Identity;
import hexagonal_architecture.OrderItem;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DateTime 2018/8/7 11:00
 *
 * @author db
 **/
public class PlaceOrderService {
    @Repository
    private OrderRepository orderRepository;

    @Service
    private OrderValidator orderValidator;

    public void execute(Identity buyerId, List<OrderItem> items, ShippingAddress shipping, BillingAddress billing){
        Order order = Order.create(buyerId, items, shipping, billing);
        if (orderValidator.isValid(order)){
            orderRepository.add(order);
        } else {
            throw new InvalidOrderException(String.format("the order which placed by buyer with %s is invalid.",buyerId));
        }
    }


}
