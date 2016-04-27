package com.icap.mywork;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

/**
 * Created by satyajit on 27/04/2016.
 */

public class PrimeNumberTest {
    private static String BASE_URL = "http://localhost:8080/mywork/rest/prime";

    @Test
    public void testPrime() throws Exception {
        Client client = Client.create();
        WebResource webResource = client.resource(BASE_URL + "/17");
        String response = webResource.get(String.class);

        assert(response.toString().equals("17 is a prime number"));
    }

    @Test
    public void testNotPrime() throws Exception {
        Client client = Client.create();
        WebResource webResource = client.resource(BASE_URL + "/6");
        String response = webResource.get(String.class);

        assert(response.toString().equals("6 is not prime number"));
    }

}
