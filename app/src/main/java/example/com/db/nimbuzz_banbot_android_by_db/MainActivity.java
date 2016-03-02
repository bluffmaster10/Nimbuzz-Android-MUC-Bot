package example.com.db.nimbuzz_banbot_android_by_db;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Handler handler = new Handler();
    private dbDialog InfoDialog;
    private Boolean exit = false;
    private static final String TAG = "MainActivity";
    public dbXMPPConn mService;
    private View view;
    private boolean mBounded;
    private final IBinder mBinder = new ServiceBinder(this.mService);


    public class ServiceBinder<T> extends Binder {

        private final WeakReference<T> mService;

        public ServiceBinder(final T service) {
            mService = new WeakReference<T>(service);
        }

        public T getService() {
            return mService.get();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button SingInBtn = (Button) findViewById(R.id.btnSignin);
        SingInBtn.setOnClickListener(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Dialog for Displaying Info
        InfoDialog = new dbDialog(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        InfoDialog.show();
                    }
                });
            }
        });
    }



    //Click Handler for Login Button
    @Override
    public void onClick(View v) {

        try {
            EditText userId = (EditText) findViewById(R.id.txtUser);
            EditText userPwd = (EditText) findViewById(R.id.txtPwd);
            String userName = userId.getText().toString();
            String passWord = userPwd.getText().toString();
            Intent intent = new Intent(getBaseContext(),dbXMPPConn.class);
            intent.putExtra("user",userName);
            intent.putExtra("pwd",passWord);
            startService(intent);

            Toast.makeText(getApplicationContext(), "Please wait...", Toast.LENGTH_SHORT).show();
            //mService.connectConnection(intent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed()
    {
        //   super.onBackPressed();
        if(exit){
            finish();
        }
        else{
            Toast.makeText(this, "Press Back Again To Exit" , Toast.LENGTH_SHORT).show();
            exit = true;

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent dbdito = new Intent(Intent.ACTION_MAIN);
                    dbdito.addCategory(Intent.CATEGORY_HOME);
                    dbdito.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(dbdito);
                }
            }, 1000);
        }
    }


}
