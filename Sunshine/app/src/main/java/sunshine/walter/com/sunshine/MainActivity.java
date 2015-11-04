package sunshine.walter.com.sunshine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_main) {
            Intent settings=new Intent(this,SettingsActivity.class);
            startActivity(settings);
        }else if(id ==R.id.action_settings_view_location)
        {
            SharedPreferences SP =getPreferences(Context.MODE_PRIVATE);
            String location=SP.getString(getString(R.string.location_key),getString(R.string.location_default_value));
            // Displays an image of the Swiss Alps
            Uri gmmIntentUri = Uri.parse("geo:0.0?").buildUpon().appendQueryParameter("q",location).build();
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if(mapIntent.resolveActivity(getPackageManager())!=null)
            {
                startActivity(mapIntent);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
