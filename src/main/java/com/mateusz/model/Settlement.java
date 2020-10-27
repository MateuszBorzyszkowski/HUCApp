package com.mateusz.model;

public class Settlement {
    private String vendorName;
    private String placeName;
    private String meterStatus;
    private String measurementDate;

    public Settlement(String vendorName, String placeName, String meterStatus, String measurementDate) {
        this.vendorName = vendorName;
        this.placeName = placeName;
        this.meterStatus = meterStatus;
        this.measurementDate = measurementDate;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getMeterStatus() {
        return meterStatus;
    }

    public void setMeterStatus(String meterStatus) {
        this.meterStatus = meterStatus;
    }

    public String getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(String measurementDate) {
        this.measurementDate = measurementDate;
    }
}
