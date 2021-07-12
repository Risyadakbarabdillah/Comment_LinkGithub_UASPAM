package com.akbar.doolanzquiz.model;

import java.io.Serializable;

public class ModelSoal implements Serializable

    {
        private String id_soal="";
        private String nama_soal="";
        private String jawaban1="";
        private String jawaban2="";
        private String jawaban3="";

        public String getId_soal() {
        return id_soal;
    }

        public void setId_soal(String id_soal) {
        this.id_soal = id_soal;
    }

        public String getNama_soal() {
        return nama_soal;
    }

        public void setNama_soal(String nama_soal) {
        this.nama_soal = nama_soal;
    }

        public String getJawaban1() {
        return jawaban1;
    }

        public void setJawaban1(String jawaban1) {
        this.jawaban1 = jawaban1;
    }

        public String getJawaban2() {
        return jawaban2;
    }

        public void setJawaban2(String jawaban2) {
        this.jawaban2 = jawaban2;
    }

        public String getJawaban3() {
        return jawaban3;
    }

        public void setJawaban3(String jawaban3) {
        this.jawaban3 = jawaban3;
    }

    @Override
        public String toString(){
        return "banksoal{" +
                "id_soal='" + id_soal + '\''+
                ", nama_soal='" + nama_soal + '\''+
                ", jawaban1='" + jawaban1 + '\''+
                ", jawaban2='" + jawaban2 + '\''+
                ", jawaban3='" + jawaban3 + '\''+
                '}';
    }
}
/koding soal yang berisi pertanyaan jawaban soal/
