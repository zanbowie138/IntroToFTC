package org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw extends SubsystemBase {
    private Servo leftServo;
    private Servo rightServo;

    enum ClawPos {
        GRAB,
        WAIT,
        IDLE,
        DEPOSIT
    }

    private final double LEFT_OPEN_POSITION = 0.5;
    private final double RIGHT_OPEN_POSITION = 0.5;
    private final double LEFT_CLOSE_POSITION = 0;
    private final double RIGHT_CLOSE_POSITION = 1;;

    public Claw(HardwareMap hMap){
        leftServo = hMap.get(Servo.class, "gripLeft");
        rightServo = hMap.get(Servo.class, "gripRight");
    }

    public void openLeft(){
        leftServo.setPosition(LEFT_OPEN_POSITION);
    }

    public void openRight(){
        rightServo.setPosition(RIGHT_OPEN_POSITION);
    }

    public void close(){
        leftServo.setPosition(LEFT_CLOSE_POSITION);
        rightServo.setPosition(RIGHT_CLOSE_POSITION);
    }


}
