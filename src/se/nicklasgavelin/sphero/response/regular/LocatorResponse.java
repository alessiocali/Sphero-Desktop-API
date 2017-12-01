package se.nicklasgavelin.sphero.response.regular;

import se.nicklasgavelin.sphero.response.ResponseMessage;

public class LocatorResponse extends ResponseMessage {

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
			if (rawData.length < 10) { System.err.println("Invalid IMU data length"); }
			else {
				x = bytesToInt(rawData[0], rawData[1]);
				y = bytesToInt(rawData[2], rawData[3]);
				xs = bytesToInt(rawData[4], rawData[5]);
				ys = bytesToInt(rawData[6], rawData[7]);
				sog = bytesToInt(rawData[8], rawData[9]);
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
