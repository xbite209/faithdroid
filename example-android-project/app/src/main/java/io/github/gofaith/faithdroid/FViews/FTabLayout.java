package io.github.gofaith.faithdroid.FViews;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import faithdroid.Faithdroid;
import io.github.gofaith.faithdroid.R;
import io.github.gofaith.faithdroid.UI.AttrGettable;
import io.github.gofaith.faithdroid.UI.AttrSettable;
import io.github.gofaith.faithdroid.UI.Toolkit;
import io.github.gofaith.faithdroid.UI.UIController;

public class FTabLayout extends FView implements AttrSettable, AttrGettable {
    public TabLayout v;

    public FTabLayout(UIController controller) {
        parentController =controller;
        v = new TabLayout(parentController.activity);
        view=v;
        setElevation("4");
        v.setTabTextColors(Color.parseColor("#dddddd"),Color.WHITE);
        v.setSelectedTabIndicatorColor(parentController.activity.getResources().getColor(R.color.colorAccent));
        v.setBackgroundColor(parentController.activity.getResources().getColor(R.color.colorPrimary));
    }
    @Override
    public String getAttr(String attr) {
        switch (attr) {
            case "Visibility":
                return getVisibility();
            case "X":
                return getX();
            case "Y":
                return getY();
            case "Width":
                return getWidth();
            case "Height":
                return getHeight();
            case "PivotX":
                return getPivotX();
            case "PivotY":
                return getPivotY();
            case "ScaleX":
                return getScaleX();
            case "ScaleY":
                return getScaleY();
            case "Rotation":
                return getRotation();
            //----------------------------------------------
        }
        return "";
    }

    @Override
    public void setAttr(String attr, final String value) {
        if (value == null) {
            return;
        }
        switch (attr) {
            case "BackgroundColor":
                setBackgroundColor(value);
                break;
            case "Background":
                setBackground(value);
                break;
            case "Foreground":
                setForeground(value);
                break;
            case "Size":
                parseSize( value);
                break;
            case "X":
                setX(value);
                break;
            case "Y":
                setY(value);
                break;
            case "PivotX":
                setPivotX(value);
                break;
            case "PivotY":
                setPivotY(value);
                break;
            case "ScaleX":
                setScaleX(value);
                break;
            case "ScaleY":
                setScaleY(value);
                break;
            case "Rotation":
                setRotation(value);
                break;
            case "Visibility":
                setVisibility(value);
                break;
            case "Padding":
                setPadding(value);
                break;
            case "Margin":
                setMargin(value);
                break;
            case "LayoutGravity":
                setLayoutGravity(value);
                break;
            case "Elevation":
                setElevation(value);
                break;
            case "LayoutWeight":
                setLayoutWeight(value);
                break;
            case "OnTouch":
                setOnTouchListener(value);
                break;
            case "OnClick":
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Faithdroid.triggerEventHandler(value,"");
                    }
                });
                break;
            // -------------------------------------------------------------------
            case "TabTextColors":
                try {
                    JSONArray array = (JSONArray) (new JSONTokener(value).nextValue());
                    v.setTabTextColors(Color.parseColor(array.getString(0)),Color.parseColor(array.getString(1)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "TabIndicatorColor":
                try {
                    v.setSelectedTabIndicatorColor(Color.parseColor(value));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "AddTab":
                try {
                    JSONObject object = (JSONObject) (new JSONTokener(value).nextValue());
                    String icon = object.getString("Icon");
                    String text = object.getString("Text");
                    TabLayout.Tab tab=v.newTab();
                    tab.setText(text);
                    if (!icon.equals("")) {
                        tab.setIcon(Toolkit.file2Drawable(parentController.activity, icon));
                    }
                    v.addTab(tab);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "ViewPager":
                Object o=parentController.viewmap.get(value);
                if (o==null) break;
                FViewPager fViewPager = (FViewPager) o;
                v.setupWithViewPager(fViewPager.v);
                break;
        }
    }
}
