package command;

import app.AbstractFactory;
import communication.Response;
import communication.User;
import data.AuthModule;
import message.MessageManager;
import object.Vehicle;

import java.util.Locale;

public class LoginCommand extends AbstractCommand implements Command, AuthCommand{
    private final AuthModule authModule;
    private final AbstractFactory abstractFactory;

    public LoginCommand(AuthModule usersDAO, AbstractFactory abstractFactory) {
        super("login", "войти в систему");
        this.abstractFactory = abstractFactory;
        this.authModule = usersDAO;
    }

    @Override
    public Response execute(String str, Vehicle vehicle, User user, Locale locale) {
        return authModule.login(user)
                ? abstractFactory.getResponse(true, MessageManager.getInstance().getLocalMessages(locale).getString("suc.login"))
                : abstractFactory.getResponse(false, MessageManager.getInstance().getLocalMessages(locale).getString("err.login"));
    }
}
