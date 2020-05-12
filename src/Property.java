public class Property {
    private String rsID;
    private double price;


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

    @Override
    public String toString() {
        return "Property{" +
                "rsID='" + rsID + '\'' +
                ", price=" + price +
                '}';
    }
}
