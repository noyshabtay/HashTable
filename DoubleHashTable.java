/**
 * DoubleHashTable
 *
 */


public class DoubleHashTable extends OAHashTable {
	ModHash hashFunc1;
	ModHash hashFunc2;
	
	
	public DoubleHashTable(int m, long p) {
		super(m);
		hashFunc1 = ModHash.GetFunc(m, p);
		hashFunc2 = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return Math.floorMod(hashFunc1.Hash(x) + (i*hashFunc2.DHash(x)), this.table.length);
	}
	
}
