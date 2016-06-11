package kmk.gotraffic.controller.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kmk.gotraffic.controller.ContaActivity;
import kmk.gotraffic.controller.PrincipalActivity;
import kmk.gotraffic.controller.R;

public class TabFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tabfragment2, container, false);

        Intent intent = new Intent(getActivity(), ContaActivity.class);
        startActivity(intent);

        return v;
    }
}