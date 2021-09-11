package jain.pranjal.studentregestration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ImageView deleteall;
    AlertDialog.Builder alt;
    ConnectDatabase db;
    ArrayList<MyData> listData=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        deleteall=(ImageView) findViewById(R.id.deleteAll);
        listView = (ListView) findViewById(R.id.list);

       db=new ConnectDatabase(this);
        Cursor data=db.getData();
        if(data.getCount()==0)
        {
            Toast.makeText(this,"No Student Is Registered !!",Toast.LENGTH_LONG).show();
        }

        while (data.moveToNext())
        {
            String name=data.getString(3);
            byte[] image=data.getBlob(1);
            String regno=data.getString(2);
            int id=data.getInt(0);
            listData.add(new MyData(name,image,regno,id));
        }
        CustomAdapter adapter=new CustomAdapter(this, R.layout.custom_activity, listData);
        listView.setAdapter(adapter);



        deleteall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alt = new AlertDialog.Builder(MainActivity.this);
                alt.setMessage("Do You Want To Delete All Data !!")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                ConnectDatabase dba=new ConnectDatabase(MainActivity.this);
                                dba.deleteAll();
                                Toast.makeText(getApplicationContext(), "Student Data Deleted Successfully !!", Toast.LENGTH_SHORT).show();
                               Intent i=new Intent(MainActivity.this,MainActivity.class);
                                startActivity(i);
                                finish();

                            }

                        })

                        .setNegativeButton("no", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(MainActivity.this, "Student Data Is Safe !!", Toast.LENGTH_SHORT).show();

                            }
                        });

                AlertDialog alert = alt.create();
                alert.show();





            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public class CustomAdapter extends BaseAdapter
    {
        private Context context;
        private int layout;
        ArrayList<MyData> textList;
        public CustomAdapter(Context context,int layout,ArrayList<MyData> textList)
        {
            this.context=context;
            this.layout=layout;
            this.textList=textList;
        }

        @Override
        public int getCount() {
            return textList.size();
        }

        @Override
        public Object getItem(int position) {
            return textList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class ViewHolder
        {
            ImageView imageView1;
            TextView textName;
            TextView regNo;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            View row = view;

            ViewHolder holder;

            if(row == null)
            {
                LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                row=inflater.inflate(layout, null);
                holder=new ViewHolder();
                holder.textName=(TextView) row.findViewById(R.id.textView);
                holder.imageView1=(ImageView) row.findViewById(R.id.imageView);
                holder.regNo=(TextView)row.findViewById(R.id.textView2);
                row.setTag(holder);


            }
            else
            {
                holder=(ViewHolder) row.getTag();

            }
            final MyData student=textList.get(position);
            holder.textName.setText(student.GetName());
            holder.regNo.setText(student.GetRegno());
            final byte[] foodImage = student.GetImage();
            final Bitmap bitmap= BitmapFactory.decodeByteArray(foodImage,0,foodImage.length);
            holder.imageView1.setImageBitmap(bitmap);
            row.setOnClickListener(new AdapterView.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Cursor data= db.getItemId(student.GetRegno());
                    int itemId = -1;
                    String Name="";
                    byte[] Image=null;
                    String Regno="";
                    String father_name="";
                    String mother_name="";
                    String birthdate="";
                    String country="";
                    String country_code="";
                    String phone_no="";
                    String email="";
                    String state="";
                    String city="";
                    String address="";
                    String course="";
                    String specialization="";
                    while (data.moveToNext())
                    {
                        Image = data.getBlob(1);
                        Regno =data.getString(2);
                        Name = data.getString(3);
                        father_name = data.getString(4);
                        mother_name = data.getString(5);
                        birthdate = data.getString(6);
                        country = data.getString(7);
                        country_code = data.getString(8);
                        phone_no = data.getString(9);
                        email = data.getString(10);
                        state = data.getString(11);
                        city = data.getString(12);
                        address=data.getString(13);
                        course = data.getString(14);
                        specialization = data.getString(15);
                        Intent showIntent=new Intent(MainActivity.this,StudentDetails.class);
                        showIntent.putExtra("regno",student.GetRegno());
                        showIntent.putExtra("name",student.GetName());
                        showIntent.putExtra("fname",father_name);
                        showIntent.putExtra("Mname",mother_name);
                        showIntent.putExtra("birthdate",birthdate);
                        showIntent.putExtra("country",country);
                        showIntent.putExtra("country_code",country_code);
                        showIntent.putExtra("phone_no",phone_no);
                        showIntent.putExtra("email",email);
                        showIntent.putExtra("state",state);
                        showIntent.putExtra("city",city);
                        showIntent.putExtra("address",address);
                        showIntent.putExtra("course",course);
                        showIntent.putExtra("special",specialization);
                        ByteArrayOutputStream bs=new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG,60,bs);
                        showIntent.putExtra("image",bs.toByteArray());
                        startActivity(showIntent);
                        finish();

                    }

                }
            });
            return row;
        }
    }

}
