package com.angello.springrestclientexamples.services;

import com.angello.api.domain.User;
import com.angello.api.domain.UserData;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/**
 * Created by jt on 9/21/17.
 */
@Service
public class ApiServiceImpl implements  ApiService {

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        //Connect rest template through proxy
/*        SimpleClientHttpRequestFactory factory = new   SimpleClientHttpRequestFactory();
        InetSocketAddress address = new InetSocketAddress("proxy",8080);
        Proxy proxy = new Proxy(Proxy.Type.HTTP,address);
        factory.setProxy(proxy);
        restTemplate.setRequestFactory(factory);*/

        UserData userData = restTemplate.getForObject("http://apifaketory.com/api/user?limit=" + limit, UserData.class);
        return userData.getData();
    }
}
