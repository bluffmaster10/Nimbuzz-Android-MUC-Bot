package example.com.db.nimbuzz_banbot_android_by_db;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Created by DB on 23-02-2016.
 */

public class dbDialog extends Dialog implements View.OnClickListener  {
    public dbDialog(Context context) {
        super(context);
    }

    public dbDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected dbDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.dbinfo_layout);
        getWindow().setFlags(4, 4);
        setTitle("About");

        Button ok = (Button) findViewById(R.id.ok);
        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.dismiss();

    }
}
