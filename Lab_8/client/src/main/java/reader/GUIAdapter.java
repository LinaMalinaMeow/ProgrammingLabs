package reader;

import communication.Response;

public interface GUIAdapter {
    Response getResponse(String commandStr);
}
