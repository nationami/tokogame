package com.tokogame.domain;

public class PembelianDetail {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pembelian_detail.pk_pembelian_detail
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    private Integer pkPembelianDetail;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pembelian_detail.fk_pembelian
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    private Integer fkPembelian;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pembelian_detail.fk_item
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    private Integer fkItem;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pembelian_detail.harga_pembelian
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    private Integer hargaPembelian;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pembelian_detail.pembelian_qty
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    private Integer pembelianQty;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pembelian_detail.keterangan
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    private String keterangan;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pembelian_detail.pk_pembelian_detail
     *
     * @return the value of pembelian_detail.pk_pembelian_detail
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public Integer getPkPembelianDetail() {
        return pkPembelianDetail;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pembelian_detail.pk_pembelian_detail
     *
     * @param pkPembelianDetail the value for pembelian_detail.pk_pembelian_detail
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public void setPkPembelianDetail(Integer pkPembelianDetail) {
        this.pkPembelianDetail = pkPembelianDetail;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pembelian_detail.fk_pembelian
     *
     * @return the value of pembelian_detail.fk_pembelian
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public Integer getFkPembelian() {
        return fkPembelian;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pembelian_detail.fk_pembelian
     *
     * @param fkPembelian the value for pembelian_detail.fk_pembelian
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public void setFkPembelian(Integer fkPembelian) {
        this.fkPembelian = fkPembelian;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pembelian_detail.fk_item
     *
     * @return the value of pembelian_detail.fk_item
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public Integer getFkItem() {
        return fkItem;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pembelian_detail.fk_item
     *
     * @param fkItem the value for pembelian_detail.fk_item
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public void setFkItem(Integer fkItem) {
        this.fkItem = fkItem;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pembelian_detail.harga_pembelian
     *
     * @return the value of pembelian_detail.harga_pembelian
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public Integer getHargaPembelian() {
        return hargaPembelian;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pembelian_detail.harga_pembelian
     *
     * @param hargaPembelian the value for pembelian_detail.harga_pembelian
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public void setHargaPembelian(Integer hargaPembelian) {
        this.hargaPembelian = hargaPembelian;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pembelian_detail.pembelian_qty
     *
     * @return the value of pembelian_detail.pembelian_qty
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public Integer getPembelianQty() {
        return pembelianQty;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pembelian_detail.pembelian_qty
     *
     * @param pembelianQty the value for pembelian_detail.pembelian_qty
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public void setPembelianQty(Integer pembelianQty) {
        this.pembelianQty = pembelianQty;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pembelian_detail.keterangan
     *
     * @return the value of pembelian_detail.keterangan
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pembelian_detail.keterangan
     *
     * @param keterangan the value for pembelian_detail.keterangan
     *
     * @ibatorgenerated Thu May 16 17:47:54 ICT 2013
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan == null ? null : keterangan.trim();
    }
}