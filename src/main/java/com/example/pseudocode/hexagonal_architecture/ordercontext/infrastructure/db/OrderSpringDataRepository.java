package hexagonal_architecture.ordercontext.infrastructure.db;

import hexagonal_architecture.ordercontext.domain.OrderRepository;

/**
 * DateTime 2018/8/7 11:35
 *
 * @author db
 **/
public class OrderSpringDataRepository implements OrderRepository {
    @Override
    public List<Order> forBuyerId(Identity buyerId) {
        return null;
    }

    @Override
    public void add(Order order) {

    }
}
