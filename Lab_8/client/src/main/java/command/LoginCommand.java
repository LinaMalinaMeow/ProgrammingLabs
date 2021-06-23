package command;

import app.AbstractFactory;
import app.AuthModule;
import communication.Request;
import communication.RequestType;

import java.util.Locale;

public class LoginCommand implements AuthCommand {
    private final AuthModule authModule;
    private final AbstractFactory factory;

    public LoginCommand(AuthModule authModule, AbstractFactory factory) {
        this.authModule = authModule;
        this.factory = factory;
    }

    @Override
    public Request execute() {
        return factory.getRequest(RequestType.EXECUTE, "login", null,null, authModule.readUser(), Locale.getDefault());
    }
}
