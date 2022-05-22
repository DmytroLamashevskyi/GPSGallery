package com.zjnu.gpsgallery;

import android.location.Location;
import android.net.Uri;
import android.os.Environment;

import java.io.File;

public class GpsImage {
    public Uri uri;
    public Location location;

    public GpsImage(Location location, Uri picUri) {
        this.uri = picUri;
        this.location = location;
    }

    public static Uri generateFileUri() {

        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            return null;

        File path = new File (Environment.getExternalStorageDirectory(), "CameraTest");
        if (! path.exists()){
            if (! path.mkdirs()){
                return null;
            }
        }

        String timeStamp = String.valueOf(System.currentTimeMillis());
        File newFile = new File(path.getPath() + File.separator + timeStamp + ".jpg");
        return Uri.fromFile(newFile);
    }

}
