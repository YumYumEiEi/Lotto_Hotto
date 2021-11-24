package Middlewear;

import ActionObjects.ActionObject;
import ActionObjects.TippActionObject;
import Backend.Backend;
import Frontend.GiveTippsFrontend;

public abstract class GiveTippsMiddlewear implements Middlewear {

    protected GiveTippsFrontend frontend;
    protected Backend backend;

    protected abstract boolean isTippLegal();

    protected abstract boolean areSevenNumbersPicked();

    protected abstract boolean isOneSuperzahlPicked();

    protected abstract boolean isTippADuplicat();

    protected abstract void giveTipp(TippActionObject performedAction);
}
