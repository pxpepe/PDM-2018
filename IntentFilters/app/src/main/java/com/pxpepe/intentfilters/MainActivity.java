package com.pxpepe.intentfilters;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int RESULTADO_PICK_CONTACTO = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnTelefonarClick(View vistaBtn) {

        EditText txtTelefone = findViewById(R.id.txtTelefonar);

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", txtTelefone.getText().toString(), null));
        startActivity(intent);
    }


    public void btnAbrirUrlClick(View vistaBtn) {

        EditText txtURL = findViewById(R.id.txtUrl);

        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://"+txtURL.getText().toString()));
        startActivity(i);

    }

    public void btnAbrirGeoClick(View vistaBtn) {

        EditText txtGeo = findViewById(R.id.txtGeo);

        Uri gmmIntentUri = Uri.parse("geo:"+txtGeo.getText().toString());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void btnObterContacto(View vistaBtn) {

        Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(contactPickerIntent, RESULTADO_PICK_CONTACTO);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // check whether the result is ok
        if (resultCode == RESULT_OK) {
            // Check for the request code, we might be usign multiple startActivityForReslut
            switch (requestCode) {
                case RESULTADO_PICK_CONTACTO:
                    contactPicked(data);
                    break;
            }
        } else {
            Log.e("MainActivity", "Falho ao recuperar o contacto");
        }
    }

    private void contactPicked(Intent data) {
        Cursor cursor = null;
        try {
            String phoneNo = null ;
            String name = null;
            // getData() method will have the Content Uri of the selected contact
            Uri uri = data.getData();
            //Query the content uri
            cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            // column index of the phone number
            int  phoneIndex =cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            // column index of the contact name
            int  nameIndex =cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            phoneNo = cursor.getString(phoneIndex);
            name = cursor.getString(nameIndex);
            // Set the value to the textviews

            TextView txtNome = findViewById(R.id.txtNome);
            txtNome.setText(name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
