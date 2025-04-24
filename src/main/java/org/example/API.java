package org.example;

import retrofit2.Call;
import retrofit2.http.*;

public interface API {

    @GET("collections/todos/records")
    Call<ResponseTodo> getTodos();

    @POST("collections/todos/records")
    Call<Todo> createTodo(@Body Todo todo);

    @DELETE("collections/todos/records/{id}")
    Call<Void> deleteTodo(@Path("id") String id);

}
