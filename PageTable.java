
public class PageTable {
	PageTableEntry[] PTE = new PageTableEntry[64];
	
	public PageTableEntry getPTE(int index) {
		return PTE[index];
	}
	public void setPTE(int index, PageTableEntry pte) {
		PTE[index] = pte;
	}
}
