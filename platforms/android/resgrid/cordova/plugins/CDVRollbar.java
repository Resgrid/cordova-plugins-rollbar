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

import android.content.Context;
import android.content.res.Resources;

import com.rollbar.android.Rollbar;

public class CDVRollbar extends CordovaPlugin {
    public static final String INIT = "init";

    public static final String ROLLBAR_ACCESS_TOKEN = "rollbar_access_token";
	public static final String ROLLBAR_ENVIRONMENT = "rollbar_environment";
	
    public static final String STRING = "string";

    private String packageName;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Context context = this.cordova.getActivity();
        packageName = context.getPackageName();
        Resources resources = context.getResources();
		
        String rollbarAccessToken = context.getString(resources.getIdentifier(ROLLBAR_ACCESS_TOKEN, STRING, packageName));
		String rollbarEnvironment = context.getString(resources.getIdentifier(ROLLBAR_ENVIRONMENT, STRING, packageName));
		
		Rollbar.init(context, rollbarAccessToken, rollbarEnvironment);
    }

    @Override
    public boolean execute(String action, final JSONArray args,
                           CallbackContext callbackContext) throws JSONException {
        try {
            if (INIT.equals(action)) {
                //final String msg = args.getString(0);
                //final String stack = args.getString(1);
                //cordova.getThreadPool().execute(new Runnable() {
                //    public void run() {
				//		Rollbar.reportException(stack, "critical", msg);
                //    }
                //});
                return true;
            } 

            return false;
        } catch (ThreadDeath td) {
            throw td;
        } catch (Throwable t) {
			Rollbar.reportException(t);
            return false;
        }
    }
}
