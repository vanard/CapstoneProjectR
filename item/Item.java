package com.example.android.capstoneprojectr.item;

/**
 * Created by Ridho Prihambodo on 3/10/2017.
 */

public class Item {
    int idPensiun;
    String nip;
    String tanggal;
    String attachment;
    String keterangan;
    String status;
    /*
    public Item(int idPensiun, String nip, String tanggal, String attachment, String keterangan, String status) {
        this.idPensiun = idPensiun;
        this.nip = nip;
        this.tanggal = tanggal;
        this.attachment = attachment;
        this.keterangan = keterangan;
        this.status = status;
    }*/

    public int getIdPensiun() {
        return idPensiun;
    }

    public void setIdPensiun(int idPensiun) {
        this.idPensiun = idPensiun;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
