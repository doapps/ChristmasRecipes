package me.doapps.christmasrecipes.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import me.doapps.christmasrecipes.R;
import me.doapps.christmasrecipes.utils.UtilFonts;

/**
 * Created by jonathan on 29/11/2014.
 */
public class Dialog_Internet extends AlertDialog {
    public Dialog_Internet(Context context) {
        super(context);
        initDialog();
    }

    protected Dialog_Internet(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initDialog();
    }

    protected Dialog_Internet(Context context, int theme) {
        super(context, theme);
        initDialog();
    }

    private void initDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.dialog_internet, null);
        setView(view);

        setCancelable(true);

        TextView txt_message = (TextView) view.findViewById(R.id.txt_message);
        txt_message.setTypeface(UtilFonts.setHelveticaThin(getContext()));
    }
}
