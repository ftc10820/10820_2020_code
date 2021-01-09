/*
Copyright 2020 FIRST Tech Challenge Team FTC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@TeleOp

public class DragonTest extends LinearOpMode {
    
    //motors
    private DcMotor drive1;
    private DcMotor drive2;
    private DcMotor drive3;
    private DcMotor drive4;
    private DcMotor intake;
    private DcMotor shooter1;
    private DcMotor shooter2;
    private DcMotor wafflemotor;
    private CRServo intakemotor;

    
    //servos
    private Servo waffle1;
    private Servo waffle2;
    
    @Override
    public void runOpMode() {
        
        
        initializeRobot();
        
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
            
            //this one works
            //wafflemotor.setPower(gamepad1.left_trigger * 0.25);
            //wafflemotor.setPower(gamepad1.right_trigger * -0.25);
            
            
         /* boolean wafflemotorForward = false;
         boolean wafflemotorBackward = false;
         boolean wafflemotorOff = false;
         
         if (gamepad1.right_trigger < 0.5){
             wafflemotorForward = true;
         } else{
             wafflemotorForward = false;
         }
         
            if (wafflemotorForward = true){
          wafflemotor.setPower(gamepad1.right_trigger * -1);
             }
             
         if (gamepad1.left_trigger < 0.5){
             wafflemotorBackward = true;
         } else{
             wafflemotorBackward = false;
         }
            if (wafflemotorBackward = true){
             wafflemotor.setPower(gamepad1.left_trigger * 1);
            
             
        } if (wafflemotorForward != true && wafflemotorBackward != true){
            wafflemotorOff = true;
            }
            if (wafflemotorOff = true){
             wafflemotor.setPower(0);
             } */
              
        //setting wafflemotor (trying to format floats) WILL try to convert floats to booleans later if have time
           if (gamepad1.dpad_down){
               
            wafflemotor.setPower(0.7);
            
           } else if (gamepad1.dpad_up){
               
            wafflemotor.setPower(-0.7);
            
           } else if (gamepad1.dpad_left){
               
                wafflemotor.setPower(0);
           }
            
            if (gamepad2.dpad_up){
                
            intakemotor.setPower(1);
            
           } else if (gamepad2.dpad_left){
               
                intakemotor.setPower(0);
                
           } 
            
            
            if (gamepad2.x) {
                
                intake.setPower(1);

            } else if (gamepad2.y) {
                
                shooter1.setPower(-0.75);
                shooter2.setPower(0.75);

            } else if (gamepad2.b){
                shooter1.setPower(0);
                shooter2.setPower(0);

            } else if (gamepad2.a) {
                
                intake.setPower(0);
                
            }
            
            
            if (gamepad1.a) {
                
                waffle1.setPosition(1);
                waffle2.setPosition(-1);
                telemetry.addData("wafflestatus", "closed");
                telemetry.update();
                
            } else if (gamepad1.y) {
                
                waffle1.setPosition(-1);
                waffle2.setPosition(1);
                telemetry.addData("wafflestatus", "open");
                telemetry.update();
                
            } else {
                
                waffle1.setPosition(0.5);
                waffle2.setPosition(0.5);
                telemetry.addData("wafflestatus", "grabbed");
                telemetry.update();
                
            }
            
            
            if (gamepad1.right_bumper) {
                
            // go right
            drive1.setPower(1);
            drive2.setPower(-1);
            drive3.setPower(-1);
            drive4.setPower(1);
                
            } else if (gamepad1.left_bumper) {
                
            // go left
            drive1.setPower(-1);
            drive2.setPower(1);
            drive3.setPower(1);
            drive4.setPower(-1);
                
            } else {
                    
            drive1.setPower(gamepad1.left_stick_y);
            drive2.setPower(gamepad1.left_stick_y);
            drive3.setPower(gamepad1.right_stick_y);
            drive4.setPower(gamepad1.right_stick_y);
                
            }
            
            
            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }
    
       
        private void initializeRobot() {
    
        //hardware maps of motors
        drive1 = hardwareMap.dcMotor.get("drive1");
        drive2 = hardwareMap.dcMotor.get("drive2");
        drive3 = hardwareMap.dcMotor.get("drive3");
        drive4 = hardwareMap.dcMotor.get("drive4");
        intake = hardwareMap.dcMotor.get("intake");
        shooter1 = hardwareMap.dcMotor.get("shooter1");
        shooter2 = hardwareMap.dcMotor.get("shooter2");
        wafflemotor = hardwareMap.dcMotor.get("wafflemotor");
        intakemotor = hardwareMap.get(CRServo.class, "intakemotor");

    
        //hardware maps of servos

        waffle1 = hardwareMap.servo.get("waffle1");
        waffle2 = hardwareMap.servo.get("waffle2");
    
        //directions
        drive1.setDirection(DcMotor.Direction.REVERSE);
        drive2.setDirection(DcMotor.Direction.REVERSE);
        drive3.setDirection(DcMotor.Direction.FORWARD);
        drive4.setDirection(DcMotor.Direction.FORWARD);
        intake.setDirection(DcMotor.Direction.FORWARD);
        shooter1.setDirection(DcMotor.Direction.FORWARD);
        shooter2.setDirection(DcMotor.Direction.REVERSE);
        wafflemotor.setDirection(DcMotor.Direction.FORWARD);
        intakemotor.setDirection(CRServo.Direction.FORWARD);

        
        telemetry.addData("Status", "Initialized");
        telemetry.update();

    }
}
