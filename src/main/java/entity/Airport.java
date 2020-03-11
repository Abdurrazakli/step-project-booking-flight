package entity;

public enum Airport {
    ATL("Atlanta"),
    HND("Tokyo"),
    DXB("Dubai"),
    LHR("London"),
    FRA("Frankfurt"),
    MAD("Madrid"),
    TBA("Istanbul"),
    TAC("Ankara"),
    KBP("Boryspil"),
    CWC("Chernivtsi"),
    ODS("Odessa"),
    VGD("Vologda"),
    DME("Moscow"),
    IIA("Irkutsk"),
    TBS("Tbilisi"),
    IFN("Isfahan"),
    XRD("Khirdalan"),
    AGD("Agdash"),
    GYD("Baku");


    private final String name;
    Airport(String name) {
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}
