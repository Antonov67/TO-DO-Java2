package org.example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodoService {

    private static final String
            BASE_URL = "http://192.168.11.164:8090/api/";
    private API api;

    public TodoService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
    }

    //получение списка TO-DO
    public void getTodos(SimpleDataCallback<ResponseTodo> callback){
        Call<ResponseTodo> call = api.getTodos();
        call.enqueue(new Callback<ResponseTodo>() {
            @Override
            public void onResponse(Call<ResponseTodo> call, Response<ResponseTodo> response) {
                if (response.isSuccessful()){
                    callback.load(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseTodo> call, Throwable throwable) {

            }
        });
    }
    //создание задачи
    public void createTodo(Todo todo, SimpleDataCallback<Todo> callback){
        Call<Todo> call = api.createTodo(todo);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                if (response.isSuccessful()){
                    callback.load(response.body());
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable throwable) {

            }
        });
    }
    //удаление задач
    public void deleteTodo(String id, SimpleDataCallback<String> callback){
        Call<Void> call = api.deleteTodo(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    callback.load("ок");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {

            }
        });
    }



}
