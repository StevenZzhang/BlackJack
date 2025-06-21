public class Card {
    private String suite;
    private int value;
    private String cardname;
    public Card() {
        suite = "heart";
        value = 1;
        cardname = "Ace";
    }
    public Card(String h, int v, String c) {
        suite = h;
        value = v;
        cardname = c;
    }
    public String getSuite() {
        return suite;
    }
    public int getvalue() {
        return value;
    }
    public String getCardname() {
        return cardname;
    }
    public void setSuite(String s) {
        suite = s;
    }
    public void setValue(int v) {
        value = v;
    }
    public void setCardname(String c) {
        cardname = c;
    }
    public String toString() {
        return "drawn the " + cardname + " of " + suite + " with a value of " + value + ".";
    }


}