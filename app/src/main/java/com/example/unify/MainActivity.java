package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.unify.databinding.ActivityMainBinding;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Button switchToSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // setSupportActionBar(binding.toolbar);

        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        //appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //// fab = floating_action_button #AndroidStudioIntelo
        //binding.fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        //    }
        //});

        switchToSecondActivity = findViewById(R.id.my_button_test);
        switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();

    }



    private void switchActivities()  {

        String accessToken = getIntent().getStringExtra("accessToken");
        /*OkHttpClient client = new OkHttpClient();

        String url = "https://api.spotify.com/v1/me"; // URL de l'API Spotify pour obtenir les informations de l'utilisateur

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + accessToken) // Remplacer accessToken par votre jeton d'accès
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    // Traitez votre réponse ici. Par exemple, vous pouvez convertir la réponse en un objet JSON :
                    String responseData = response.body().string();
                    try {
                        JSONObject json = new JSONObject(responseData);
                        String displayName = json.getString("display_name"); // Par exemple, obtenir le nom d'affichage de l'utilisateur
                        Log.d("SpotifyAPI", "Display name: " + displayName);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });*/

        Intent switchActivityIntent = new Intent(this, SpotifyPlayer.class);
        switchActivityIntent.putExtra("accessToken", accessToken);
        startActivity(switchActivityIntent);
        /*Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:")); // Seuls les clients de messagerie devraient traiter ceci
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"chneater.synesh@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Sujet");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Corps du message");

        try {
            startActivity(Intent.createChooser(emailIntent, "Envoyer un email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "Il n'y a pas d'application de messagerie installée.", Toast.LENGTH_SHORT).show();
        }*/
        /*Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"logan.synesh@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Sujet du message");
        intent.putExtra(Intent.EXTRA_TEXT, "Contenu du message");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*/

        /*Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("my-app://callback"));
        startActivity(intent);*/

        /*try {
            MimeMessage email = createEmail("chneater.synesh@gmail.com", "unifydevs@gmail.com", "Subject", "Body text");
        } catch (MessagingException e) {
            e.printStackTrace();
        }*/
        //sendMessage(service, "me", email);
        /*MailService mailer = new MailService("from@mydomain.example","to@domain.example","Subject","TextBody", "<b>HtmlBody</b>", (Attachment) null);
        try {
            mailer.sendAuthenticated();
        } catch (Exception e) {
            Log.e("lol", "Failed sending email.", e);
        }*/
    }

    public static MimeMessage createEmail(String to, String from, String subject, String bodyText)
            throws MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);
        email.setText(bodyText);
        return email;
    }

    public static void sendMessage(Gmail service, String userId, MimeMessage emailContent)
            throws MessagingException, IOException {
        Message message = createMessageWithEmail(emailContent);
        message = service.users().messages().send(userId, message).execute();

        System.out.println("Message id: " + message.getId());
        System.out.println(message.toPrettyString());
    }

    public static Message createMessageWithEmail(MimeMessage emailContent) throws MessagingException, IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        emailContent.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.getEncoder().encodeToString(bytes);
        Message message = new Message();
        message.setRaw(encodedEmail);
        return message;
    }

    /*EditText editTextTo,editTextSubject,editTextMessage;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTo=(EditText)findViewById(R.id.editText1);
        editTextSubject=(EditText)findViewById(R.id.editText2);
        editTextMessage=(EditText)findViewById(R.id.editText3);

        send=(Button)findViewById(R.id.button1);

        send.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String to=editTextTo.getText().toString();
                String subject=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/

}