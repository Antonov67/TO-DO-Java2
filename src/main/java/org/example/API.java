package org.example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("collections/todos/records")
    Call<ResponseTodo> getTodos();

}
