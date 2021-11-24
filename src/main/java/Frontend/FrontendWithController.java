package Frontend;

import ActionObjects.ActionObject;

public interface FrontendWithController extends Frontend {
    void actionPerformed(ActionObject action);
}
