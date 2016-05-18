package kmk.gotraffic.controller.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;

import kmk.gotraffic.controller.R;

/**
 * Created by Thiago Fantin on 13/03/2016.
 */
public class AlertaUtil {
//
//    public static void showMsgToast(Activity activity, String txt) {
//        LayoutInflater inflater = activity.getLayoutInflater();
////        View lytToast = inflater.inflate(R.layout.toast_template, (ViewGroup) activity.findViewById(R.id.lytToast));
////
////        TextView txtToast = (TextView) lytToast.findViewById(R.id.txtToast);
//        txtToast.setText(txt);
//
//        Toast toast = new Toast(activity);
//        toast.setView(lytToast);
//        toast.show();
//    }


    public static void showAlert(Activity act, String txtMessage, TipoAlertaUtil tipoAlertaUtil) {

        AlertDialog alertDialog = null;
        int theme = 0, icone = 0;
        String msg = null;
        String titulo = null;

        switch (tipoAlertaUtil) {
            case HOLE:
                theme = R.style.AppTheme_Dark_Dialog_Hole;
                titulo = "Buraco";
                msg = "Você tem 35% de chances de cair em um buraco aqui!";
                icone = R.drawable.hole;
                break;
            case CRASH:
                theme = R.style.AppTheme_Dark_Dialog_Crash;
                titulo = "Acidente";
                msg = "Você tem 80% de chances de sofrer um acidente aqui!";
                icone = R.drawable.crash;
                break;
            case TRAFFIC:
                theme = R.style.AppTheme_Dark_Dialog_Traffic;
                titulo = "Congestionamento";
                msg = "Há 75% de chances de ocorrer um congestionamento aqui!";
                icone = R.drawable.traffic;
                break;
        }
        alertDialog = new AlertDialog.Builder(act, theme).create();
        alertDialog.setTitle(titulo);
        alertDialog.setMessage(msg);
        alertDialog.setIcon(icone);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //VAZIO
            }
        });

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(alertDialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;

        alertDialog.show();
        alertDialog.getWindow().setAttributes(params);
    }
}
