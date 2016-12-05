package jcmc;

import java.io.*;

public class DeleteCoverageInformation {
	public static void main(String args[]) {
		String cp = "/home/mdy/workspace/Z_coverage/c_path.txt";
		String tp = "/home/mdy/workspace/Z_coverage/t_path.txt";
		try{
			File cf = new File(cp);
			if(cf.exists()){
				cf.delete();
				System.out.println("c_path.txt deleted successfuly");
			}else{
				System.out.println("already deteleted or no c_path.txt");
			}
			File tf = new File(tp);
			if(tf.exists()){
				tf.delete();
				System.out.println("t_path.txt deleted successfuly");
			}else{
				System.out.println("already deteleted or no t_path.txt");
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}

}
