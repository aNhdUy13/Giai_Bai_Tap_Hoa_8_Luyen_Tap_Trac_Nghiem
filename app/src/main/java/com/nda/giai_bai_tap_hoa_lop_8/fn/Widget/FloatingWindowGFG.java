package com.nda.giai_bai_tap_hoa_lop_8.fn.Widget;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.nda.giai_bai_tap_hoa_lop_8.MainActivity;
import com.nda.giai_bai_tap_hoa_lop_8.R;

public class FloatingWindowGFG extends Service {
    private ViewGroup floatView;

    private int LAYOUT_TYPE;
    private WindowManager.LayoutParams floatWindowLayoutParam;
    private WindowManager windowManager;
    private ImageView img_closeWidget;
    String title, question, result;
    Bundle bundle;
    TextView txt_title, txt_task_question, txt_task_result;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {


        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // The screen height and width are calculated, cause
        // the height and width of the floating window is set depending on this
        DisplayMetrics metrics = getApplicationContext().getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        // To obtain a WindowManager of a different Display,
        // we need a Context for that display, so WINDOW_SERVICE is used
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        // A LayoutInflater instance is created to retrieve the
        // LayoutInflater for the floating_layout xml
        LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

        // inflate a new view hierarchy from the floating_layout xml
        floatView = (ViewGroup) inflater.inflate(R.layout.layout_floating_widget, null);

        img_closeWidget = floatView.findViewById(R.id.img_closeWidget);
        txt_title               = floatView.findViewById(R.id.txt_title);
        txt_task_question       = floatView.findViewById(R.id.txt_task_question);
        txt_task_result         = floatView.findViewById(R.id.txt_task_result);





        // WindowManager.LayoutParams takes a lot of parameters to set the
        // the parameters of the layout. One of them is Layout_type.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // If API Level is more than 26, we need TYPE_APPLICATION_OVERLAY
            LAYOUT_TYPE = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            // If API Level is lesser than 26, then we can
            // use TYPE_SYSTEM_ERROR,
            // TYPE_SYSTEM_OVERLAY, TYPE_PHONE, TYPE_PRIORITY_PHONE.
            // But these are all
            // deprecated in API 26 and later. Here TYPE_TOAST works best.
            LAYOUT_TYPE = WindowManager.LayoutParams.TYPE_TOAST;
        }

        // Now the Parameter of the floating-window layout is set.
        // 1) The Width of the window will be 55% of the phone width.
        // 2) The Height of the window will be 58% of the phone height.
        // 3) Layout_Type is already set.
        // 4) Next Parameter is Window_Flag. Here FLAG_NOT_FOCUSABLE is used. But
        // problem with this flag is key inputs can't be given to the EditText.
        // This problem is solved later.
        // 5) Next parameter is Layout_Format. System chooses a format that supports
        // translucency by PixelFormat.TRANSLUCENT
        floatWindowLayoutParam = new WindowManager.LayoutParams(
                (int) (width * (0.60f)),
                (int) (height * (0.50f)),
                LAYOUT_TYPE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );

        // The Gravity of the Floating Window is set.
        // The Window will appear in the center of the screen
        floatWindowLayoutParam.gravity = Gravity.CENTER;

        // X and Y value of the window is set
        floatWindowLayoutParam.x = 0;
        floatWindowLayoutParam.y = 0;

        // The ViewGroup that inflates the floating_layout.xml is
        // added to the WindowManager with all the parameters
        windowManager.addView(floatView, floatWindowLayoutParam);


        // The button that helps to maximize the app
        img_closeWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // stopSelf() method is used to stop the service if
                // it was previously started
                stopSelf();

                // The window is removed from the screen
                windowManager.removeView(floatView);


                // The app will maximize again. So the MainActivity
                // class will be called again.
                Intent backToHome = new Intent(FloatingWindowGFG.this, MainActivity.class);

                // 1) FLAG_ACTIVITY_NEW_TASK flag helps activity to start a new task on the history stack.
                // If a task is already running like the floating window service, a new activity will not be started.
                // Instead the task will be brought back to the front just like the MainActivity here
                // 2) FLAG_ACTIVITY_CLEAR_TASK can be used in the conjunction with FLAG_ACTIVITY_NEW_TASK. This flag will
                // kill the existing task first and then new activity is started.
                backToHome.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(backToHome);
            }
        });

        // Another feature of the floating window is, the window is movable.
        // The window can be moved at any position on the screen.
        floatView.setOnTouchListener(new View.OnTouchListener() {
            final WindowManager.LayoutParams floatWindowLayoutUpdateParam = floatWindowLayoutParam;
            double x;
            double y;
            double px;
            double py;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    // When the window will be touched,
                    // the x and y position of that position
                    // will be retrieved
                    case MotionEvent.ACTION_DOWN:
                        x = floatWindowLayoutUpdateParam.x;
                        y = floatWindowLayoutUpdateParam.y;

                        // returns the original raw X
                        // coordinate of this event
                        px = event.getRawX();

                        // returns the original raw Y
                        // coordinate of this event
                        py = event.getRawY();
                        break;
                    // When the window will be dragged around,
                    // it will update the x, y of the Window Layout Parameter
                    case MotionEvent.ACTION_MOVE:
                        floatWindowLayoutUpdateParam.x = (int) ((x + event.getRawX()) - px);
                        floatWindowLayoutUpdateParam.y = (int) ((y + event.getRawY()) - py);

                        // updated parameter is applied to the WindowManager
                        windowManager.updateViewLayout(floatView, floatWindowLayoutUpdateParam);
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getExtras() != null)
        {

            title = intent.getStringExtra("title");
            question = intent.getStringExtra("question");
            result = intent.getStringExtra("result");

            txt_title.setText(title);
            txt_task_question.setText(question);
            txt_task_result.setText(result);

        }
        return START_STICKY;
    }

    // It is called when stopService()
    // method is called in MainActivity
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
        // Window is removed from the screen
        windowManager.removeView(floatView);
    }

}
