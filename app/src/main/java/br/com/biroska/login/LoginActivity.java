package br.com.biroska.login;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import br.com.biroska.login.model.User;

public class LoginActivity extends AppCompatActivity {

    private EditText editText;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void logar( View view ){

        user = new User();

        editText = ( EditText ) findViewById( R.id.loginEmail );
        user.setEmail( editText.getText().toString() );

        editText = ( EditText ) findViewById( R.id.loginPassword );
        user.setPassword( editText.getText().toString() );

        validate( user );
    }

    private boolean validate( User user ){

        boolean isValid = true;
        String validationMessages = "";

        if ( user == null ){
            return false;
        }

        if ( TextUtils.isEmpty( user.getEmail() ) ){
            isValid = false;
            validationMessages = getResources().getString( R.string.validation_message_mandatory_email );
        }

        if ( TextUtils.isEmpty( user.getPassword() ) ){
            isValid = false;
            validationMessages += ";" + getResources().getString( R.string.validation_message_mandatory_password );
        }

        if ( isValid ){
            if ( !user.getEmail().equals("biroska@gmail.com") ||
                 !user.getPassword().equals("123456") ){
                isValid = false;
                validationMessages = getResources().getString( R.string.validation_message_wrong_password );
            }
        }

        if ( !isValid ){
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder( this );
            alertBuilder.setTitle( getResources().getString( R.string.label_validation_messages ) );
            buildValidationMessagesInAlert( alertBuilder, validationMessages  );
            alertBuilder.setCancelable( true );
            alertBuilder.show();
        }

        return isValid;
    }

    private void buildValidationMessagesInAlert( AlertDialog.Builder builder, String messages  ){

        if ( TextUtils.isEmpty( messages ) || builder == null ){
            return;
        }

        if ( messages.contains(";") ){
            builder.setMessage( messages.replace(";","\n") );
        } else {
            builder.setMessage( messages );
        }
    }
}
