package Model;

public class PropertySearch1 {
    // tạo điều kiện Contructor search theo API
    private String apiId ;
    private String country;
    private String province_Area;
    private String location;
    private double priceFrom;
    private double priceTo;
    private String type_Subtype;
    private boolean onlyOwnProperties;
    private boolean onlyFeaturedProperties;
    private boolean ownPropertyFirst;
    private boolean onlyPreferredAgencies;
    private String urbanisation;
    private String  secureID;

    public PropertySearch1() {
    }
    public String getApiId() {
        return apiId;
    }
    public void setApiId(String apiId) {
        this.apiId = apiId;
    }
    public String getSearchType() {
        return apiId;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince_Area() {
        return province_Area;
    }

    public String getLocation() {
        return location;
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public String getType_Subtype() {
        return type_Subtype;
    }

    public boolean isOnlyOwnProperties() {
        return onlyOwnProperties;
    }

    public boolean isOnlyFeaturedProperties() {
        return onlyFeaturedProperties;
    }

    public boolean isOwnPropertyFirst() {
        return ownPropertyFirst;
    }

    public boolean isOnlyPreferredAgencies() {
        return onlyPreferredAgencies;
    }

    public String getUrbanisation() {
        return urbanisation;
    }

    public void setSearchType(String searchType) {
        this.apiId = searchType;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProvince_Area(String province_Area) {
        this.province_Area = province_Area;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }

    public void setType_Subtype(String type_Subtype) {
        this.type_Subtype = type_Subtype;
    }

    public void setOnlyOwnProperties(boolean onlyOwnProperties) {
        this.onlyOwnProperties = onlyOwnProperties;
    }

    public void setOnlyFeaturedProperties(boolean onlyFeaturedProperties) {
        this.onlyFeaturedProperties = onlyFeaturedProperties;
    }

    public void setOwnPropertyFirst(boolean ownPropertyFirst) {
        this.ownPropertyFirst = ownPropertyFirst;
    }

    public void setOnlyPreferredAgencies(boolean onlyPreferredAgencies) {
        this.onlyPreferredAgencies = onlyPreferredAgencies;
    }

    public String getSecureID() {
        return secureID;
    }

    public void setSecureID(String secureID) {
        this.secureID = secureID;
    }

    public void setUrbanisation(String urbanisation) {
        this.urbanisation = urbanisation;
    }
    public PropertySearch1(String apiId, String country, String province_Area, String location, double priceFrom, double priceTo, String type_Subtype, boolean onlyOwnProperties, boolean onlyFeaturedProperties, boolean ownPropertyFirst, boolean onlyPreferredAgencies, String urbanisation) {
        this.apiId = apiId;
        this.country = country;
        this.province_Area = province_Area;
        this.location = location;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.type_Subtype = type_Subtype;
        this.onlyOwnProperties = onlyOwnProperties;
        this.onlyFeaturedProperties = onlyFeaturedProperties;
        this.ownPropertyFirst = ownPropertyFirst;
        this.onlyPreferredAgencies = onlyPreferredAgencies;
        this.urbanisation = urbanisation;
    }

    public PropertySearch1(String apiId, String country, String province_Area, String location, double priceFrom, double priceTo, String type_Subtype, boolean onlyOwnProperties, boolean onlyFeaturedProperties, boolean ownPropertyFirst, boolean onlyPreferredAgencies, String urbanisation, String secureID) {
        this.apiId = apiId;
        this.country = country;
        this.province_Area = province_Area;
        this.location = location;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.type_Subtype = type_Subtype;
        this.onlyOwnProperties = onlyOwnProperties;
        this.onlyFeaturedProperties = onlyFeaturedProperties;
        this.ownPropertyFirst = ownPropertyFirst;
        this.onlyPreferredAgencies = onlyPreferredAgencies;
        this.urbanisation = urbanisation;
        this.secureID = secureID;
    }

    public PropertySearch1(String apiId, String country, String province_Area, String location, double priceFrom, double priceTo, String type_Subtype) {
        this.apiId = apiId;
        this.country = country;
        this.province_Area = province_Area;
        this.location = location;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.type_Subtype = type_Subtype;
    }

    @Override
    public String toString() {
        return "Model.PropertySearch1{" +
                "apiId='" + apiId + '\'' +
                ", country='" + country + '\'' +
                ", province_Area='" + province_Area + '\'' +
                ", location='" + location + '\'' +
                ", priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                ", type_Subtype='" + type_Subtype + '\'' +
                '}';
    }
}
