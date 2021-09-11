package jain.pranjal.studentregestration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by hp on 7/13/2019.
 */

public class FrontPage extends AppCompatActivity{
    ImageView register,show;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);
        register=(ImageView) findViewById(R.id.imageView3);
        show=(ImageView) findViewById(R.id.imageView5);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FrontPage.this, Add.class));


            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FrontPage.this, MainActivity.class));


            }
        });



    }
}
