package entity;

public enum Airport {
    ATL("Hartsfield_Jackson_Atlanta_International_Airport"),
    HND("Tokyo_Haneda_Airport"),
    DXB("Dubai_International_Airport"),
    LHR("London_Heathrow_Airport"),
    FRA("Frankfurt_Airport"),
    MAD("Madrid_Barajas_Airport"),
    TBA("Istanbul_Ataturk_Airport"),
    TAC("Ankara_Esenboga_Airport"),
    KBP("Boryspil_International_Airport"),
    CWC("Chernivtsi_International_Airport"),
    ODS("Odessa_International_Airport"),
    VGD("Vologda_Airport"),
    DME("Moscow_Domodedovo_Airport"),
    IIA("Irkutsk_International_Airport"),
    TBS("Tbilisi_Airport"),
    IFN("Isfahan_International_Airport"),
    GYD("Heydar_Aliyev_International_Airport");


    private final String name;
    Airport(String name) {
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}
