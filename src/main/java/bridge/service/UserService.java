package bridge.service;

public class UserService {
    private static class InstanceHolder {
        private static final UserService INSTANCE = new UserService();
    }

    public static UserService getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
