package com.example.services;

import com.example.assertions.AssertableResponse;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserApiService extends ApiService {


    @Step
    public AssertableResponse deleteToDoBy(String id){
        return new AssertableResponse(setup()
                .when()
                .delete("/todos/{id}", id));
    }

    @Step
    public AssertableResponse getToDoBy(String id){
        return new AssertableResponse(setup()
                .when()
                .get("/todos/{id}", id));
    }

    @Step
    public AssertableResponse getAllToDos(){
        return new AssertableResponse(setup()
                .when()
                .get("/todos"));
    }
}
