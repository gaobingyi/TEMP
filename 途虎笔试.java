import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Sheep {
	int age = 0;
}

public class Solution {	
	/*
	 * 第n年后羊的数量
	 */
	public static int numOfSheep(int n) {
		List<Sheep> sheeps = new CopyOnWriteArrayList<>();
		sheeps.add(new Sheep());
		for (int i = 1; i <= n; i++) {
			Iterator<Sheep> it = sheeps.iterator();
			while (it.hasNext()) {
				Sheep sheep = it.next();
				sheep.age++;
				if (sheep.age == 2 || sheep.age == 4)
					sheeps.add(new Sheep());
				if (sheep.age == 5)
					sheeps.remove(sheep);
			}
		}
		return sheeps.size();
	}
	
	public static int numOfSheep2(int n) {
		int num = 1; // the initial sheep number
		for (int i = 1; i <= n; i++){
		    if (i == 2) {
			num += numOfSheep2(n - 2);
		    } else if (i == 4){
			num += numOfSheep2(n - 4);
		    } else if (i == 5){
			num--;
		    }
		}
		return num;
	}
}
