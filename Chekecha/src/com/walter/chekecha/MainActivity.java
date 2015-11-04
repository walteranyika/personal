package com.walter.chekecha;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView textView;
	private String [] data={"We ni mrough hadi ukiguza mouse comp inawika new hardware detected ","Manzi yako ana a** ndogo akitashu u move mbele. ","Mobile 4n yako ni kali mpaka inamixx ma ringtones","Wewe ni fala siku yako ya kwanza kuona strong tea ulianza kuuliza eti kama hiyo maji imeungua!","Mbuyu wako ni mnono akikalia hashu akiamka inakuwa kobole mbili ","We ni mnono hadi ukikalia ashu inakuwa five bob mbili","Kwenu nyi ni mafala hadi mna patia kuku zenu maji moto ati ndio zitoe mayai boilo ","We ni msee wa choir damu hadi we hushuta desyn ya vigelegele alililililiiiii","Dem yako ni fala alienda kwa kibanda ku ulizia kama wakona apple earphones ","ati we ni mkonde mpaka ukiingia class watoi huwika oooonnnneeeee!!! ","Ati una sura mbaya ukilia machozi zinaenda juu","Nyi muko wengi hadi mukipigwa family photo wengine wanahang kwa frame","Hao yenu ni bigi mpaka in ma slumz ndani. ","ati jo! uko na mguu ka smal mpaka huwezi kanyangia risto za baze ","ati we ni mlafi sana unakulanga shimo ya katikati ya doughnut kwanza. ","Wewe in mweusi hadi ukitoka nje giza inasema mmh ","Ati ha wasee ni masikini hadi wakihama walienda na takataka","radio yenu hushika petrol station ","ati kwenu ni ocha hadi samosa zenyu ni za githeri ","mko wengi instead of kutumia bafu mnaenda cattle dip. ","nyanyako ni mzee mpaka yeye hufanywa carbon dating research ","Uko na skin rough we huscratch credo na forehead kisha inakusho Nakufeel pia. ","Dame yako ana lips kubwa mpaka anatumia roll on ka lip balm ","ati mko wengi design nyi hulala kwa kitanda mkiwa mmejipanga ka vibiriti ","Wewe mshamba mara yako ya kwanza kununua ballgum ulisema hutaki ya green ati haijaiva ","Ati naskia nagos yako ni chinku hadi ikona game inaitwa Thika road ","we ni mweusi mpaka ukishika mtoi anadoze akidhani ni usiku.","nyinyi kwenu ni wa black mkiingia kwa moti yenyu dirisha zinakuwa tinted ","Ati TV yenu ni small mpaka nyi hu-watch na jicho moja","Wewe ni mshamba mpaka the first time ulipanda mathree ulitandika vitambaa","site yako ni supuu mpaka google inataka kuikatia! ","Manzi yako ni mugly, ukisimama na yeye kwa stage, kondakta anasema.. Mizigo juu!","ati we ni mshamba hadi huweka redio kwa fridge ndo uskie cool musik ","Ati naskia wewe ni mjinga hadi ulirepeat naso mara mbili ","Manzi yako ni mhairy hadi ako na Afro kwa nipples. ","we ni mweusi ukijipaka vaseline unakaa ni ka umevaa leather jacket.","dem yako ana boobs bwaku hadi yeye uvalia bra long sleeved ","Ati naskia wewe ni mtukutu ukienda toile wewe hukataa kusquat ","we ni mchoyo hadi we utema mate kwa wallet. ","ati we ni mfat hadi unaamka na sessions ","We ni fala ulipatikana uki fine tune microwave yenu ishike XYZ ","ati uko na masikio bigi tym ya kuzaliwa ulishikwa ka cup ya UEFA. ","Nyinyi kwenu mumesota mpaka mna-kunywanga chai kwa kifuniko ya Bic.","Ati we ni m-tall mpaka ukivaa trao by the time ifike kwa waist imeisha fashion","manze ukona kihara lakini bado we hu insist barber akunyoe box! ","Mko wadosi mpaka ng’ombe zenu huvalishwa Trust condoms zikienda kulala ","Kuku zenu ziko mbele hadi zikishikwa na jogoo zinawika you knocked me down ","ati demu yako ni so thin mpaka hatumii always anatumianga elastoplast ","We Mshamba ulisikia computer inashika VIRUS ukainunulia condom ","Wewe ni mblack mpaka ukikutana na mzungu morning anakushow good evening? ","Ati naskia kwenyu kunawagondi hadi gate mumeiweka kwa hao.....haahaaa ","ati uko na masikio bigi tym ya kuzaliwa ulishikwa ka cup ya UEFA.","Kwenyu nyi ni wengi badala ya sofasets muko na viti za stadi (stadium)","tv yenyu ndogo mpaka Kasavuli hupiga magoti kusoma news!! ","Wewe mweusi mpaka ukirushiwa mawe, mawe inarudi kuitisha torch","Nyanya yako Kipara lakini bado analilia CURL KIT ","Budako mrefu mpaka anauza mahindi kwa watu kwa plane","UKo na macho kubwa hadi wewe huitwa eye witness ","manzi yako ni msupa badala ya kumea fudhi ye humea ma flowers ","ati mbwa yenyu ni noma wagondi wakitokea inaanza kuimba teren teren ","Ati dem yako akona sura mbaya hadi yeye huadmitiwa kwa store ya hosi ","We ni mfupi hadi we hucheza rudgy na njugu. ","eti chief ako na kwalala ndogo ye udunga condom na belt! ","wewe ni mnono mpaka uki pigwa picha ina andikwa to b continued ","naskia grandmasako nimzee lakini bado anataka kua AMERICAN NEXT TOP MODEL ","Ati wewe ni danda ulienda sunday school parallel programe ","Ati wewe mweusi tu sana mpaka hauna bright ideas. ","Uko na phone kubwa hadi ni bouncer club 20. ","Brother yako ako na skin tight mpaka aki-wink mguu moja inainuka ","Ati we ni mjinga hadi ukienda kwa hoteli unauliza ka kuna mayai alafu unadai upewe mama yake","Ati we ni mnoma hadi ndoto zako huanzia..previously on.. ","Wewe ni bowlegged na manzi wako ni knock-kneed, mukisimama pamoja muna spell 'OX'","wee ni dingo noma hadi wee uiba sukari kwa chai... ","We ni geek/nerd hadi maskio zako ziko na spinnerz. ","kwenyu chapo za klisi nyi uzipika january alafu munazifile hadi dise ","tenje yenyu deadly inamix kiss na ramogi!! ","Naskia wesewe ni black hadi ile siku God ali kuumba alisema oops have burnt one ","nyinyi m-mesota mpaka mnalipa kiberiti na monthly installments!! ","Doggy yenu noma, inabark ikitweng 'werf!! werf!!''","ati wewe uwet bed hadi masayako amehang kibao kwa bed yako imeandikwaonyo kali usikojoe hapa. ","Dem yako ni fala yeye hu vaa pencil na rubber na hapendi kusoma ","m-meokoka mpaka wezi wakikuja kwenyu umbwa zenyu zinawika iba tu mungu anakuona ","Ati naskia dem yako akimeza mate yeye hu nyora ","manzi yako anakichwa biggy hadi akienda salon ye hushukwa style zote","Ati wewe ni mkonda mpaka ukienda toile unatumia uzi badala ya tissue!!! ","unajipaka make up mob ukilia unaacha erosion ","Wewe ni danda ukiingia lift unafinya number tisa ikufikishe isich ","Mamako m..Lazy..anapika chapo moja na anatoa fotocopy ya hizo zingine ","Wewe mshamba mara yako ya kwanza kununua ballgum ulisema hutaki ya green ati haijaiva ","Ati we ni mzee hadi insted ya kuchukua ID we hurudisha! ","Budako ni fala alienda kubuy ngombe akaona ikikojoa akasema sitaki hiyo imetoboka. ","mamako ni mjanja ye hupaka rob kwa chapo ndio zikue menthol. ","Uko na sura kiatu hadi we hutumika kuadvert sumu ","Mtoi wa Jelimo ni mshort hadi hukimbia 800m juu ya chapo. ","ATI KWENU IMEJENGWA NA MCHANGA WEZI WAKI KAMU WANA SEMA FUNGUA AMA TUKOJOE ","we ni mweusi mpaka ukishika mtoi anadoze akidhani ni usiku. ","ati teli yenu ni pyienga design Mwakazi na Mutegi usoma Breakfast Show kama wame keti kwa floor ","We ni mnono hadi ukikalia ashu inakuwa five bob mbili ","Tv yenu ni nzee hadi dexter anaongea kikamba","Ati una sura mbaya ukilia machozi zinaenda juu "};
	private int position=0;
	private int size=100;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
		getActionBar().setTitle(Html.fromHtml("<font color='#3aaef2'>Cheka</font>"));//font color on the action bar
		textView=(TextView) findViewById(R.id.tvData);		
		textView.setText(data[0]);//display the first item when the app starts
		//display text in a fancy font downloaded and added in the assets/fonts folder
		//more fonts can be downloaded from http://www.fontsquirrel.com/
	    Typeface font=Typeface.createFromAsset(getAssets(), "fonts/boogaloo.otf");
	    textView.setTypeface(font);
	    //more Links
	    //tools to create a cool button http://angrytools.com/android/button/
	    //tools to resize icons  https://resizeappicon.com/
	    //http://makeappicon.com/
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	
    public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==R.id.action_share)
		{
		  //Share an Item
		  Intent i=new Intent(Intent.ACTION_SEND);
		  i.putExtra(Intent.EXTRA_TEXT, data[position]);
		  i.setType("text/plain");
		  startActivity(i);
		}
		else if(item.getItemId()==R.id.action_settings)
		{

		}
		return super.onOptionsItemSelected(item);
	}
	//next button listener
    public void next(View v)
	{  
		position++;//increment position
		//check that the position(index) is within allowed limits of array size
		if(position>=0 && position<size)
		{
		  textView.setText( data[position] );//display an item from array		  
		}
		else
		{
			Toast.makeText(this, "Reached The End", Toast.LENGTH_SHORT).show();
			position=0;//reset the position once the user reaches the end of the array
		}		
	}
    //previous button listener
	public void previous(View v)
	{
	    position--;//decrement position
		//check that the position(index) is within allowed limits of array size
		if(position>=0 && position<size)
		{
		  textView.setText(data[position]);//display an item from array	
		}
		else
		{
			Toast.makeText(this, "Reached The End", Toast.LENGTH_SHORT).show();
			position=99;//reset the position once the user reaches the beginning
		}					
	}
	//inspire-africa.org/app.zip
	
	
	
	
	
	
	
}
