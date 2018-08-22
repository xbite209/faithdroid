package io.github.gofaith.faithdroid.UI;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Space;

import java.util.HashMap;

import faithdroid.Activity;
import faithdroid.Faithdroid;
import faithdroid.MainActivity;
import faithdroid.UIInterface;
import io.github.gofaith.faithdroid.FViews.FButton;
import io.github.gofaith.faithdroid.FViews.FLinearLayout;
import io.github.gofaith.faithdroid.FViews.FTextView;
import io.github.gofaith.faithdroid.FViews.FView;

public class UIController implements UIInterface {
    public AppCompatActivity activity;
    public Activity factivity;
    public HashMap<String, FView> viewmap = new HashMap<>();
    public FrameLayout rootView;
    public UIController(AppCompatActivity a, FrameLayout main_ctn) {
        this.activity=a;
        this.rootView =main_ctn;
    }

    @Override
    public String getPkg() {
        return activity.getPackageName();
    }

    @Override
    public void newView(String vName, String vID) {
        FView v = null;
        switch (vName) {
            case "LinearLayout":
                FLinearLayout fLinearLayout = new FLinearLayout(this);
                v=fLinearLayout;
                viewmap.put(vID, fLinearLayout);
                break;
            case "TextView":
                FTextView textView = new FTextView(this);
                v=textView;
                viewmap.put(vID , textView);
                break;
            case "Button":
                FButton button = new FButton(this);
                v=button;
                viewmap.put(vID, button);
                break;
        }
        v.className =vName;
        v.vID=vID;
        viewmap.put(vID, v);
    }

    @Override
    public void runOnUIThread(final String s) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Faithdroid.triggerEventHandler(s,"");
            }
        });
    }

    @Override
    public String viewGetAttr(String vID, String attr) {
        FView v = viewmap.get(vID);
        return ((AttrGettable) v).getAttr(attr);
    }

    @Override
    public void viewSetAttr(String vID, String attr, String value) {
        FView v = viewmap.get(vID);
        ((AttrSettable)(v)).setAttr(attr,value);
    }

    @Override
    public void showOnRootView(String vID) {
        FView v = viewmap.get(vID);
        rootView.addView(v.view);
    }

    public void setFViewBackground(FView v, String value) {
    }
}