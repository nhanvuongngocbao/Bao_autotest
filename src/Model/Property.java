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

    @Override
    public String toString() {
        return "Model.Property{" +
                "rsID='" + rsID + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", area='" + area + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", subtype='" + subtype + '\'' +
                '}';
    }
}
