package com.tokogame.dao;

import com.tokogame.domain.Pembelian;
import com.tokogame.domain.PembelianExample;
import java.util.List;

public interface PembelianDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    int countByExample(PembelianExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    int deleteByExample(PembelianExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    int deleteByPrimaryKey(Integer pkPembelian);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    void insert(Pembelian record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    void insertSelective(Pembelian record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    List<Pembelian> selectByExample(PembelianExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    Pembelian selectByPrimaryKey(Integer pkPembelian);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    int updateByExampleSelective(Pembelian record, PembelianExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    int updateByExample(Pembelian record, PembelianExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    int updateByPrimaryKeySelective(Pembelian record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pembelian
     *
     * @ibatorgenerated Wed May 15 22:57:03 ICT 2013
     */
    int updateByPrimaryKey(Pembelian record);
}