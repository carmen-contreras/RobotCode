package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Wheels extends SubsystemBase {
    
    public enum LeftWheelMotorState
    {
        ON,
        OFF,
        REVERSED
    }

    public enum RightWheelMotorState
    {
        ON,
        OFF,
        REVERSED
    }

    public CANSparkMax LeftWheelMotor = new CANSparkMax(Constants.Wheels.leftWheelMotor, MotorType.kBrushless);
    public CANSparkMax RightWheelMotor = new CANSparkMax(Constants.Wheels.rightWheelMotor, MotorType.kBrushless);
    
    public DigitalInput WheelLimitSwitch = new DigitalInput(Constants.DIO.WheelLimitSwitch);

    public LeftWheelMotorState leftWheelMotor = LeftWheelMotorState.OFF;
    public RightWheelMotorState rightWheelMotor = RightWheelMotorState.OFF;

    public Wheels()
    {
        this.LeftWheelMotor.setIdleMode(IdleMode.kBrake);
        this.RightWheelMotor.setIdleMode(IdleMode.kBrake);

        this.LeftWheelMotor.setSmartCurrentLimit(40);
        this.RightWheelMotor.setSmartCurrentLimit(40);
    }

    public void setLeftWheelMotorState(LeftWheelMotorState state)
    {
        this.leftWheelMotor = state;

        switch(state)
        {
            case ON:
                this.LeftWheelMotor.set(Constants.Wheels.WheelForwardSpeed);
                break;
            case OFF:
                this.LeftWheelMotor.set(0.0);
                break;
            case REVERSED:
                this.LeftWheelMotor.set(Constants.Wheels.WheelBackwardsSpeed);
                break;
            default:
                this.setLeftWheelMotorState(LeftWheelMotorState.OFF);
        }
    }

    public void setRightWheelMotorState(RightWheelMotorState state)
    {
        this.rightWheelMotor = state;

        switch(state)
        {
            case ON:
                this.RightWheelMotor.set(Constants.Wheels.WheelForwardSpeed);
                break;
            case OFF:
                this.RightWheelMotor.set(0.0);
                break;
            case REVERSED:
                this.RightWheelMotor.set(Constants.Wheels.WheelBackwardsSpeed);
                break;
            default:
                this.setRightWheelMotorState(RightWheelMotorState.OFF);
        }
    }

    public double getLeftWheelMotorPosition()
    {
        return this.LeftWheelMotor.getEncoder().getPosition();
    }

    public double getRightWheelMotorPosition()
    {
        return this.RightWheelMotor.getEncoder().getPosition();
    }

    public boolean getWheelSwitch()
    {
        return this.WheelLimitSwitch.get();
    }
}
