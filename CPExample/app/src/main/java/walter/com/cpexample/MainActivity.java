package walter.com.cpexample;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void save(View view) {
        EditText edtname= (EditText) findViewById(R.id.editText);
        EditText edtEmail = (EditText) findViewById(R.id.editText2);
        String names= edtname.getText().toString();
        String email =edtEmail.getText().toString();
        ContentValues values=new ContentValues();
        values.put(StudentsProvider.NAME, names);
        values.put(StudentsProvider.EMAIL,email);

        Uri uri =getContentResolver().insert(StudentsProvider.CONTENT_URI,values);
        Toast.makeText(this,uri.toString(),Toast.LENGTH_SHORT).show();
    }

    public void retrieve(View view) {
        // Retrieve student records
        String URL = "content://com.walter.College/students";

        Uri students = Uri.parse(URL);
        Cursor c = getContentResolver().query(students,null,null,null,null);
        Toast.makeText(this,"Count "+c.getCount(),Toast.LENGTH_SHORT).show();
       /* if (c.moveToFirst()) {
            do{
                           Toast.makeText(this, c.getString(c.getColumnIndex(StudentsProvider._ID)) + ", " +  c.getString(c.getColumnIndex( StudentsProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex( StudentsProvider.EMAIL)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }*/

        Cursor cursor= getContentResolver().query(Uri.parse("content://sms/inbox"),null,null,null,null);
        if(cursor.moveToFirst())
        {
          do{
               String msgData="";
               for(int i=0; i<cursor.getColumnCount(); i++)
               {
                 msgData += " " + cursor.getColumnName(i)+": "+cursor.getString(i);
               }
            }while (cursor.moveToNext()) ;

        }

    }

    public void test_clicked(View view) {
    }
}







