package com.tokogame.domain;

import java.util.Date;

public class Belanja {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column belanja.pk_belanja
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    private Integer pkBelanja;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column belanja.fk_user
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    private Integer fkUser;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column belanja.kode_belanja
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    private String kodeBelanja;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column belanja.kode_autentikasi
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    private String kodeAutentikasi;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column belanja.total_item
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    private Integer totalItem;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column belanja.total_harga
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    private Integer totalHarga;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column belanja.updated_date
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    private Date updatedDate;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column belanja.status
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    private String status;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column belanja.pk_belanja
     *
     * @return the value of belanja.pk_belanja
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public Integer getPkBelanja() {
        return pkBelanja;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column belanja.pk_belanja
     *
     * @param pkBelanja the value for belanja.pk_belanja
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public void setPkBelanja(Integer pkBelanja) {
        this.pkBelanja = pkBelanja;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column belanja.fk_user
     *
     * @return the value of belanja.fk_user
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public Integer getFkUser() {
        return fkUser;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column belanja.fk_user
     *
     * @param fkUser the value for belanja.fk_user
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public void setFkUser(Integer fkUser) {
        this.fkUser = fkUser;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column belanja.kode_belanja
     *
     * @return the value of belanja.kode_belanja
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public String getKodeBelanja() {
        return kodeBelanja;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column belanja.kode_belanja
     *
     * @param kodeBelanja the value for belanja.kode_belanja
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public void setKodeBelanja(String kodeBelanja) {
        this.kodeBelanja = kodeBelanja == null ? null : kodeBelanja.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column belanja.kode_autentikasi
     *
     * @return the value of belanja.kode_autentikasi
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public String getKodeAutentikasi() {
        return kodeAutentikasi;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column belanja.kode_autentikasi
     *
     * @param kodeAutentikasi the value for belanja.kode_autentikasi
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public void setKodeAutentikasi(String kodeAutentikasi) {
        this.kodeAutentikasi = kodeAutentikasi == null ? null : kodeAutentikasi.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column belanja.total_item
     *
     * @return the value of belanja.total_item
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public Integer getTotalItem() {
        return totalItem;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column belanja.total_item
     *
     * @param totalItem the value for belanja.total_item
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column belanja.total_harga
     *
     * @return the value of belanja.total_harga
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public Integer getTotalHarga() {
        return totalHarga;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column belanja.total_harga
     *
     * @param totalHarga the value for belanja.total_harga
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public void setTotalHarga(Integer totalHarga) {
        this.totalHarga = totalHarga;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column belanja.updated_date
     *
     * @return the value of belanja.updated_date
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column belanja.updated_date
     *
     * @param updatedDate the value for belanja.updated_date
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column belanja.status
     *
     * @return the value of belanja.status
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column belanja.status
     *
     * @param status the value for belanja.status
     *
     * @ibatorgenerated Mon May 06 23:07:04 ICT 2013
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}