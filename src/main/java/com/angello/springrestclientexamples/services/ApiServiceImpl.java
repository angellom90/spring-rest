package com.angello.springrestclientexamples.services;

import com.angello.api.domain.User;
import com.angello.api.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/**
 * Created by jt on 9/21/17.
 */
@Service
public class ApiServiceImpl implements  ApiService {

    private RestTemplate restTemplate;
    private final String api_url;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        //Connect rest template through proxy
/*        SimpleClientHttpRequestFactory factory = new   SimpleClientHttpRequestFactory();
        InetSocketAddress address = new InetSocketAddress("proxy",8080);
        Proxy proxy = new Proxy(Proxy.Type.HTTP,address);
        factory.setProxy(proxy);
        restTemplate.setRequestFactory(factory);*/

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("limit", limit);

        UserData userData = restTemplate.getForObject(uriBuilder.toUriString(), UserData.class);
        return userData.getData();
    }
}
