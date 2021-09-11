package jain.pranjal.studentregestration;

/**
 * Created by hp on 6/21/2019.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 5/16/2019.
 */

public class ConnectDatabase extends SQLiteOpenHelper {

    private static String db_name = "my_db_test3";
    private static String tbl_name ="my_table_test3";

    private static String create_record = "create table " + tbl_name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,image blob ,regno TEXT unique ,full_name TEXT,father_name TEXT,mother_name TEXT,birthdate TEXT,country TEXT,country_code TEXT,mobileno TEXT ,email TEXT,state TEXT,city TEXT,address TEXT,course TEXT,specialization TEXT);";
    private static String drop_record = "drop table if exist" + tbl_name;

    Context context;

    public ConnectDatabase(Context context) {
        super(context, db_name, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_record);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(drop_record);
        onCreate(db);

    }

    public long insert(byte[] image, String regno,String full_name,String father_name ,String mother_name ,String birthdate,String country,String country_code,String mobileno ,String email,String state,String city,String address,String course,String specialization)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("image",image);
        cv.put("regno",regno);
        cv.put("full_name",full_name);
        cv.put("father_name",father_name);
        cv.put("mother_name",mother_name);
        cv.put("birthdate",birthdate);
        cv.put("country",country);
        cv.put("country_code",country_code);
        cv.put("mobileno",mobileno);
        cv.put("email",email);
        cv.put("state",state);
        cv.put("city",city);
        cv.put("address",address);
        cv.put("course",course);
        cv.put("specialization",specialization);

        long l=db.insert(tbl_name,null,cv);
        db.close();
        return l;
    }

    public String retrieve(String d)
    {
        String a=d;
        String data = "";
        SQLiteDatabase sqdb = this.getReadableDatabase();
        String[] col={"regno","full_name","father_name","mother_name","birthdate","country","country_code","mobileno","email","state","city","address","course","specialization"};
        String Selection="full_name=?";
        String[] args={a};
        Cursor c = sqdb.query(tbl_name,col,Selection,args,null,null,null,null);
        if(c == null)
        {
            data = "No Data";
        }
        else
        {
            while (c.moveToNext())
            {
                data +="Id:\t\t"+ c.getString(0) + "\n\n Registration No.:\t\t"+ c.getString(2) + "\n\n Name:\t\t" + c.getString(3) + "\n\n Father's Name:\t\t" + c.getString(4) + "\n\n Mother's Name:\t\t" + c.getString(5) + "\n\n Birthdate:\t\t" + c.getString(6)+ "\n\n Country:\t\t" + c.getString(7)+ "\n\n Country Code:\t\t" + c.getString(8)+ "\n Phone Number:\t\t" + c.getString(9)+ "\n\n Email:\t\t" + c.getString(10)+ "\n\n State:\t\t" + c.getString(11)+ "\n\n City:\t\t" + c.getString(12)+ "\n\n Address:\t\t" + c.getString(13)+ "\n\n Course:\t\t" + c.getString(14)+ "\n\n Specialization:\t\t" + c.getString(15);

            }

        }
        sqdb.close();
        return data;
    }


    public Cursor getData()
    {
        SQLiteDatabase sqdb = this.getWritableDatabase();
        //String orderBy="ID desc";
        // Cursor c = sqdb.rawQuery("select * from "+tbl_name, null);
        Cursor data= sqdb.query(tbl_name,null,null,null,null,null,null,null);
        return data;
    }

    public Cursor getItemId(String d)
    {
        String data = "";
        SQLiteDatabase sqdb = this.getReadableDatabase();
        String[] col={"id","image","regno","full_name","father_name","mother_name","birthdate","country","country_code","mobileno","email","state","city","address","course","specialization"};
        String Selection="regno=?";
        String[] args={d};
        Cursor c = sqdb.query(tbl_name,col,Selection,args,null,null,null,null);
        return c;
    }






    public boolean delete(String nm[])
    {
        SQLiteDatabase db=this.getWritableDatabase();

        long l =db.delete(tbl_name,"regno=?",nm);
        if(l == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }






    public long update_db(byte[] image,String regno,String full_name,String father_name ,String mother_name ,String birthdate,String country,String country_code,String mobileno ,String email,String state,String city,String address,String course,String specialization)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("image",image);
        cv.put("regno",regno);
        cv.put("full_name",full_name);
        cv.put("father_name",father_name);
        cv.put("mother_name",mother_name);
        cv.put("birthdate",birthdate);
        cv.put("country",country);
        cv.put("country_code",country_code);
        cv.put("mobileno",mobileno);
        cv.put("email",email);
        cv.put("state",state);
        cv.put("city",city);
        cv.put("address",address);
        cv.put("course",course);
        cv.put("specialization",specialization);


        String nam[]={regno};
        long l=db.update(tbl_name,cv,"regno=?",nam);
        return l;
    }

    public boolean  deleteAll()
    {

        SQLiteDatabase db = this.getWritableDatabase();
        //db.delete(TABLE_NAME,null,null);

        //db.execSQL("TRUNCATE table" + TABLE_NAME);
        long d =db.delete(tbl_name,null,null);
        if(d == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}




