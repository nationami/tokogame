package com.tokogame.domain;

import java.util.Date;

public class Sequence {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column sequence.sequence_no
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    private Integer sequenceNo;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column sequence.sequence_name
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    private String sequenceName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column sequence.sequence_date
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    private Date sequenceDate;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column sequence.sequence_no
     *
     * @return the value of sequence.sequence_no
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public Integer getSequenceNo() {
        return sequenceNo;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column sequence.sequence_no
     *
     * @param sequenceNo the value for sequence.sequence_no
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column sequence.sequence_name
     *
     * @return the value of sequence.sequence_name
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public String getSequenceName() {
        return sequenceName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column sequence.sequence_name
     *
     * @param sequenceName the value for sequence.sequence_name
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName == null ? null : sequenceName.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column sequence.sequence_date
     *
     * @return the value of sequence.sequence_date
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public Date getSequenceDate() {
        return sequenceDate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column sequence.sequence_date
     *
     * @param sequenceDate the value for sequence.sequence_date
     *
     * @ibatorgenerated Tue Apr 30 23:45:56 ICT 2013
     */
    public void setSequenceDate(Date sequenceDate) {
        this.sequenceDate = sequenceDate;
    }
}