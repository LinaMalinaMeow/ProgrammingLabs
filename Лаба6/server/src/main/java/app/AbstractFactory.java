package app;

import communication.Response;

public interface AbstractFactory {
    Response getResponse(boolean successful, String message);
}
