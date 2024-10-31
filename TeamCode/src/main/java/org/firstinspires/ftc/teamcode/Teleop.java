package org.firstinspires.ftc.teamcode;


import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.sun.tools.javac.comp.Resolve;

@TeleOp
public class Teleop extends LinearOpMode{

    @Override
    public void runOpMode() {
        DcMotor l_motor = hardwareMap.get(DcMotor.class,"l_motor");
        DcMotor r_motor = hardwareMap.get(DcMotor.class,"r_motor");

        //l_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        //r_motor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()){
            //setting joystick values
            //Left value
            double ly = gamepad1.left_stick_y;
            //Right value
            double rx = gamepad1.right_stick_x;

            //Motor speed Joystick use
            l_motor.setPower(ly + rx);
            r_motor.setPower(ly - rx);
        }
    }
}
