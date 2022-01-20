package multiplex.service;

import multiplex.model.MovieSession;
import multiplex.model.ShoppingCart;
import multiplex.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
