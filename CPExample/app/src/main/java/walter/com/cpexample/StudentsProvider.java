package walter.com.cpexample;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
/**
 * Created by Walter on 9/17/2015.
 */
public class StudentsProvider extends ContentProvider {
    static final String PROVIDER_NAME="com.walter.College";
    static final String URL ="content://"+PROVIDER_NAME+"/students";
    static  final Uri CONTENT_URI = Uri.parse(URL);

    static final String _ID="id";
    static final String NAME ="name";
    static final String EMAIL ="email";

    private  static HashMap<String,String> STUDENTS_PROJECTION_MAP;

    static  final int STUDENTS =1;
    static  final int STUDENTS_ID =2;

    static  final UriMatcher uriMatcher;
    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME,"students",STUDENTS);
        uriMatcher.addURI(PROVIDER_NAME,"students/#",STUDENTS_ID);
    }

    /*DB SPECIFIC CONSTANTS*/
    private SQLiteDatabase db;
    static  final String DATABASE_NAME="shule";
    static  final String STUDENTS_TABLE_NAME ="wanafunzi";
    static  final int DATABASE_VERSION=1;
    static  final String CREATE_DB_TABLE="Create table "+STUDENTS_TABLE_NAME+
            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            " name TEXT NOT NULL, "+
            " email TEXT NOT NULL);";
    private static class DatabaseHelpetr extends SQLiteOpenHelper{

        public DatabaseHelpetr(Context context) {
            super(context, DATABASE_NAME ,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
           db.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS " +STUDENTS_TABLE_NAME);
        }
    }


    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelpetr dbHelper=new DatabaseHelpetr(context);
        db= dbHelper.getWritableDatabase();
        boolean state=false;
        if(db!=null)
        {
           state=true;
        }
        return state;
    }

    @Override
    public Cursor query(Uri uri_uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb= new SQLiteQueryBuilder();
        qb.setTables(STUDENTS_TABLE_NAME);


        switch (uriMatcher.match(uri_uri))
        {
            case STUDENTS :
                qb.setProjectionMap(STUDENTS_PROJECTION_MAP);
                break;
            case STUDENTS_ID :
                 qb.appendWhere(_ID + "=" + uri_uri.getPathSegments().get(1));
                break;
            default:
                throw new IllegalArgumentException("UNKOWN URI"+ uri_uri);

        }
        if(sortOrder == null || sortOrder=="")
        {
         sortOrder = NAME;
        }
        Cursor c= qb.query(db, projection,selection,selectionArgs,null,null,sortOrder);
        c.setNotificationUri(getContext().getContentResolver(),uri_uri);
        return c;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            /**
             * Get all student records
             */
            case STUDENTS:
                return "vnd.android.cursor.dir/vnd.example.wanafunzi";

            /**
             * Get a particular student
             */
            case STUDENTS_ID:
                return "vnd.android.cursor.item/vnd.example.wanafunzi";

            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID= db.insert(STUDENTS_TABLE_NAME,"",values);
        if(rowID>0)
        {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI,rowID);
            getContext().getContentResolver().notifyChange(_uri,null);
            return _uri;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count= 0;
        switch (uriMatcher.match(uri))
        {
            case STUDENTS :
                  count=db.delete(STUDENTS_TABLE_NAME,selection,selectionArgs);
                break;
            case STUDENTS_ID :
                String id= uri.getPathSegments().get(1);
                count= db.delete(STUDENTS_TABLE_NAME,_ID+" = "+id+ (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""),selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("UNKOWN URI"+ uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int count = 0;

        switch (uriMatcher.match(uri)){
            case STUDENTS:
                count = db.update(STUDENTS_TABLE_NAME, values, selection, selectionArgs);
                break;

            case STUDENTS_ID:
                count = db.update(STUDENTS_TABLE_NAME, values, _ID + " = " + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" +selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri );
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;

    }
}
