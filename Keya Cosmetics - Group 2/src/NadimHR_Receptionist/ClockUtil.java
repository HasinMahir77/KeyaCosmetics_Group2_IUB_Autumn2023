/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NadimHR_Receptionist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author Nadimul
 */
public class ClockUtil {
    
    private final Label label;

    public ClockUtil(Label label) {
        this.label = label;
        startClock();
    }
    
    public static String getCurrentTimeString() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm:ss a");
        Date now = new Date();
        return timeFormat.format(now);
    }

    private void startClock() {
        Timeline clockTimeline = new Timeline(new KeyFrame(Duration.ZERO, e -> updateClock()), new KeyFrame(Duration.seconds(1)));
        clockTimeline.setCycleCount(Timeline.INDEFINITE);
        clockTimeline.play();
    }

    private void updateClock() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm:ss a");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);

        Date now = new Date();
        String timeString = timeFormat.format(now);
        String dateString = dateFormat.format(now);
        String dayString = dayFormat.format(now);

        label.setText(dayString + ", " + dateString + ", " + timeString);
    }
}
