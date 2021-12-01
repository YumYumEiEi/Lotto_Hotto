package Middlewear;

import ActionObjects.ActionObject;
import ActionObjects.InitializeShowTippsWindowActionObject;
import Backend.Backend;
import BackendObjects.Tipp;
import BackendObjects.TippTableView;
import Frontend.Frontend;
import Frontend.ShowTippFrontend;

public class ShowTippHandler extends ShowTippMiddlewear {

    ShowTippFrontend frontend;
    Backend backend;

    public ShowTippHandler( ShowTippFrontend frontend, Backend backend){
        this.frontend = frontend;
        this.backend = backend;
    }

    @Override
    public void heandleAction(ActionObject performedAction) {
        String calledFunction = performedAction.getFunctionCall();

        switch (calledFunction){
            case "initialize":
                initializeTheFrontend((InitializeShowTippsWindowActionObject)performedAction);
                break;
        }
    }

    private void initializeTheFrontend(InitializeShowTippsWindowActionObject data) {
        TippTableView[] allTippsFromUser = backend.getAllTippsFromUser(data.getUserID());
        frontend.fillTippTabel(allTippsFromUser);
    }
}
