package hn.techcom.com.hnapp;

import android.support.annotation.NonNull;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar homeToolbar;
    private TabLayout homeTabLayout;
    private ViewPager homeViewPager;
    private TabItem trendingPostsTab, featuredPostsTab;
    private HomeFragmentPagerAdapter homeFragmentPagerAdapter;
    private FloatingActionButton fabWrite;

    Boolean FabExpanded = false;

    LinearLayout layoutFabWriteQuote;
    LinearLayout layoutFabWriteStory;
    LinearLayout layoutFabWritePoem;
    LinearLayout layoutFabUploadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //initializing all the views in home screen
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        homeToolbar = findViewById(R.id.toolbar_home);
        homeTabLayout = findViewById(R.id.tabs_home);
        trendingPostsTab = findViewById(R.id.tab_trending_posts);
        featuredPostsTab = findViewById(R.id.tab_featured_posts);
        homeViewPager = findViewById(R.id.tabs_pager_home);
        fabWrite = findViewById(R.id.fabCreates);
        layoutFabWriteQuote = findViewById(R.id.layoutWriteQuote);
        layoutFabWriteStory = findViewById(R.id.layoutWriteStory);
        layoutFabWritePoem = findViewById(R.id.layoutWritePoem);
        layoutFabUploadImage = findViewById(R.id.layoutUploadImage);

        //initializing the home view pager adapter
        homeFragmentPagerAdapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        homeViewPager.setAdapter(homeFragmentPagerAdapter);
        homeTabLayout.setupWithViewPager(homeViewPager);

        //setting home toolbar's default tittle to null
        homeToolbar.setTitle("");
        setSupportActionBar(homeToolbar);
        ActionBar actionBar = getSupportActionBar();

            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu_icon_24dp);


        //removing default icon tint color for navigation view
        navigationView.setItemIconTintList(null);

        //setting navigation menu items to their corresponding fragments
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                Fragment fragment = null;
                FragmentManager fragmentManager = getSupportFragmentManager();

                // open corresponding fragment when its name is being tapped in the drawer menu
                switch (id){
                    case R.id.nav_sign_out:
                }
                return false;
            }
        });

        fabWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FabExpanded){
                    closeSubMenusFab();
                }
                else {
                    openSubMenusFab();
                }
            }
        });

        closeSubMenusFab();

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //opening the side navigation drawer on menu icon click
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //closes FAB submenus
    private void closeSubMenusFab(){
        layoutFabWriteQuote.setVisibility(View.INVISIBLE);
        layoutFabWriteStory.setVisibility(View.INVISIBLE);
        layoutFabWritePoem.setVisibility(View.INVISIBLE);
        layoutFabUploadImage.setVisibility(View.INVISIBLE);

        fabWrite.setImageResource(R.drawable.ic_write_white_24dp);
        FabExpanded = false;
    }

    //Opens FAB submenus
    private void openSubMenusFab(){
        layoutFabWriteQuote.setVisibility(View.VISIBLE);
        layoutFabWriteStory.setVisibility(View.VISIBLE);
        layoutFabWritePoem.setVisibility(View.VISIBLE);
        layoutFabUploadImage.setVisibility(View.VISIBLE);

        //Change settings icon to 'X' icon
        fabWrite.setImageResource(R.drawable.ic_close_white_24dp);
        FabExpanded = true;
    }

    private void ifUserIsLoggedIn(){

    }
}
