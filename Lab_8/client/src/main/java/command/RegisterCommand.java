package command;

import app.AbstractFactory;
import app.AuthModule;
import communication.Request;
import communication.RequestType;

import java.util.Locale;

public class RegisterCommand implements AuthCommand{
    private final AuthModule authModule;
    private final AbstractFactory abstractFactory;

    public RegisterCommand(AuthModule authModule, AbstractFactory abstractFactory) {
        this.authModule = authModule;
        this.abstractFactory = abstractFactory;
    }

    @Override
    public Request execute() {
        return abstractFactory.getRequest(RequestType.EXECUTE, "register", null,null, authModule.readUser(), Locale.getDefault());
    }
}
