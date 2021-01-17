package com.fh.entity.po;

public class Value {
    private Integer id;

    private String value;

    private String valueCH;

    private Integer propertyId;

    private int   isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueCH() {
        return valueCH;
    }

    public void setValueCH(String valueCH) {
        this.valueCH = valueCH;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }
}
