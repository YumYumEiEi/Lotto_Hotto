package DataObjects;

public class StatisticData {

    private final String lowestMostPickedNumberPrivate;
    private final String lowestMostPickedNumberGlobal;
    private final String highestMostPickedNumberPrivate;
    private final String highestMostPickedNumberGlobal;
    private final String favoritTippPrivate;
    private final String favoritTippGlobal;
    private final String favoritBonusnumberPrivate;
    private final String favoritBonusnumberGlobal;
    private final String highestWinnerClassPrivate;
    private final String highestWinnerClassGlobal;
    private final String highestWinnPrivate;
    private final String totalMoneyWonGlobal;
    private final String totalMoneyWonPrivate;

    public StatisticData(String lowestMostPickedNumberPrivate, String lowestMostPickedNumberGlobal, String highestMostPickedNumberPrivate,
                         String highestMostPickedNumberGlobal, String favoritTippPrivate, String favoritTippGlobal, String favoritBonusnumberPrivate,
                         String favoritBonusnumberGlobal, String highestWinnerClassPrivate, String highestWinnerClassGlobal,
                         String highestWinnPrivate, String totalMoneyWonGlobal, String totalMoneyWonPrivate) {
        this.lowestMostPickedNumberPrivate = lowestMostPickedNumberPrivate;
        this.lowestMostPickedNumberGlobal = lowestMostPickedNumberGlobal;
        this.highestMostPickedNumberPrivate = highestMostPickedNumberPrivate;
        this.highestMostPickedNumberGlobal = highestMostPickedNumberGlobal;
        this.favoritTippPrivate = favoritTippPrivate;
        this.favoritTippGlobal = favoritTippGlobal;
        this.favoritBonusnumberPrivate = favoritBonusnumberPrivate;
        this.favoritBonusnumberGlobal = favoritBonusnumberGlobal;
        this.highestWinnerClassPrivate = highestWinnerClassPrivate;
        this.highestWinnerClassGlobal = highestWinnerClassGlobal;
        this.highestWinnPrivate = highestWinnPrivate;
        this.totalMoneyWonGlobal = totalMoneyWonGlobal;
        this.totalMoneyWonPrivate = totalMoneyWonPrivate;
    }

    public String getLowestMostPickedNumberPrivate() {
        return lowestMostPickedNumberPrivate;
    }

    public String getLowestMostPickedNumberGlobal() {
        return lowestMostPickedNumberGlobal;
    }

    public String getHighestMostPickedNumberPrivate() {
        return highestMostPickedNumberPrivate;
    }

    public String getHighestMostPickedNumberGlobal() {
        return highestMostPickedNumberGlobal;
    }

    public String getFavoritTippPrivate() {
        return favoritTippPrivate;
    }

    public String getFavoritTippGlobal() {
        return favoritTippGlobal;
    }

    public String getFavoritBonusnumberPrivate() {
        return favoritBonusnumberPrivate;
    }

    public String getFavoritBonusnumberGlobal() {
        return favoritBonusnumberGlobal;
    }

    public String getHighestWinnerClassPrivate() {
        return highestWinnerClassPrivate;
    }

    public String getHighestWinnerClassGlobal() {
        return highestWinnerClassGlobal;
    }

    public String getHighestWinnPrivate() {
        return highestWinnPrivate;
    }

    public String getTotalMoneyWonGlobal() {
        return totalMoneyWonGlobal;
    }

    public String getTotalMoneyWonPrivate() {
        return totalMoneyWonPrivate;
    }
}
