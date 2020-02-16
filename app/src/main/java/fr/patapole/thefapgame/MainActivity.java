package fr.patapole.thefapgame;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import com.squareup.seismic.ShakeDetector;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener{

    public static Context context;
    public static Activity activity;

    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;


    public static String prefix = "The Fap Game";

    Toolbar mToolbar;
    ChallengeAdapter mAdapter;
    ListView mListView;
    TextView mEmptyView;

    private void buildChallenges(){
        new Challenge("Behind Seven Proxies", "Fap through your pants.", R.drawable.behind_seven_proxies);
        new Challenge("Altitude", "Fap on an airplane.", R.drawable.altitude);
        new Challenge("Ambidexterous", "Fap with your both hands.", R.drawable.ambidexterous);
        new Challenge("Anger Management", "Fap while angry.", R.drawable.anger_management);
        new Challenge("Anti-Depressant", "Fap while sad.", R.drawable.anti_depressant);
        new Challenge("Backstabber", "Fap in a firends shower.", R.drawable.backstabber);
        new Challenge("Beauty Parlor", "Fap while at spa getting massage or some shit.", R.drawable.beauty_parlor);
        new Challenge("Behind Enemy Lines", "Fap in someone eles's house.", R.drawable.behind_enemy_lines);
        new Challenge("Bible-Thumper", "Fap to Jesus.", R.drawable.bible_thumper);
        new Challenge("Big Belly, Big Lovin", "Fap to pregnant chick.", R.drawable.big_belly);
        new Challenge("Biodegradable", "Fap to a dead person.", R.drawable.biodegradable);
        new Challenge("Blinding shot", "Fap/Cum to the sun.", R.drawable.blinding_shot);
        new Challenge("Boogie Man", "Fap under bed.", R.drawable.boogie_man);
        new Challenge("Bookworm", "Go to public library and cum into a book.", R.drawable.bookworm);
        new Challenge("Buckets", "Edge routinely for at least 2 weeks, without cumming. Then release your saved up load, in all its glory.", R.drawable.buckets);
        new Challenge("Bullseye", "Shoot into your own mouth and swallow.", R.drawable.bullseye);
        new Challenge("Capture The Cum", "Aim the cum in a jar 3 feet away.", R.drawable.capture_the_cum);
        new Challenge("Careless", "Cum in your underwear or pants and wear them like nothing happened.", R.drawable.careless);
        new Challenge("Chris Benoit", "Fap in the gym.", R.drawable.chris_benoit);
        new Challenge("Complete Control", "Get an errection on command.", R.drawable.complete_control);
        new Challenge("Company Ink", "Fap to a classmate.", R.drawable.company_ink);
        new Challenge("Corruption", "Fap to rule 34 of something innocent.", R.drawable.corrumption);
        new Challenge("Dead shot", "Fap to the dead.", R.drawable.dead_shot);
        new Challenge("Dirty Harry", "Fap while fingering your asshole.", R.drawable.dirty_harry);
        new Challenge("Dodged It!", "Cum flies towards your face and you dedge it.", R.drawable.dodged_it);
        new Challenge("Doggy Style", "Fap to bestiality.", R.drawable.doggy_style);
        new Challenge("Drive-By", "Fap while driving your car.", R.drawable.drive_by);
        new Challenge("Drying Paint", "Fap to your wall and cum onto it.", R.drawable.drying_paint);
        new Challenge("Duracell", "Fap three times in a row.", R.drawable.duracell);
        new Challenge("Early Bird", "Fap immediately after you wake up.", R.drawable.early_bird);

        new Challenge("Empty Balls", "All achievements unlocked.", R.drawable.empty_balls);

        new Challenge("Endurance Fap", "Fap for more than 60 minutes.", R.drawable.endurance_fap);
        new Challenge("Endurance test", "Fap for the whole day.", R.drawable.endurance_test);
        new Challenge("Exposure", "Fap standing at your window, so people living across the street can see you do it.", R.drawable.exposure);
        new Challenge("Family Shot", "Fap to family.", R.drawable.family_shot);
        new Challenge("Fap Fap And Away", "Cum 100 feet above ground level.", R.drawable.fap_fap_and_away);
        new Challenge("Fap And Dump", "Take a dump while fapping.", R.drawable.fap_and_dump);
        new Challenge("The Fapman", "Fap using the left hand (or right, if you are lefty) while playing pacman.", R.drawable.the_fapman);
        new Challenge("Farmer Jones", "Fap in a field.", R.drawable.farmer_jones);
        new Challenge("Feels Good, Man", "Fart while fapping.", R.drawable.feels_good_man);
        new Challenge("Friction Burn", "Fap fast/hard enough to create a friction-burn like sore on penis.", R.drawable.friction_burn);
        new Challenge("Fruityloop", "Fap with a fruit or vegetable.", R.drawable.fruityloop);
        new Challenge("In God We Fap", "Fap in a church.", R.drawable.in_god_we_fap);
        new Challenge("Greedy Fucker", "Fap next to sleeping girlfriend after sex.", R.drawable.greedy_fucker);
        new Challenge("Green Thumb", "Fap in the wood.", R.drawable.green_thumb);
        new Challenge("Hard At Work", "Fall asleep while fapping.", R.drawable.hard_at_work);
        new Challenge("Headshot", "Fap onto girlfriend's face.", R.drawable.headshot);
        new Challenge("Holding The Line", "Hold your orgasm 3 times.", R.drawable.holding_the_line);
        new Challenge("Going Up", "Fap in the elevator.", R.drawable.going_up);
        new Challenge("HOT FIRE!", "Fap to gingers.", R.drawable.hot_fire);
        new Challenge("Hot Nights", "Spend a whole night fapping.", R.drawable.hot_nights);
        new Challenge("I Buy It For The Articles", "Fap to a porn magazine.", R.drawable.i_buy_it_for_the_articles);
        new Challenge("I Don't Give A Fuck", "Fap into someone's food.", R.drawable.i_dont_give_a_fuck);
        new Challenge("Imagination Mode", "Fap without any porn of any sort beside your imagination.", R.drawable.imagination_mode);
        new Challenge("In Recent News ...", "Fap to anchorwoman.", R.drawable.in_recent_news);
        new Challenge("Iron Man", "Fap without any form of lube.", R.drawable.iron_man);
        new Challenge("Iron Will", "Don't fap fpr 30 days.", R.drawable.iron_will);
        new Challenge("Jack-Off Daniels", "Fap whilst drunk.", R.drawable.jack_off_daniels);
        new Challenge("Jaws", "Fap in public pool.", R.drawable.jaws);
        new Challenge("JETSON! You're Fired!", "Fap at work.", R.drawable.jetson);
        new Challenge("Just A Cold", "Wipe your jizz on your bedsheets when sick, blame runny nose.", R.drawable.just_a_cold);
        new Challenge("Kamikaze Fap", "Fap in a busy public library.", R.drawable.kamikaze_fap);
        new Challenge("Keeps The Doctor Away", "Fap once a day (6 months).", R.drawable.keeps_the_doctor_away);
        new Challenge("Killstreak", "Fap more than 10 times a day.", R.drawable.killstreak);
        new Challenge("Kodak Moment", "Fap and cum to a face pic of someone.", R.drawable.kodak_moment);
        new Challenge("Lasting Blast", "Fire at least 10 shots.", R.drawable.lasting_blast);
        new Challenge("Like Father Like Son", "Fap to your mom.", R.drawable.like_father_like_son);
        new Challenge("Long Shot", "Fire your cum 3 feet.", R.drawable.long_shot);
        new Challenge("Manfap", "Fap to men.", R.drawable.manfap);
        new Challenge("Messmaker", "Fap and cum all over the floor.", R.drawable.messmaker);
        new Challenge("Monkey Man", "Fap while hanging from the local playgrounds monkey bars.", R.drawable.monkey_man);
        new Challenge("Motorhead", "Fap to machine.", R.drawable.motorhead);
        new Challenge("Mount Vesuvius", "Cum 18 inches into the air.", R.drawable.mount_vesuvius);
        new Challenge("Multi Shot", "Fire more than once per fap.", R.drawable.multi_shot);
        new Challenge("Music To My Ears", "Fap with headphones on, listening music.", R.drawable.music_to_my_ears);
        new Challenge("New Meat", "Fap to your ex's new boyfriend.", R.drawable.new_meat);
        new Challenge("Ninja-Fap", "Fap in public without being noticed.", R.drawable.ninja_fap);
        new Challenge("Nirvana", "Fap stoned.", R.drawable.nirvana);
        new Challenge("No Fear", "Successfully fap while there is someone in the house with the door open.", R.drawable.no_fear);
        new Challenge("No Hands", "Cum without touching your penis.", R.drawable.no_hands);
        new Challenge("No Rest For The Wicked", "Fap at a family funeral.", R.drawable.no_rest_for_the_wicked);
        new Challenge("Parental Controls", "Fap to something on PBS.", R.drawable.parental_controls);
        new Challenge("Performance Enhancer", "Fap while stoned, multiple times in the same high.", R.drawable.performance_enhancer);
        new Challenge("Pet Shop", "Fap to animals.", R.drawable.pet_shot);
        new Challenge("Precision", "Fap and shoot cum over a shoulder.", R.drawable.precision);
        new Challenge("Quickshot", "Cum in less than 90 seconds.", R.drawable.quickshot);
        new Challenge("Rageeee", "Fap while holding in your shit.", R.drawable.ragee);
        new Challenge("Rebound", "Fap and cum twice in thirty minutes.", R.drawable.rebound);
        new Challenge("Rigor Mortis", "Fap in a hospital.", R.drawable.rigor_mortis);
        new Challenge("Royal Flush", "Cum into same toilet bowl five times.", R.drawable.royal_flush);
        new Challenge("Runner World", "Fap while running around the house.", R.drawable.runners_world);
        new Challenge("Safety", "Fap in a condom.", R.drawable.safety);
        new Challenge("Self Sufficiency", "Fap to yourself.", R.drawable.self_sufficiency);
        new Challenge("Seppuku", "Shoot load into own face.", R.drawable.seppuku);
        new Challenge("Shifty Shot", "Fap with alternating hands each night.", R.drawable.shifty_shot);
        new Challenge("Sick Fuck", "Fap to furry sex in the missionary position.", R.drawable.sick_fuck);
        new Challenge("Sieg Heil", "Fap to Hitler.", R.drawable.sieg_hell);
        new Challenge("So Ronery", "Fap to a picture of the person you have feelings for.", R.drawable.so_ronery);
        new Challenge("Stained", "Use the same fap rag for a week straight.", R.drawable.stained);
        new Challenge("Stealth", "Fap with a friend in the room, remaining inconspicuous.", R.drawable.stealth);
        new Challenge("Stealth Shot", "Fap while watching a movie with a friend.", R.drawable.stealth_shot);
        new Challenge("Balls Of Steel", "Fap while soaking your balls in cold water.", R.drawable.balls_of_steel);
        new Challenge("Surprise!!!", "Cum on something for someone else to find.", R.drawable.surprise);
        new Challenge("Tastes Like Chicken", "Eat your load after cumming.", R.drawable.tastes_like_chiken);
        new Challenge("Technology", "Fap to porn from your smartphone.", R.drawable.technology);
        new Challenge("I Like Teh Movies", "Fap in a theater.", R.drawable.i_like_teh_movies);
        new Challenge("The Good Student", "Fap in class.", R.drawable.the_good_student);
        new Challenge("The Mozart", "Fap at a classical music concert.", R.drawable.the_mozart);
        new Challenge("The Passenger", "Fap in taxi.", R.drawable.the_passenger);
        new Challenge("This Is So Wrong", "Fap to an unusual fetish.", R.drawable.this_is_so_wrong);
        new Challenge("Tickle Me Elmo", "Tickle/rub the back of your cock until you cum.", R.drawable.tickle_me_elmo);
        new Challenge("Trap Fap", "Fap to a trap.", R.drawable.trap_fap);
        new Challenge("Tresfapping", "Trespass/fap.", R.drawable.tresfapping);
        new Challenge("Two Birds, One Stone", "Fap into a tissue, then blow your nose into the same tissue.", R.drawable.two_birds_one_stone);
        new Challenge("Under Pressure", "Fap inside the changing room of a clothing store.", R.drawable.under_pressure);
        new Challenge("V For Vendetta", "Shoot cum off in two directions.", R.drawable.v_vendetta);
        new Challenge("Voyeur", "Fap to someone you can see outside.", R.drawable.voyeur);
        new Challenge("Wet Willy", "Fap in the shower.", R.drawable.wet_willy);
        new Challenge("Work With What Ya Got", "Dry fap, then fap again with your jizz.", R.drawable.work_with_what_ya_got);


    }

    private int count(){
        int i = 0;
        for(Challenge c : Challenge.challenges){
            if(c.isDone()){
                i++;
            }
        }
        return i;
    }
    private int egg = 2;
    @Override
    public void hearShake() {
        if(egg == 0) {
            Toast.makeText(this,"Unlock",Toast.LENGTH_SHORT).show();
            new Challenge("Astolfo", "Fap to Astolfo", R.drawable.astolfo);
            load("Astolfo");
            getSupportActionBar().setTitle("Astolfo ("+count()+"/"+Challenge.challenges.size()+")");
        } else if (egg > 0) {
            egg--;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildChallenges();

        load();

        List<Challenge> challenges = Challenge.challenges;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("The Fap Game ("+count()+"/"+Challenge.challenges.size()+")");
        setSupportActionBar(mToolbar);


        mListView = (ListView) findViewById(R.id.list);
        mEmptyView = (TextView) findViewById(R.id.emptyView);

        mAdapter = new ChallengeAdapter(this, challenges);

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mListView.setEmptyView(mEmptyView);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        ShakeDetector shakeDetector = new ShakeDetector(this);

        shakeDetector.start(sensorManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem mSearch = menu.findItem(R.id.action_search);

        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onPause() {
        save();
        super.onPause();
    }

    public static void setTitle(String title){
        ((AppCompatActivity) activity).getSupportActionBar().setTitle(title);
    }

    private void save(){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("The Fap Game", 0);
        SharedPreferences.Editor editor = settings.edit();

        for(Challenge c : Challenge.challenges){
            int val = c.isDone() ? 1 : 0;
            editor.putInt(c.getName(), val);
        }
        editor.apply();

        getSupportActionBar().setTitle(prefix+" ("+count()+"/"+Challenge.challenges.size()+")");

    }

    private void load(){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("The Fap Game", 0);
        for(Challenge c : Challenge.challenges){
            c.setDone(settings.getInt(c.getName(), 0) == 1 ? true : false);
        }
    }

    private void load(String custom){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("The Fap Game", 0);
        for(Challenge c : Challenge.challenges){
            if(c.getName().equals(custom)){
                c.setDone(settings.getInt(c.getName(), 0) == 1 ? true : false);
                break;
            }
        }
    }
}
