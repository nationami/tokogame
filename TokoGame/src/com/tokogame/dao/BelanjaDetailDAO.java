package com.tokogame.dao;

import com.tokogame.domain.BelanjaDetail;
import com.tokogame.domain.BelanjaDetailExample;
import java.util.List;

public interface BelanjaDetailDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table belanja_detail
     *
     * @ibatorgenerated Thu May 09 22:54:14 ICT 2013
     */
    int countByExample(BelanjaDetailExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table belanja_detail
     *
     * @ibatorgenerated Thu May 09 22:54:14 ICT 2013
     */
    int deleteByExample(BelanjaDetailExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table belanja_detail
     *
     * @ibatorgenerated Thu May 09 22:54:14 ICT 2013
     */
    int deleteByPrimaryKey(Integer pkBelanjaDetail);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table belanja_detail
     *
     * @ibatorgenerated Thu May 09 22:54:14 ICT 2013
     */
    void insert(BelanjaDetail record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table belanja_detail
     *
     * @ibatorgenerated Thu May 09 22:54:14 ICT 2013
     */
    void insertSelective(BelanjaDetail record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table belanja_detail
     *
     * @ibatorgenerated Thu May 09 22:54:14 ICT 2013
     */
    List<BelanjaDetail> selectByExample(BelanjaDetailExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table belanja_detail
     *
     * @ibatorgenerated Thu May 09 22:54:14 ICT 2013
     */
    BelanjaDetail selectByPrimaryKey(Integer pkBelanjaDetail);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table belanja_detail
     *
     * @ibatorgenerated Thu May 09 22:54:14 ICT 2013
     */
    int updateByExampleSelective(BelanjaDetail record, BelanjaDetailExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table belanja_detail
     *
     * @ibatorgenerated Thu May 09 22:54:14 ICT 2013
     */
    int updateByExample(BelanjaDetail record, BelanjaDetailExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table belanja_detail
     *
     * @ibatorgenerated Thu May 09 22:54:14 ICT 2013
     */
    int updateByPrimaryKeySelective(BelanjaDetail record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table belanja_detail
     *
     * @ibatorgenerated Thu May 09 22:54:14 ICT 2013
     */
    int updateByPrimaryKey(BelanjaDetail record);
}