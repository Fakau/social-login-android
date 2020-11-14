package com.engine.fakau.facebookgoogleauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class UserProfile extends AppCompatActivity {
    private ImageView profilePhoto;
    private TextView name, email, id;
    private Button signOut;
    private GoogleSignInAccount acct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        init();
        event();
    }

    private void init() {
        profilePhoto = findViewById(R.id.photo_profile_id);
        name = findViewById(R.id.name);
        email= findViewById(R.id.email);
        id  = findViewById(R.id.id);
        signOut = findViewById(R.id.logout);
        acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            name.setText(personName);
            email.setText(personEmail);
            id.setText(personId);
            Glide.with(this).load(personPhoto).into(profilePhoto);
        }else
           startActivity( new Intent(this, MainActivity.class));

    }

    private void event() {
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}