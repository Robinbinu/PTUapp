package com.robin.fragments;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class WebShotService extends Service {
    private WebView webView;
    private WindowManager winManager;

    public int onStartCommand(Intent intent, int flags, int startId) {
        winManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        webView = new WebView(this);
        webView.setVerticalScrollBarEnabled(false);
        webView.setWebViewClient(client);

        final WindowManager.LayoutParams params =
                new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        PixelFormat.TRANSLUCENT);
        params.x = 0;
        params.y = 0;
        params.width = 0;
        params.height = 0;

        final FrameLayout frame = new FrameLayout(this);
        frame.addView(webView);
        winManager.addView(frame, params);

        webView.loadUrl("https://www.ptuniv.edu.in/");

        return START_STICKY;
    }

    private final WebViewClient client = new WebViewClient() {
        public void onPageFinished(WebView view, String url) {
            final Point p = new Point();
            winManager.getDefaultDisplay().getSize(p);

            webView.measure(View.MeasureSpec.makeMeasureSpec((p.x < p.y ? p.y : p.x),
                            View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec((p.x < p.y ? p.x : p.y),
                            View.MeasureSpec.EXACTLY));
            webView.layout(0, 0, webView.getMeasuredWidth(), webView.getMeasuredHeight());

            webView.postDelayed(capture, 1000);
        }
    };

    private final Runnable capture = new Runnable() {
        @Override
        public void run() {
            try {
                final Bitmap bmp = Bitmap.createBitmap(webView.getWidth(),
                        webView.getHeight(), Bitmap.Config.ARGB_8888);
                final Canvas c = new Canvas(bmp);
                webView.draw(c);

                updateWidgets(bmp);
            }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            stopSelf();
        }
    };

    private void updateWidgets(Bitmap bmp) {
        final AppWidgetManager widgetManager = AppWidgetManager.getInstance(this);
        final int[] ids = widgetManager.getAppWidgetIds(
                new ComponentName(this, WebWidgetProvider.class));

        if (ids.length < 1) {
            return;
        }

        final RemoteViews views = new RemoteViews(getPackageName(), R.layout.widget_layout);
        views.setImageViewBitmap(R.id.widget_image, bmp);
        widgetManager.updateAppWidget(ids, views);

        Toast.makeText(this, "WebWidget Update", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}