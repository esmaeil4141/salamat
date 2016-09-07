package ir.sharif.random.salamat.model.localDataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


/**
 * Created by Mojtaba on 8/13/2016.
 */
public class DataSource implements DataBaseService {
    public final String TAG = this.getClass().getSimpleName();
    DataOpenHelper helper;
    SQLiteDatabase database;

    public DataSource(Context context) {
        helper = new DataOpenHelper(context);
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

}
