package Control;

import Model.PropertySearch1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static ArrayList<String> readCsvFile(String fileName) throws IOException {
        // Đọc file CSV theo mẫu
        // Đưa ra danh ách các API request
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            String line;
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                list.add(xuLy(parseCsvLine(line)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        return list;
    }

    public static PropertySearch1 parseCsvLine(String csvLine) {
        // Đọc 1 line CSV thành đối tượng
        // Author Bao Nhan
        // Create on 15-May-2020
        PropertySearch1 p = new PropertySearch1("", "", "", "", 0, 0, "");
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            p.setApiId(splitData[0]);
            p.setCountry(splitData[1]);
            p.setProvince_Area(splitData[2]);
            p.setLocation(splitData[3]);
            p.setPriceFrom(Double.parseDouble(splitData[4]));
            p.setPriceTo(Double.parseDouble(splitData[5]));
            p.setType_Subtype(splitData[6]);
        }
        return p;
    }

    public static String xuLy(PropertySearch1 pro) {
        // Đọc file CSV sau đó generate ra 1 câu API request
        String st = "feature-602.git.env1.resales-online.com/WebApi/V5-3/SearchProperties.php?p1=1000610&p2=879dab3e2ed47c64e1c76f4d6f364e53b9432a3d";
        StringBuilder bulider = new StringBuilder();
        bulider.append(st);
        if (!pro.getApiId().equals("no")) {
            bulider.append("&p_apiid=" + pro.getApiId());
        }
        if (!pro.getCountry().equals("no")) {
            bulider.append("&p_Country=" + pro.getCountry());
        }
        if (!pro.getProvince_Area().equals("no")) {
            bulider.append("&p_area=" + pro.getProvince_Area());
        }
        if (!pro.getLocation().equals("no")) {
            bulider.append("&p_location=" + pro.getLocation());
        }
        if (pro.getPriceFrom() != 0) {
            bulider.append("&p_Min=" + pro.getPriceFrom());
        }
        if (pro.getPriceTo() != 0) {
            bulider.append("&p_Max=" + pro.getPriceTo());
        }

        switch (pro.getType_Subtype()) {
            case "Apartment":
                bulider.append("&p_PropertyTypes=1-1");
                break;
            case "House":
                bulider.append("&p_PropertyTypes=2-1");
                break;
            case "Plot":
                bulider.append("&p_PropertyTypes=3-1");
                break;
            case "Commercial":
                bulider.append("&p_PropertyTypes=4-1");
                break;
            case "Ground Floor Apartment":
                bulider.append("&p_PropertyTypes=1-2");
                break;
            case "Middle Floor Apartment":
                bulider.append("&p_PropertyTypes=1-4");
                break;
            case "Top Floor Apartment":
                bulider.append("&p_PropertyTypes=1-5");
                break;
            case "Penthouse":
                bulider.append("&p_PropertyTypes=1-6");
                break;
            case "Ground Floor Studio":
                bulider.append("&p_PropertyTypes=1-7");
                break;
            case "Middle Floor Studio":
                bulider.append("&p_PropertyTypes=1-8");
                break;
            case "Top Floor Studio":
                bulider.append("&p_PropertyTypes=1-9");
                break;
            case "Detached Villa":
                bulider.append("&p_PropertyTypes=2-2");
                break;
            case "Semi-Detached House":
                bulider.append("&p_PropertyTypes=2-4");
                break;
            case "Townhouse":
                bulider.append("&p_PropertyTypes=2-5");
                break;
            case "Finca - Cortijo":
                bulider.append("&p_PropertyTypes=2-6");
                break;
            case "Bungalow":
                bulider.append("&p_PropertyTypes=2-9");
                break;
            case "Quad":
                bulider.append("&p_PropertyTypes=2-10");
                break;
            case "Castle":
                bulider.append("&p_PropertyTypes=2-12");
                break;
            case "City Palace":
                bulider.append("&p_PropertyTypes=2-13");
                break;
            case "Wooden Cabin":
                bulider.append("&p_PropertyTypes=2-14");
                break;
            case "Wooden House":
                bulider.append("&p_PropertyTypes=2-15");
                break;
            case "Mobile Home":
                bulider.append("&p_PropertyTypes=2-16");
                break;
            case "Cave Home":
                bulider.append("&p_PropertyTypes=2-17");
                break;
            case "Residential Plot":
                bulider.append("&p_PropertyTypes=3-2");
                break;
            case "Commercial Plot":
                bulider.append("&p_PropertyTypes=3-3");
                break;
            case "Land":
                bulider.append("&p_PropertyTypes=3-4");
                break;
            case "Land with Ruin":
                bulider.append("&p_PropertyTypes=3-5");
                break;
            case "Bar":
                bulider.append("&p_PropertyTypes=4-2");
                break;
            case "Restaurant":
                bulider.append("&p_PropertyTypes=4-3");
                break;
            case "Café":
                bulider.append("&p_PropertyTypes=4-4");
                break;
            case "Hotel":
                bulider.append("&p_PropertyTypes=4-5");
                break;
            case "Hostel":
                bulider.append("&p_PropertyTypes=4-6");
                break;
            case "Bed and Breakfast":
                bulider.append("&p_PropertyTypes=4-8");
                break;
            case "Guest House":
                bulider.append("&p_PropertyTypes=4-7");
                break;
            case "Shop":
                bulider.append("&p_PropertyTypes=4-9");
                break;
            case "Office":
                bulider.append("&p_PropertyTypes=4-10");
                break;
            case "Storage Room":
                bulider.append("&p_PropertyTypes=4-11");
                break;
            case "Parking Space":
                bulider.append("&p_PropertyTypes=4-12");
                break;
            case "Farm":
                bulider.append("&p_PropertyTypes=4-13");
                break;
            case "Night Club":
                bulider.append("&p_PropertyTypes=4-15");
                break;
            case "Warehouse":
                bulider.append("&p_PropertyTypes=4-16");
                break;
            case "Garage":
                bulider.append("&p_PropertyTypes=4-17");
                break;
            case "Business":
                bulider.append("&p_PropertyTypes=4-18");
                break;
            case "Mooring":
                bulider.append("&p_PropertyTypes=4-19");
                break;
            case "Stables":
                bulider.append("&p_PropertyTypes=4-20");
                break;
            case "Kiosk":
                bulider.append("&p_PropertyTypes=4-21");
                break;
            case "Chiringuito":
                bulider.append("&p_PropertyTypes=4-22");
                break;
            case "Beach Bar":
                bulider.append("&p_PropertyTypes=4-23");
                break;
            case "Mechanics":
                bulider.append("&p_PropertyTypes=4-24");
                break;
            case "Hairdressers":
                bulider.append("&p_PropertyTypes=4-25");
                break;
            case "Photography Studio":
                bulider.append("&p_PropertyTypes=4-26");
                break;
            case "Laundry":
                bulider.append("&p_PropertyTypes=4-27");
                break;
            case "Aparthotel":
                bulider.append("&p_PropertyTypes=4-28");
                break;
            case "Apartment Complex":
                bulider.append("&p_PropertyTypes=4-29");
                break;
            case "Residential Home":
                bulider.append("&p_PropertyTypes=4-30");
                break;
            case "Vineyard":
                bulider.append("&p_PropertyTypes=4-32");
                break;
            case "Olive Grove":
                bulider.append("&p_PropertyTypes=4-33");
                break;
            case "Car Park":
                bulider.append("&p_PropertyTypes=4-34");
                break;
            case "Commercial Premises":
                bulider.append("&p_PropertyTypes=4-35");
                break;
            case "Campsite":
                bulider.append("&p_PropertyTypes=4-36");
                break;
            case "With Residence":
                bulider.append("&p_PropertyTypes=4-37");
                break;
            case "Others":
                bulider.append("&p_PropertyTypes=4-100");
                break;
        }
        st = bulider.toString();
        return st;
    }

    private static void print(List<String> l) {
        System.out.println(l.toString());
    }
}

