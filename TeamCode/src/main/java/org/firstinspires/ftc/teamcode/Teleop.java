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
        DcMotor a_motor = hardwareMap.get(DcMotor.class,"a_motor");
        //Pivot Motors
        DcMotor lp_motor = hardwareMap.get(DcMotor.class,"lp_motor");
        DcMotor rp_motor = hardwareMap.get(DcMotor.class,"rp_motor")
        //Code to reverse Motor direction
        //l_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        //r_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        //lp_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        //rp_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        //Postion for linear extension
        int p1 = 0;
        int p2 = 0;
        //Postion for Pivot
        int pos_up = 0;
        int pos_stright = 0;
        int pos_down = 0:
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

            //Arm extension
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
            //Pivot?
            if (gamepad1.dpad_up){
                lp_motor.setTargetPosition(pos_up);
                lp_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                lp_motor.setPower(1);
            }
            else if (gamepad1.dpad_left){
                lp_motor.setTargetPosition(pos_stright);
                lp_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                lp_motor.setPower(1);
            }
            else if (gamepad1.dpad_down){
                lp_motor.setTargetPosition(pos_down);
                lp_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                lp_motor.setPower(-1);
            }
            else{
                lp_motor.setPower(0);
                rp_motor.setPower(0);
            }
        }
    }
}
