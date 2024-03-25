package com.walearn.platform.backend.users.service;


import com.walearn.platform.backend.users.request.SignInRequest;
import com.walearn.platform.backend.users.request.SignUpRequest;
import com.walearn.platform.backend.users.response.APIResponse;

public interface UserService {


    APIResponse signup(SignUpRequest signUpRequest);


    APIResponse signIn(SignInRequest signInRequest);
}
