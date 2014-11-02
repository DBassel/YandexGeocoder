YandexGeocoder
==============

Java API for [Yandex Geocoder service](https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/About-docpage/)

#1. Usage

    GeocoderRequest request = new GeocoderRequest.Builder("Москва, Костромская, 12").get();
            Geocoder geocoder = new Geocoder();
            try {
                GeocoderResponse response = geocoder.geocode(request);
                System.out.println(
                        String.format(
                                "Found %d results",
                                response.getResponse().getCollection().getMetadataProperty().getMetadata().getFound()
                        )
                );

                for (GeoObjectCollection.GeoObjectHolder holder : response.getResponse().getCollection().getGeoObjectHolders()) {
                    System.out.println("Location: " + holder.getObject().getPoint().getPositionString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


The example  prints out:

    Found 1 results
    Location: 37.596372 55.885721


The library is straightforward to use: just set the necessary request parameters via `GeocoderRequest.Builder` and get your results via `Geocoder`.

Refer to javadoc and [Yandex Geocoder service](https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/About-docpage/) for request parameters and service description.