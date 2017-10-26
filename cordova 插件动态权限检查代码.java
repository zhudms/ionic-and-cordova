package cordova.lerong.camerawithframe;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cordova.ryl.cordovalib.FileHelper;
import io.ionic.plugindemo.R;

/**
 * This class echoes a string called from JavaScript.
 需要配合 Lib 使用
 */
public class CameraWithFrame extends CordovaPlugin {

    public   CallbackContext mCallback;
    private String[] primissions={Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    public static final int PRIMISSION_REQUEST=1;
    private String picPath;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("take")) {
            String message = args.getString(0);
            this.prepareTakePic();
            return true;
        }
        return false;
    }

    private void prepareTakePic() {
        boolean hasPrimission=true;

        for (int i = 0; i < primissions.length; i++) {
            hasPrimission=hasPrimission&&PermissionHelper.hasPermission(CameraWithFrame.this,primissions[0]);
        }
        if (hasPrimission){
            getPicPath();
            takePic();

        }else{
            gainPrimission();
        }

    }


    private void gainPrimission() {
        PermissionHelper.requestPermissions(CameraWithFrame.this,PRIMISSION_REQUEST,primissions);
    }

    @Override
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) throws JSONException {
//        super.onRequestPermissionResult(requestCode, permissions, grantResults);
        for (int primissionResult :
                grantResults) {
            if (primissionResult != PackageManager.PERMISSION_GRANTED){
                sendMyResult(PluginResult.Status.ERROR, R.string.prommission_request);
            }
        }
    }



    private void sendMyResult(PluginResult.Status state,int message){
        mCallback.sendPluginResult(new PluginResult(state,message));
    }


    private void getPicPath() {
        picPath= FileHelper.SD_IDFRAME_ROOT+System.currentTimeMillis()+"jpg";
    }

     /**
     * 转跳拍照页面
     */
    private void takePic() {

    }
}
