/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtextux.sample.showcase2.client;

public class SampleData {

    private static Object[][] countryData;
    private static String[][] stateData;
    private static Object[][] companyData;
    private static Object[][] companyDataSmall;

    public static Object[][] getCountries() {
        if (countryData == null) {
            //abbr, name, capital, continent, population, area in sq. km
            countryData = new Object[][]{
                    new Object[]{"au", "Australia", "Canberra", "Australia", new Integer(18090000), new Integer(7713360)},
                    new Object[]{"br", "Brazil", "Brasilia", "South America", new Integer(170000000), new Integer(8547404)},
                    new Object[]{"ca", "Canada", "Ottawa", "North America", new Integer(31000000), new Integer(9976140)},
                    new Object[]{"cn", "China", "Beijing", "Asia", new Integer(1222017000), new Integer(9596960)},
                    new Object[]{"de", "Germany", "Berlin", "Europe", new Integer(80942000), new Integer(356910)},
                    new Object[]{"fr", "France", "Paris", "Europe", new Integer(57571000), new Integer(551500)},
                    new Object[]{"in", "India", "New Delhi", "Asia", new Integer(913747000), new Integer(3287590)},
                    new Object[]{"sc", "Seychelles", "Victoria", "Africa", new Integer(73000), new Integer(280)},
                    new Object[]{"us", "United States", "Washington, DC", "North America", new Integer(260513000), new Integer(9372610)},
                    new Object[]{"jp", "Japan", "Tokyo", "Asia", new Integer(125422000), new Integer(377800)},
                    new Object[]{"ie", "Italy", "Rome", "Eorope", new Integer(57867000), new Integer(301270)},
                    new Object[]{"gh", "Ghana", "Accra", "Africa", new Integer(16944000), new Integer(238540)},
                    new Object[]{"ie", "Iceland", "Reykjavik", "Europe", new Integer(270000), new Integer(103000)},
                    new Object[]{"fi", "Finland", "Helsinki", "Europe", new Integer(5033000), new Integer(338130)},
                    new Object[]{"ch", "Switzerland", "Berne", "Europe", new Integer(6910000), new Integer(41290)}
            };
        }
        return countryData;
    }

    public static String[][] getStates() {
        if (stateData == null) {
            stateData = new String[][]{
                    new String[]{"AL", "Alabama", "The Heart of Dixie"},
                    new String[]{"AK", "Alaska", "The Land of the Midnight Sun"},
                    new String[]{"AZ", "Arizona", "The Grand Canyon State"},
                    new String[]{"AR", "Arkansas", "The Natural State"},
                    new String[]{"CA", "California", "The Golden State"},
                    new String[]{"CO", "Colorado", "The Mountain State"},
                    new String[]{"CN", "Connecticut", "The Constitution State"},
                    new String[]{"DE", "Delaware", "The First State"},
                    new String[]{"DC", "District of Columbia", "The Nation's Capital"},
                    new String[]{"FL", "Florida", "The Sunshine State"},
                    new String[]{"GA", "Georgia", "The Peach State"},
                    new String[]{"HW", "Hawaii", "The Aloha State"},
                    new String[]{"ID", "Idaho", "Famous Potatoes"},
                    new String[]{"IL", "Illinois", "The Prairie State"},
                    new String[]{"IN", "Indiana", "The Hospitality State"},
                    new String[]{"IA", "Iowa", "The Corn State"},
                    new String[]{"KS", "Kansas", "The Sunflower State"},
                    new String[]{"KY", "Kentucky", "The Bluegrass State"},
                    new String[]{"LA", "Louisiana", "The Bayou State"},
                    new String[]{"ME", "Maine", "The Pine Tree State"},
                    new String[]{"MA", "Massachusetts", "The Spirit of America"},
                    new String[]{"MD", "Maryland", "Chesapeake State"},
                    new String[]{"MI", "Michigan", "Great Lakes State"},
                    new String[]{"MN", "Minnesota", "North Star State"},
                    new String[]{"MS", "Mississippi", "Magnolia State"},
                    new String[]{"MO", "Missouri", "Show Me State"},
                    new String[]{"MT", "Montana", "Big Sky Country"},
                    new String[]{"NE", "Nebraska", "Beef State"},
                    new String[]{"NV", "Nevada", "Silver State"},
                    new String[]{"NH", "New Hampshire", "Granite State"},
                    new String[]{"NJ", "New Jersey", "Garden State"},
                    new String[]{"NM", "New Mexico", "Land of Enchantment"},
                    new String[]{"NY", "New York", "Empire State"},
                    new String[]{"NC", "North Carolina", "First in Freedom"},
                    new String[]{"ND", "North Dakota", "Peace Garden State"},
                    new String[]{"OH", "Ohio", "The Heart of it All"},
                    new String[]{"OK", "Oklahoma", "Oklahoma is OK"},
                    new String[]{"OR", "Oregon", "Pacific Wonderland"},
                    new String[]{"PA", "Pennsylvania", "Keystone State"},
                    new String[]{"RH", "Rhode Island", "Ocean State"},
                    new String[]{"SC", "South Carolina", "Nothing Could be Finer"},
                    new String[]{"SD", "South Dakota", "Great Faces, Great Places"},
                    new String[]{"TE", "Tennessee", "Volunteer State"},
                    new String[]{"TX", "Texas", "Lone Star State"},
                    new String[]{"UT", "Utah", "Salt Lake State"},
                    new String[]{"VE", "Vermont", "Green Mountain State"},
                    new String[]{"VA", "Virginia", "Mother of States"},
                    new String[]{"WA", "Washington", "Green Tree State"},
                    new String[]{"WV", "West Virginia", "Mountain State"},
                    new String[]{"WI", "Wisconsin", "America's Dairyland"},
                    new String[]{"WY", "Wyoming", "Like No Place on Earth"}
            };
        }
        return stateData;
    }

    public static Object[][] getCompanyDataLarge() {
        if (companyData == null) {
            companyData = new Object[][]{
                    new Object[]{"3m Co", new Double(71.72), new Double(0.02), new Double(0.03), "9/1 12:00am", "MMM", "Manufacturing"},
                    new Object[]{"Alcoa Inc", new Double(29.01), new Double(0.42), new Double(1.47), "9/1 12:00am", "AA", "Manufacturing"},
                    new Object[]{"Altria Group Inc", new Double(83.81), new Double(0.28), new Double(0.34), "9/1 12:00am", "MO", "Manufacturing"},
                    new Object[]{"American Express Company", new Double(52.55), new Double(0.01), new Double(0.02), "9/1 12:00am", "AXP", "Finance"},
                    new Object[]{"American International Group, Inc.", new Double(64.13), new Double(0.31), new Double(0.49), "9/1 12:00am", "AIG", "Services"},
                    new Object[]{"AT&T Inc.", new Double(31.61), new Double(-0.48), new Double(-1.54), "9/1 12:00am", "T", "Services"},
                    new Object[]{"Boeing Co.", new Double(75.43), new Double(0.53), new Double(0.71), "9/1 12:00am", "BA", "Manufacturing"},
                    new Object[]{"Caterpillar Inc.", new Double(67.27), new Double(0.92), new Double(1.39), "9/1 12:00am", "CAT", "Services"},
                    new Object[]{"Citigroup, Inc.", new Double(49.37), new Double(0.02), new Double(0.04), "9/1 12:00am", "C", "Finance"},
                    new Object[]{"E.I. du Pont de Nemours and Company", new Double(40.48), new Double(0.51), new Double(1.28), "9/1 12:00am", "DD", "Manufacturing"},
                    new Object[]{"Exxon Mobil Corp", new Double(68.1), new Double(-0.43), new Double(-0.64), "9/1 12:00am", "XOM", "Manufacturing"},
                    new Object[]{"General Electric Company", new Double(34.14), new Double(-0.08), new Double(-0.23), "9/1 12:00am", "GE", "Manufacturing"},
                    new Object[]{"General Motors Corporation", new Double(30.27), new Double(1.09), new Double(3.74), "9/1 12:00am", "GM", "Automotive"},
                    new Object[]{"Hewlett-Packard Co.", new Double(36.53), new Double(-0.03), new Double(-0.08), "9/1 12:00am", "HPQ", "Computer"},
                    new Object[]{"Honeywell Intl Inc", new Double(38.77), new Double(0.05), new Double(0.13), "9/1 12:00am", "HON", "Manufacturing"},
                    new Object[]{"Intel Corporation", new Double(19.88), new Double(0.31), new Double(1.58), "9/1 12:00am", "INTC", "Computer"},
                    new Object[]{"International Business Machines", new Double(81.41), new Double(0.44), new Double(0.54), "9/1 12:00am", "IBM", "Computer"},
                    new Object[]{"Johnson & Johnson", new Double(64.72), new Double(0.06), new Double(0.09), "9/1 12:00am", "JNJ", "Medical"},
                    new Object[]{"JP Morgan & Chase & Co", new Double(45.73), new Double(0.07), new Double(0.15), "9/1 12:00am", "JPM", "Finance"},
                    new Object[]{"McDonald\"s Corporation", new Double(36.76), new Double(0.86), new Double(2.40), "9/1 12:00am", "MCD", "Food"},
                    new Object[]{"Merck & Co., Inc.", new Double(40.96), new Double(0.41), new Double(1.01), "9/1 12:00am", "MRK", "Medical"},
                    new Object[]{"Microsoft Corporation", new Double(25.84), new Double(0.14), new Double(0.54), "9/1 12:00am", "MSFT", "Computer"},
                    new Object[]{"Pfizer Inc", new Double(27.96), new Double(0.4), new Double(1.45), "9/1 12:00am", "PFE", "Medical"},
                    new Object[]{"The Coca-Cola Company", new Double(45.07), new Double(0.26), new Double(0.58), "9/1 12:00am", "KO", "Food"},
                    new Object[]{"The Home Depot, Inc.", new Double(34.64), new Double(0.35), new Double(1.02), "9/1 12:00am", "HD", "Retail"},
                    new Object[]{"The Procter & Gamble Company", new Double(61.91), new Double(0.01), new Double(0.02), "9/1 12:00am", "PG", "Manufacturing"},
                    new Object[]{"United Technologies Corporation", new Double(63.26), new Double(0.55), new Double(0.88), "9/1 12:00am", "UTX", "Computer"},
                    new Object[]{"Verizon Communications", new Double(35.57), new Double(0.39), new Double(1.11), "9/1 12:00am", "VZ", "Services"},
                    new Object[]{"Wal-Mart Stores, Inc.", new Double(45.45), new Double(0.73), new Double(1.63), "9/1 12:00am", "WMT", "Retail"},
                    new Object[]{"Walt Disney Company (The) (Holding Company)", new Double(29.89), new Double(0.24), new Double(0.81), "9/1 12:00am", "DIS", "Services"}
            };

        }
        return companyData;
    }

    public static Object[][] getCompanyDataSmall() {
        if (companyDataSmall == null) {
            companyDataSmall = new Object[][]{
                    new Object[]{"3m Co", new Double(71.72), new Double(0.02), new Double(0.03), "9/1 12:00am", "MMM", "Manufacturing"},
                    new Object[]{"Alcoa Inc", new Double(29.01), new Double(0.42), new Double(1.47), "9/1 12:00am", "AA", "Manufacturing"},
                    new Object[]{"Altria Group Inc", new Double(83.81), new Double(0.28), new Double(0.34), "9/1 12:00am", "MO", "Manufacturing"},
                    new Object[]{"American Express Company", new Double(52.55), new Double(0.01), new Double(0.02), "9/1 12:00am", "AXP", "Finance"},
                    new Object[]{"American International Group, Inc.", new Double(64.13), new Double(0.31), new Double(0.49), "9/1 12:00am", "AIG", "Services"},
                    new Object[]{"AT&T Inc.", new Double(31.61), new Double(-0.48), new Double(-1.54), "9/1 12:00am", "T", "Services"},
                    new Object[]{"Boeing Co.", new Double(75.43), new Double(0.53), new Double(0.71), "9/1 12:00am", "BA", "Manufacturing"},
                    new Object[]{"Caterpillar Inc.", new Double(67.27), new Double(0.92), new Double(1.39), "9/1 12:00am", "CAT", "Services"},
                    new Object[]{"Citigroup, Inc.", new Double(49.37), new Double(0.02), new Double(0.04), "9/1 12:00am", "C", "Finance"},
                    new Object[]{"E.I. du Pont de Nemours and Company", new Double(40.48), new Double(0.51), new Double(1.28), "9/1 12:00am", "DD", "Manufacturing"}
            };

        }
        return companyDataSmall;
    }

    
    public static String getShortBogusMarkup() {
        return "<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed metus nibh, sodales a, porta at, vulputate eget, dui.  In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, cursus a, fringilla vel, urna.";
    }

    public static String getBogusMarkup() {
        return "<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed metus nibh, sodales a, porta at, vulputate eget, dui. Pellentesque ut nisl. Maecenas tortor turpis, interdum non, sodales non, iaculis ac, lacus. Vestibulum auctor, tortor quis iaculis malesuada, libero lectus bibendum purus, sit amet tincidunt quam turpis vel lacus. In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, cursus a, fringilla vel, urna.<br/><br/>Aliquam commodo ullamcorper erat. Nullam vel justo in neque porttitor laoreet. Aenean lacus dui, consequat eu, adipiscing eget, nonummy non, nisi. Morbi nunc est, dignissim non, ornare sed, luctus eu, massa. Vivamus eget quam. Vivamus tincidunt diam nec urna. Curabitur velit.</p>";
    }
}