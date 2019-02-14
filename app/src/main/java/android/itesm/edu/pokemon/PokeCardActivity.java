package android.itesm.edu.pokemon;

import android.content.Intent;
import android.itesm.edu.pokemon.model.PokeCard;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class PokeCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_card);
        PokeCard pokeCard = (PokeCard) getIntent().getSerializableExtra("pokemon");
        loadPokemon(pokeCard);
    }
    private void loadPokemon(PokeCard pokeCard){
        TextView id, name, artist, another;
        ImageView image;
        id = findViewById(R.id.id_card);
        name = findViewById(R.id.card_name);
        artist = findViewById(R.id.author_card);
        image = findViewById(R.id.card);
        another = findViewById(R.id.another);

        RequestOptions options = new RequestOptions().centerCrop()
                .placeholder(R.drawable.load_card).error(R.drawable.load_card);
        name.setText(pokeCard.getName());
        id.setText(pokeCard.getId());
        artist.setText(pokeCard.getArtist());
        another.setText(pokeCard.getCategory());

        Glide.with(this).load(pokeCard.getImageUrl()).apply(options).into(image);

    }

    public void button(View view){
        PokeCard pokeCard = (PokeCard) getIntent().getSerializableExtra("pokemon");
        loadPokemon(pokeCard);
        Uri page = Uri.parse(pokeCard.getYouTube());
        Intent web = new Intent(Intent.ACTION_VIEW, page);
        startActivity(web);
    }
}
