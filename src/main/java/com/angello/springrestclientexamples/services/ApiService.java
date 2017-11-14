package com.angello.springrestclientexamples.services;
import com.angello.api.domain.User;

import java.util.List;

/**
 * Created by jt on 9/21/17.
 */
public interface ApiService {

    List<User> getUsers(Integer limit);
}
