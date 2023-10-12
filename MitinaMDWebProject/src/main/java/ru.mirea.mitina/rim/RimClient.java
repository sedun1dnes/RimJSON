package ru.mirea.mitina.rim;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.mirea.mitina.stonks.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RimClient {
    public static void main(String[] args) throws IOException, SQLException {
        Retrofit client = new Retrofit
                .Builder()
                .baseUrl("https://rickandmortyapi.com")
                .addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
                .build();

        RimService rimService = client.create(RimService.class);

        Response<DTO> response = rimService
                .getSeries(1).execute();

        DTO dto = response.body();

        List<Episode> episodes = dto.getEpisodes().stream()
                .sorted(Comparator.comparing(Episode::getAmountOfCharacters).reversed())
                .collect(Collectors.toList());

        System.out.println(episodes.get(0).getTitle());

    }
}
