package Middlewear;

import ActionObjects.GiveATippActionObject;
import Backend.Backend;
import BackendObjects.Tipp;
import Frontend.GiveTippsFrontend;

public abstract class GiveTippsMiddlewear implements Middlewear {

    protected GiveTippsFrontend frontend;
    protected Backend backend;

    protected abstract boolean isTippLegal(Tipp givenTipp, String userID);

    protected abstract boolean areSixNumbersPicked(Tipp givenTipp);

    protected abstract boolean isOneBonusnumberPicked(Tipp givenTipp);

    protected abstract boolean isTippADuplicat(Tipp givenTipp, String userID);

    protected abstract void giveTipp(GiveATippActionObject performedAction);
}
