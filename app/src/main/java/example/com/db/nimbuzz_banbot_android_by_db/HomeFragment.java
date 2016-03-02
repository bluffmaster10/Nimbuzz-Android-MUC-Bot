package example.com.db.nimbuzz_banbot_android_by_db;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class HomeFragment extends Fragment {
    private TextView botjid;
    private Button LogoutBtn;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        botjid = (TextView) view.findViewById(R.id.textView6);
        botjid.setText(XMPPLogic.connection.getUser());

        LogoutBtn = (Button) view.findViewById(R.id.logoutbtn);
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                XMPPLogic.connection.disconnect();
                if (!XMPPLogic.connection.isConnected()) {
                    //finish();
                    //  Return Back To MainActivity
                    Intent dbint2 = new Intent(getActivity(), MainActivity.class);
                    dbint2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(dbint2);
                }
            }
        });

        return view;
    }
    
}
