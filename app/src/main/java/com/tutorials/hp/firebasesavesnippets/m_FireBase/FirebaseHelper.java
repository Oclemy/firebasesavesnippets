package com.tutorials.hp.firebasesavesnippets.m_FireBase;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.tutorials.hp.firebasesavesnippets.m_Model.Spacecraft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oclemy on 6/21/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * SAVE DATA
 */
public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved=null;

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    public Boolean save(String name)
    {
        if(name != null && name.length()>0)
        {
            try
            {
                db.child("Spacecraft").push().setValue(name);
                saved=true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }

        return saved;
    }

    //SAVE OBJE
    public Boolean saveObject(Spacecraft spacecraft)
    {
        if(spacecraft != null)
        {
            try
            {
                db.child("Object").push().setValue(spacecraft);
                saved=true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }

        return saved;
    }

    //SAVE OBJE
    public Boolean saveList(ArrayList<String> lists)
    {
        if(lists != null && lists.size()>0)
        {
            try
            {
                db.child("Lists").push().setValue(lists);
                saved=true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }

        return saved;
    }
}


















