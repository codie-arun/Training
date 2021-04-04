package filebuilders;

public class Main {

	public static void main(String[] args) throws Exception{
		
//		FileBuilder f = new ExcelFileBuilder();
//		f.buildFile("bill");
		FileBuilder f = new PdfFileBuilder();
		f.buildFile("bill");
	}
	
}
