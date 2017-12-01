package se.nicklasgavelin.sphero.response.regular;

import se.nicklasgavelin.log.Logging;
import se.nicklasgavelin.sphero.response.ResponseMessage;

public class LocatorResponse extends ResponseMessage {
	
	private static final int PAYLOAD_LENGTH = 10;
	private static final int LOC_X_INDEX = 0, LOC_Y_INDEX = 2, LOC_XS_INDEX = 4,
							 LOC_YS_INDEX = 6, LOC_SOG_INDEX = 8;

	private byte[] rawData;
	private int x = 0;
	private int xs = 0;
	private int y = 0;
	private int ys = 0;
	private int sog = 0;
	
	public LocatorResponse(ResponseHeader _drh) {
		super(_drh);
		if (!isCorrupt()) {
			rawData = this.getPacketPayload();
			if (rawData.length < PAYLOAD_LENGTH) { Logging.error("Invalid IMU data length"); }
			else {
				x = bytesToInt(rawData[LOC_X_INDEX], rawData[LOC_X_INDEX + 1]);
				y = bytesToInt(rawData[LOC_Y_INDEX], rawData[LOC_Y_INDEX + 1]);
				xs = bytesToInt(rawData[LOC_XS_INDEX], rawData[LOC_XS_INDEX + 1]);
				ys = bytesToInt(rawData[LOC_YS_INDEX], rawData[LOC_YS_INDEX + 1]);
				sog = bytesToInt(rawData[LOC_SOG_INDEX], rawData[LOC_SOG_INDEX + 1]);
			}
		}
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getXS() { return xs; }
	public int getYS() { return ys; }
	public int getSog() { return sog; }
	public byte[] getRaw() { return rawData; }
	
	private int bytesToInt(byte b1, byte b2) {
		int r = 0;
		r |= b1; r = r << 8;
		return r | b2;
	}
}
