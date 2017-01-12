package application;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface Constants {
	
	int NUM_SKILLS = 3;
	String[] SKILL_NAMES = {"search","cook","fight"};
	
	int INIT_SURV = 10;
	int INIT_RATIONS = 2 * INIT_SURV;
	int INIT_WEAPONS = 0;
	int	INIT_UNC = 10;

	int POS_FINDS = 4;

	/**
	 * uncooked -> ration ratio
	 */
	int UNC_RAT = 4;



	Function<Integer,int[]> identity = e ->{
		int[] res = new int[e];
		for (int i = 0; i < res.length; i++) {
			res[i]=0;
		}
		return res;
	};

	BiFunction<int[],int[],int[]> addArrays = (a, b) -> {
		int[] res = new int[4];
		for (int i = 0; i < a.length; i++) {
			res[i]=a[i]+b[i];
		}
		return res;
	};

	BiFunction<Integer,Integer,Integer> min = (a,b) ->{
	    return a<b?a:b;
    };

}
