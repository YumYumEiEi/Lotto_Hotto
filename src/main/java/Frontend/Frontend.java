package Frontend;

import ActionObjects.ActionObject;
import ActionObjects.LoginActionObject;
import javafx.stage.Stage;

public interface Frontend {

    void start(Stage stage, Mediator mediator) throws Exception;
}
