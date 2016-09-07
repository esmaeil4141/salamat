package ir.sharif.random.salamat.model.localDataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class DataBaseService implements LocalDataBaseService, CloudDataBaseService {

    public final String TAG = this.getClass().getSimpleName();
    private String appId = "9AB14D7E-8CA3-0491-FFC8-3E387234E800";
    private String secretKet = "1365F672-9303-976A-FF41-10CDC8029F00";
    private String version = "v1";

    DataOpenHelper helper;
    SQLiteDatabase database;
    ModelCallBack modelCallBack;


    public interface ModelCallBack {
        void registeredSuccessfully();
    }

    public DataBaseService(Context context) {
        helper = new DataOpenHelper(context);
        Backendless.initApp(context, appId, secretKet, version);
    }


    public void open() {
        database = helper.getWritableDatabase();
        Log.i(TAG, "database opened");
    }

    public void close() {
        database.close();
        helper.close();
        Log.i(TAG, "database closed");
    }

    @Override
    public void setModelCallBack(ModelCallBack callBack) {
        this.modelCallBack = callBack;
    }

    @Override
    public void registerUser(String email, String password) {
        BackendlessUser user = new BackendlessUser();
        user.setProperty("email", email);
        user.setPassword(password);

        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                modelCallBack.registeredSuccessfully();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                //ToDO
            }
        });
    }
}
