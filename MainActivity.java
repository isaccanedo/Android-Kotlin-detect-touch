import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView

/*
ref: 
https://developer.android.com/training/gestures/detector#capture-touch-events-for-a-single-view
Android Developers Guides > Detect common gestures > Capture touch events for a single view
 */

class MainActivity : AppCompatActivity() {
    private lateinit var ivIcon: ImageView
    private lateinit var tvSysInfo: TextView
    private lateinit var tvSdkInfo: TextView
    private lateinit var tvConsole: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivIcon = findViewById(R.id.icon)
        tvSysInfo = findViewById(R.id.sysinfo)
        tvSdkInfo = findViewById(R.id.sdkinfo)
        tvConsole = findViewById(R.id.console)

        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        val release = Build.VERSION.RELEASE

        val pkgInfo = packageManager.getPackageInfo(packageName, 0)
        val appInfo = pkgInfo.applicationInfo
        val targetSdkVersion = appInfo.targetSdkVersion
        val minSdkVersion = appInfo.minSdkVersion

        tvSysInfo.text = manufacturer + "\n" +
                model + "\n" + "Android: " + release
        tvSdkInfo.text = "targetSdkVersion: " + targetSdkVersion + "\n" +
                "minSdkVersion: " + minSdkVersion

        tvConsole.text = "Android Example:" +
                "\nCapture touch events for a single view"

        ivIcon.setOnTouchListener { v, event -> // ... Respond to touch events
            /*
            return true if the listener has consumed the event, false otherwise.
             */
            val action = event.action
            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    /*
                    Beware of creating a listener that returns false
                    for the ACTION_DOWN event.
                    If you do this, the listener will not be called
                    for the subsequent ACTION_MOVE and ACTION_UP string of events.
                    This is because ACTION_DOWN is the starting point for all touch events.
                     */

                    tvConsole.text = "ACTION_DOWN@ivIcon"

                    true}
                MotionEvent.ACTION_MOVE -> {
                    tvConsole.append("\nACTION_MOVE@ivIcon")
                    true}
                MotionEvent.ACTION_UP -> {
                    tvConsole.text = "ACTION_UP@ivIcon"
                    true}
                MotionEvent.ACTION_CANCEL -> {
                    tvConsole.text = "ACTION_CANCEL@ivIcon"
                    true}
                MotionEvent.ACTION_OUTSIDE -> {
                    tvConsole.text = "ACTION_OUTSIDE@ivIcon"
                    true}
                else -> super.onTouchEvent(event)
            }

        }

        tvSysInfo.setOnTouchListener { v, event -> // ... Respond to touch events

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    tvConsole.text = "ACTION_DOWN@tvSysInfo"
                    true}
                MotionEvent.ACTION_MOVE -> {
                    tvConsole.append("\nACTION_MOVE@tvSysInfo")
                    true}
                MotionEvent.ACTION_UP -> {
                    tvConsole.text = "ACTION_UP@tvSysInfo"
                    true}
                MotionEvent.ACTION_CANCEL -> {
                    tvConsole.text = "ACTION_CANCEL@tvSysInfo"
                    true}
                MotionEvent.ACTION_OUTSIDE -> {
                    tvConsole.text = "ACTION_OUTSIDE@tvSysInfo"
                    true}
                else -> super.onTouchEvent(event)
            }
        }

        tvSdkInfo.setOnTouchListener { v, event -> // ... Respond to touch events

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    tvConsole.text = "ACTION_DOWN@tvSdkInfo"
                    true}
                MotionEvent.ACTION_MOVE -> {
                    tvConsole.append("\nACTION_MOVE@tvSdkInfo")
                    true}
                MotionEvent.ACTION_UP -> {
                    tvConsole.text = "ACTION_UP@tvSdkInfo"
                    true}
                MotionEvent.ACTION_CANCEL -> {
                    tvConsole.text = "ACTION_CANCEL@tvSdkInfo"
                    true}
                MotionEvent.ACTION_OUTSIDE -> {
                    tvConsole.text = "ACTION_OUTSIDE@tvSdkInfo"
                    true}
                else -> super.onTouchEvent(event)
            }
        }
    }
}
