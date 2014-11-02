YandexGeocoder
==============

Java API for [Yandex Geocoder service](https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/About-docpage/)

#1. Maven dependency

To use this library, you need to add the following repository to your `pom.xml`:


    <repositories>
        ...
        <repository>
            <id>YandexGeocoder</id>
            <url>https://raw.github.com/ousenko/YandexGeocoder/mvn-repo/</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
        ...
    </repositories>


Then add the following dependency to your `pom.xml`:

    <dependencies>
        <dependency>
            <groupId>com.yandex.tech.geocoder</groupId>
            <artifactId>geocoder</artifactId>
            <version>0.1</version>
        </dependency>
        <!-- If you need javadoc
        <dependency>
                    <groupId>com.yandex.tech.geocoder</groupId>
                    <artifactId>geocoder</artifactId>
                    <version>0.1</version>
                    <classifier>javadoc</classifier>
                </dependency>
        -->
        <!-- If you need sources
                <dependency>
                            <groupId>com.yandex.tech.geocoder</groupId>
                            <artifactId>geocoder</artifactId>
                            <version>0.1</version>
                            <classifier>sources</classifier>
                        </dependency>
                -->
    </dependencies>

And you're fine.



#2. Usage

    public class Example{

        public static void main(String[] args){

            GeocoderRequest request = new GeocoderRequest.Builder("Москва, Костромская, 12").get();

            //search for objects near or with the area
            GeocoderRequest requestSearchNearArea = new GeocoderRequest.Builder("Ивановка")
                    .setSearchArea(false, //find results within or near boundary
                            new GeocoderRequest.SearchBoundary(37.618920, 55.756994, 3.552069, 2.400552)).get();

            //search for objects WITHIN the area
            GeocoderRequest requestRestrictSearchToArea = new GeocoderRequest.Builder("Ивановка")
                    .setSearchArea(true,//restrict search to boundary
                            new GeocoderRequest.SearchBoundary(37.618920, 55.756994, 3.552069, 2.400552)).get();


            Geocoder geocoder = new Geocoder();//create standard geocoder
            try {
                GeocoderResponse response = geocoder.geocode(request);


                System.out.println(
                        String.format(
                                "When searching for \"%s\", Found %d results",
                                request.getGeocode(),//get search address
                                response.getResponse().getCollection().getMetadataProperty().getMetadata().getFound()//get amount of found items
                        )
                );
                System.out.println("The match was: " + response.getResponse()
                        .getCollection()
                        .getGeoObjectHolders()//get List of wrappers around GeoObject
                        .get(0).getObject()
                        .getMetadataProperty().getGeocoderMetadata().getPrecision());//get precision of search match

                System.out.println("Location is: " + response.getResponse()
                        .getCollection()
                        .getGeoObjectHolders()
                        .get(0).getObject().getPoint().getPositionString());


                //iterate over found results
                for (GeoObjectCollection.GeoObjectHolder holder : response.getResponse().getCollection().getGeoObjectHolders()) {
                    System.out.println(
                            String.format("GeoObject: %s,%s ",
                                    holder.getObject().getDescription(),
                                    holder.getObject().getName()));
                }

                GeocoderResponse responseNearAreaRequest = geocoder.geocode(requestSearchNearArea);

                System.out.println(
                        String.format(
                                "When searching for \"%s\" near specified area, Found %d results",
                                requestSearchNearArea.getGeocode(),
                                responseNearAreaRequest.getResponse().getCollection().getMetadataProperty().getMetadata().getFound()
                        )
                );



                GeoObject accurate = responseNearAreaRequest.getMostAccurateResult();
                System.out.println("Among those the most accurate is: " + accurate.getDescription() + ", " + accurate.getName() + ", location = " + accurate.getPoint().getPositionString());

                GeocoderResponse responseRestrictedAreaSearchRequest = geocoder.geocode(requestRestrictSearchToArea);
                System.out.println(
                        String.format(
                                "When searching for \"%s\" WITHIN the specified boundary, Found %d results",
                                requestRestrictSearchToArea.getGeocode(),
                                responseRestrictedAreaSearchRequest.getResponse().getCollection().getMetadataProperty().getMetadata().getFound()
                        )
                );

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


The example  prints out:

    When searching for "Москва, Костромская, 12", Found 1 results
    The match was: exact
    Location is: 37.596372 55.885721
    GeoObject: Москва, Россия,Костромская улица, 12
    When searching for "Ивановка" near specified area, Found 545 results
    Among those the most accurate is: Арзамас, Нижегородская область, Россия, микрорайон Ивановка, location = 43.824805 55.366323
    When searching for "Ивановка" WITHIN the specified boundary, Found 0 results



The library is straightforward to use: just set the necessary request parameters via `GeocoderRequest.Builder` and get your results via `Geocoder`.

Refer to javadoc and [Yandex Geocoder service](https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/About-docpage/) for request parameters and service description.

#3. Contributions

All contributions are welcome.

#4. License

[Apache License, 2.0](LICENSE)
