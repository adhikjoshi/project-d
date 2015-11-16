package com.idealdevelopers.dzirecybercafe.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.idealdevelopers.dzirecybercafe.R;
import com.idealdevelopers.dzirecybercafe.ui.fragment.HomeFragement;
import com.idealdevelopers.dzirecybercafe.ui.fragment.JobworkFragement;
import com.idealdevelopers.dzirecybercafe.ui.fragment.MainFragment;
import com.idealdevelopers.dzirecybercafe.ui.fragment.developers_infi;
import com.idealdevs.dzirecybercafe.Model.HelpLiveo;
import com.idealdevs.dzirecybercafe.interfaces.OnItemClickListener;
import com.idealdevs.dzirecybercafe.interfaces.OnPrepareOptionsMenuLiveo;
import com.idealdevs.dzirecybercafe.navigationliveo.NavigationLiveo;
import com.parse.ParseAnalytics;

public class MainActivity extends NavigationLiveo implements OnItemClickListener {

    private HelpLiveo mHelpLiveo;

    @Override
    public void onInt(Bundle savedInstanceState) {


        //parse crash reposring
        ParseAnalytics.trackAppOpenedInBackground(getIntent());

        // User Information
        this.userName.setText("");
        this.userName.setText(R.string.app_name);
        this.userEmail.setText("dzirecybercafe@gmail.com");
        this.userPhoto.setImageResource(R.drawable.dzire_logo);
        this.userBackground.setImageResource(R.drawable.ic_user_background_first);

        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.inbox), R.mipmap.ic_inbox_black_24dp);
        mHelpLiveo.add(getString(R.string.starred), R.mipmap.ic_add_white_24dp);
        mHelpLiveo.add(getString(R.string.trash), R.mipmap.ic_delete_black_24dp);
        mHelpLiveo.add(getString(R.string.categories), R.mipmap.ic_inbox_black_24dp);
        mHelpLiveo.add(getString(R.string.spam), R.mipmap.ic_report_black_24dp);

        with(this).startingPosition(0) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())

                //{optional} - List Customization "If you remove these methods and the list will take his white standard color"
                //.selectorCheck(R.drawable.selector_check) //Inform the background of the selected item color
              //  .colorItemDefault(R.color.nliveo_blue_colorPrimary) //Inform the standard color name, icon and counter
                .colorItemSelected(R.color.nliveo_purple_colorPrimary) //State the name of the color, icon and meter when it is selected
                //.backgroundList(R.color.nliveo_black_light) //Inform the list of background color
                //.colorLineSeparator(R.color.nliveo_transparent) //Inform the color of the subheader line

                //{optional} - SubHeader Customization
              //  .colorItemSelected(R.color.nliveo_blue_colorPrimary)
              //  .colorNameSubHeader(R.color.nliveo_blue_colorPrimary)
                //.colorLineSeparator(R.color.nliveo_blue_colorPrimary)

                .footerItem(R.string.settings, R.mipmap.ic_settings_black_24dp)

                //{optional} - Footer Customization
                //.footerNameColor(R.color.nliveo_blue_colorPrimary)
                //.footerIconColor(R.color.nliveo_blue_colorPrimary)
                //.footerBackground(R.color.nliveo_white)

                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
                .build();

        int position = this.getCurrentPosition();
        this.setElevationToolBar(position != 2 ? 15 : 0);

    }

    @Override
    public void onItemClick(int position) {
        Fragment mFragment;
        FragmentManager mFragmentManager = getSupportFragmentManager();

        switch (position){

            case 0:
                mFragment = new HomeFragement();
                break;

            case 1:
                mFragment = new JobworkFragement();
                break;

            case 2:
                mFragment = new developers_infi();
                break;

            default:
                mFragment = MainFragment.newInstance(mHelpLiveo.get(position).getName());
                break;
        }

        if (mFragment != null){
            mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
        }

        setElevationToolBar(position != 2 ? 15 : 0);
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "onClickPhoto :D", Toast.LENGTH_SHORT).show();
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), com.idealdevelopers.dzirecybercafe.ui.Parse.MainActivity.class));
            closeDrawer();
        }
    };
}

