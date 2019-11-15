import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static PageTable[] ProcessTable = new PageTable[9];
	static int num;
	static int Access = 0;
	static int Hits = 0;
	static int Miss = 0;
	static int Compulsory_Misses = 0;
	static Memory memory = new Memory();
	static PageTable PT = new PageTable();
	static PageTableEntry PTE = new PageTableEntry();
	
	
	
	public static void  main(String[] args) {
		String Filename = "Input.txt";
		String a = "new";
		String b = "switch";
		String c = "access";
		Scanner s;
		try {
			s = new Scanner(new File(Filename));
			while(s.hasNextLine()) {
				String str = s.nextLine();
				String[] kuang = str.split(" ");
				if(kuang[0].equals(a)) {
					num = Integer.parseInt(kuang[1]);
					ProcessTable[num] = new PageTable();
				}else if(kuang[0].equals(b)) {
					int z = Integer.parseInt(kuang[1]);
					num = z;
				}else if(kuang[0].equals(c)) {
					int i = Integer.parseInt(kuang[1]);
					i = i >> 10;
					//System.out.println(i);
					if(ProcessTable[num].getPTE(i) != null) {
						
						if(ProcessTable[num].getPTE(i).isinmemory() == false) {
							Miss++;
							Access++;
							memory.FindPageFrame(ProcessTable[num].getPTE(i));
							//Page[num].getPTE(i).setinmemory(true);
						} else {
							Hits++;
							Access++;
						}
					} else {
						Miss++;
						Compulsory_Misses++;
						Access++;
						//Set the PTE Here.
						ProcessTable[num].setPTE(i, new PageTableEntry());
						memory.FindPageFrame(ProcessTable[num].getPTE(i));
						
						
						
					}
				}
				
			}
			System.out.println("Accesses: " + Access);
			System.out.println("Hits: " + Hits);
			System.out.println("Miss: " + Miss);
			System.out.println("Compulsory Misses: " + Compulsory_Misses);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
