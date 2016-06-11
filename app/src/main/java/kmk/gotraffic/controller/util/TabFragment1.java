package kmk.gotraffic.controller.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kmk.gotraffic.controller.PrincipalActivity;
import kmk.gotraffic.controller.R;

public class TabFragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_principal, container, false);

        Intent intent = new Intent(getActivity(), PrincipalActivity.class);
        startActivity(intent);

        return v;
    }
}