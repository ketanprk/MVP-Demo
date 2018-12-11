package assignment.ketan.com.assignmentketan.utiities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import assignment.ketan.com.assignmentketan.R;

import static android.view.View.VISIBLE;

public class AppUtils {
    public static ProgressDialog createProgressDialog(Context mContext, String title, String message) {

        ProgressDialog progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage(message);
        progressDialog.setTitle(title);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        return progressDialog;
    }

    public static Dialog showAlertDialog(Context mContext, String message, String positiveButtonText, String negativeButtonText, View.OnClickListener positiveButtonListener, View.OnClickListener negativeButtonListener) {

        final Dialog alertDialog = new Dialog(mContext);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(R.layout.alert_custom_dialog);
        TextView tv_dialog_text = (TextView) alertDialog.findViewById(R.id.tv_dialog_text);
        TextView alert_button_yes = (TextView) alertDialog.findViewById(R.id.alert_button_yes);
        TextView alert_button_no = (TextView) alertDialog.findViewById(R.id.alert_button_no);
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);

        tv_dialog_text.setText(message);
        alert_button_yes.setText(positiveButtonText);
        alert_button_no.setText(negativeButtonText);
        if (TextUtils.isEmpty(positiveButtonText))
            alert_button_yes.setVisibility(View.GONE);
        else
            alert_button_yes.setVisibility(VISIBLE);
        if (negativeButtonListener != null)
            alert_button_no.setOnClickListener(negativeButtonListener);
        if (positiveButtonListener != null && alert_button_yes.getVisibility() != View.GONE)
            alert_button_yes.setOnClickListener(positiveButtonListener);


        alertDialog.show();

        return alertDialog;
    }
}
