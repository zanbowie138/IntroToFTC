package org.firstinspires.ftc.teamcode.teleop_ftclib.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm extends SubsystemBase {
    private Servo leftArmServo;
    private Servo rightArmServo;
    private Servo rotateServo;

    private final double LEFT_GRAB = 0.5;
    private final double RIGHT_GRAB = 0.5;
    private final double LEFT_WAIT = 0.5;
    private final double RIGHT_WAIT = 0.5;
    private final double LEFT_DEPOSIT = 0.5;
    private final double RIGHT_DEPOSIT = 0.5;
    private final double CLAW_GRIP_ROTATION = 0;
    private final double CLAW_WAIT_ROTATION = 0.5;
    private final double CLAW_IDLE_ROTATION = 1;
    private final double CLAW_DEPOSIT_ROTATION = 0.25;

    public Arm(HardwareMap hMap){
        leftArmServo = hMap.get(Servo.class, "axonLeft");
        rightArmServo = hMap.get(Servo.class, "axonRight");
        rotateServo = hMap.get(Servo.class, "clawServo");
    }

    public void grab(){
        leftArmServo.setPosition(LEFT_GRAB);
        rightArmServo.setPosition(RIGHT_GRAB);
        rotateServo.setPosition(CLAW_GRIP_ROTATION);
    }

    public void idle(){
        leftArmServo.setPosition(LEFT_WAIT);
        rightArmServo.setPosition(RIGHT_WAIT);
        rotateServo.setPosition(CLAW_WAIT_ROTATION);
    }

    public void deposit(){
        leftArmServo.setPosition(LEFT_DEPOSIT);
        rightArmServo.setPosition(RIGHT_DEPOSIT);
        rotateServo.setPosition(CLAW_DEPOSIT_ROTATION);
    }


}
