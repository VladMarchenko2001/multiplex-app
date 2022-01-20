package multiplex.service;

import multiplex.model.Order;
import multiplex.model.ShoppingCart;
import multiplex.model.User;

import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
