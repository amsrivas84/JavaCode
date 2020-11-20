package com.amrita.java.ObjClone;

public class ShallowCopy {
 int i;
 
	@Override
public String toString() {
	return "ShallowCopy [i=" + i + "]";
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ShallowCopy sc = new ShallowCopy();
		sc.i= 40;
		System.out.println(sc.toString());
		ShallowCopy sc1=sc;
		sc1.i=50;
		System.out.println(sc1.toString());
		System.out.println(sc.toString());
		
		
	}

}
