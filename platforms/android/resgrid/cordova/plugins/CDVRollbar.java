package resgrid.cordova.plugins.rollbar;

import java.net.URL;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.content.Context;
import android.content.res.Resources;

import com.rollbar.android.Rollbar;

public class CDVRollbar extends CordovaPlugin {
    public static final String TAG = "RollbarPlugin";
    public static final String INIT = "init";

    public static final String ROLLBAR_ACCESS_TOKEN = "rollbar_access_token";
    public static final String ROLLBAR_ENVIRONMENT = "rollbar_environment";

    public static final String STRING = "string";

    private String packageName;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        Context context = this.cordova.getActivity();
        packageName = context.getPackageName();
        Resources resources = context.getResources();
        
        String rollbarAccessToken = context.getString(resources.getIdentifier(ROLLBAR_ACCESS_TOKEN, STRING, packageName));
        String rollbarEnvironment = context.getString(resources.getIdentifier(ROLLBAR_ENVIRONMENT, STRING, packageName));
        
        Log.v(TAG, "Initializing Rollbar with token (" + rollbarAccessToken + ") and environment ("  + rollbarEnvironment + ")");
        
        try {
            Rollbar.init(context, rollbarAccessToken, rollbarEnvironment);
        } catch (Exception e) {
            Log.e(TAG, "Initializing Rollbar with token (" + rollbarAccessToken + ") and environment ("  + rollbarEnvironment + ")");
            throw e;
        }
        
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, final JSONArray args,
                           CallbackContext callbackContext) throws JSONException {
                           
        /**
		 * For right now we call Rollbar on initialize to get it monitoring as soon as possible. Other operations will be added here in the future.
		 */
         return true;
    }
}
