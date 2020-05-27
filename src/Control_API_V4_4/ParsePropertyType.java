package Control_API_V4_4;

public class ParsePropertyType {
    public static String ParsePropertyType(String type){
        String kq = "";
        switch (type) {
            case "Apartment":
                kq= "1-1";
            break;
            case "House":
                kq= "2-1";
            break;
            case "Plot":
                kq= "3-1";
            break;
            case "Commercial":
                kq= "4-1";
            break;
            case "Ground Floor Apartment":
                kq="1-2";
            break;
            case "Middle Floor Apartment":
                kq= "1-4";
            break;
            case "Top Floor Apartment":
                kq= "1-5";
            break;
            case "Penthouse":
                kq= "1-6";
            break;
            case "Ground Floor Studio":
                kq= "1-7";
            break;
            case "Middle Floor Studio":
                kq= "1-8";
            break;
            case "Top Floor Studio":
                kq= "1-9";
            break;
            case "Detached Villa":
                kq= "2-2";
            break;
            case "Semi-Detached House":
                kq= "2-4";
            break;
            case "Townhouse":
                kq= "2-5";
            break;
            case "Finca - Cortijo":
                kq= "2-6";
            break;
            case "Bungalow":
                kq= "2-9";
            break;
            case "Quad":
                kq= "2-10";
            break;
            case "Castle":
                kq= "2-12";
            break;
            case "City Palace":
                kq= "2-13";
            break;
            case "Wooden Cabin":
                kq= "2-14";
            break;
            case "Wooden House":
                kq= "2-15";
            break;
            case "Mobile Home":
                kq= "2-16";
            break;
            case "Cave Home":
                kq= "2-17";
            break;
            case "Residential Plot":
                kq= "3-2";
            break;
            case "Commercial Plot":
                kq= "3-3";
            break;
            case "Land":
                kq= "3-4";
            break;
            case "Land with Ruin":
                kq= "3-5";
            break;
            case "Bar":
                kq= "4-2";
            break;
            case "Restaurant":
                kq= "4-3";
            break;
            case "Café":
                kq= "4-4";
            break;
            case "Hotel":
                kq= "4-5";
            break;
            case "Hostel":
                kq= "4-6";
            break;
            case "Bed and Breakfast":
                kq= "4-8";
            break;
            case "Guest House":
                kq= "4-7";
            break;
            case "Shop":
                kq= "4-9";
            break;
            case "Office":
                kq= "4-10";
            break;
            case "Storage Room":
                kq= "4-11";
            break;
            case "Parking Space":
                kq= "4-12";
            break;
            case "Farm":
                kq= "4-13";
            break;
            case "Night Club":
                kq= "4-15";
            break;
            case "Warehouse":
                kq= "4-16";
            break;
            case "Garage":
                kq= "4-17";
            break;
            case "Business":
                kq= "4-18";
            break;
            case "Mooring":
                kq= "4-19";
            break;
            case "Stables":
                kq= "4-20";
            break;
            case "Kiosk":
                kq= "4-21";
            break;
            case "Chiringuito":
                kq= "4-22";
            break;
            case "Beach Bar":
                kq= "4-23";
            break;
            case "Mechanics":
                kq= "4-24";
            break;
            case "Hairdressers":
                kq= "4-25";
            break;
            case "Photography Studio":
                kq= "4-26";
            break;
            case "Laundry":
                kq= "4-27";
            break;
            case "Aparthotel":
                kq= "4-28";
            break;
            case "Apartment Complex":
                kq= "4-29";
            break;
            case "Residential Home":
                kq= "4-30";
            break;
            case "Vineyard":
                kq= "4-32";
            break;
            case "Olive Grove":
                kq= "4-33";
            break;
            case "Car Park":
                kq= "4-34";
            break;
            case "Commercial Premises":
                kq= "4-35";
            break;
            case "Campsite":
                kq= "4-36";
            break;
            case "With Residence":
                kq= "4-37";
            break;
            case "Others":
                kq= "4-100";
            break;
        }
        return kq;
    }
}
