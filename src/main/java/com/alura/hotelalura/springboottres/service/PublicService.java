package com.alura.hotelalura.springboottres.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TreeSet;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.alura.hotelalura.springboottres.controller.requests.ReservaRequest;
import com.alura.hotelalura.springboottres.controller.responses.ConsultarResponses;
import com.alura.hotelalura.springboottres.controller.responses.ReservaResponses;
import com.alura.hotelalura.springboottres.persitence.repository.HabitacionTipoRepository;
import com.alura.hotelalura.springboottres.persitence.repository.MetodoRepository;
import com.alura.hotelalura.springboottres.service.validate.ReservaValidation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
@RequiredArgsConstructor
public class PublicService 
{

    private final HabitacionTipoRepository habitacionTipoRepository;
    private final List<ReservaValidation> reservaValidation;
    private final MetodoRepository metodoRepository;
    private final ObjectMapper mapper;
  
     
    @Cacheable("listarPorCategoria")
    public List<String> listarPorCategoria()
    {   
        return habitacionTipoRepository.findByActivoTrue();
    }

    public ReservaResponses ConsultarReserva (ReservaRequest request)
    { 
       reservaValidation.forEach((validar) -> validar.validate(request));
       BigDecimal precioUnitario = habitacionTipoRepository.findById(request.categoria())
                                                                                       .get()
                                                                                       .getPercioUnitario();
          
       Long dias = ChronoUnit.DAYS.between(request.checkIn(), request.checkOut());
       return new ReservaResponses(request.username(), 
                                   this.listarPorCategoria(), 
                                   new ConsultarResponses(request.checkIn(), 
                                                          request.checkOut(), 
                                                          request.categoria(), 
                                                          precioUnitario.multiply(new BigDecimal(dias))
                                                          ));
    }
    
    @Cacheable("listarMetodoPago")
    public List<String> listarMetodoPago()
    {
      return metodoRepository.buscarMetodoPagos();
    }
    
    @Cacheable(cacheNames = "cachingUserName", key = "'generarPaisses'")
    public TreeSet<String> generarPaisses() throws IOException
    {   

       TreeSet<String> mysPaises = new TreeSet<>();
       OkHttpClient client = new OkHttpClient();
       Request request = new Request.Builder()
                .url("https://restcountries.com/v3.1/all")
                .build();

        Response responses = client.newCall(request).execute();
        String responseBody = responses.body().string();
        JsonNode paises = mapper.readTree(responseBody);
        
        
        if(mysPaises.isEmpty())
        {
            for (JsonNode pais: paises)
            {mysPaises.add(pais.get("name").get("common").asText());}

        }

        return mysPaises;
    }

}
