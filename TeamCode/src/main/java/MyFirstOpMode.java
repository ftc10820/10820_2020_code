package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class MyFirstOpMode extends LinearOpMode {

    private DcMotor dragon1;
    private DcMotor dragon2;
    private DcMotor dragon3;
    private DcMotor dragon4;

    private Servo arm1;

    @Override
    public void runOpMode() {

        dragon1 = hardwareMap.get(DcMotor.class, "dragon1");
        dragon2 = hardwareMap.get(DcMotor.class, "dragon2");
        dragon3 = hardwareMap.get(DcMotor.class, "dragon3");
        dragon4 = hardwareMap.get(DcMotor.class, "dragon4");

        telemetry.addData("Status" , "Initialized");
        waitForStart();


        while (opModeIsActive()) {
            telemetry.addData("Status" ,"Runnning");
            telemetry.update();

            if (gamepad1.right_stick_y){
                dragon1.setPower(1);
                dragon3.setPower(1);

            } elif (-gamepad1.right_stick_y) {
                dragon1.setPower(-1);
                dragon3.setPower(-1);
            } else {
                dragon1.setPower(0);
                dragon3.setPower(0);
            }

            if (gamepad1.left_stick_y) {
                dragon2.setPower(1);
                dragon4.setPower(1);

            } elif (-gamepad1.left_stick_y) {
                dragon2.setPoer(-1);
                dragon4,setPower(-1);

            } else {
                dragon2.setPower(0);
                dragon4.setPower(0);
            }

            if (gamepad1.y) {
                arm1.setPosition(1);

            } elif (gamepad1.a) {
                arm1.setPosition(0);

            } else {
                arm1.setPosition(0.5);
            }
 




        }
    }


}
