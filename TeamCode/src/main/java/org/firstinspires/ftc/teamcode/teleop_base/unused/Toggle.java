package org.firstinspires.ftc.teamcode.teleop_base.unused;

public class Toggle {
    private boolean value;

    // If the button is being held, the toggle is locked from changing until the button is let go
    private boolean buttonLock = false;

    public Toggle(boolean initialValue) { this.value = initialValue; }

    public void update(boolean buttonPressed) {
        // Returns true if value has been toggled, false otherwise
        if (buttonPressed) {
            if (!buttonLock) {
                value = !value;
                buttonLock = true;
            }
        } else { buttonLock = false; }
    }
    public boolean value() { return value; }
}
