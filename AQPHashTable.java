/**
 * AQPHashTable
 *
 */



public class AQPHashTable extends OAHashTable {
	ModHash hashFunc;
	
	
	public AQPHashTable(int m, long p) {
		super(m);
		hashFunc = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return Math.floorMod(hashFunc.Hash(x) + (int)Math.pow(-1, i)*(int)Math.pow(i, 2),this.table.length);
	}
}
