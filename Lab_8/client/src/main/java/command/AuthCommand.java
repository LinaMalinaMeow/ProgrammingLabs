package command;

import communication.Request;
import communication.User;

public interface AuthCommand {
    Request execute();
}
