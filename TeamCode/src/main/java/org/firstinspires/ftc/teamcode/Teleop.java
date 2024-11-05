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
        //Left Motor
        DcMotor l_motor = hardwareMap.get(DcMotor.class,"l_motor");
        //Right Motor
        DcMotor r_motor = hardwareMap.get(DcMotor.class,"r_motor");
        //Arm Motor
        DcMotor a_motor = hardwareMap.get(DcMotor.class,"A_motor"):
        //Code to reverse Motor direction
        //l_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        //r_motor.setDirection(DcMotorSimple.Direction.REVERSE);

        int p1 = 0;
        int p2 = 0;

        waitForStart();
        while (opModeIsActive()) {
            //setting joystick values
            //Left value
            double ly = gamepad1.left_stick_y;
            //Right value
            double rx = gamepad1.right_stick_x;
            //Motor speed Joystick use
            l_motor.setPower(ly + rx);
            r_motor.setPower(ly - rx);


            if (gamepad1.a) {
                a_motor.setTargetPosition(p1);
                a_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                a_motor.setPower(1);
            }
            else if (gamepad1.y) {
                    a_motor.setTargetPosition(p2);
                    a_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    a_motor.setPower(-1);
                }
                else{
                    a_motor.setPower(0);
                }
            }
        }
    }
}
