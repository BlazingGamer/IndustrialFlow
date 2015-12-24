package cf.blazegamer.mctoontown;

public class TTMCStreet extends TTMCArea {
	private TTMCArea to;
	private TTMCArea from;
	private int min;
	private int max;
	private int sb;
	private int cb;
	private int lb;
	private int bb;
	private boolean returnable;
	private String name;

	public TTMCStreet(TTMCArea from, TTMCArea to, int min, int max, int sbpercent, int cbpercent, int lbpercent, int bbpercent, String name, boolean returnable) {
		// TODO Auto-generated constructor stub
	}
	
	public int getChanceSB() {
		return this.sb;
	}
	
	public int getChanceCB() {
		return this.cb;
	}
	
	public int getChanceLB() {
		return this.lb;
	}
	
	public int getChanceBB() {
		return this.bb;
	}
}
