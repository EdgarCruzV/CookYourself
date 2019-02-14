package android.itesm.edu.pokemon;


import android.app.Activity;
import android.itesm.edu.pokemon.adapters.PokemonRecycleAdapter;
import android.itesm.edu.pokemon.model.PokeCard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ListActivity extends AppCompatActivity {

    private final String JSON_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=" ;

    private JsonObjectRequest request;
    private RequestQueue requestQueue;
    private List<PokeCard> cards;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        cards = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleView);
        jsonrequest();


    }
    private void jsonrequest(){
        request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray cardsJSON = response.getJSONArray("meals");
                            JSONObject jsonObject = null;
                            for(int i=0; i< cardsJSON.length(); i++){
                                jsonObject = cardsJSON.getJSONObject(i);
                                PokeCard pokeCard = new PokeCard();
                                pokeCard.setId(jsonObject.getString("strTags"));
                                pokeCard.setName(jsonObject.getString("strMeal"));
                                pokeCard.setImageUrl(jsonObject.getString("strMealThumb"));
                                pokeCard.setArtist(jsonObject.getString("strArea"));
                                pokeCard.setCategory(jsonObject.getString("strCategory"));
                                pokeCard.setYouTube(jsonObject.getString("strYoutube"));

                                cards.add(pokeCard);

                            }
                        }catch(JSONException jsonException){
                            jsonException.printStackTrace();
                        }

                        setRecyclerView(cards);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error del server", Toast.LENGTH_LONG).show();
            }
        });

        requestQueue= Volley.newRequestQueue(ListActivity.this);
        requestQueue.add(request);
    }

    private void setRecyclerView(List<PokeCard> pokeCards){
        PokemonRecycleAdapter pokemonRecycleAdapter = new PokemonRecycleAdapter(this, pokeCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(pokemonRecycleAdapter);
    }


}
