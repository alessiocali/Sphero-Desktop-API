package se.nicklasgavelin.sphero.command;

public class LocatorCommand extends CommandMessage {

	public LocatorCommand() {
		super(COMMAND_MESSAGE_TYPE.READ_LOCATOR);
	}

}
