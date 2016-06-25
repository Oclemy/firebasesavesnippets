package com.tutorials.hp.firebasesavesnippets;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tutorials.hp.firebasesavesnippets.m_FireBase.FirebaseHelper;
import com.tutorials.hp.firebasesavesnippets.m_Model.Spacecraft;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //SETUP FIREBASE
        db=FirebaseDatabase.getInstance().getReference();
        helper=new FirebaseHelper(db);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();
            }
        });
    }

    private void displayInputDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("Save To Firebase");
        d.setContentView(R.layout.input_dialog);

        final EditText nameEditTxt= (EditText) d.findViewById(R.id.nameEditText);
        Button saveBtn= (Button) d.findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get data
                String name=nameEditTxt.getText().toString();

                //1 SAVE PRIMITIVE
//                //save
//                if(helper.save(name))
//                {
//                    nameEditTxt.setText("");
//                }





                //2. SAVE OBJECT
                //SET DATA
                Spacecraft s=new Spacecraft();
                s.setName(name);
                if(helper.saveObject(s))
                {
                    nameEditTxt.setText("");
                }

                ///3
                // SAVE LISTS
//                ArrayList<String> data=new ArrayList<String>();
//                for (int i=0;i<10;i++)
//                {
//                    data.add("Name "+String.valueOf(i));
//                }
//
//                if(helper.saveList(data))
//                {
//                    Toast.makeText(MainActivity.this, "Successfully Saved", Toast.LENGTH_SHORT).show();
//                }


            }
        });

        d.show();
    }
}
