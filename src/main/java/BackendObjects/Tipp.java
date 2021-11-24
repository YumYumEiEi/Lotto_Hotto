package BackendObjects;

public class Tipp {
    private final String[] allTippedNumbers;
    private final String superzahl;

    private final String username;

    private final String zeihung;


    public Tipp(String[] allTippedNumbers, String superzahl, String username, String zeihung) {
        this.allTippedNumbers = allTippedNumbers;
        this.superzahl = superzahl;
        this.username = username;
        this.zeihung = zeihung;
    }
}
