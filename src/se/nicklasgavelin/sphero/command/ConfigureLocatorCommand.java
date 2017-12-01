package se.nicklasgavelin.sphero.command;

public class ConfigureLocatorCommand extends CommandMessage {

	private byte flags;
	private short x, y, yawTare;
	
	
	public ConfigureLocatorCommand(boolean autoCorrect, short x, short y, short yaw) {
		super(COMMAND_MESSAGE_TYPE.CONFIGURE_LOCATOR);
		
		flags = 0;
		if (autoCorrect) { flags |= 1; }
		
		this.x = x;
		this.y = y;
		this.yawTare = yaw;
	}
	
	@Override
	public byte[] getPacketData() {
		byte data[] = new byte[7];
		
		data[0] = flags;
		data[1] = (byte) (x >> 8);
		data[2] = (byte) x;
		data[3] = (byte) (y >> 8);
		data[4] = (byte) y;
		data[5] = (byte) (yawTare >> 8);
		data[6] = (byte) yawTare;
		
		return data;
	}

}
