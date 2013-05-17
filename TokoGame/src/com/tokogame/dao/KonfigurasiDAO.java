package com.tokogame.dao;

import com.tokogame.domain.Konfigurasi;
import com.tokogame.domain.KonfigurasiExample;
import java.util.List;

public interface KonfigurasiDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    int countByExample(KonfigurasiExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    int deleteByExample(KonfigurasiExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    int deleteByPrimaryKey(Integer pkKonfigurasi);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    void insert(Konfigurasi record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    void insertSelective(Konfigurasi record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    List<Konfigurasi> selectByExample(KonfigurasiExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    Konfigurasi selectByPrimaryKey(Integer pkKonfigurasi);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    int updateByExampleSelective(Konfigurasi record, KonfigurasiExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    int updateByExample(Konfigurasi record, KonfigurasiExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    int updateByPrimaryKeySelective(Konfigurasi record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table konfigurasi
     *
     * @ibatorgenerated Sat May 11 00:38:31 ICT 2013
     */
    int updateByPrimaryKey(Konfigurasi record);
}