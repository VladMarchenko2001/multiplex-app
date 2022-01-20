package multiplex.dao;

import multiplex.model.Order;
import multiplex.model.User;

import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
