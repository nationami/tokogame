package com.tokogame.domain;

import java.util.Date;

public class Pembelian {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pembelian.pk_pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    private Integer pkPembelian;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pembelian.nota
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    private String nota;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pembelian.supplier
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    private String supplier;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pembelian.tanggal_beli
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    private Date tanggalBeli;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pembelian.pk_pembelian
     *
     * @return the value of pembelian.pk_pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public Integer getPkPembelian() {
        return pkPembelian;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pembelian.pk_pembelian
     *
     * @param pkPembelian the value for pembelian.pk_pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public void setPkPembelian(Integer pkPembelian) {
        this.pkPembelian = pkPembelian;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pembelian.nota
     *
     * @return the value of pembelian.nota
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public String getNota() {
        return nota;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pembelian.nota
     *
     * @param nota the value for pembelian.nota
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public void setNota(String nota) {
        this.nota = nota == null ? null : nota.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pembelian.supplier
     *
     * @return the value of pembelian.supplier
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pembelian.supplier
     *
     * @param supplier the value for pembelian.supplier
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pembelian.tanggal_beli
     *
     * @return the value of pembelian.tanggal_beli
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public Date getTanggalBeli() {
        return tanggalBeli;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pembelian.tanggal_beli
     *
     * @param tanggalBeli the value for pembelian.tanggal_beli
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    public void setTanggalBeli(Date tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
    }
}