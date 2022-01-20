package multiplex.service;

import multiplex.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
