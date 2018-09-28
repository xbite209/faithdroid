package io.github.gofaith.faithdroid.FViews;

import android.graphics.Color;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import faithdroid.Faithdroid;
import io.github.gofaith.faithdroid.UI.AttrGettable;
import io.github.gofaith.faithdroid.UI.AttrSettable;
import io.github.gofaith.faithdroid.UI.UIController;

public class FCheckBox extends FView implements AttrGettable, AttrSettable {
    private CheckBox v;

    public FCheckBox(UIController controller) {
        parentController = controller;
        v = new CheckBox(parentController.activity);
        view=v;
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
            // ------------------------------------------
            case "Checked":
                return String.valueOf(v.isChecked());
            case "Enabled":
                return String.valueOf(v.isEnabled());
            case "Text":
                return v.getText().toString();
        }
        return "";
    }

    @Override
    public void setAttr(String attr, final String value) {
        if (value==null)
            return;
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
                parseSize(value);
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
            case "Text":
                v.setText(value);
                break;
            case "TextColor":
                try {
                    v.setTextColor(Color.parseColor(value));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "TextSize":
                try {
                    v.setTextSize(dp2pixel(parentController.activity,Float.valueOf(value)));
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case "Enabled":
                if (value.equals("true")) {
                    v.setEnabled(true);
                } else {
                    v.setEnabled(false);
                }
                break;
            case "OnCheckedChangeListener":
                v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Faithdroid.triggerEventHandler(value, String.valueOf(isChecked));
                    }
                });
                break;
        }
    }
}