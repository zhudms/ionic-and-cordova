package cordova.ryl.wagesignocr;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static cordova.ryl.cordovalib.ActivityResultHelper.PERMISSION_DENIED_ERROR;

/**
 * This class echoes a string called from JavaScript.
 */
public class cordovawagesignocr extends CordovaPlugin {

public static final int promissionRequestCode = 10;


    private CallbackContext mCallBack;
    protected final static String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};



    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
         
         //需要判断的action
         if (action.equals("")) {

            mCallBack = callbackContext;
            
            //程序入口
            getPromission();
           
            return true;
        }
        return false;
    }


  private void getPromission() {

      int sdk = android.os.Build.VERSION.SDK_INT;
      if (sdk >= 23) {
          
        boolean hasPromission = true;

        for (int i = 0; i < PERMISSIONS.length; i++) {

          hasPromission = hasPromission && (checkPermissions(PERMISSIONS[i]));

          if (!hasPromission) {
            requestThePermissions();
            break;
          }

        }

        if (hasPromission) {
          startFunction();
        }

      } else {

        //这里应该也要获取权限状态啊 ,后面再写完整吧
        startFunction();

      }
    
}

private boolean checkPermissions(String permission){
    return ContextCompat.checkSelfPermission(cordova.getActivity(), PERMISSIONS[i])== PackageManager.PERMISSION_GRANTED;
}

private void requestThePermissions (){
      PermissionHelper.requestPermissions(this, TAKE_PIC_SEC, PERMISSIONS);
}

 public void onRequestPermissionResult(int requestCode, String[] permissions,
                                          int[] grantResults) throws JSONException {
        for (int r : grantResults) {
            if (r == PackageManager.PERMISSION_DENIED) {
                this.mCallBack.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, PERMISSION_DENIED_ERROR));
                return;
            }
        }
        switch (requestCode) {
            case TAKE_PIC_SEC:
                startFunction(OCR_OCRSide);
                break;

        }
    }

private void startFunction(){
    //如果需要传参,请使用全局变量
     startOCRID();
}





}
