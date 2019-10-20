package com.example.activityrecognition;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
//import android.widget.ImageView;

//import androidx.core.app.NotificationCompat;
//import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.List;

public class ActivityRecognizedService extends IntentService {

    public ActivityRecognizedService() {
        super("ActivityRecognizedService");
    }

    public ActivityRecognizedService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(ActivityRecognitionResult.hasResult(intent)) {
            ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
            handleDetectedActivities( result.getProbableActivities() );
        }
    }

    private void handleDetectedActivities(List<DetectedActivity> probableActivities) {
        for( DetectedActivity activity : probableActivities ) {
            if( (activity.getType() == DetectedActivity.IN_VEHICLE) && activity.getConfidence() >= 75 ) {
                Log.d( "ActivityRecogition", "In Vehicle: " + activity.getConfidence());
            }
            if( (activity.getType() == DetectedActivity.ON_BICYCLE) && activity.getConfidence() >= 75 ) {
                Log.d( "ActivityRecogition", "On Bicycle: " + activity.getConfidence());
            }
            if( (activity.getType() == DetectedActivity.STILL) && activity.getConfidence() >= 75 ) {
//                screen = findViewById(R.id.Imageview);
//                screen.setImageResource(R.drawable.still);
                Log.d( "ActivityRecogition", "Still: " + activity.getConfidence());
            }
            if( (activity.getType() == DetectedActivity.WALKING) && activity.getConfidence() >= 75 ) {
                Log.d( "ActivityRecogition", "Walking: " + activity.getConfidence());
            }


//            switch( activity.getType() ) {
//                case DetectedActivity.IN_VEHICLE: {
//                    Log.d( "ActivityRecogition", "In Vehicle: " + activity.getConfidence() );
//                    break;
//                }
//                case DetectedActivity.ON_BICYCLE: {
//                    Log.d( "ActivityRecogition", "On Bicycle: " + activity.getConfidence() );
//                    break;
//                }
//                case DetectedActivity.ON_FOOT: {
//                    Log.d( "ActivityRecogition", "On Foot: " + activity.getConfidence() );
//                    break;
//                }
//                case DetectedActivity.RUNNING: {
//                    Log.d( "ActivityRecogition", "Running: " + activity.getConfidence() );
//                    break;
//                }
//                case DetectedActivity.STILL: {
//                    Log.d( "ActivityRecogition", "Still: " + activity.getConfidence() );
//                    break;
//                }
//                case DetectedActivity.TILTING: {
//                    Log.d( "ActivityRecogition", "Tilting: " + activity.getConfidence() );
//                    break;
//                }
//                case DetectedActivity.WALKING: {
//                    Log.d( "ActivityRecogition", "Walking: " + activity.getConfidence() );
//                    if( activity.getConfidence() >= 75 ) {
//                        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//                        builder.setContentText( "Are you walking?" );
//                        builder.setSmallIcon( R.mipmap.ic_launcher );
//                        builder.setContentTitle( getString( R.string.app_name ) );
//                        NotificationManagerCompat.from(this).notify(0, builder.build());
//                    }
//                    break;
//                }
//                case DetectedActivity.UNKNOWN: {
//                    Log.d( "ActivityRecogition", "Unknown: " + activity.getConfidence() );
//                    break;
//                }
//            }
        }
    }
}
