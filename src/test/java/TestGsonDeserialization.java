import api.address.*;
import api.geocoding.*;
import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class TestGsonDeserialization {


    @Test
    public void testYandexResponse() {
        String validJson = "{\"response\":{\"Attribution\":\"\",\"GeoObjectCollection\":{\"metaDataProperty\":{\"GeocoderResponseMetaData\":{\"request\":\"Тверская       6\",\"found\":\"75\",\"results\":\"10\"}},\"featureMember\":[{\"GeoObject\":{\"metaDataProperty\":{\"GeocoderMetaData\":{\"kind\":\"house\",\"text\":\"Россия, Санкт-Петербург, Колпино, Тверская улица, 6\",\"precision\":\"exact\",\"AddressDetails\":{\"Country\":{\"AddressLine\":\"Санкт-Петербург, Колпино, Тверская улица, 6\",\"CountryNameCode\":\"RU\",\"CountryName\":\"Россия\",\"AdministrativeArea\":{\"AdministrativeAreaName\":\"Северо-Западный федеральный округ\",\"SubAdministrativeArea\":{\"SubAdministrativeAreaName\":\"Санкт-Петербург\",\"Locality\":{\"LocalityName\":\"Колпино\",\"Thoroughfare\":{\"ThoroughfareName\":\"Тверская улица\",\"Premise\":{\"PremiseNumber\":\"6\"}}}}}}}}},\"description\":\"Колпино, Санкт-Петербург, Россия\",\"name\":\"Тверская улица, 6\",\"boundedBy\":{\"Envelope\":{\"lowerCorner\":\"30.602592 59.741735\",\"upperCorner\":\"30.61905 59.750041\"}},\"Point\":{\"pos\":\"30.610821 59.745889\"}}},{\"GeoObject\":{\"metaDataProperty\":{\"GeocoderMetaData\":{\"kind\":\"house\",\"text\":\"Россия, Московская область, Лотошинский район, поселок городского типа Лотошино, Тверская улица, 6\",\"precision\":\"exact\",\"AddressDetails\":{\"Country\":{\"AddressLine\":\"Московская область, Лотошинский район, поселок городского типа Лотошино, Тверская улица, 6\",\"CountryNameCode\":\"RU\",\"CountryName\":\"Россия\",\"AdministrativeArea\":{\"AdministrativeAreaName\":\"Московская область\",\"SubAdministrativeArea\":{\"SubAdministrativeAreaName\":\"Лотошинский район\",\"Locality\":{\"LocalityName\":\"поселок городского типа Лотошино\",\"Thoroughfare\":{\"ThoroughfareName\":\"Тверская улица\",\"Premise\":{\"PremiseNumber\":\"6\"}}}}}}}}},\"description\":\"поселок городского типа Лотошино, Лотошинский район, Московская область, Россия\",\"name\":\"Тверская улица, 6\",\"boundedBy\":{\"Envelope\":{\"lowerCorner\":\"35.622621 56.228731\",\"upperCorner\":\"35.639078 56.237897\"}},\"Point\":{\"pos\":\"35.630849 56.233314\"}}},{\"GeoObject\":{\"metaDataProperty\":{\"GeocoderMetaData\":{\"kind\":\"house\",\"text\":\"Россия, Московская область, Дубна, Тверская улица, 6\",\"precision\":\"exact\",\"AddressDetails\":{\"Country\":{\"AddressLine\":\"Московская область, Дубна, Тверская улица, 6\",\"CountryNameCode\":\"RU\",\"CountryName\":\"Россия\",\"AdministrativeArea\":{\"AdministrativeAreaName\":\"Московская область\",\"SubAdministrativeArea\":{\"SubAdministrativeAreaName\":\"городской округ Дубна\",\"Locality\":{\"LocalityName\":\"Дубна\",\"Thoroughfare\":{\"ThoroughfareName\":\"Тверская улица\",\"Premise\":{\"PremiseNumber\":\"6\"}}}}}}}}},\"description\":\"Дубна, Московская область, Россия\",\"name\":\"Тверская улица, 6\",\"boundedBy\":{\"Envelope\":{\"lowerCorner\":\"37.131045 56.757826\",\"upperCorner\":\"37.147502 56.766864\"}},\"Point\":{\"pos\":\"37.139273 56.762345\"}}},{\"GeoObject\":{\"metaDataProperty\":{\"GeocoderMetaData\":{\"kind\":\"house\",\"text\":\"Украина, Киев, Тверская улица, 6\",\"precision\":\"exact\",\"AddressDetails\":{\"Country\":{\"AddressLine\":\"Киев, Тверская улица, 6\",\"CountryNameCode\":\"UA\",\"CountryName\":\"Украина\",\"AdministrativeArea\":{\"AdministrativeAreaName\":\"Киев\",\"SubAdministrativeArea\":{\"SubAdministrativeAreaName\":\"Киев\",\"Locality\":{\"LocalityName\":\"Киев\",\"Thoroughfare\":{\"ThoroughfareName\":\"Тверская улица\",\"Premise\":{\"PremiseNumber\":\"6\"}}}}}}}}},\"description\":\"Киев, Украина\",\"name\":\"Тверская улица, 6\",\"boundedBy\":{\"Envelope\":{\"lowerCorner\":\"30.515132 50.414683\",\"upperCorner\":\"30.53159 50.425198\"}},\"Point\":{\"pos\":\"30.523361 50.419941\"}}},{\"GeoObject\":{\"metaDataProperty\":{\"GeocoderMetaData\":{\"kind\":\"house\",\"text\":\"Украина, Днепропетровск, Тверская улица, 6\",\"precision\":\"exact\",\"AddressDetails\":{\"Country\":{\"AddressLine\":\"Днепропетровск, Тверская улица, 6\",\"CountryNameCode\":\"UA\",\"CountryName\":\"Украина\",\"AdministrativeArea\":{\"AdministrativeAreaName\":\"Днепропетровская область\",\"SubAdministrativeArea\":{\"SubAdministrativeAreaName\":\"Днепропетровский городской совет\",\"Locality\":{\"LocalityName\":\"Днепропетровск\",\"Thoroughfare\":{\"ThoroughfareName\":\"Тверская улица\",\"Premise\":{\"PremiseNumber\":\"6\"}}}}}}}}},\"description\":\"Днепропетровск, Украина\",\"name\":\"Тверская улица, 6\",\"boundedBy\":{\"Envelope\":{\"lowerCorner\":\"35.072052 48.502227\",\"upperCorner\":\"35.088509 48.513162\"}},\"Point\":{\"pos\":\"35.080281 48.507695\"}}},{\"GeoObject\":{\"metaDataProperty\":{\"GeocoderMetaData\":{\"kind\":\"house\",\"text\":\"Россия, Красноярский край, Ачинск, Тверская улица, 6\",\"precision\":\"exact\",\"AddressDetails\":{\"Country\":{\"AddressLine\":\"Красноярский край, Ачинск, Тверская улица, 6\",\"CountryNameCode\":\"RU\",\"CountryName\":\"Россия\",\"AdministrativeArea\":{\"AdministrativeAreaName\":\"Красноярский край\",\"SubAdministrativeArea\":{\"SubAdministrativeAreaName\":\"городской округ Ачинск\",\"Locality\":{\"LocalityName\":\"Ачинск\",\"Thoroughfare\":{\"ThoroughfareName\":\"Тверская улица\",\"Premise\":{\"PremiseNumber\":\"6\"}}}}}}}}},\"description\":\"Ачинск, Красноярский край, Россия\",\"name\":\"Тверская улица, 6\",\"boundedBy\":{\"Envelope\":{\"lowerCorner\":\"90.501447 56.289965\",\"upperCorner\":\"90.517904 56.299116\"}},\"Point\":{\"pos\":\"90.509676 56.294541\"}}},{\"GeoObject\":{\"metaDataProperty\":{\"GeocoderMetaData\":{\"kind\":\"house\",\"text\":\"Украина, Харьков, Тверская улица, 6\",\"precision\":\"exact\",\"AddressDetails\":{\"Country\":{\"AddressLine\":\"Харьков, Тверская улица, 6\",\"CountryNameCode\":\"UA\",\"CountryName\":\"Украина\",\"AdministrativeArea\":{\"AdministrativeAreaName\":\"Харьковская область\",\"SubAdministrativeArea\":{\"SubAdministrativeAreaName\":\"Харьковский городской совет\",\"Locality\":{\"LocalityName\":\"Харьков\",\"Thoroughfare\":{\"ThoroughfareName\":\"Тверская улица\",\"Premise\":{\"PremiseNumber\":\"6\"}}}}}}}}},\"description\":\"Харьков, Украина\",\"name\":\"Тверская улица, 6\",\"boundedBy\":{\"Envelope\":{\"lowerCorner\":\"36.162841 49.940504\",\"upperCorner\":\"36.179298 49.951124\"}},\"Point\":{\"pos\":\"36.171069 49.945815\"}}},{\"GeoObject\":{\"metaDataProperty\":{\"GeocoderMetaData\":{\"kind\":\"house\",\"text\":\"Украина, Донецкая область, Дружковка, Тверская улица, 6\",\"precision\":\"exact\",\"AddressDetails\":{\"Country\":{\"AddressLine\":\"Донецкая область, Дружковка, Тверская улица, 6\",\"CountryNameCode\":\"UA\",\"CountryName\":\"Украина\",\"AdministrativeArea\":{\"AdministrativeAreaName\":\"Донецкая область\",\"SubAdministrativeArea\":{\"SubAdministrativeAreaName\":\"Дружковский городской совет\",\"Locality\":{\"LocalityName\":\"Дружковка\",\"Thoroughfare\":{\"ThoroughfareName\":\"Тверская улица\",\"Premise\":{\"PremiseNumber\":\"6\"}}}}}}}}},\"description\":\"Дружковка, Донецкая область, Украина\",\"name\":\"Тверская улица, 6\",\"boundedBy\":{\"Envelope\":{\"lowerCorner\":\"37.513889 48.615012\",\"upperCorner\":\"37.530346 48.625923\"}},\"Point\":{\"pos\":\"37.522117 48.620468\"}}},{\"GeoObject\":{\"metaDataProperty\":{\"GeocoderMetaData\":{\"kind\":\"house\",\"text\":\"Россия, Тверь, Тверская площадь, 6\",\"precision\":\"exact\",\"AddressDetails\":{\"Country\":{\"AddressLine\":\"Тверь, Тверская площадь, 6\",\"CountryNameCode\":\"RU\",\"CountryName\":\"Россия\",\"AdministrativeArea\":{\"AdministrativeAreaName\":\"Тверская область\",\"SubAdministrativeArea\":{\"SubAdministrativeAreaName\":\"городской округ Тверь\",\"Locality\":{\"LocalityName\":\"Тверь\",\"Thoroughfare\":{\"ThoroughfareName\":\"Тверская площадь\",\"Premise\":{\"PremiseNumber\":\"6\"}}}}}}}}},\"description\":\"Тверь, Россия\",\"name\":\"Тверская площадь, 6\",\"boundedBy\":{\"Envelope\":{\"lowerCorner\":\"35.89481 56.852721\",\"upperCorner\":\"35.911267 56.861736\"}},\"Point\":{\"pos\":\"35.903039 56.857229\"}}},{\"GeoObject\":{\"metaDataProperty\":{\"GeocoderMetaData\":{\"kind\":\"house\",\"text\":\"Россия, Санкт-Петербург, Тверская улица, 6\",\"precision\":\"exact\",\"AddressDetails\":{\"Country\":{\"AddressLine\":\"Санкт-Петербург, Тверская улица, 6\",\"CountryNameCode\":\"RU\",\"CountryName\":\"Россия\",\"AdministrativeArea\":{\"AdministrativeAreaName\":\"Северо-Западный федеральный округ\",\"SubAdministrativeArea\":{\"SubAdministrativeAreaName\":\"Санкт-Петербург\",\"Locality\":{\"LocalityName\":\"Санкт-Петербург\",\"Thoroughfare\":{\"ThoroughfareName\":\"Тверская улица\",\"Premise\":{\"PremiseNumber\":\"6\"}}}}}}}}},\"description\":\"Санкт-Петербург, Россия\",\"name\":\"Тверская улица, 6\",\"boundedBy\":{\"Envelope\":{\"lowerCorner\":\"30.3716 59.943057\",\"upperCorner\":\"30.388057 59.951312\"}},\"Point\":{\"pos\":\"30.379828 59.947185\"}}}]}}}";
        GeocoderResponse response = new Gson().fromJson(validJson, GeocoderResponse.class);
        testNullityHelper(response);
    }


    @Test
    public void testSuggest() {
        String meta = "{  \n" +
                "               \"request\":\"Масква\",\n" +
                "               \"suggest\":\"М<fix>о<\\/fix>сква\",\n" +
                "               \"found\":\"25\",\n" +
                "               \"results\":\"10\"\n" +
                "            }";

        GeocoderResponseMetadata md = new Gson().fromJson(meta, GeocoderResponseMetadata.class);
        assertNotNull(md.getSuggest());
        assertEquals("М<fix>о</fix>сква", md.getSuggest());

    }

    @Test
    public void testLocality() {
        String validJson = "{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"Тверская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"1\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }";
        Gson gson = new Gson();

        Locality locality1 = gson.fromJson(validJson, Locality.class);
        testNullityHelper(locality1);

    }


    @Test
    public void testSubAdministrativeArea() {
        String subAdministrative = "{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"Тверская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"1\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }";

        Gson gson = new Gson();
        SubAdministrativeArea area = gson.fromJson(subAdministrative, SubAdministrativeArea.class);


        testNullityHelper(area);

    }


    @Test
    public void testAdministrative() {
        String validJson = "{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"Тверская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"1\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }";

        Gson gson = new Gson();
        AdministrativeArea area = gson.fromJson(validJson, AdministrativeArea.class);

        testNullityHelper(area);

    }


    @Test
    public void testGeocoderMetadata() {
        String validJson = "{  \n" +
                "                        \"kind\":\"house\",\n" +
                "                        \"text\":\"Россия, Москва, Тверская улица, 1\",\n" +
                "                        \"precision\":\"exact\",\n" +
                "                        \"AddressDetails\":{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, Тверская улица, 1\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"Тверская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"1\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }\n" +
                "                     }";

        GeocoderMetadata metadata = new Gson().fromJson(validJson, GeocoderMetadata.class);
        testNullityHelper(metadata);

    }


    @Test
    public void testCountry() {
        String validJson = "{  \n" +
                "                              \"AddressLine\":\"Москва, Тверская улица, 1\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"Тверская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"1\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }";


        Country country = new Gson().fromJson(validJson, Country.class);

        testNullityHelper(country);


    }


    @Test
    public void testGeoObject() {

        String valid = "{  \n" +
                "                  \"metaDataProperty\":{  \n" +
                "                     \"GeocoderMetaData\":{  \n" +
                "                        \"kind\":\"house\",\n" +
                "                        \"text\":\"Россия, Москва, Тверская улица, 1\",\n" +
                "                        \"precision\":\"exact\",\n" +
                "                        \"AddressDetails\":{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, Тверская улица, 1\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"Тверская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"1\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"description\":\"Москва, Россия\",\n" +
                "                  \"name\":\"Тверская улица, 1\",\n" +
                "                  \"boundedBy\":{  \n" +
                "                     \"Envelope\":{  \n" +
                "                        \"lowerCorner\":\"37.605777 55.752354\",\n" +
                "                        \"upperCorner\":\"37.622235 55.761634\"\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"Point\":{  \n" +
                "                     \"pos\":\"37.614006 55.756994\"\n" +
                "                  }\n" +
                "               }";


        GeoObject object = new Gson().fromJson(valid, GeoObject.class);
        testNullityHelper(object);


    }


    @Test
    public void testAddressDetails() {
        String validJson = "{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, Тверская улица, 1\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"Тверская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"1\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }";

        AddressDetails details = new Gson().fromJson(validJson, AddressDetails.class);

        testNullityHelper(details);

    }


    @Test
    public void testGeoObjectCollection() {

        String valid = "{  \n" +
                "         \"metaDataProperty\":{  \n" +
                "            \"GeocoderResponseMetaData\":{  \n" +
                "               \"request\":\"Москва, Тверская,1\",\n" +
                "               \"found\":\"9\",\n" +
                "               \"results\":\"10\"\n" +
                "            }\n" +
                "         },\n" +
                "         \"featureMember\":[  \n" +
                "            {  \n" +
                "               \"GeoObject\":{  \n" +
                "                  \"metaDataProperty\":{  \n" +
                "                     \"GeocoderMetaData\":{  \n" +
                "                        \"kind\":\"house\",\n" +
                "                        \"text\":\"Россия, Москва, Тверская улица, 1\",\n" +
                "                        \"precision\":\"exact\",\n" +
                "                        \"AddressDetails\":{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, Тверская улица, 1\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"Тверская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"1\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"description\":\"Москва, Россия\",\n" +
                "                  \"name\":\"Тверская улица, 1\",\n" +
                "                  \"boundedBy\":{  \n" +
                "                     \"Envelope\":{  \n" +
                "                        \"lowerCorner\":\"37.605777 55.752354\",\n" +
                "                        \"upperCorner\":\"37.622235 55.761634\"\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"Point\":{  \n" +
                "                     \"pos\":\"37.614006 55.756994\"\n" +
                "                  }\n" +
                "               }\n" +
                "            },\n" +
                "            {  \n" +
                "               \"GeoObject\":{  \n" +
                "                  \"metaDataProperty\":{  \n" +
                "                     \"GeocoderMetaData\":{  \n" +
                "                        \"kind\":\"house\",\n" +
                "                        \"text\":\"Россия, Москва, 1-я Тверская-Ямская улица, 1\\/3с2\",\n" +
                "                        \"precision\":\"number\",\n" +
                "                        \"AddressDetails\":{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, 1-я Тверская-Ямская улица, 1\\/3с2\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"1-я Тверская-Ямская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"1\\/3с2\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"description\":\"Москва, Россия\",\n" +
                "                  \"name\":\"1-я Тверская-Ямская улица, 1\\/3с2\",\n" +
                "                  \"boundedBy\":{  \n" +
                "                     \"Envelope\":{  \n" +
                "                        \"lowerCorner\":\"37.586832 55.765407\",\n" +
                "                        \"upperCorner\":\"37.603289 55.774684\"\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"Point\":{  \n" +
                "                     \"pos\":\"37.595061 55.770046\"\n" +
                "                  }\n" +
                "               }\n" +
                "            },\n" +
                "            {  \n" +
                "               \"GeoObject\":{  \n" +
                "                  \"metaDataProperty\":{  \n" +
                "                     \"GeocoderMetaData\":{  \n" +
                "                        \"kind\":\"house\",\n" +
                "                        \"text\":\"Россия, Москва, 3-я Тверская-Ямская улица, 3с2\",\n" +
                "                        \"precision\":\"near\",\n" +
                "                        \"AddressDetails\":{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, 3-я Тверская-Ямская улица, 3с2\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"3-я Тверская-Ямская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"3с2\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"description\":\"Москва, Россия\",\n" +
                "                  \"name\":\"3-я Тверская-Ямская улица, 3с2\",\n" +
                "                  \"boundedBy\":{  \n" +
                "                     \"Envelope\":{  \n" +
                "                        \"lowerCorner\":\"37.588835 55.766456\",\n" +
                "                        \"upperCorner\":\"37.605292 55.775732\"\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"Point\":{  \n" +
                "                     \"pos\":\"37.597064 55.771094\"\n" +
                "                  }\n" +
                "               }\n" +
                "            },\n" +
                "            {  \n" +
                "               \"GeoObject\":{  \n" +
                "                  \"metaDataProperty\":{  \n" +
                "                     \"GeocoderMetaData\":{  \n" +
                "                        \"kind\":\"house\",\n" +
                "                        \"text\":\"Россия, Москва, 2-я Тверская-Ямская улица, 6\",\n" +
                "                        \"precision\":\"near\",\n" +
                "                        \"AddressDetails\":{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, 2-я Тверская-Ямская улица, 6\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"2-я Тверская-Ямская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"6\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"description\":\"Москва, Россия\",\n" +
                "                  \"name\":\"2-я Тверская-Ямская улица, 6\",\n" +
                "                  \"boundedBy\":{  \n" +
                "                     \"Envelope\":{  \n" +
                "                        \"lowerCorner\":\"37.588153 55.766425\",\n" +
                "                        \"upperCorner\":\"37.60461 55.775702\"\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"Point\":{  \n" +
                "                     \"pos\":\"37.596381 55.771064\"\n" +
                "                  }\n" +
                "               }\n" +
                "            },\n" +
                "            {  \n" +
                "               \"GeoObject\":{  \n" +
                "                  \"metaDataProperty\":{  \n" +
                "                     \"GeocoderMetaData\":{  \n" +
                "                        \"kind\":\"house\",\n" +
                "                        \"text\":\"Россия, Москва, 4-я Тверская-Ямская улица, 3\",\n" +
                "                        \"precision\":\"near\",\n" +
                "                        \"AddressDetails\":{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, 4-я Тверская-Ямская улица, 3\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"4-я Тверская-Ямская улица\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"3\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"description\":\"Москва, Россия\",\n" +
                "                  \"name\":\"4-я Тверская-Ямская улица, 3\",\n" +
                "                  \"boundedBy\":{  \n" +
                "                     \"Envelope\":{  \n" +
                "                        \"lowerCorner\":\"37.589859 55.767003\",\n" +
                "                        \"upperCorner\":\"37.606316 55.776279\"\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"Point\":{  \n" +
                "                     \"pos\":\"37.598088 55.771641\"\n" +
                "                  }\n" +
                "               }\n" +
                "            },\n" +
                "            {  \n" +
                "               \"GeoObject\":{  \n" +
                "                  \"metaDataProperty\":{  \n" +
                "                     \"GeocoderMetaData\":{  \n" +
                "                        \"kind\":\"house\",\n" +
                "                        \"text\":\"Россия, Москва, площадь Тверская Застава, 3\",\n" +
                "                        \"precision\":\"near\",\n" +
                "                        \"AddressDetails\":{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, площадь Тверская Застава, 3\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"площадь Тверская Застава\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseNumber\":\"3\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"description\":\"Москва, Россия\",\n" +
                "                  \"name\":\"площадь Тверская Застава, 3\",\n" +
                "                  \"boundedBy\":{  \n" +
                "                     \"Envelope\":{  \n" +
                "                        \"lowerCorner\":\"37.573753 55.770699\",\n" +
                "                        \"upperCorner\":\"37.59021 55.779975\"\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"Point\":{  \n" +
                "                     \"pos\":\"37.581981 55.775338\"\n" +
                "                  }\n" +
                "               }\n" +
                "            },\n" +
                "            {  \n" +
                "               \"GeoObject\":{  \n" +
                "                  \"metaDataProperty\":{  \n" +
                "                     \"GeocoderMetaData\":{  \n" +
                "                        \"kind\":\"street\",\n" +
                "                        \"text\":\"Россия, Москва, Тверская площадь\",\n" +
                "                        \"precision\":\"street\",\n" +
                "                        \"AddressDetails\":{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, Тверская площадь\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"Тверская площадь\"\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"description\":\"Москва, Россия\",\n" +
                "                  \"name\":\"Тверская площадь\",\n" +
                "                  \"boundedBy\":{  \n" +
                "                     \"Envelope\":{  \n" +
                "                        \"lowerCorner\":\"37.609047 55.761305\",\n" +
                "                        \"upperCorner\":\"37.610655 55.76214\"\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"Point\":{  \n" +
                "                     \"pos\":\"37.609856 55.761720\"\n" +
                "                  }\n" +
                "               }\n" +
                "            },\n" +
                "            {  \n" +
                "               \"GeoObject\":{  \n" +
                "                  \"metaDataProperty\":{  \n" +
                "                     \"GeocoderMetaData\":{  \n" +
                "                        \"kind\":\"street\",\n" +
                "                        \"text\":\"Россия, Москва, площадь Тверская Застава\",\n" +
                "                        \"precision\":\"street\",\n" +
                "                        \"AddressDetails\":{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, площадь Тверская Застава\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"площадь Тверская Застава\"\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"description\":\"Москва, Россия\",\n" +
                "                  \"name\":\"площадь Тверская Застава\",\n" +
                "                  \"boundedBy\":{  \n" +
                "                     \"Envelope\":{  \n" +
                "                        \"lowerCorner\":\"37.583347 55.775353\",\n" +
                "                        \"upperCorner\":\"37.584236 55.776689\"\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"Point\":{  \n" +
                "                     \"pos\":\"37.583877 55.775945\"\n" +
                "                  }\n" +
                "               }\n" +
                "            },\n" +
                "            {  \n" +
                "               \"GeoObject\":{  \n" +
                "                  \"metaDataProperty\":{  \n" +
                "                     \"GeocoderMetaData\":{  \n" +
                "                        \"kind\":\"metro\",\n" +
                "                        \"text\":\"Россия, Москва, Замоскворецкая линия, метро Тверская\",\n" +
                "                        \"precision\":\"other\",\n" +
                "                        \"AddressDetails\":{  \n" +
                "                           \"Country\":{  \n" +
                "                              \"AddressLine\":\"Москва, Замоскворецкая линия, метро Тверская\",\n" +
                "                              \"CountryNameCode\":\"RU\",\n" +
                "                              \"CountryName\":\"Россия\",\n" +
                "                              \"AdministrativeArea\":{  \n" +
                "                                 \"AdministrativeAreaName\":\"Центральный федеральный округ\",\n" +
                "                                 \"SubAdministrativeArea\":{  \n" +
                "                                    \"SubAdministrativeAreaName\":\"Москва\",\n" +
                "                                    \"Locality\":{  \n" +
                "                                       \"LocalityName\":\"Москва\",\n" +
                "                                       \"Thoroughfare\":{  \n" +
                "                                          \"ThoroughfareName\":\"Замоскворецкая линия\",\n" +
                "                                          \"Premise\":{  \n" +
                "                                             \"PremiseName\":\"метро Тверская\"\n" +
                "                                          }\n" +
                "                                       }\n" +
                "                                    }\n" +
                "                                 }\n" +
                "                              }\n" +
                "                           }\n" +
                "                        }\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"description\":\"Замоскворецкая линия, Москва, Россия\",\n" +
                "                  \"name\":\"метро Тверская\",\n" +
                "                  \"boundedBy\":{  \n" +
                "                     \"Envelope\":{  \n" +
                "                        \"lowerCorner\":\"37.597711 55.759816\",\n" +
                "                        \"upperCorner\":\"37.614168 55.769094\"\n" +
                "                     }\n" +
                "                  },\n" +
                "                  \"Point\":{  \n" +
                "                     \"pos\":\"37.605939 55.764455\"\n" +
                "                  }\n" +
                "               }\n" +
                "            }\n" +
                "         ]\n" +
                "      }";


        GeoObjectCollection collection = new Gson().fromJson(valid, GeoObjectCollection.class);

        testNullityHelper(collection);


    }

    private void testNullityHelper(GeoObjectCollection collection) {
        assertNotNull(collection);
        assertNotNull(collection.getMetadataProperty());
        assertNotNull(collection.getMetadataProperty().getMetadata());
        assertNotNull(collection.getMetadataProperty().getMetadata().getRequest());
        assertNotNull(collection.getGeoObjectHolders());
        testNullityHelper(collection.getGeoObjectHolders().get(0).getObject());

    }

    private void testNullityHelper(GeoObject object) {
        assertNotNull(object);
        assertNotNull(object.getName());
        assertNotNull(object.getDescription());
        assertNotNull(object.getPoint());
        assertNotNull(object.getMetadataProperty());
        testNullityHelper(object.getMetadataProperty().getGeocoderMetadata());

    }

    private void testNullityHelper(AddressDetails details) {
        assertNotNull(details);
        testNullityHelper(details.getCountry());
    }

    private void testNullityHelper(Country country) {
        assertNotNull(country);
        assertNotNull(country.getAddressLine());
        assertNotNull(country.getCountryName());
        assertNotNull(country.getCountryNameCode());
        testNullityHelper(country.getAdministrativeArea());
    }

    private void testNullityHelper(GeocoderMetadata metadata) {
        assertNotNull(metadata);
        assertNotNull(metadata.getKind());
        assertNotNull(metadata.getPrecision());
        assertNotNull(metadata.getPrecision());
        testNullityHelper(metadata.getAddressDetails());

    }

    private void testNullityHelper(Locality locality) {
        assertNotNull(locality);
        assertNotNull(locality.getLocalityName());
        assertNotNull(locality.getThoroughfare());
        assertNotNull(locality.getThoroughfare().getPremise());
        assertNotNull(locality.getThoroughfare().getThoroughfareName());

    }

    private void testNullityHelper(AdministrativeArea area) {
        assertNotNull(area);
        assertNotNull(area.getAdministrativeAreaName());
        assertNotNull(area.getSubAdministrativeArea());
        testNullityHelper(area.getSubAdministrativeArea());
    }

    private void testNullityHelper(SubAdministrativeArea area) {
        assertNotNull(area);
        testNullityHelper(area.getLocality());
        assertNotNull(area.getSubAdministrativeAreaName());
    }

    private void testNullityHelper(GeocoderResponse response) {
        assertNotNull(response.getResponse());
        assertNotNull(response.getResponse().getAttribution());
        testNullityHelper(response.getResponse().getCollection());
    }


}
