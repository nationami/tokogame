package com.tokogame.domain;

public class KoleksiRelation {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column koleksi_relation.pk_koleksi_relation
     *
     * @ibatorgenerated Tue May 14 23:15:06 ICT 2013
     */
    private Integer pkKoleksiRelation;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column koleksi_relation.fk_koleksi
     *
     * @ibatorgenerated Tue May 14 23:15:06 ICT 2013
     */
    private Integer fkKoleksi;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column koleksi_relation.fk_kategori
     *
     * @ibatorgenerated Tue May 14 23:15:06 ICT 2013
     */
    private Integer fkKategori;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column koleksi_relation.pk_koleksi_relation
     *
     * @return the value of koleksi_relation.pk_koleksi_relation
     *
     * @ibatorgenerated Tue May 14 23:15:06 ICT 2013
     */
    public Integer getPkKoleksiRelation() {
        return pkKoleksiRelation;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column koleksi_relation.pk_koleksi_relation
     *
     * @param pkKoleksiRelation the value for koleksi_relation.pk_koleksi_relation
     *
     * @ibatorgenerated Tue May 14 23:15:06 ICT 2013
     */
    public void setPkKoleksiRelation(Integer pkKoleksiRelation) {
        this.pkKoleksiRelation = pkKoleksiRelation;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column koleksi_relation.fk_koleksi
     *
     * @return the value of koleksi_relation.fk_koleksi
     *
     * @ibatorgenerated Tue May 14 23:15:06 ICT 2013
     */
    public Integer getFkKoleksi() {
        return fkKoleksi;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column koleksi_relation.fk_koleksi
     *
     * @param fkKoleksi the value for koleksi_relation.fk_koleksi
     *
     * @ibatorgenerated Tue May 14 23:15:06 ICT 2013
     */
    public void setFkKoleksi(Integer fkKoleksi) {
        this.fkKoleksi = fkKoleksi;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column koleksi_relation.fk_kategori
     *
     * @return the value of koleksi_relation.fk_kategori
     *
     * @ibatorgenerated Tue May 14 23:15:06 ICT 2013
     */
    public Integer getFkKategori() {
        return fkKategori;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column koleksi_relation.fk_kategori
     *
     * @param fkKategori the value for koleksi_relation.fk_kategori
     *
     * @ibatorgenerated Tue May 14 23:15:06 ICT 2013
     */
    public void setFkKategori(Integer fkKategori) {
        this.fkKategori = fkKategori;
    }
}