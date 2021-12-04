package Middlewear;

import ActionObjects.ActionObject;
import Backend.Backend;
import Frontend.StatisticFrontend;

public class StatisticHandler extends StatisticMiddlewear {
    StatisticFrontend frontend;
    Backend backend;

    public StatisticHandler (StatisticFrontend frontend, Backend backend){
        this.frontend = frontend;
        this.backend = backend;
    }

    @Override
    public void heandleAction(ActionObject performedAction) {

    }
}
