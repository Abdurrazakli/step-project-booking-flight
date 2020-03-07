package entity;

public enum Airline {
    AZAL("AHY"),
    TURKISHAIRLINES("THY"),
    BUTA("BUT");

    public final String airlineCode;

    Airline(String airlineCode) {
        this.airlineCode = airlineCode;
    }
    public String getAirlineCode(){
        return this.airlineCode;
    }
}
