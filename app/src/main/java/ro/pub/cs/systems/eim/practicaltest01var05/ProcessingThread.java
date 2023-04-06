package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.StringTokenizer;

public class ProcessingThread extends Thread{

    final public static String ACTION_STRING = "ro.pub.cs.systems.eim.lab05.startedservice.string";
    final public static String DATA = "ro.pub.cs.systems.eim.lab05.startedservice.data";

    final public static long SLEEP_TIME = 5000;

    private Context context = null;
    private boolean isRunning = true;

    String text;

    public ProcessingThread(Context context, String text) {
        this.context = context;
        this.text = text;
    }

    @Override
    public void run() {


        Log.d("[Started Service Activity]", "Thread has started! PID: " + android.os.Process.myPid() + " TID: " + android.os.Process.myTid());
        while (isRunning) {
            StringTokenizer st = new StringTokenizer(text, " ,");
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                switch (str) {
                    case "Top right":
                        sendMessage("Top right");
                        break;
                    case "Top left":
                        sendMessage("Top left");
                        break;
                    case "Bottom right":
                        sendMessage("Bottom right");
                        break;
                    case "Bottom left":
                        sendMessage("Bottom left");
                        break;
                    case "Center":
                        sendMessage("Center");
                        break;
                }
                sleep();
            }
        }
    }

    private void sendMessage(String messageType) {
        Intent intent = new Intent();

        intent.setAction(ACTION_STRING);
        intent.putExtra(DATA, messageType);

        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
