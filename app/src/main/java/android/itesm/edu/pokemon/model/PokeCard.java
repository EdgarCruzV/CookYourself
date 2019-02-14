package android.itesm.edu.pokemon.model;

import java.io.Serializable;
public class PokeCard implements Serializable {

    private String id, name, imageUrl, artist, category, youTube;

    public PokeCard() {
    }

    public PokeCard(String id, String name, String imageUrl, String artist, String category, String youTube) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.artist = artist;
        this.category = category;
        this.youTube = youTube;
    }

    public String getYouTube() {
        return youTube;
    }

    public void setYouTube(String youTube) {
        this.youTube = youTube;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
