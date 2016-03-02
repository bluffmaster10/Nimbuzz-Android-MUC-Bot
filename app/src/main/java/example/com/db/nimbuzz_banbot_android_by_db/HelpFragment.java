package example.com.db.nimbuzz_banbot_android_by_db;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class HelpFragment extends ListFragment {


    String[] helpitems = new String[] {
            "All Available Command List:",
            "",
            "kick user:  .k id",
            "member user:  .m id",
            "ban user:  .b id",
            "ip-ban user:  .bip id",
            "visitor user:  .v id",
            "grant moderator:  .mod id",
            "grant admin:  .a id",
            "grant owner:  .o id",
            "add commander:  .addc id",
            "remove commander:  .remc id",
            "Coded By DB~@NC"
    };

    public HelpFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_help_list, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, helpitems);
        setListAdapter(adapter);

        //
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
