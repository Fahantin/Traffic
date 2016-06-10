package kmk.gotraffic;

import com.google.android.gms.location.Geofence;

import java.util.UUID;

/**
 * Created by Teste on 08/06/2016.
 */
public class NamedGeofences {

    public Geofence geofence() {
        String id = UUID.randomUUID().toString();
        double latitude = 0;
        double longitude = 0;
        float radius = 0;
        return new Geofence.Builder()
                .setRequestId(id)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER)
                .setCircularRegion(latitude, longitude, radius)
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .build();
    }

}
