package week4day1;

import java.io.File;
import java.io.FilenameFilter;

public class IODemo2 {

	public static void main(String[] args) {
		File f = new File("d:/temp");
		
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getName());
		System.out.println(f.exists());
		System.out.println(f.isDirectory());
		System.out.println(f.canWrite());
		
		File dest = new File("D:\\backup\\onlinecourse\\coursesite\\templates\\coursesite");
		
		String s[] = dest.list(new MyFilter("html"));
		
		for(String ss:s) {
			System.out.println(ss);
		}
	}
}


class MyFilter implements FilenameFilter{
	
	String extension;
	public MyFilter(String extension) {
		// TODO Auto-generated constructor stub
		this.extension = extension;
	}
	@Override
	public boolean accept(File dir,String name) {
		return name.endsWith("."+extension);
	}
	
}