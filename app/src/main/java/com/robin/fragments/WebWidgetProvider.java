package com.robin.fragments;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class WebWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // We can't trust the appWidgetIds param here, as we're using
        // ACTION_APPWIDGET_UPDATE to trigger our own updates, and
        // Widgets might've been removed/added since the alarm was last set.
        final int[] currentIds = appWidgetManager.getAppWidgetIds(
                new ComponentName(context, WebWidgetProvider.class));

        if (currentIds.length < 1) {
            return;
        }

        // We attach the current Widget IDs to the alarm Intent to ensure its
        // broadcast is correctly routed to onUpdate() when our AppWidgetProvider
        // next receives it.
        Intent iWidget = new Intent(context, WebWidgetProvider.class)
                .setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE)
                .putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, currentIds);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, iWidget, 0);

        ((AlarmManager) context.getSystemService(Context.ALARM_SERVICE))
                .setExact(AlarmManager.RTC, System.currentTimeMillis() + 30000, pi);

        Intent iService = new Intent(context, WebShotService.class);
        context.startService(iService);
    }
}
