package hexagonal_architecture.ordercontext.domain;

/**
 * DateTime 2018/8/7 11:17
 *
 * @author db
 **/
public interface OrderRepository {
    List<Order> forBuyerId(Identity buyerId);
    void add(Order order);
}
