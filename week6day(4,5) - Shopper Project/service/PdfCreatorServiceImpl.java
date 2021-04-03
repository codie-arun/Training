package service;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public class PdfCreatorServiceImpl implements PdfCreatorService{

	Properties prop;
	private static PdfCreatorServiceImpl pdfCreatorServiceImpl;
	
		
	
	public PdfCreatorServiceImpl(Properties prop) {
		
		this.prop = prop;
	}
	
	public static PdfCreatorServiceImpl getPdfCreatorServiceImpl(Properties prop) {
		if(pdfCreatorServiceImpl == null) {
			pdfCreatorServiceImpl = new PdfCreatorServiceImpl(prop);
			return pdfCreatorServiceImpl;
		}else {
			return pdfCreatorServiceImpl.getClone();
		}
	}
	
	public PdfCreatorServiceImpl getClone() {
		try {
			return (PdfCreatorServiceImpl)super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
		
	private static String FILE = "D:/temp/shoppeebill.pdf";
	  
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    
    ArrayList<ArrayList<String>> xmlobj;

    public  void generatePdf(String path) throws Exception{
    	
    	SaxXmlParser parser = new SaxXmlParser();
    	this.xmlobj = parser.parse(path);
    	
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            //addTitlePage(document);
            addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }

    

    private  void addContent(Document document) throws DocumentException {
    	
    	Paragraph p;
    	
        Anchor anchor = new Anchor("XML TO PDF", catFont);
        anchor.setName("XML TO PDF");

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor),1);

        Paragraph subPara = new Paragraph("Bill Invoice", catFont);
        Section subCatPart = catPart.addSection(subPara);

//        subPara = new Paragraph("Subcategory 2", subFont);
//        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Bill No : "+xmlobj.get(0).get(0)));
        subCatPart.add(new Paragraph("Bill Date : "+xmlobj.get(0).get(1)));
        subCatPart.add(new Paragraph("Customer Name : "+xmlobj.get(0).get(2)));
        p = new Paragraph("---------------------------------------------------------------------------------------------------");
        p.setAlignment(Paragraph.ALIGN_CENTER);
        subCatPart.add(p);
        
        String gst = xmlobj.get(0).get(3);
        String total = xmlobj.get(0).get(4);
        // add a list
//        createList(subCatPart);
//       Paragraph paragraph = new Paragraph();
//       addEmptyLine(paragraph, 5);
//        subCatPart.add(paragraph);

        // add a table
        xmlobj.remove(0);
        createTable(subCatPart);
        
        p = new Paragraph("GST : "+gst);
        subCatPart.add(p);
        p = new Paragraph("TOTAL : "+total+" /-");
        p.setAlignment(Paragraph.ALIGN_RIGHT);
        subCatPart.add(p);
        
        // now add all this to the document
        document.add(catPart);

//        // Next section
//        anchor = new Anchor("Second Chapter", catFont);
//        anchor.setName("Second Chapter");
//
//        // Second parameter is the number of the chapter
//        catPart = new Chapter(new Paragraph(anchor), 1);
//
//        subPara = new Paragraph("Subcategory", subFont);
//        subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("This is a very important message"));
//
//        // now add all this to the document
//        document.add(catPart);

    }

    private void createTable(Section subCatPart)
            throws BadElementException {
        PdfPTable table = new PdfPTable(6);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);

        PdfPCell c1 = new PdfPCell(new Phrase("Sl.No"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Item No"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Name"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Price"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Quantity"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Amount"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        
        int slno = 1;
        
        for(ArrayList<String> item: xmlobj) {
        	table.addCell(""+slno++);
        	for(String i:item) {
        		table.addCell(i);
        	}
        }
        
        
       

        subCatPart.add(table);

    }

    private static void createList(Section subCatPart) {
        List list = new List(true, false, 10);
        list.add(new ListItem("First point"));
        list.add(new ListItem("Second point"));
        list.add(new ListItem("Third point"));
        subCatPart.add(list);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}


