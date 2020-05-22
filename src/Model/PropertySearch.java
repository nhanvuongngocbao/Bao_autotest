package Model;

import java.util.ArrayList;

public class PropertySearch {
    private String searchType;
    private String country;
    private String province_Area;
    private ArrayList<String> Location;
    private double priceFrom;
    private double priceTo;
    private ArrayList<String> type_Subtype;
    private boolean onlyOwnProperties;
    private boolean onlyFeaturedProperties;
    private boolean ownPropertyFirst;
    private boolean onlyPreferredAgencies;
    private ArrayList<String> urbanisation;

    public PropertySearch() {
    }

    public PropertySearch(String searchType, String country, String province_Area, ArrayList<String> location, double priceFrom, double priceTo, ArrayList<String> type_Subtype, boolean onlyOwnProperties, boolean onlyFeaturedProperties, boolean ownPropertyFirst, boolean onlyPreferredAgencies, ArrayList<String> urbanisation) {
        this.searchType = searchType;
        this.country = country;
        this.province_Area = province_Area;
        Location = location;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.type_Subtype = type_Subtype;
        this.onlyOwnProperties = onlyOwnProperties;
        this.onlyFeaturedProperties = onlyFeaturedProperties;
        this.ownPropertyFirst = ownPropertyFirst;
        this.onlyPreferredAgencies = onlyPreferredAgencies;
        this.urbanisation = urbanisation;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }

    public void setLocation(ArrayList<String> location) {
        Location = location;
    }

    public void setOnlyFeaturedProperties(boolean onlyFeaturedProperties) {
        this.onlyFeaturedProperties = onlyFeaturedProperties;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setProvince_Area(String province_Area) {
        this.province_Area = province_Area;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public void setType_Subtype(ArrayList<String> type_Subtype) {
        this.type_Subtype = type_Subtype;
    }

    public void setOnlyOwnProperties(boolean onlyOwnProperties) {
        this.onlyOwnProperties = onlyOwnProperties;
    }

    public void setOnlyPreferredAgencies(boolean onlyPreferredAgencies) {
        this.onlyPreferredAgencies = onlyPreferredAgencies;
    }

    public void setOwnPropertyFirst(boolean ownPropertyFirst) {
        this.ownPropertyFirst = ownPropertyFirst;
    }

    public void setUrbanisation(ArrayList<String> urbanisation) {
        this.urbanisation = urbanisation;
    }
    public ArrayList<String> getLocation() {
        return Location;
    }

    public ArrayList<String> getType_Subtype() {
        return type_Subtype;
    }

    public ArrayList<String> getUrbanisation() {
        return urbanisation;
    }

    public boolean isOnlyFeaturedProperties() {
        return onlyFeaturedProperties;
    }
    public boolean isOnlyOwnProperties() {
        return onlyOwnProperties;
    }

    public boolean isOnlyPreferredAgencies() {
        return onlyPreferredAgencies;
    }

    public boolean isOwnPropertyFirst() {
        return ownPropertyFirst;
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince_Area() {
        return province_Area;
    }

    public String getSearchType() {
        return searchType;
    }

    @Override
    public String toString() {
        return "Model.PropertySearch{" +
                "searchType='" + searchType + '\'' +
                ", country='" + country + '\'' +
                ", province_Area='" + province_Area + '\'' +
                ", Location=" + Location +
                ", priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                ", type_Subtype=" + type_Subtype +
                ", onlyOwnProperties=" + onlyOwnProperties +
                ", onlyFeaturedProperties=" + onlyFeaturedProperties +
                ", ownPropertyFirst=" + ownPropertyFirst +
                ", onlyPreferredAgencies=" + onlyPreferredAgencies +
                ", urbanisation=" + urbanisation +
                '}';
    }
}
