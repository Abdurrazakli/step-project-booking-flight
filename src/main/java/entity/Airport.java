package entity;

enum Airport {
    Hartsfield_Jackson_Atlanta_International_Airport("ATL"),
    Tokyo_Haneda_Airport("HND"),
    Dubai_International_Airport("DXB"),
    London_Heathrow_Airport("LHR"),
    Frankfurt_Airport("FRA"),
    Madrid_Barajas_Airport("MAD"),
    Istanbul_Ataturk_Airport("LTBA"),
    Ankara_Esenboga_Airport("LTAC"),
    Boryspil_International_Airport("KBP"),
    Chernivtsi_International_Airport("CWC"),
    Odessa_International_Airport("ODS"),
    Vologda_Airport("VGD"),
    Moscow_Domodedovo_Airport("DME"),
    Irkutsk_International_Airport("IIA"),
    Tbilisi_Airport("TBS"),
    Isfahan_International_Airport("IFN"),
    Heydar_Aliyev_International_Airport("GYD");

    private final String code;
    Airport(String code) {
        this.code=code;
    }

    public String getCode(){
        return this.code;
    }
}
