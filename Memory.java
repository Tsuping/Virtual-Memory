
public class Memory {
	private static PageTableEntry[] Pte = new PageTableEntry[30];
	private int frame = 0;
	public void FindPageFrame( PageTableEntry epte) {
		if(Pte[frame] != null) {
			Pte[frame].setinmemory(false);
		} 
		Pte[frame] = epte;
		Pte[frame].setinmemory(true);
		frame++;
		if(frame >= 30) {
			frame -= 30;
		}
	}
	

}
