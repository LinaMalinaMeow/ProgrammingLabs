package app;

import communication.Response;
import communication.ResponseImpl;

public class AbstractFactoryImpl implements AbstractFactory{
    public Response getResponse(boolean successful, String message) {
        return new ResponseImpl(message, successful);
    }
}
