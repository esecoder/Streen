package com.streen.android.dialog;


import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.streen.android.R;
import com.streen.android.dialog.dialogplus.DialogPlus;
import com.streen.android.dialog.dialogplus.OnClickListener;
import com.streen.android.dialog.dialogplus.OnDismissListener;
import com.streen.android.dialog.dialogplus.ViewHolder;
import com.streen.android.util.network.HotspotListener;
import com.streen.android.util.network.HotspotManager;

/**
 * Class for helper dialog methods utilizing DialogPlus library
 */
public class CommonDialogs {

    /**
     * Shows a non cancellable generic message dialog
     *
     * @param context    Context
     * @param header     dialog header/title
     * @param body       dialog body/message
     * @param buttonText dialog button text
     * @param listener   the listener to handle clicks
     */
    public static void nonCancellableMessageDialog(Context context, String header, @NonNull String body, String buttonText,
                                                   OnClickListener listener) {
        DialogPlus dialog = DialogPlus.newDialog(context)
                .setContentHolder(new ViewHolder(R.layout.message_dialog))
                .setGravity(Gravity.CENTER)
                .setCancelable(false)
                .setOnClickListener(listener)
                .create();
        TextView textView = (TextView) dialog.findViewById(R.id.title);
        if (header == null) {
            textView.setText(context.getResources().getString(R.string.notice));
        } else {
            textView.setText(header);
        }
        TextView textView1 = (TextView) dialog.findViewById(R.id.message);
        textView1.setText(body);

        Button button = (Button) dialog.findViewById(R.id.dismiss);
        if (buttonText != null)
            button.setText(buttonText);
        dialog.show();
    }


    /*public static DialogPlus nonCancellableProgressDialog(Context context, OnDismissListener dismissListener) {
        DialogPlus dialog = DialogPlus.newDialog(context)
                .setContentHolder(new ViewHolder(R.layout.progress_dialog))
                .setGravity(Gravity.CENTER)
                .setCancelable(false)
                .setOnClickListener(null)
                .setOnDismissListener(dismissListener)
                .create();
        dialog.show();

        return dialog;
    }*/

    /**
     * Shows a cancellable generic message dialog
     *
     * @param context    Context
     * @param header     dialog header/title
     * @param body       dialog body/message
     * @param buttonText dialog button text
     * @param listener   the listener to handle clicks
     */
    public static void cancellableMessageDialog(Context context, int header, @NonNull int body, int buttonText, OnClickListener listener) {
        DialogPlus dialog = DialogPlus.newDialog(context)
                .setContentHolder(new ViewHolder(R.layout.message_dialog))
                .setGravity(Gravity.CENTER)
                .setCancelable(true)
                .setOnClickListener(listener == null ? new OnClickListener() {
                    @Override
                    public void onClick(DialogPlus dialog, View view) {
                        if (view.getId() == R.id.dismiss)
                            dialog.dismiss();
                    }
                } : listener)
                .create();
        TextView textView = (TextView) dialog.findViewById(R.id.title);
        if (header == 0)
            textView.setText(context.getResources().getString(R.string.notice));
        else
            textView.setText(context.getString(header));

        TextView textView1 = (TextView) dialog.findViewById(R.id.message);
        textView1.setText(context.getString(body));

        Button button = (Button) dialog.findViewById(R.id.dismiss);
        if (buttonText != 0)
            button.setText(context.getString(buttonText));

        dialog.show();
    }

    /**
     * Shows a cancellable generic message dialog
     *
     * @param context    Context
     * @param header     dialog header/title
     * @param body       dialog body/message
     * @param buttonText dialog button text
     * @param listener   the listener to handle clicks
     */
    public static void cancellableMessageDialog(Context context, int header, @NonNull String body, int buttonText, OnClickListener listener) {
        DialogPlus dialog = DialogPlus.newDialog(context)
                .setContentHolder(new ViewHolder(R.layout.message_dialog))
                .setGravity(Gravity.CENTER)
                .setCancelable(true)
                .setOnClickListener(listener == null ? new OnClickListener() {
                    @Override
                    public void onClick(DialogPlus dialog, View view) {
                        if (view.getId() == R.id.dismiss)
                            dialog.dismiss();
                    }
                } : listener)
                .create();
        TextView textView = (TextView) dialog.findViewById(R.id.title);
        if (header == 0)
            textView.setText(context.getResources().getString(R.string.notice));
        else
            textView.setText(context.getString(header));

        TextView textView1 = (TextView) dialog.findViewById(R.id.message);
        textView1.setText(body);

        Button button = (Button) dialog.findViewById(R.id.dismiss);
        if (buttonText != 0)
            button.setText(context.getString(buttonText));

        dialog.show();
    }

    /**
     * Shows the setup dialog for various streaming socket connection setups
     * @param context
     * @param listener
     * @param dismissListener
     */
    public static void setupDialog(Context context, OnClickListener listener, OnDismissListener dismissListener) {
        DialogPlus dialog = DialogPlus.newDialog(context)
                .setContentHolder(new ViewHolder(R.layout.setup_dialog))
                .setGravity(Gravity.CENTER)
                .setCancelable(true)
                .setOnClickListener(listener)
                .setOnDismissListener(dismissListener)
                .create();

        TextView textView = (TextView) dialog.findViewById(R.id.setup_status_text);
        ProgressBar progressBar = (ProgressBar) dialog.findViewById(R.id.progress_bar);
        TextView textView1 = (TextView) dialog.findViewById(R.id.title_1);
        TextView textView2 = (TextView) dialog.findViewById(R.id.message_1);
        TextView textView3 = (TextView) dialog.findViewById(R.id.title_2);
        TextView textView4 = (TextView) dialog.findViewById(R.id.message_2);
        TextView textView5 = (TextView) dialog.findViewById(R.id.error_message);

        Button button1 = (Button) dialog.findViewById(R.id.switch_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO check what setup is in progress from streaming service
            }
        });
        Button button2 = (Button) dialog.findViewById(R.id.switch_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO check what setup is in progress from streaming service
            }
        });
        Button button3 = (Button) dialog.findViewById(R.id.switch_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO check what setup is in progress from streaming service
            }
        });

        //Start hotspot network by default
        HotspotManager.startAccessPoint(new HotspotListener() {

        });

        dialog.show();
    }

}
