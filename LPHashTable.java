/**
 * LPHashTable
 *
 */

public class LPHashTable extends OAHashTable {
	ModHash hashFunc;
	
	public LPHashTable(int m, long p) {
		super(m);
		hashFunc = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return Math.floorMod(hashFunc.Hash(x) + i,this.table.length);
	}
	
}
