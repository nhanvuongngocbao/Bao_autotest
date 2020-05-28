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
    private int beds;
    private int baths;
    private int images;
    private String rentalType;
    private String rentalDateFrom;
    private String rentalDateTo;
    private String SearchType;


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

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
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

    public Property(String rsID, double price, String country, String province, String area, String location, String type, String subtype, int beds, int baths, int images, String rentalType, String rentalDateFrom, String rentalDateTo, String searchType) {
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
                '}';
    }
}
