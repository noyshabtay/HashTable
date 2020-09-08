/**
 * OAHashTable
 *
 */
public abstract class OAHashTable implements IHashTable {
	private static final HashTableElement DELETED = new HashTableElement(0,0);
	protected HashTableElement [] table;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		for (int i=0; i < this.table.length; i++) {
			int j = Hash(key, i);
			if (this.table[j] == null)
				return null;
			else if (this.table[j] == DELETED)
				continue;
			else if (this.table[j].GetKey() == key)
				return this.table[j];
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		HashTableElement x = Find(hte.GetKey());
		if (x != null)
			throw new IHashTable.KeyAlreadyExistsException(hte);
		for (int i=0; i < this.table.length; i++) {
			int j = Hash(hte.GetKey(), i);
			if (this.table[j] == null || this.table[j] == DELETED) {
				this.table[j] = hte;
				return;
			}
		}
		throw new IHashTable.TableIsFullException(hte);
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		int j;
		for (int i = 0; i < table.length; i++) {
			j = Hash(key, i);
			if (this.table[j] == null)
				throw new IHashTable.KeyDoesntExistException(key);
			else if (this.table[j] == DELETED)
				continue;
			else if (this.table[j].GetKey() == key) {
				this.table[j] = DELETED;
				return;
			}
		}
		throw new IHashTable.KeyDoesntExistException(key);
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
