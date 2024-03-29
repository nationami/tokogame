package com.tokogame.domain;

import java.util.Date;

public class Item {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.pk_item
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private Integer pkItem;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.fk_koleksi
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private Integer fkKoleksi;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.fk_kategori
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private Integer fkKategori;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.item_name
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private String itemName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.jenis_item
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private String jenisItem;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.file_size
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private String fileSize;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.harga
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private Integer harga;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.informasi_produk
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private String informasiProduk;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.informasi_lain
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private String informasiLain;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.item_qty
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private Integer itemQty;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.path
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private String path;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.updated_date
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private Date updatedDate;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column item.rating
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    private Integer rating;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.pk_item
     *
     * @return the value of item.pk_item
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public Integer getPkItem() {
        return pkItem;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.pk_item
     *
     * @param pkItem the value for item.pk_item
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setPkItem(Integer pkItem) {
        this.pkItem = pkItem;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.fk_koleksi
     *
     * @return the value of item.fk_koleksi
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public Integer getFkKoleksi() {
        return fkKoleksi;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.fk_koleksi
     *
     * @param fkKoleksi the value for item.fk_koleksi
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setFkKoleksi(Integer fkKoleksi) {
        this.fkKoleksi = fkKoleksi;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.fk_kategori
     *
     * @return the value of item.fk_kategori
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public Integer getFkKategori() {
        return fkKategori;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.fk_kategori
     *
     * @param fkKategori the value for item.fk_kategori
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setFkKategori(Integer fkKategori) {
        this.fkKategori = fkKategori;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.item_name
     *
     * @return the value of item.item_name
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.item_name
     *
     * @param itemName the value for item.item_name
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.jenis_item
     *
     * @return the value of item.jenis_item
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public String getJenisItem() {
        return jenisItem;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.jenis_item
     *
     * @param jenisItem the value for item.jenis_item
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setJenisItem(String jenisItem) {
        this.jenisItem = jenisItem == null ? null : jenisItem.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.file_size
     *
     * @return the value of item.file_size
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.file_size
     *
     * @param fileSize the value for item.file_size
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.harga
     *
     * @return the value of item.harga
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public Integer getHarga() {
        return harga;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.harga
     *
     * @param harga the value for item.harga
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.informasi_produk
     *
     * @return the value of item.informasi_produk
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public String getInformasiProduk() {
        return informasiProduk;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.informasi_produk
     *
     * @param informasiProduk the value for item.informasi_produk
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setInformasiProduk(String informasiProduk) {
        this.informasiProduk = informasiProduk == null ? null : informasiProduk.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.informasi_lain
     *
     * @return the value of item.informasi_lain
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public String getInformasiLain() {
        return informasiLain;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.informasi_lain
     *
     * @param informasiLain the value for item.informasi_lain
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setInformasiLain(String informasiLain) {
        this.informasiLain = informasiLain == null ? null : informasiLain.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.item_qty
     *
     * @return the value of item.item_qty
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public Integer getItemQty() {
        return itemQty;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.item_qty
     *
     * @param itemQty the value for item.item_qty
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.path
     *
     * @return the value of item.path
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.path
     *
     * @param path the value for item.path
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.updated_date
     *
     * @return the value of item.updated_date
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.updated_date
     *
     * @param updatedDate the value for item.updated_date
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column item.rating
     *
     * @return the value of item.rating
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column item.rating
     *
     * @param rating the value for item.rating
     *
     * @ibatorgenerated Thu May 09 00:35:39 ICT 2013
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }
}