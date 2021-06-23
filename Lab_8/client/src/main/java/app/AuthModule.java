package app;

import communication.User;

public interface AuthModule {
    User getUser();
    void setUser(User user);
    User readUser();
}
