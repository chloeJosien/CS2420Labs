package lab08;

public class BetterRandomNumberGenerator implements RandomNumberGenerator {
	
	private long previous;
	private long multiplier, increment;
	
	private static final long mask =(1L<< 48)-1;
	@Override
	public int nextInt(int max) {
		
		long value = (multiplier*previous+increment) & mask;
		previous = value;
		return (int)(value%max);
	}

	@Override
	public void setSeed(long seed) {
		previous = seed;
	}

	@Override
	public void setConstants(long multiplier, long increment) {
		this.multiplier = multiplier;
		this.increment = increment;
	}
}
