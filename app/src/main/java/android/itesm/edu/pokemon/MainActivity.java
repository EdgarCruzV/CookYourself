package android.itesm.edu.pokemon;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttons(View view){
        switch(view.getId()){
            case R.id.site:
                Uri page = Uri.parse("https://www.eatthismuch.com/");
                Intent web = new Intent(Intent.ACTION_VIEW, page);
                startActivity(web);
                break;
            case R.id.list:
                Intent intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
