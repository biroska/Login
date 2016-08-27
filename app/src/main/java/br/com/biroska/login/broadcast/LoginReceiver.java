package br.com.biroska.login.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Notebook on 27/08/2016.
 */
public class LoginReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText( context, "Logado", Toast.LENGTH_LONG).show();

    }
}
