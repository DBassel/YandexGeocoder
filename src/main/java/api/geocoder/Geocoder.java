package api.geocoder;


import api.geocoding.GeocoderRequest;
import api.geocoding.GeocoderResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;


/**
 * Geocoder class to perform requests to Yandex Geocoding service
 */
public class Geocoder {

    private static final String GEOCODER_SCHEME_HOST = "geocode-maps.yandex.ru";
    private static final String GEOCODER_SCHEME_HTTP = "http";
    private static final String GEOCODER_SCHEME_HTTPS = "https";
    private static final String GEOCODER_SCHEME_PATH = "/1.x/";

    /**
     * Default format for doubles in request
     */
    private DecimalFormat format = new DecimalFormat("#.######");

    private ResponseHandler<GeocoderResponse> responseHandler;

    private final HttpClient httpClient;

    /**
     * Creates Geocoder instance using the default HttpClient
     */
    public Geocoder() {
        this(HttpClients.createDefault());
    }


    /**
     * Creates Geocoder instance using custom HttpClient
     *
     * @param httpClient custom  HttpClient instance
     */
    public Geocoder(HttpClient httpClient) {
        if (httpClient == null) {
            throw new IllegalArgumentException("http client can not be null");
        }
        this.httpClient = httpClient;
        responseHandler = getDefaultResponseHandler();
    }


    /**
     * Process geocoding request
     *
     * @param geocoderRequest request to a Yandex Geocoder service
     * @return response from geocoding service
     * @throws java.io.IOException
     * @throws org.apache.http.client.ClientProtocolException
     */
    public GeocoderResponse geocode(GeocoderRequest geocoderRequest) throws IOException, ClientProtocolException {
        if (geocoderRequest == null) {
            throw new IllegalArgumentException("geocoder request can not be null");
        }
        URI uri = getURI(geocoderRequest);
        return request(uri);

    }


    /**
     * @param uri fully constructed request URI
     * @return response from geocoding service
     * @throws java.io.IOException
     * @throws org.apache.http.client.ClientProtocolException
     */
    protected GeocoderResponse request(URI uri) throws IOException, ClientProtocolException {
        HttpGet get = new HttpGet(uri);
        return httpClient.execute(get, responseHandler);
    }


    /**
     * Get the URL for a specific geocoding service request
     *
     * @param geocoderRequest request to a Yandex Geocoder service
     * @return URL for performing a geocoding service request
     * @throws java.lang.IllegalArgumentException if failed to build URI from geocoderRequest
     */
    URI getURI(GeocoderRequest geocoderRequest) {

        URIBuilder builder = new URIBuilder();
        builder.setScheme(geocoderRequest.getKey() == null ? GEOCODER_SCHEME_HTTP : GEOCODER_SCHEME_HTTPS);
        builder.setHost(GEOCODER_SCHEME_HOST);
        builder.setPath(GEOCODER_SCHEME_PATH);
        builder.setParameter("format", "json");

        builder.setParameter("geocode", geocoderRequest.getGeocode());

        if (geocoderRequest.getKey() != null && geocoderRequest.getKey().length() != 0) {
            builder.setParameter("key", geocoderRequest.getKey());
        }

        if (geocoderRequest.getKind() != null) {
            builder.setParameter("kind", geocoderRequest.getKind().toString());
        }

        if (geocoderRequest.getLanguage() != null) {
            builder.setParameter("lang", geocoderRequest.getLanguage().toString());
        }

        if (geocoderRequest.isSearchAreaRestricted()) {
            builder.setParameter("rspn", "1");
        }

        if (geocoderRequest.isSearchAreaRestricted() || geocoderRequest.isSearchAreaSpecified()) {
            builder.setParameter("ll",
                    String.format("%s,%s",
                            formatDoubleDefault(geocoderRequest.getCenterLat()),
                            formatDoubleDefault(geocoderRequest.getCenterLng()))
            );
        }

        if (geocoderRequest.getResults() != GeocoderRequest.RESULTS_DEAFULT) {
            builder.setParameter("results", String.valueOf(geocoderRequest.getResults()));
        }
        if (geocoderRequest.getSkip() != GeocoderRequest.SKIP_DEFAULT) {
            builder.setParameter("skip", String.valueOf(geocoderRequest.getSkip()));
        }


        try {
            return builder.build();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("GeocoderRequest contains illegal parameters: URISyntaxException was thrown when building URI");
        }
    }

    /**
     * Format a double value to a String value
     * By default uses DecimalFormat with RoundingMode.HALF_EVEN
     *
     * @param f value to be formatted
     * @return a formatted String
     */
    String formatDoubleDefault(double f) {
        return format.format(f);
    }


    /**
     * @return default ResponseHandler to handle http client responses
     */
    ResponseHandler<GeocoderResponse> getDefaultResponseHandler() {
        return new ResponseHandler<GeocoderResponse>() {
            @Override
            public GeocoderResponse handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                StatusLine statusLine = response.getStatusLine();
                HttpEntity entity = response.getEntity();
                if (statusLine.getStatusCode() >= 300) {
                    throw new HttpResponseException(
                            statusLine.getStatusCode(),
                            statusLine.getReasonPhrase());
                }
                if (entity == null) {
                    throw new ClientProtocolException("Response contains no content");
                }
                Gson gson = new GsonBuilder().create();
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                Reader reader = new InputStreamReader(entity.getContent(), charset);
                return gson.fromJson(reader, GeocoderResponse.class);
            }
        };
    }


}
