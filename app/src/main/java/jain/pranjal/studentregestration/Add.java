package jain.pranjal.studentregestration;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by hp on 6/21/2019.
 */

public class Add extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

   // TextView t1;
   final int REQUEST_CODE_GALLERY=999;
    ImageView myImg;
    EditText regno,name,fname,mname,birthday,phoneno,email,state,city,address;
    Spinner country,country_code,course,speciallization;
    Button save;
    TextView Country_error,Iso_code_error,Course_error,Specialization_error;
    ImageView date;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        myImg=(ImageView)findViewById(R.id.imageView);
        regno=(EditText)findViewById(R.id.registrationno);
        name=(EditText)findViewById(R.id.fullname);
        fname=(EditText)findViewById(R.id.father_name);
        mname=(EditText)findViewById(R.id.mother_name);
        birthday=(EditText)findViewById(R.id.birthdate);
        phoneno=(EditText)findViewById(R.id.phone_no);
        country=(Spinner)findViewById(R.id.country);
        country_code=(Spinner)findViewById(R.id.country_code);
        email=(EditText)findViewById(R.id.email);
        state=(EditText)findViewById(R.id.state);
        city=(EditText)findViewById(R.id.city);
        address=(EditText)findViewById(R.id.address);
        course=(Spinner)findViewById(R.id.course);
        speciallization=(Spinner)findViewById(R.id.specialization);
        save=(Button)findViewById(R.id.button6);
        Country_error=(TextView)findViewById(R.id.country_error);
        Iso_code_error=(TextView)findViewById(R.id.country_code_error);
        Course_error=(TextView)findViewById(R.id.course_error);
        Specialization_error=(TextView)findViewById(R.id.specialization_error);
        date=(ImageView)findViewById(R.id.imageView7);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        myImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(Add.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_CODE_GALLERY);
            }
        });

        List<String> Scountry=new ArrayList<String>();
        Scountry.add("Country");
        Scountry.add("Afghanistan");
        Scountry.add("Albania");
        Scountry.add("Algeria");
        Scountry.add("American Samoa");
        Scountry.add("Andorra");
        Scountry.add("Angola");
        Scountry.add("Anguilla");
        Scountry.add("Antarctica");
        Scountry.add("Antigua");
        Scountry.add("Argentina");
        Scountry.add("Armenia");
        Scountry.add("Aruba");
        Scountry.add("Aruba");
        Scountry.add("Ascension");
        Scountry.add("Australia");
        Scountry.add("Australian External Territories");
        Scountry.add("Austria");
        Scountry.add("Azerbaijan");
        Scountry.add("Bahamas");
        Scountry.add("Bahrain");
        Scountry.add("Bangladesh");
        Scountry.add("Barbados");
        Scountry.add("Barbuda");
        Scountry.add("Belarus");
        Scountry.add("Belgium");
        Scountry.add("Belize");
        Scountry.add("Benin");
        Scountry.add("Bermuda");
        Scountry.add("Bhutan");
        Scountry.add("Bolivia");
        Scountry.add("Bosnia & Herzegovina");
        Scountry.add("Botswana");
        Scountry.add("Brazil");
        Scountry.add("British Virgin Islands");
        Scountry.add("Brunei Darussalam");
        Scountry.add("Bulgaria");
        Scountry.add("Burkina Faso");
        Scountry.add("Burundi");
        Scountry.add("Cambodia");
        Scountry.add("Cameroon");
        Scountry.add("Canada");
        Scountry.add("Cape Verde Islands");
        Scountry.add("Cayman Islands");
        Scountry.add("Central African Republic");
        Scountry.add("Chad");
        Scountry.add("Chatham Island (New Zealand)");
        Scountry.add("Chile");
        Scountry.add("China (PRC)");
        Scountry.add("Christmas Island");
        Scountry.add("Cocos-Keeling Islands");
        Scountry.add("Colombia");
        Scountry.add("Comoros");
        Scountry.add("Congo");
        Scountry.add("Congo, Dem. Rep. of  (former Zaire)");
        Scountry.add("Cook Islands");
        Scountry.add("Costa Rica");
        Scountry.add("Côte d'Ivoire (Ivory Coast)");
        Scountry.add("Croatia");
        Scountry.add("Cuba");
        Scountry.add("Cuba (Guantanamo Bay)");
        Scountry.add("Curaçao");
        Scountry.add("Cyprus");
        Scountry.add("Czech Republic");
        Scountry.add("Denmark");
        Scountry.add("Diego Garcia");
        Scountry.add("Djibouti");
        Scountry.add("Dominica");
        Scountry.add("Dominican Republic");
        Scountry.add("East Timor");
        Scountry.add("Easter Island");
        Scountry.add("Ecuador");
        Scountry.add("Egypt");
        Scountry.add("El Salvador");
        Scountry.add("Ellipso (Mobile Satellite service)");
        Scountry.add("EMSAT (Mobile Satellite service)");
        Scountry.add("Equatorial Guinea");
        Scountry.add("Eritrea");
        Scountry.add("Estonia");
        Scountry.add("Ethiopia");
        Scountry.add("Falkland Islands (Malvinas)");
        Scountry.add("Faroe Islands");
        Scountry.add("Fiji Islands");
        Scountry.add("Finland");
        Scountry.add("France");
        Scountry.add("French Antilles");
        Scountry.add("French Guiana");
        Scountry.add("French Polynesia");
        Scountry.add("Gabonese Republic");
        Scountry.add("Gambia");
        Scountry.add("Georgia");
        Scountry.add("Germany");
        Scountry.add("Ghana");
        Scountry.add("Gibraltar");
        Scountry.add("Global Mobile Satellite System (GMSS)");
        Scountry.add("Globalstar (Mobile Satellite Service)");
        Scountry.add("Greece");
        Scountry.add("Greenland");
        Scountry.add("Grenada");
        Scountry.add("Guadeloupe");
        Scountry.add("Guam");
        Scountry.add("Guantanamo Bay");
        Scountry.add("Guatemala");
        Scountry.add("Guinea-Bissau");
        Scountry.add("Guinea");
        Scountry.add("Guyana");
        Scountry.add("Haiti");
        Scountry.add("Honduras");
        Scountry.add("Hong Kong");
        Scountry.add("Hungary");
        Scountry.add("ICO Global (Mobile Satellite Service)");
        Scountry.add("Iceland");
        Scountry.add("India");
        Scountry.add("Indonesia");
        Scountry.add("Inmarsat (Atlantic Ocean - East)");
        Scountry.add("Inmarsat (Atlantic Ocean - West)");
        Scountry.add("Inmarsat (Indian Ocean)");
        Scountry.add("Inmarsat (Pacific Ocean)");
        Scountry.add("Inmarsat SNAC");
        Scountry.add("International Freephone Service");
        Scountry.add("International Shared Cost Service (ISCS)");
        Scountry.add("Iran");
        Scountry.add("Iraq");
        Scountry.add("Ireland");
        Scountry.add("Iridium (Mobile Satellite service)");
        Scountry.add("Israel");
        Scountry.add("Italy");
        Scountry.add("Jamaica");
        Scountry.add("Japan");
        Scountry.add("Jordan");
        Scountry.add("Kazakhstan");
        Scountry.add("Kenya");
        Scountry.add("Kiribati");
        Scountry.add("Korea (North)");
        Scountry.add("Korea (South)");
        Scountry.add("Kuwait");
        Scountry.add("Kyrgyz Republic");
        Scountry.add("Laos");
        Scountry.add("Latvia");
        Scountry.add("Lebanon");
        Scountry.add("Lesotho");
        Scountry.add("Liberia");
        Scountry.add("Libya");
        Scountry.add("Liechtenstein");
        Scountry.add("Lithuania");
        Scountry.add("Luxembourg");
        Scountry.add("Macao");
        Scountry.add("Macedonia (Former Yugoslav Rep of.)");
        Scountry.add("Madagascar");
        Scountry.add("Malawi");
        Scountry.add("Malaysia");
        Scountry.add("Maldives");
        Scountry.add("Mali Republic");
        Scountry.add("Malta");
        Scountry.add("Marshall Islands");
        Scountry.add("Martinique");
        Scountry.add("Mauritania");
        Scountry.add("Mauritius");
        Scountry.add("Mayotte Island");
        Scountry.add("Mexico");
        Scountry.add("Micronesia, (Federal States of)");
        Scountry.add("Midway Island");
        Scountry.add("Moldova");
        Scountry.add("Monaco");
        Scountry.add("Mongolia");
        Scountry.add("Montenegro");
        Scountry.add("Montserrat");
        Scountry.add("Morocco");
        Scountry.add("Mozambique");
        Scountry.add("Myanmar");
        Scountry.add("Namibia");
        Scountry.add("Nauru");
        Scountry.add("Nepal");
        Scountry.add("Netherlands");
        Scountry.add("Netherlands Antilles");
        Scountry.add("Nevis");
        Scountry.add("New Caledonia");
        Scountry.add("New Zealand");
        Scountry.add("Nicaragua");
        Scountry.add("Niger");
        Scountry.add("Nigeria");
        Scountry.add("Niue");
        Scountry.add("Norfolk Island");
        Scountry.add("Northern Marianas Islands");
        Scountry.add("(Saipan, Rota, & Tinian)");
        Scountry.add("Norway");
        Scountry.add("Oman");
        Scountry.add("Pakistan");
        Scountry.add("Palau");
        Scountry.add("Palestinian Settlements");
        Scountry.add("Panama");
        Scountry.add("Papua New Guinea");
        Scountry.add("Paraguay");
        Scountry.add("Peru");
        Scountry.add("Philippines");
        Scountry.add("Poland");
        Scountry.add("Portugal");
        Scountry.add("Puerto Rico");
        Scountry.add("Qatar");
        Scountry.add("Réunion Island");
        Scountry.add("Romania");
        Scountry.add("Russia");
        Scountry.add("Rwandese Republic");
        Scountry.add("St. Helena");
        Scountry.add("St. Kitts/Nevis");
        Scountry.add("St. Lucia");
        Scountry.add("St. Pierre & Miquelon");
        Scountry.add("St. Vincent & Grenadines");
        Scountry.add("Samoa");
        Scountry.add("San Marino");
        Scountry.add("São Tomé and Principe");
        Scountry.add("Saudi Arabia");
        Scountry.add("Senegal");
        Scountry.add("Serbia");
        Scountry.add("Seychelles Republic");
        Scountry.add("Sierra Leone");
        Scountry.add("Singapore");
        Scountry.add("Slovak Republic");
        Scountry.add("Slovenia");
        Scountry.add("Solomon Islands");
        Scountry.add("Somali Democratic Republic");
        Scountry.add("South Africa");
        Scountry.add("Spain");
        Scountry.add("Sri Lanka");
        Scountry.add("Sudan");
        Scountry.add("Suriname");
        Scountry.add("Swaziland");
        Scountry.add("Sweden");
        Scountry.add("Switzerland");
        Scountry.add("Syria");
        Scountry.add("Taiwan");
        Scountry.add("Tajikistan");
        Scountry.add("Tanzania");
        Scountry.add("Thailand");
        Scountry.add("Thuraya (Mobile Satellite service)");
        Scountry.add("Timor Leste");
        Scountry.add("Togolese Republic");
        Scountry.add("Tokelau");
        Scountry.add("Tonga Islands");
        Scountry.add("Trinidad & Tobago");
        Scountry.add("Tunisia");
        Scountry.add("Turkey");
        Scountry.add("Turkmenistan");
        Scountry.add("Turks and Caicos Islands");
        Scountry.add("Tuvalu");
        Scountry.add("Uganda");
        Scountry.add("Ukraine");
        Scountry.add("United Arab Emirates");
        Scountry.add("United Kingdom");
        Scountry.add("United States of America");
        Scountry.add("US Virgin Islands");
        Scountry.add("Universal Personal Telecommunications (UPT)");
        Scountry.add("Uruguay");
        Scountry.add("Uzbekistan");
        Scountry.add("Vanuatu");
        Scountry.add("Vatican City");
        Scountry.add("Venezuela");
        Scountry.add("Vietnam");
        Scountry.add("Wake Island");
        Scountry.add("Wallis and Futuna Islands");
        Scountry.add("Yemen");
        Scountry.add("Zambia");
        Scountry.add("Zanzibar");
        Scountry.add("Zimbabwe");
        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Scountry);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(dataAdapter);


       List<String> Scountry_code=new ArrayList<String>();
        Scountry_code.add("ISO Code");
        Scountry_code.add("AF +93");
        Scountry_code.add("AL +355");
        Scountry_code.add("DZ +213");
        Scountry_code.add("AS +684");
        Scountry_code.add("AD +376");
        Scountry_code.add("AO +244");
        Scountry_code.add("AI +264");
        Scountry_code.add("AQ +672");
        Scountry_code.add("AG +268");
        Scountry_code.add("AR +54");
        Scountry_code.add("AM +374");
        Scountry_code.add("AW +297");
        Scountry_code.add("AU +61");
        Scountry_code.add("AT +43");
        Scountry_code.add("AZ +994");
        Scountry_code.add("BS +242");
        Scountry_code.add("BH +973");
        Scountry_code.add("BD +880");
        Scountry_code.add("BB +246");
        Scountry_code.add("BY +375");
        Scountry_code.add("BE +32");
        Scountry_code.add("BZ +501");
        Scountry_code.add("BJ +229");
        Scountry_code.add("BM +441");
        Scountry_code.add("BT +975");
        Scountry_code.add("BO +591");
        Scountry_code.add("BA +387");
        Scountry_code.add("BW +267");
        Scountry_code.add("BR +55");
        Scountry_code.add("IO +246");
        Scountry_code.add("VG +284");
        Scountry_code.add("BN +673");
        Scountry_code.add("BG +359");
        Scountry_code.add("BF +226");
        Scountry_code.add("BI +257");
        Scountry_code.add("KH +855");
        Scountry_code.add("CM +237");
        Scountry_code.add("CA +1");
        Scountry_code.add("CV +238");
        Scountry_code.add("KY +345");
        Scountry_code.add("CF +236");
        Scountry_code.add("TD +235");
        Scountry_code.add("CL +56");
        Scountry_code.add("CN +86");
        Scountry_code.add("CX +61");
        Scountry_code.add("CC +61");
        Scountry_code.add("CO +57");
        Scountry_code.add("KM +269");
        Scountry_code.add("CK +682");
        Scountry_code.add("CR +506");
        Scountry_code.add("HR +385");
        Scountry_code.add("CU +53");
        Scountry_code.add("CW +599");
        Scountry_code.add("CY +357");
        Scountry_code.add("CZ +420");
        Scountry_code.add("CD +243");
        Scountry_code.add("DK +45");
        Scountry_code.add("DJ +253");
        Scountry_code.add("DM +767");
        Scountry_code.add("DO +1-809");
        Scountry_code.add("TL +670");
        Scountry_code.add("EC +593");
        Scountry_code.add("EG +20");
        Scountry_code.add("SV +503");
        Scountry_code.add("GQ +240");
        Scountry_code.add("ER +291");
        Scountry_code.add("EE +372");
        Scountry_code.add("ET +251");
        Scountry_code.add("FK +500");
        Scountry_code.add("FO +298");
        Scountry_code.add("FJ +679");
        Scountry_code.add("FI +358");
        Scountry_code.add("FR +33");
        Scountry_code.add("PF +689");
        Scountry_code.add("GA +241");
        Scountry_code.add("GM +220");
        Scountry_code.add("GE +995");
        Scountry_code.add("DE +49");
        Scountry_code.add("GH +233");
        Scountry_code.add("GI +350");
        Scountry_code.add("GR +30");
        Scountry_code.add("GL +299");
        Scountry_code.add("GD +1-473");
        Scountry_code.add("GU +1-671");
        Scountry_code.add("GT +502");
        Scountry_code.add("GG +44-1481");
        Scountry_code.add("GN +224");
        Scountry_code.add("GW +245");
        Scountry_code.add("GY +592");
        Scountry_code.add("HT +509");
        Scountry_code.add("HN +504");
        Scountry_code.add("HK +852");
        Scountry_code.add("HU +36");
        Scountry_code.add("IS +354");
        Scountry_code.add("IN +91");
        Scountry_code.add("ID +62");
        Scountry_code.add("IR +98");
        Scountry_code.add("IQ +964");
        Scountry_code.add("IE +353");
        Scountry_code.add("IM +44-1624");
        Scountry_code.add("IL +972");
        Scountry_code.add("IT +39");
        Scountry_code.add("CI +225");
        Scountry_code.add("JM +1-876");
        Scountry_code.add("JP +81");
        Scountry_code.add("JE +44-1534");
        Scountry_code.add("JO +962");
        Scountry_code.add("KZ +7");
        Scountry_code.add("KE +254");
        Scountry_code.add("KI +686");
        Scountry_code.add("XK +383");
        Scountry_code.add("KW +965");
        Scountry_code.add("KG +996");
        Scountry_code.add("LA +856");
        Scountry_code.add("LV +371");
        Scountry_code.add("LB +961");
        Scountry_code.add("LS +266");
        Scountry_code.add("LR +231");
        Scountry_code.add("LY +218");
        Scountry_code.add("LI +423");
        Scountry_code.add("LT +370");
        Scountry_code.add("LU +352");
        Scountry_code.add("MO +853");
        Scountry_code.add("MK +389");
        Scountry_code.add("MG +261");
        Scountry_code.add("MW +265");
        Scountry_code.add("MY +60");
        Scountry_code.add("MV +960");
        Scountry_code.add("ML +223");
        Scountry_code.add("MT +356");
        Scountry_code.add("MH +692");
        Scountry_code.add("MR +222");
        Scountry_code.add("MU +230");
        Scountry_code.add("YT +262");
        Scountry_code.add("MX +52");
        Scountry_code.add("FM +691");
        Scountry_code.add("MD +373");
        Scountry_code.add("MC +377");
        Scountry_code.add("MN +976");
        Scountry_code.add("ME +382");
        Scountry_code.add("MS +1-664");
        Scountry_code.add("MA +212");
        Scountry_code.add("MZ +258");
        Scountry_code.add("MM +95");
        Scountry_code.add("NA +264");
        Scountry_code.add("NR +674");
        Scountry_code.add("NP +977");
        Scountry_code.add("NL +31");
        Scountry_code.add("AN +599");
        Scountry_code.add("NC +687");
        Scountry_code.add("NZ +64");
        Scountry_code.add("NI +505");
        Scountry_code.add("NE +227");
        Scountry_code.add("NG +234");
        Scountry_code.add("NU +683");
        Scountry_code.add("KP +850");
        Scountry_code.add("MP +1-670");
        Scountry_code.add("NO +47");
        Scountry_code.add("OM +968");
        Scountry_code.add("PK +92");
        Scountry_code.add("PW +680");
        Scountry_code.add("PS +970");
        Scountry_code.add("PA +507");
        Scountry_code.add("PG +675");
        Scountry_code.add("PY +595");
        Scountry_code.add("PE +51");
        Scountry_code.add("PH +63");
        Scountry_code.add("PN +64");
        Scountry_code.add("PL +48");
        Scountry_code.add("PT +351");
        Scountry_code.add("PR +1-787, +1-939");
        Scountry_code.add("QA +974");
        Scountry_code.add("CG +242");
        Scountry_code.add("RE +262");
        Scountry_code.add("RO +40");
        Scountry_code.add("RU +7");
        Scountry_code.add("RW +250");
        Scountry_code.add("BL +590");
        Scountry_code.add("SH +290");
        Scountry_code.add("KN +1-869");
        Scountry_code.add("LC +1-758");
        Scountry_code.add("MF +590");
        Scountry_code.add("PM +508");
        Scountry_code.add("VC +1-784");
        Scountry_code.add("WS +685");
        Scountry_code.add("SM +378");
        Scountry_code.add("ST +239");
        Scountry_code.add("SN +221");
        Scountry_code.add("RS +381");
        Scountry_code.add("SC +248");
        Scountry_code.add("SL +232");
        Scountry_code.add("SG +65");
        Scountry_code.add("SX +1-721");
        Scountry_code.add("SK +421");
        Scountry_code.add("SI +386");
        Scountry_code.add("SB +677");
        Scountry_code.add("SO +252");
        Scountry_code.add("ZA +27");
        Scountry_code.add("KR +82");
        Scountry_code.add("SS +211");
        Scountry_code.add("ES +34");
        Scountry_code.add("LK +94");
        Scountry_code.add("SD +249");
        Scountry_code.add("SR +597");
        Scountry_code.add("SJ +47");
        Scountry_code.add("SZ +268");
        Scountry_code.add("SE +46");
        Scountry_code.add("CH +41");
        Scountry_code.add("SY +963");
        Scountry_code.add("TW +886");
        Scountry_code.add("TJ +992");
        Scountry_code.add("TZ +255");
        Scountry_code.add("TH +66");
        Scountry_code.add("TG +228");
        Scountry_code.add("TK +690");
        Scountry_code.add("TO +676");
        Scountry_code.add("TT +1-868");
        Scountry_code.add("TN +216");
        Scountry_code.add("TR +90");
        Scountry_code.add("TM +993");
        Scountry_code.add("TC +1-649");
        Scountry_code.add("TV +688");
        Scountry_code.add("VI +1-340");
        Scountry_code.add("UG +256");
        Scountry_code.add("UA +380");
        Scountry_code.add("AE +971");
        Scountry_code.add("GB +44");
        Scountry_code.add("US +1");
        Scountry_code.add("UY +598");
        Scountry_code.add("UZ +998");
        Scountry_code.add("VU +678");
        Scountry_code.add("VA +379");
        Scountry_code.add("VE +58");
        Scountry_code.add("VN +84");
        Scountry_code.add("WF +681");
        Scountry_code.add("EH +212");
        Scountry_code.add("YE +967");
        Scountry_code.add("ZM +260");
        Scountry_code.add("ZW +263");
        ArrayAdapter<String> dataAdapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Scountry_code);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country_code.setAdapter(dataAdapter2);


        List<String> Scourse=new ArrayList<String>();
        Scourse.add("Course");
        Scourse.add("B.Tech");
        Scourse.add("B.Arch");
        Scourse.add("B.com");
        Scourse.add("B.Des");
        Scourse.add("B.Sc");
        Scourse.add("B.Voc");
        Scourse.add("BBA");
        Scourse.add("BCA");
        ArrayAdapter<String> dataAdapter3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Scourse);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course.setAdapter(dataAdapter3);

        List<String> special = new ArrayList<String>();
        special.add("Specialization");
        special.add("B.Tech(Civil)");
        special.add("B.Tech(Computer Engineering)");
        special.add("B.Tech(Electrical Engineering)");
        special.add("B.Tech(Electronics and Communication Engineering)");
        special.add("B.Tech(Mechanical)");
        special.add("B.Tech.CE(Artificial Intelligence)");
        special.add("B.Tech.CE(Blockchain)");
        special.add("B.Tech.CE(Cloud Technology and Information Security)");
        special.add("B.Tech.CE(Data Science)");
        special.add("B.Arch");
        special.add("B.Com.(Honors)");
        special.add("B.Com.(Pass Course)");
        special.add("B.Des.(Interior Design)");
        special.add("B.Des.(Fashion and Textile Design)");
        special.add("B.Sc.(Physics Chemistery and Math");
        special.add("B.Sc.(Animation and VFX)");
        special.add("B.Voc.(Interior Design)");
        special.add("B.Voc.(Apparel Design)");
        special.add("BBA(Finance Management)");
        special.add("BBA(General)");
        special.add("BBA(Retail Management)");
        special.add("BCA(AI and Process Automation)");
        special.add("BCA(Cloud Technology and Mobile Applications)");
        special.add("BBA(Data Science)");
        special.add("BBA(General)");
        special.add("BCA(ITIMS and Cloud Technology)");
        special.add("BCA(Mobile Applications and Information Security)");
        special.add("BCA(UI/UX)");
        special.add("NA");
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, special);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speciallization.setAdapter(dataAdapter4);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                byte[] NewEntryImg=imageViewTobyte(myImg);
                String r=regno.getText().toString();
                String n=name.getText().toString();
                String fn=fname.getText().toString();
                String mn=mname.getText().toString();
                String b=birthday.getText().toString();
                String co=String.valueOf(country.getSelectedItem());
                String co_code=String.valueOf(country_code.getSelectedItem());
                String p=phoneno.getText().toString();
                String e=email.getText().toString();
                String s=state.getText().toString();
                String c=city.getText().toString();
                String a=address.getText().toString();
                String cour=String.valueOf(course.getSelectedItem());
                String sp=String.valueOf(speciallization.getSelectedItem());


                if (r.isEmpty()) {
                    regno.setError("Field can't be empty");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();

                }
               else if (n.isEmpty()) {
                    name.setError("Field can't be empty");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();

                }
                else if (fn.isEmpty()) {
                    fname.setError("Field can't be empty");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();

                }
                else if (mn.isEmpty()) {
                    mname.setError("Field can't be empty");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();

                }
                else if (b.isEmpty()) {
                    birthday.setError("Field can't be empty");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();

                }
                else if (co.equals("Country")) {
                    Country_error.setText("Select a Country*");
                    Iso_code_error.setText("");
                    Course_error.setText("");
                    Specialization_error.setText("");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();

                }
                else if (co_code.equals("ISO Code")) {
                    Iso_code_error.setText("Select an Iso Code*");
                    Country_error.setText("");
                    Course_error.setText("");
                    Specialization_error.setText("");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();

                }
                else if (p.isEmpty()) {
                    phoneno.setError("Field can't be empty");
                }
                else if (p.length()<4 || p.length()> 12) {
                    phoneno.setError("Please Enter Valid Phone Number");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();

                }
                else if (e.isEmpty()) {
                    email.setError("Field can't be empty");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();

                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
                    email.setError("Please enter a valid email address");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();
                }
                else if (s.isEmpty()) {
                    state.setError("Field can't be empty");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();
                }
                else if (c.isEmpty()) {
                    city.setError("Field can't be empty");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();
                }
                else if (a.isEmpty()) {
                    address.setError("Field can't be empty");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();
                }
                else if (cour.equals("Course")) {
                    Course_error.setText("Select your Course*");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();
                    Country_error.setText("");
                    Iso_code_error.setText("");
                    Specialization_error.setText("");
                }
                else if (sp.equals("Specialization")) {
                    Specialization_error.setText("Select your Specialization*");
                    Country_error.setText("");
                    Iso_code_error.setText("");
                    Course_error.setText("");
                    Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();

                }



                else if( regno.length() !=0 && name.length() !=0 && fname.length() !=0 && mname.length() !=0 && birthday.length() !=0 && co != "Country" && co_code !="ISO Code" && phoneno.length() !=0 && p.length()>=4 || p.length()<=12 && email.length() !=0 && Patterns.EMAIL_ADDRESS.matcher(e).matches() && state.length() !=0 && city.length() !=0 && address.length() !=0 && cour !="Course" && sp !="Specialization")
                {

                    ConnectDatabase dba = new ConnectDatabase(Add.this);
                    long l = dba.insert(NewEntryImg,r, n, fn, mn, b,co,co_code,p,e,s,c,a,cour,sp);

                        if (l == -1) {
                            Toast.makeText(Add.this, "Something is Wrong!!", Toast.LENGTH_LONG).show();
                            regno.setError("This registration number is already exist!! pleasr try another");

                        }
                        else
                            {
                            Toast.makeText(Add.this, "Student is Added Successfully!!", Toast.LENGTH_LONG).show();
                                Intent i=new Intent(Add.this,MainActivity.class);
                                startActivity(i);
                                finish();
                        }


                    }



                }





            private byte[] imageViewTobyte(ImageView image) {
                Bitmap bitmapp = ((BitmapDrawable) image.getDrawable()).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmapp.compress(Bitmap.CompressFormat.PNG, 60, stream);
                byte[] byteArray = stream.toByteArray();
                return byteArray;

            }
        });


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_GALLERY)
        {
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"you donn't have the permissions to access files",Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Uri uri=data.getData();
        try
        {
            InputStream inputStrem = getContentResolver().openInputStream(uri);
            Bitmap bitmap= BitmapFactory.decodeStream(inputStrem);
            myImg.setImageBitmap(bitmap);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        super.onActivityResult(requestCode,resultCode,data);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        birthday.setText(currentDateString);

    }
}
