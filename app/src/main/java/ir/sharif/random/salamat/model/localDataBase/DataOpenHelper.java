package ir.sharif.random.salamat.model.localDataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataOpenHelper extends SQLiteOpenHelper{
    public final String TAG = this.getClass().getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="DataBase.db" ;
    public static final String TABLE_NAME ="NAME" ;

    public static final String COLUMN_ID= "ID";

    private static final String TASK_TABLE_CREATE = "CREATE TABLE "+ TABLE_NAME +
            " ( "+
            COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT );";

    public DataOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TASK_TABLE_CREATE);
        Log.i(TAG, "database created with 1 table:"+ TABLE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ TABLE_NAME);
        onCreate(db);
        Log.i(TAG, "database ReCreated");
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ TABLE_NAME);
        onCreate(db);
        Log.i(TAG, "database ReCreated in downGrade");
    }
}
