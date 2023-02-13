package com.example.pushnot

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val TAG = "Service"

//        val data = remoteMessage.data
        val title = remoteMessage.notification!!.title
        val message = remoteMessage.notification!!.body
//        val action = data.get("action") as String
        Log.i(TAG, "onMessageReceived: title : $title")
        Log.i(TAG, "onMessageReceived: message : $message")
//        Log.i(TAG, "onMessageReceived: action : $action")

        //val intent = Intent(this, NextActivity::class.java)

        val CHANNEL_ID = "MYCHANNEL"
        val notificationChannel =
            NotificationChannel(CHANNEL_ID, "name", NotificationManager.IMPORTANCE_HIGH)

//        val pendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
//            addNextIntentWithParentStack(intent)
//            getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)
//        }


        val mBuilder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext)
            .setContentTitle(title)
            .setContentText(message)
           // .setContentIntent(pendingIntent)
           // .addAction(R.drawable.sym_action_chat,"Title",pendingIntent)
            .setChannelId(CHANNEL_ID)
            .setSmallIcon(R.drawable.sym_action_chat)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel);
        notificationManager.notify(0, mBuilder.build())
    }
//    with(NotificationManagerCompat.from(this)) {
//        notify(NOTIFICATION_ID, builder.build())

}
















































//
//val mBuilder: NotificationCompat.Builder = NotificationCompat.Builder(context)
//    .setSmallIcon(R.drawable.your_notification_icon)
//    .setContentTitle("Notification Title")
//    .setContentText("Notification ")
//    .setContentIntent(pendingIntent)
//
//val notificationManager = getSystemService(FirebaseMessagingService.NOTIFICATION_SERVICE) as NotificationManager
//notificationManager.notify(0, mBuilder.build())

//        val CHANNEL_ID = "MYCHANNEL"
//        val notification: Notification = NotificationCompat.Builder(this,CHANNEL_ID)
//            .setContentTitle(title)
//            .setContentText(message)
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//            .build()
//        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.notify(1,notification)
//        val notificationManager = getSystemService<Any>(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.createNotificationChannel(notificationChannel)
//        notificationManager.notify(1, notification)

//        val notificationManager =
//            getSystemService<Any>(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.createNotificationChannel(notificationChannel)
//        notificationManager.notify(1, notification)

//        val notification: Notification = NotificationCompat.Builder(this)
//            .setContentTitle(remoteMessage.notification!!.title)
//            .setContentText(remoteMessage.notification!!.body)
//            .build()


//        val CHANNEL_ID = "MYCHANNEL"
//        val notificationChannel =
//            NotificationChannel(CHANNEL_ID, "name", NotificationManager.IMPORTANCE_LOW)
//        val pendingIntent = PendingIntent.getActivity(applicationContext, 1, intent, 0)
//        val notification = Notification.Builder(
//            applicationContext, CHANNEL_ID
//        )
//            .setContentText("Heading")
//            .setContentTitle("subheading")
//            .setContentIntent(pendingIntent)
//            .addAction(R.drawable.sym_action_chat, "Title", pendingIntent)
//            .setChannelId(CHANNEL_ID)
//            .setSmallIcon(R.drawable.sym_action_chat)
//            .build()
//
//        val notificationManager =
//            getSystemService<Any>(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.createNotificationChannel(notificationChannel)
//        notificationManager.notify(1, notification)



//        super.onMessageReceived(remoteMessage)
//
//        val notification: Notification = NotificationCompat.Builder(this)
//            .setContentTitle(remoteMessage.notification!!.title)
//            .setContentText(remoteMessage.notification!!.body)
//            .build()
//        val manager = NotificationManagerCompat.from(applicationContext)
//        manager.notify(123, notification)
  //  }
//}
//    val TAG = "Service"
//
//    override fun onMessageReceived(message: RemoteMessage) {
//
//        super.onMessageReceived(message)
//        handleMessage(message)
//
//        Log.d(TAG, "From: " + message!!.from)
//        Log.d(TAG, "Notification Message Body: " + message.notification?.body!!)
//    }
//
//    private fun handleMessage(message: RemoteMessage) {
//
//        val handler = Handler(Looper.getMainLooper())
//        handler.post(Runnable
//        {
//            Toast.makeText(baseContext, getString(R.string.handle_notification_now),
//                Toast.LENGTH_LONG).show()
//        })
//    }
//}



//    override fun onMessageReceived(remoteMessage: RemoteMessage) {
//        // ...
//
//        // TODO(developer): Handle FCM messages here.
//        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
//        Log.d(TAG, "From: ${remoteMessage.from}")
//
//        // Check if message contains a data payload.
//        if (remoteMessage.data.isNotEmpty()) {
//            Log.d(TAG, "Message data payload: ${remoteMessage.data}")
//
//            if (/* Check if data needs to be processed by long running job */ true) {
//                // For long-running tasks (10 seconds or more) use WorkManager.
//                scheduleJob()
//            } else {
//                // Handle message within 10 seconds
//                handleNow()
//            }
//        }
//
//        // Check if message contains a notification payload.
//        remoteMessage.notification?.let {
//            Log.d(TAG, "Message Notification Body: ${it.body}")
//        }
//
//    }
