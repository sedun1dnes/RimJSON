package ru.mirea.mitina.rim;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.mirea.mitina.stonks.DailyCurs;

public interface RimService {
    @GET("/api/episode")
    Call<DTO> getSeries(@Query("page") int num);
}
