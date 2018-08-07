package hexagonal_architecture.ordercontext.application;

import com.sun.javafx.geom.transform.Identity;
import hexagonal_architecture.OrderItem;
import hexagonal_architecture.ordercontext.domain.OrderRepository;
import hexagonal_architecture.ordercontext.domain.PlaceOrderService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DateTime 2018/8/7 10:59
 *
 * @author db
 **/
@Transactional
public class OrderAppService {
    @Service
    private PlaceOrderService placeOrder;

    @Repository
    private OrderRepository orderRepository;

    @Service
    private CacheClient<List<Order>> cacheClient;

    public void placeOrder(Identity buyerId, List<OrderItem> itmes, ShippingAddress shipping, BillingAddress billing){
        try {
            placeOrder.execute(buyerId, itmes, shipping, billing);
        } catch (OrderRepositoryException | InvalidOrderException | Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
        }
    }


    public List<Order> findBy(Identity buyerId){
        Optional<List<Order>> cachedOrders = cacheClient.get(buyerId.value());
        if (cachedOrders.isPresent()){
            return cachedOrders.get();
        }

        List<Order> orders = orderRepository.forBuyerId(buyerId);
        if (!orders.isEmpty()){
            cacheClient.put(buyerId.value(),orders);
        }
        return orders;
    }

}
