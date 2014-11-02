import api.yg.GeocoderRequest;
import api.geocoder.Geocoder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGeocoderRequestBuilder {


    @Test
    public void testDefaultRequestUrl() {
        String requestStr = "http://geocode-maps.yandex.ru/1.x/?format=json&geocode=Москва,+Тверская+6";
        GeocoderRequest request =
                new GeocoderRequest.Builder("Москва, Тверская 6").get();

        Geocoder geocoder = new Geocoder();
        String testUrl = geocoder.getURL(request);
        assertEquals(requestStr, testUrl);
    }

    @Test
    public void testNotRestrictedSearchArea() {
        String searchCloseUrl = "http://geocode-maps.yandex.ru/1.x/?format=json&geocode=Ивановка&ll=37.61892,55.756994&spn=3.552069,2.400552";
        GeocoderRequest request1 = new GeocoderRequest.Builder("Ивановка").setSearchArea(false, 37.618920,55.756994,3.552069, 2.400552).get();
        GeocoderRequest request2 = new GeocoderRequest.Builder("Ивановка").setSearchArea(false, new GeocoderRequest.SearchBoundary(37.618920, 55.756994, 3.552069, 2.400552)).get();

        Geocoder geocoder = new Geocoder();
        String testUrl1 = geocoder.getURL(request1);
        String testUrl2 = geocoder.getURL(request2);

        assertEquals(searchCloseUrl,testUrl1);
        assertEquals(searchCloseUrl,testUrl2);


    }


    @Test
    public void testRestrictedSearchArea() {
        String searchCloseUrl = "http://geocode-maps.yandex.ru/1.x/?format=json&geocode=Ивановка&rspn=1&ll=37.61892,55.756994&spn=3.552069,2.400552";
        GeocoderRequest request1 = new GeocoderRequest.Builder("Ивановка").setSearchArea(true, 37.618920,55.756994,3.552069, 2.400552).get();
        GeocoderRequest request2 = new GeocoderRequest.Builder("Ивановка").setSearchArea(true, new GeocoderRequest.SearchBoundary(37.618920, 55.756994, 3.552069, 2.400552)).get();

        Geocoder geocoder = new Geocoder();
        String testUrl1 = geocoder.getURL(request1);
        String testUrl2 = geocoder.getURL(request2);

        assertEquals(searchCloseUrl,testUrl1);
        assertEquals(searchCloseUrl,testUrl2);


    }

    @Test
    public void testLimitAndSkip() {
        String req = "http://geocode-maps.yandex.ru/1.x/?format=json&geocode=Ивановка&results=5&skip=42";
        GeocoderRequest request1 = new GeocoderRequest.Builder("Ивановка").setResults(5).setSkip(42).get();
        Geocoder geocoder = new Geocoder();
        String url = geocoder.getURL(request1);
        assertEquals(req, url);

    }


    @Test
    public void testFullAddress() {
        String req = "http://geocode-maps.yandex.ru/1.x/?format=json&geocode=город+Москва,+Тверская+улица,+дом+18,+корпус+1&results=5&skip=42";
        GeocoderRequest request1 = new GeocoderRequest.Builder("город Москва, Тверская улица, дом 18, корпус 1").setResults(5).setSkip(42).get();
        Geocoder geocoder = new Geocoder();
        String url = geocoder.getURL(request1);
        assertEquals(req, url);
    }


}
