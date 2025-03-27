package classes;

import java.util.List;

public class Transaksi {
    private String id;
    private String namePembeli;
    private String namePenjual;
    private String namePengirim;
    private String idDiskon;
    private HistoryStatus[] historyStatus;
    private TransaksiProduct[] produkDibeli;
    private String jenisTransaksi; // "Instant", "Next Day", or "Regular"
    private long biayaOngkir;

    // Constructor
    public Transaksi(String id, String namePembeli, String namePenjual, String namePengirim, String idDiskon,
                     HistoryStatus[] historyStatus, TransaksiProduct[] produkDibeli, String jenisTransaksi, long biayaOngkir) {
        this.id = id;
        this.namePembeli = namePembeli;
        this.namePenjual = namePenjual;
        this.namePengirim = namePengirim;
        this.idDiskon = idDiskon;
        this.historyStatus = historyStatus;
        this.produkDibeli = produkDibeli;
        this.jenisTransaksi = jenisTransaksi;
        this.biayaOngkir = biayaOngkir;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamePembeli() {
        return namePembeli;
    }

    public void setNamePembeli(String namePembeli) {
        this.namePembeli = namePembeli;
    }

    public String getNamePenjual() {
        return namePenjual;
    }

    public void setNamePenjual(String namePenjual) {
        this.namePenjual = namePenjual;
    }

    public String getNamePengirim() {
        return namePengirim;
    }

    public void setNamePengirim(String namePengirim) {
        this.namePengirim = namePengirim;
    }

    public String getIdDiskon() {
        return idDiskon;
    }

    public void setIdDiskon(String idDiskon) {
        this.idDiskon = idDiskon;
    }

    public HistoryStatus[] getHistoryStatus() {
        return historyStatus;
    }

    public void setHistoryStatus(HistoryStatus[] historyStatus) {
        this.historyStatus = historyStatus;
    }

    public TransaksiProduct[] getProdukDibeli() {
        return produkDibeli;
    }

    public void setProdukDibeli(TransaksiProduct[] produkDibeli) {
        this.produkDibeli = produkDibeli;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public long getBiayaOngkir() {
        return biayaOngkir;
    }

    public void setBiayaOngkir(long biayaOngkir) {
        this.biayaOngkir = biayaOngkir;
    }
}
