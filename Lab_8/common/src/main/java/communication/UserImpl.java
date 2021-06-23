package communication;

import java.io.Serializable;
import java.util.Objects;

public class UserImpl implements User, Serializable {

    private final String login;
    private final String password;

    public UserImpl(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserImpl{" +
                "login='" + login + '\'' +
                ", password='" + "******" + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserImpl user = (UserImpl) o;
        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
