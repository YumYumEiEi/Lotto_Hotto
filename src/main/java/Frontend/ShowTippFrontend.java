package Frontend;

import BackendObjects.TippTableView;

public interface ShowTippFrontend extends FrontendWithController {
    void fillTippTabel(TippTableView[] tippsFromUser);
}
