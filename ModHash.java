

/**
 * ModHash
 *
 */
public class ModHash {
	long a;
	long b;
	int m;
	long p;
	
	public ModHash(long a, long b, int m, long p) {
		this.a = a;
		this.b = b;
		this.m = m;
		this.p = p;
	}
	
	public static ModHash GetFunc(int m, long p){
		long a = abGenrator(1,p);
		long b = abGenrator(0,p);
		ModHash hashFunc = new ModHash(a, b, m, p);
		return hashFunc;
	}
	
	public int Hash(long key) {
		int ans = (int) Math.floorMod(Math.floorMod((this.a*key) + this.b, this.p), m);
		return ans;
	}
	
	public int DHash(long key) {
		int ans = (int) (Math.floorMod(Math.floorMod((this.a*key) + this.b, this.p), m-1) + 1);
		return ans;
	}
	
	public static long abGenrator(long leftLimit, long rightLimit) {
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	    return generatedLong;
	}

}
