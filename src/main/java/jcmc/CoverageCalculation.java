package jcmc;

import java.io.*;
import java.util.*;

public class CoverageCalculation {
	public static void main (String args[]) throws Exception {
		String cover_file_path = "/home/mdy/workspace/Z_coverage/c_path.txt";
		String total_file_path = "/home/mdy/workspace/Z_coverage/t_path.txt";
		BufferedReader bf_c = new BufferedReader (new FileReader(cover_file_path));
		BufferedReader bf_t = new BufferedReader (new FileReader(total_file_path));
		Set<String> c1_set = new HashSet<String>();
		Set<String> t_set = new HashSet<String>();
		for (String c_line = bf_c.readLine(); c_line != null; c_line = bf_c.readLine()) {
			c1_set.add(c_line);
		}
		for (String t_line = bf_t.readLine(); t_line != null; t_line = bf_t.readLine()) {
			t_set.add(t_line);
		}
		
		Set<String> c_set = new HashSet<String>();
		for (String c1 : c1_set) {
			if (t_set.contains(c1)) {
				c_set.add(c1);
			}
		}
		
		for (String c : c_set) {
			System.out.println("cover "+c);
		}
		for (String t : t_set) {
			System.out.println("total "+t);
		}
		Set<String> comple = new HashSet<String>();
		comple.clear();
		comple.addAll(t_set);
		comple.removeAll(c_set);
		for (String cp : comple) {
			System.out.println("uncover :"+cp);
		}
		double s_coverage = (c_set.size()*100)/(t_set.size());
		System.out.println("Coverage: "+c_set.size()+"/"+t_set.size()+"="+s_coverage+"%");
		bf_c.close();
		bf_t.close();
	}

}
