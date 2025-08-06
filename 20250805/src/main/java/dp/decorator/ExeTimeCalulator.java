package dp.decorator;

public class ExeTimeCalulator implements Calculator{

	private Calculator delegate;
	
	public ExeTimeCalulator(Calculator delegate) {
		super();
		this.delegate = delegate;
	}



	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		
		long result = delegate.factorial(num);
		
		long stop = System.nanoTime();
		System.out.println((stop - start) + "나노초");
		return result;
	}

	

}
