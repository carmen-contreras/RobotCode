package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.Backwards;
import frc.robot.commands.Forwards;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer  
{
  public Command forwards;
  public Command backwards;

    // Driver Controller
    public Joystick joy = new Joystick(0);
    public JoystickButton a_button = new JoystickButton(joy, 1);
    public JoystickButton b_button = new JoystickButton(joy, 2);
    public JoystickButton x_button = new JoystickButton(joy, 3);
    public JoystickButton y_button = new JoystickButton(joy, 4);
    public JoystickButton l_bump = new JoystickButton(joy, 5);
    public JoystickButton r_bump = new JoystickButton(joy, 6);
    public JoystickButton left_menu = new JoystickButton(joy, 7);
    public JoystickButton right_menu = new JoystickButton(joy, 8);
    public JoystickButton left_stick = new JoystickButton(joy, 9);
    public JoystickButton right_stick = new JoystickButton(joy, 10);

    public POVButton povUp = new POVButton(joy, 0, 0);
    public POVButton povRight = new POVButton(joy, 90, 0);
    public POVButton povDown = new POVButton(joy, 180, 0);
    public POVButton povLeft = new POVButton(joy, 270, 0); 

    public RobotContainer() 
    {

      forwards = new Forwards();
      backwards = new Backwards();

      configureButtonBindings();
      
    };

    private void configureButtonBindings() 
    {
      this.y_button.onTrue(forwards);
      this.y_button.onFalse(new InstantCommand(){
        public void initialize()
        {
          forwards.cancel();
        }
      });
     
     
      this.a_button.onTrue(backwards);
      this.a_button.onFalse(new InstantCommand() {
        public void initialize()
        {
          backwards.cancel();
        }   
       });
    }
}
