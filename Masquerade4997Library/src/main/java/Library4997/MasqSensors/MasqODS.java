package Library4997.MasqSensors;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.firstinspires.ftc.robotcontroller.internal.FtcOpModeRegister;

import Library4997.MasqHardware;
import Library4997.MasqSensor;

/**
 * Created by Archish on 10/28/16.
 */

public class MasqODS implements MasqSensor, MasqHardware {
    private OpticalDistanceSensor ods;
    private String nameODSSensor;

    public MasqODS(String name, HardwareMap hardwareMap){
        this.nameODSSensor = name;
        ods = hardwareMap.opticalDistanceSensor.get(name);
    }
    public void enableLED() {
        ods.enableLed(true);
    }
    public void disableLED() {
        ods.enableLed(false);
    }
    public double lightDetected () {
        return ods.getLightDetected();
    }
    public double rawLight () {
        return ods.getRawLightDetected();
    }
    public boolean isWhite () {
        return lightDetected() <= ODS_WHITE;
    }
    public boolean isBlack () {
        return lightDetected() >= ODS_BLACK;
    }
    public String getName() {
        return nameODSSensor;
    }
    public String[] getDash() {
        return new String[]{
                "Light Detected" + Double.toString(lightDetected()),
                "is Black:" + Boolean.toString(isBlack()),
                "IS White:" + Boolean.toString(isWhite())
        };
    }

    @Override
    public boolean stop() {
        return !isWhite();
    }
}
