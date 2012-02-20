package site.nicklas.sphero.command;

import site.nicklas.sphero.util.Value;

/**
 * A command to modify the brightness of the front LED on the Sphero robot.
 * The brightness must be set to 0-1
 * 
 * @author Nicklas Gavelin
 */
public class FrontLEDCommand extends DeviceCommand
{
    private float brightness = 0;

    /**
     * Create a front LED command to modify the brightness of the LED on 
     * the Sphero robot
     * 
     * @param brightness The new brightness
     */
    public FrontLEDCommand( float brightness )
    {
        super( DEVICE_COMMAND.FRONT_LED_OUTPUT );
        this.brightness = ( float ) Value.clamp( brightness, 0.0D, 1.0D );
    }

    /**
     * Returns the front LED brightness set in the command
     * 
     * @return The brightness value
     */
    public float getBrightness()
    {
        return this.brightness;
    }

    /**
     * Update the brightness for LED in the command
     * 
     * @param brightness The new brightness
     */
    public void setBrightness( float brightness )
    {
        this.brightness = brightness;
    }


    @Override
    public byte[] getPacketData()
    {
        byte[] data = new byte[ 1 ];
        data[0] = ( byte ) ( int ) (255.0D * this.brightness);

        return data;
    }
}
