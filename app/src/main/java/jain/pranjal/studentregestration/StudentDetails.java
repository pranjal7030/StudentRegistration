package jain.pranjal.studentregestration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hp on 7/12/2019.
 */

public class StudentDetails extends AppCompatActivity {
    ImageView profile;
   public TextView regno, name, father_name, mother_name, birthdate, country, country_code, phone_no, email, state, city, address, course, specialization;
    public String regno2, name2, father_name2, mother_name2, birthdate2, country2, country_code2, phone_no2, email2, state2, city2, address2, course2, specialization2;
    ImageView edit, delete;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_form);
        profile = (ImageView) findViewById(R.id.imageView2);
        regno = (TextView) findViewById(R.id.regno1);
        name = (TextView) findViewById(R.id.name1);
        father_name = (TextView) findViewById(R.id.fathername1);
        mother_name = (TextView) findViewById(R.id.mothername);
        birthdate = (TextView) findViewById(R.id.birthdate1);
        country = (TextView) findViewById(R.id.country1);
        country_code = (TextView) findViewById(R.id.country_code);
        phone_no = (TextView) findViewById(R.id.phone_no1);
        email = (TextView) findViewById(R.id.email1);
        state = (TextView) findViewById(R.id.state1);
        city = (TextView) findViewById(R.id.city1);
        address = (TextView) findViewById(R.id.address1);
        course = (TextView) findViewById(R.id.course1);
        specialization = (TextView) findViewById(R.id.specialization1);
        edit = (ImageView) findViewById(R.id.edit_this_student);
        delete = (ImageView) findViewById(R.id.delete_this_student);


        Intent recievedTent = getIntent();
        regno2 = recievedTent.getStringExtra("regno");
        name2 = recievedTent.getStringExtra("name");
        father_name2 = recievedTent.getStringExtra("fname");
        mother_name2 = recievedTent.getStringExtra("Mname");
        birthdate2 = recievedTent.getStringExtra("birthdate");
        country2 = recievedTent.getStringExtra("country");
        country_code2 = recievedTent.getStringExtra("country_code");
        phone_no2 = recievedTent.getStringExtra("phone_no");
        email2 = recievedTent.getStringExtra("email");
        state2 = recievedTent.getStringExtra("state");
        city2 = recievedTent.getStringExtra("city");
        address2 = recievedTent.getStringExtra("address");
        course2 = recievedTent.getStringExtra("course");
        specialization2 = recievedTent.getStringExtra("special");
        if (getIntent().hasExtra("image")) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("image"), 0, getIntent().getByteArrayExtra("image").length);
            profile.setImageBitmap(bitmap);
        }

        regno.setText(regno2);
        name.setText(name2);
        father_name.setText(father_name2);
        mother_name.setText(mother_name2);
        birthdate.setText(birthdate2);
        country.setText(country2);
        country_code.setText(country_code2);
        phone_no.setText(phone_no2);
        email.setText(email2);
        state.setText(state2);
        city.setText(city2);
        address.setText(address2);
        course.setText(course2);
        specialization.setText(specialization2);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectDatabase dba = new ConnectDatabase(StudentDetails.this);
                String nam[] = {regno2};

                boolean b = dba.delete(nam);

                if (b == true) {
                    Toast.makeText(StudentDetails.this, "Student Details Deleted successfully !!", Toast.LENGTH_LONG).show();
                    Intent studentDetails = new Intent(StudentDetails.this, MainActivity.class);
                    startActivity(studentDetails);
                    finish();


                } else {
                    Toast.makeText(StudentDetails.this, "Student Details not Deleted !! Something is Wrong.", Toast.LENGTH_LONG).show();


                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent sent_to_edit=new Intent(StudentDetails.this,Edit.class);
                    sent_to_edit.putExtra("regnumber",regno2);
                    startActivity(sent_to_edit);
                    finish();

                }






        });
    }

}
