package org.firstinspires.ftc.teamcode.teleop_base;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Transport {
    private Servo axonLeft, axonRight, clawServo, gripServoLeft, gripServoRight;
    private TransportPos transportPos;
    private Gamepad gamepad1;
    private Telemetry telemetry;
    private ElapsedTime gripDelay;
    private boolean isGripClosed = false;
    private boolean waitToChangePos = false;
    private TransportPos queuedPosChange = TransportPos.INTAKING;
    private boolean gripButtonLock = false;

    public Transport(HardwareMap hardwareMap, Telemetry telemetry, Gamepad gamepad1) {
        axonLeft = hardwareMap.get(Servo.class, "axonLeft");
        axonRight = hardwareMap.get(Servo.class, "axonRight");
        clawServo = hardwareMap.get(Servo.class, "clawServo");
        gripServoLeft = hardwareMap.get(Servo.class, "gripLeft");
        gripServoRight = hardwareMap.get(Servo.class, "gripRight");

        this.gamepad1 = gamepad1;
        this.telemetry = telemetry;

        gripDelay = new ElapsedTime();
    }

    public void update() {
        if (transportPos == TransportPos.INTAKING) {
            axonLeft.setPosition(0.313);
            axonRight.setPosition(0.313);
            clawServo.setPosition(0.947);

            if (gamepad1.right_bumper) {
                isGripClosed = true;
                changePosAfterDelay(TransportPos.INTAKING);
            } 
        } else if (transportPos == TransportPos.PLACING) {
            axonLeft.setPosition(0.7052);
            axonRight.setPosition(0.7052);
            clawServo.setPosition(0.4);

            if (gamepad1.left_bumper) {
                isGripClosed = false;
                changePosAfterDelay(TransportPos.INTAKING);
            }
        }

        if (isGripClosed) {
            gripServoLeft.setPosition(0.8);
            gripServoRight.setPosition(0.18);
        } else {
            gripServoLeft.setPosition(0.30844);
            gripServoRight.setPosition(0.6609);
        }
        
        if (gamepad1.a && !gripButtonLock) {
            isGripClosed = !isGripClosed;
        }

        updatePos();

        telemetry.addData("Transport Mode: ", transportPos);
        telemetry.addData("Grip Closed: ", isGripClosed);
    }

    public void updatePos() {
        if (waitToChangePos && gripDelay.milliseconds() > 500) {
            transportPos = queuedPosChange;
            waitToChangePos = false;
            gripDelay.reset();
        }
    }

    public void changePosAfterDelay(TransportPos queuedChange) {
        waitToChangePos = true;
        queuedPosChange = queuedChange;
    }

    private enum TransportPos {
        INTAKING, PLACING
    }
}
