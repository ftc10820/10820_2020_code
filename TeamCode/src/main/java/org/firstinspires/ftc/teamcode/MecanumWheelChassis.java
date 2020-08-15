package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class MecanumWheelChassis extends LinearOpMode {

    //drive motors
    private DcMotor drive1;
    private DcMotor drive2;
    private DcMotor drive3;
    private DcMotor drive4;

    @Override 
    public void runOpMode() {

            initializeRobot()

        waitForStart();


        while (opModeIsActive()) {

            //mecanum wheel drive
            

            if (gamepad1.right_stick_x) {
                
                drive1.setPower(-0.5);
                drive2.setPower(0.5);
                drive3.setPower(-0.5);
                drive4.setPower(0.5);

            } else if (-gamepad1.right_stick_x) {

                drive1.setPower(0.5);
                drive2.setPower(-0.5);
                drive3.setPower(0.5);
                drive4.setPower(-0.5);

            } else if (gamepad1.left_stick_x) {

                drive1.setPower(-0.5);
                drive2.setPower(0.5);
                drive3.setPower(-0.5);
                drive4.setPower(0.5);

            } else if (-gamepad1.right_stick_x) {

                drive1.setPower(0.5);
                drive2.setPower(-0.5);
                drive3.setPower(0.5);
                drive4.setPower(-0.5);

            } else {
        
                drive1.setPower(gamepad1.left_stick_y);
                drive2.setPower(gamepad1.left_stick_y);
                drive3.setPower(gamepad1.right_stick_y);
                drive4.setPower(gamepad1.right_stick_y);

            }


        }

    } 

}


private void initializeRobot() {
    //hardware maps of drive motors
    drive1 = hardwareMap.dcMotor.get("drive1");
    drive2 = hardwareMap.dcMotor.get("drive2");
    drive3 = hardwareMap.dcMotor.get("drive3");
    drive4 = hardwareMap.dcMotor.get("drive4");

    //direction of motors
    drive1.setDirection(DcMotor.Direction.FORWARD);
    drive2.setDirection(DcMotor.Direction.REVERSE);
    drive3.setDirection(DcMotor.Direction.FORWARD);
    drive4.setDirection(DcMotor.Direction.REVERSE);

}

