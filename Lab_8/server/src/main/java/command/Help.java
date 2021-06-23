package command;


import app.AbstractFactory;
import communication.Response;
import communication.User;
import message.MessageManager;
import object.Vehicle;

import java.util.Locale;

public class Help extends AbstractCommand implements Command {
    private AbstractFactory factory;

    public Help(AbstractFactory factory){
        super("help","Вывести справку по доступным командам");
        this.factory = factory;
    }
    @Override
    public Response execute(String str, Vehicle vehicle, User user, Locale locale){
        return factory.getResponse(true,
                "help: " + MessageManager.getInstance().getLocalMessages(locale).getString("desc.help") + "\n" +
                "info: " + MessageManager.getInstance().getLocalMessages(locale).getString("desc.info") +"\n" +
                "show: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.show") +"\n" +
                "add: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.add") +"\n" +
                "update: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.update") +"\n" +
                "remove_by_id: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.rem_id") +"\n" +
                "clear: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.clear") +"\n" +
                "execute_script: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.exec") +"\n" +
                "remove_first: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.rem_fir") +"\n" +
                "head: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.head") +"\n" +
                "remove_head: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.rem_head") +"\n" +
                "min_by_distance_travelled: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.min") +"\n" +
                "print_ascending: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.pr_asc") +"\n" +
                "print_field_ascending_number_of_wheels: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.pr_field") +"\n" +
                "login: "+ MessageManager.getInstance().getLocalMessages(locale).getString("desc.login") +"\n" +
                "register: " + MessageManager.getInstance().getLocalMessages(locale).getString("desc.reg"));
    }
}
