package Model;

public class Property {
    private String rsID;
    private double price;
    private String country;
    private String province;
    private String area;
    private String location;
    private String type;
    private String subtype;
    private String beds;
    private String baths;
    private String images;
    private String rentalType;
    private String rentalDateFrom;
    private String rentalDateTo;
    private String SearchType;
    private double priceRentalLong;
    private double priceRentalShort;
    private String devID;
    private double shortTermRentLow;
    private double shortTermRentHigh;
    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getArea() {
        return area;
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getLocation() {
        return location;
    }

    public Property(){

    }
    public Property(String rsID,double price){
        this.rsID= rsID;
        this.price=price;
    }
    public String getRsID(){
        return rsID;
    }

    public double getPrice() {
        return price;
    }

    public void setRsID(String rsID) {
        this.rsID = rsID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Property(String rsID, double price, String country, String province, String area, String location, String type, String subtype) {
        this.rsID = rsID;
        this.price = price;
        this.country = country;
        this.province = province;
        this.area = area;
        this.location = location;
        this.type = type;
        this.subtype = subtype;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getBaths() {
        return baths;
    }

    public void setBaths(String baths) {
        this.baths = baths;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getRentalDateFrom() {
        return rentalDateFrom;
    }

    public void setRentalDateFrom(String rentalDateFrom) {
        this.rentalDateFrom = rentalDateFrom;
    }

    public String getRentalDateTo() {
        return rentalDateTo;
    }

    public void setRentalDateTo(String rentalDateTo) {
        this.rentalDateTo = rentalDateTo;
    }

    public String getSearchType() {
        return SearchType;
    }

    public void setSearchType(String searchType) {
        SearchType = searchType;
    }

    public Property(String rsID, double price, String country, String province, String area, String location, String type, String subtype, String beds, String baths, String images, String rentalType, String rentalDateFrom, String rentalDateTo, String searchType) {
        this.rsID = rsID;
        this.price = price;
        this.country = country;
        this.province = province;
        this.area = area;
        this.location = location;
        this.type = type;
        this.subtype = subtype;
        this.beds = beds;
        this.baths = baths;
        this.images = images;
        this.rentalType = rentalType;
        this.rentalDateFrom = rentalDateFrom;
        this.rentalDateTo = rentalDateTo;
        SearchType = searchType;
    }

    public double getPriceRentalLong() {
        return priceRentalLong;
    }

    public void setPriceRentalLong(double priceRentalLong) {
        this.priceRentalLong = priceRentalLong;
    }

    public double getPriceRentalShort() {
        return priceRentalShort;
    }

    public void setPriceRentalShort(double priceRentalShort) {
        this.priceRentalShort = priceRentalShort;
    }

    public Property(String rsID, double price, String country, String province, String area, String location, String type, String subtype, String beds, String baths, String images, String rentalType, String rentalDateFrom, String rentalDateTo, String searchType, double priceRentalLong, double priceRentalShort) {
        this.rsID = rsID;
        this.price = price;
        this.country = country;
        this.province = province;
        this.area = area;
        this.location = location;
        this.type = type;
        this.subtype = subtype;
        this.beds = beds;
        this.baths = baths;
        this.images = images;
        this.rentalType = rentalType;
        this.rentalDateFrom = rentalDateFrom;
        this.rentalDateTo = rentalDateTo;
        SearchType = searchType;
        this.priceRentalLong = priceRentalLong;
        this.priceRentalShort = priceRentalShort;
    }

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public Property(String rsID, double price, String country, String province, String area, String location, String type, String subtype, String beds, String baths, String images, String rentalType, String rentalDateFrom, String rentalDateTo, String searchType, double priceRentalLong, double priceRentalShort, String devID) {
        this.rsID = rsID;
        this.price = price;
        this.country = country;
        this.province = province;
        this.area = area;
        this.location = location;
        this.type = type;
        this.subtype = subtype;
        this.beds = beds;
        this.baths = baths;
        this.images = images;
        this.rentalType = rentalType;
        this.rentalDateFrom = rentalDateFrom;
        this.rentalDateTo = rentalDateTo;
        SearchType = searchType;
        this.priceRentalLong = priceRentalLong;
        this.priceRentalShort = priceRentalShort;
        this.devID = devID;
    }

    public double getShortTermRentLow() {
        return shortTermRentLow;
    }

    public void setShortTermRentLow(double shortTermRentLow) {
        this.shortTermRentLow = shortTermRentLow;
    }

    public double getShortTermRentHigh() {
        return shortTermRentHigh;
    }

    public void setShortTermRentHigh(double shortTermRentHigh) {
        this.shortTermRentHigh = shortTermRentHigh;
    }

    public Property(String rsID, double price, String country, String province, String area, String location, String type, String subtype, String beds, String baths, String images, String rentalType, String rentalDateFrom, String rentalDateTo, String searchType, double priceRentalLong, double priceRentalShort, String devID, double shortTermRentLow, double shortTermRentHigh) {
        this.rsID = rsID;
        this.price = price;
        this.country = country;
        this.province = province;
        this.area = area;
        this.location = location;
        this.type = type;
        this.subtype = subtype;
        this.beds = beds;
        this.baths = baths;
        this.images = images;
        this.rentalType = rentalType;
        this.rentalDateFrom = rentalDateFrom;
        this.rentalDateTo = rentalDateTo;
        SearchType = searchType;
        this.priceRentalLong = priceRentalLong;
        this.priceRentalShort = priceRentalShort;
        this.devID = devID;
        this.shortTermRentLow = shortTermRentLow;
        this.shortTermRentHigh = shortTermRentHigh;
    }

    @Override
    public String toString() {
        return "Property{" +
                "rsID='" + rsID + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", area='" + area + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", subtype='" + subtype + '\'' +
                ", beds=" + beds +
                ", baths=" + baths +
                ", images=" + images +
                ", rentalType='" + rentalType + '\'' +
                ", rentalDateFrom='" + rentalDateFrom + '\'' +
                ", rentalDateTo='" + rentalDateTo + '\'' +
                ", SearchType='" + SearchType + '\'' +
                ", priceRentalLong=" + priceRentalLong +
                ", priceRentalShort=" + priceRentalShort +
                ", devID='" + devID + '\'' +
                ", shortTermRentLow=" + shortTermRentLow +
                ", shortTermRentHigh=" + shortTermRentHigh +
                '}';
    }
}
