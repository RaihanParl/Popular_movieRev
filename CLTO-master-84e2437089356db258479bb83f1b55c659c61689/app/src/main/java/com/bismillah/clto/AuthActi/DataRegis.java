package com.bismillah.clto.AuthActi;

/**
 * Created by You on 9/6/17.
 */

public class DataRegis {
    String keyUid;

    String namaTim;
    String kaptenTim;
    String basecamp;
    String kota;

    String nomorTelpon;


    public DataRegis(String keyUid,String namaTim, String kaptenTim, String basecamp,String kota,String nomorTelpon) {
        this.namaTim = namaTim;
        this.kaptenTim = kaptenTim;
        this.basecamp = basecamp;
        this.keyUid=keyUid;
        this.kota = kota;
        this.nomorTelpon = nomorTelpon;
    }

    public DataRegis() {
    }
    public String getKeyUid() {
        return keyUid;
    }

    public void setKeyUid(String keyUid) {
        this.keyUid = keyUid;
    }

    public String getNamaTim() {
        return namaTim;
    }

    public void setNamaTim(String namaTim) {
        this.namaTim = namaTim;
    }

    public String getKaptenTim() {
        return kaptenTim;
    }

    public void setKaptenTim(String kaptenTim) {
        this.kaptenTim = kaptenTim;
    }

    public String getBasecamp() {
        return basecamp;
    }

    public void setBasecamp(String basecamp) {
        this.basecamp = basecamp;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNomorTelpon() {
        return nomorTelpon;
    }

    public void setNomorTelpon(String nomorTelpon) {
        this.nomorTelpon = nomorTelpon;
    }





}
