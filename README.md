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


