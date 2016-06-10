package kmk.gotraffic;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.Geofence;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teste on 08/06/2016.
 */
public class GeofenceController {

    private final String TAG = GeofenceController.class.getName();

    private Context context;
    private GoogleApiClient googleApiClient;
    private Gson gson;
    private SharedPreferences prefs;

    private List<NamedGeofences> namedGeofences;
    public List<NamedGeofences> getNamedGeofences() {
        return namedGeofences;
    }

    private List<NamedGeofences> namedGeofencesToRemove;

    private Geofence geofenceToAdd;
    private NamedGeofences namedGeofenceToAdd;

    private static GeofenceController INSTANCE;

    public static GeofenceController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GeofenceController();
        }
        return INSTANCE;
    }

//    public void init(Context context) {
//        this.context = context.getApplicationContext();
//
//        gson = new Gson();
//        namedGeofences = new ArrayList<>();
//        namedGeofencesToRemove = new ArrayList<>();
//        prefs = this.context.getSharedPreferences(
////                SyncStateContract.Constants.SharedPrefs.Geofences, Context.MODE_PRIVATE);
//    }
}
