package br.com.biroska.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.biroska.login.model.User;

public class PrincipalActivity extends AppCompatActivity {

    private User user;
    private TextView txtView;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Object param = getIntent().getSerializableExtra("user");

        if ( param instanceof User ){
            user = (User) param;

            message = String.format(  getResources().getString( R.string.message_welcome ), user.getEmail() );

            txtView = ( TextView ) findViewById( R.id.welcome );
            txtView.setText( message );
        }

    }
}
