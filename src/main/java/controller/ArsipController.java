/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Penghuni;
import model.Surat;
import model.SuratKeluar;
import model.SuratMasuk;

/**
 *
 * @author LENOVO
 */
public class ArsipController {

    private final ArrayList<SuratMasuk> daftarSuratMasuk;
    private final ArrayList<SuratKeluar> daftarSuratKeluar;
    private final ArrayList<Penghuni> daftarPenghuni;

    public ArsipController() {

        daftarSuratMasuk = new ArrayList<>();
        daftarSuratKeluar = new ArrayList<>();
        daftarPenghuni = new ArrayList<>();

        buatDataDummy();
    }

    private void buatDataDummy() {

        SuratMasuk suratMasuk1 = new SuratMasuk(
                "001/Fakultas-Teknik/2026",
                "Surat Undangan Rapat",
                "20-09-2026",
                "Fakultas Teknik"
        );

        SuratKeluar suratKeluar1 = new SuratKeluar(
                "Surat Permohonan Kegiatan",
                3,
                "21-09-2026",
                "Fakultas Teknik"
        );

        Penghuni penghuni1 = new Penghuni(
                "Aditya Harsa Arga Putra",
                "2409086008",
                "Balikpapan",
                "TEKNIK",
                "S1-Teknik Geologi",
                "PENGHUNI AKTIF",
                ""
        );

        Penghuni penghuni2 = new Penghuni(
                "Reno Abdul Firman",
                "2509066031",
                "Bau-Bau",
                "TEKNIK",
                "S1-Teknik Kimia",
                "PENGHUNI AKTIF",
                ""
        );

        Penghuni penghuni3 = new Penghuni(
                "Abdul Gafar",
                "2209076044",
                "Penajam",
                "TEKNIK",
                "S1-Teknik Elektro",
                "ALUMNI",
                "lulus 2026"
        );

        daftarSuratMasuk.add(suratMasuk1);
        daftarSuratKeluar.add(suratKeluar1);

        daftarPenghuni.add(penghuni1);
        daftarPenghuni.add(penghuni2);
        daftarPenghuni.add(penghuni3);
    }

    public ArrayList<SuratMasuk> getDaftarSuratMasuk() {
        return daftarSuratMasuk;
    }

    public ArrayList<SuratKeluar> getDaftarSuratKeluar() {
        return daftarSuratKeluar;
    }

    public ArrayList<Penghuni> getDaftarPenghuni() {
        return daftarPenghuni;
    }

    // Tambah Surat Masuk
    public void tambahSuratMasuk(
            String nomorSurat,
            String perihal,
            String tanggalMasuk,
            String pengirim) {

        SuratMasuk suratBaru = new SuratMasuk(
                nomorSurat,
                perihal,
                tanggalMasuk,
                pengirim
        );

        daftarSuratMasuk.add(suratBaru);
    }

    // Edit Surat Masuk
    public void editSuratMasuk(
            int index,
            String nomorSurat,
            String perihal,
            String tanggalMasuk,
            String pengirim) {

        SuratMasuk surat = daftarSuratMasuk.get(index);

        if (!nomorSurat.isEmpty()) {
            surat.setNomorSurat(nomorSurat);
        }

        if (!perihal.isEmpty()) {
            surat.setPerihal(perihal);
        }

        if (!tanggalMasuk.isEmpty()) {
            surat.setTanggalMasukSurat(tanggalMasuk);
        }

        if (!pengirim.isEmpty()) {
            surat.setPengirim(pengirim);
        }
    }

    // Hapus Surat Masuk
    public void hapusSuratMasuk(int index) {
        daftarSuratMasuk.remove(index);
    }

    // Tambah Surat Keluar
    public void tambahSuratKeluar(
            String perihal,
            int kategori,
            String tanggalKeluar,
            String penerima) {

        SuratKeluar suratBaru = new SuratKeluar(
                perihal,
                kategori,
                tanggalKeluar,
                penerima
        );

        daftarSuratKeluar.add(suratBaru);
    }

    // Edit Surat Keluar
    public void editSuratKeluar(
            int index,
            String perihal,
            String tanggalKeluar,
            String penerima) {

        SuratKeluar surat = daftarSuratKeluar.get(index);

        if (!perihal.isEmpty()) {
            surat.setPerihal(perihal);
        }

        if (!tanggalKeluar.isEmpty()) {
            surat.setTanggalKeluarSurat(tanggalKeluar);
        }

        if (!penerima.isEmpty()) {
            surat.setPenerima(penerima);
        }
    }

    // Hapus Surat Keluar
    public void hapusSuratKeluar(int index) {
        daftarSuratKeluar.remove(index);
    }

    // Mencari surat
    public void cariSurat(String pihak) {

        boolean ditemukan = false;

        for (SuratMasuk surat : daftarSuratMasuk) {

            if (surat.getPengirim()
                    .toLowerCase()
                    .contains(pihak.toLowerCase())) {

                surat.tampilkanDaftarSurat();
                ditemukan = true;
            }
        }

        for (SuratKeluar surat : daftarSuratKeluar) {

            if (surat.getPenerima()
                    .toLowerCase()
                    .contains(pihak.toLowerCase())) {

                surat.tampilkanDaftarSurat();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println(
                    "Surat dengan pihak tersebut tidak ditemukan."
            );
        }
    }

    // Mencari surat keluar berdasarkan kategori
    public void cariSurat(int kategori) {

        boolean ditemukan = false;

        for (SuratKeluar surat : daftarSuratKeluar) {

            if (surat.getKategoriSuratAngka() == kategori) {

                surat.tampilkanDaftarSurat();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println(
                    "Surat keluar dengan kategori tersebut tidak ditemukan."
            );
        }
    }
}
