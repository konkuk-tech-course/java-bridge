package bridge.service;

import bridge.domain.User;

public class UserService {
    private static class InstanceHolder {
        private static final UserService INSTANCE = new UserService();
    }

    public static UserService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public User createUser() {
        return new User();
    }
}
