package samplesharedpreferences.com.sendsms;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity {

    EditText mobile;
    EditText msg;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        mobile=findViewById( R.id.mobile );
        msg=findViewById(R.id.msg);
        button=findViewById(R.id.btnSendSMS);

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent( getApplicationContext(), MainActivity.class );
                    PendingIntent pi = PendingIntent.getActivity( getApplicationContext(), 0, intent, 0 );

//Get the SmsManager instance and call the sendTextMessage method to send message
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage( "9770828387", null, "hello javatpoint", pi, null );
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        } );
    }
    /*private static final int PERMISSION_REQUEST_CODE = 1;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

        if (checkSelfPermission( Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_DENIED) {

            Log.d("permission", "permission denied to SEND_SMS - requesting it");
            String[] permissions = {Manifest.permission.SEND_SMS};

            requestPermissions(permissions, PERMISSION_REQUEST_CODE);

        }
    }

*/

}
