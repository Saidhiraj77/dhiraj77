package com.cts.hms.pac.controller;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;

import com.cts.hms.pac.entity.Slots;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
 
 
public class UserPDFExporter {
   //private Slots listUsers;
   Slots slot =new Slots();
     
    public UserPDFExporter(Slots slot) {
        this.slot = slot;
   }
 
    private void writeTable(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
       cell.setBackgroundColor(Color.green);
        cell.setPadding(2);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.red);
        cell.setPhrase(new Phrase("User ID", font)); 
     
         //table.addCell("id");
      
        table.addCell(cell);
        
        
        cell.setPhrase(new Phrase("Slot Date", font));
        table.addCell(String.valueOf(slot.getId()));
        table.addCell(cell); 
         
        cell.setPhrase(new Phrase("Slot Time", font));
        table.addCell(String.valueOf(slot.getSlotDate()));
       table.addCell(cell);
         
        cell.setPhrase(new Phrase("User Name", font));
        table.addCell(slot.getSlotTime());
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Center Name", font));
        table.addCell(slot.getUserName()); 
        table.addCell(cell);  
        
        cell.setPhrase(new Phrase("Vaccine Type", font));
        table.addCell(slot.getCenterName());
        
        table.addCell(cell); 
       
        cell.setPhrase(new Phrase("Aadhar Number", font));
        
      table.addCell(slot.getVType());
      table.addCell(cell); 
      table.addCell(String.valueOf(slot.getAadharNumber()));
      
    }
     
  // private void writeTableData(PdfPTable table) {
        //for (User user : listUsers) {
           
	  // table.addCell(slot.getVType());
	 
	  
	   
        
           
        
    //  }
 //   }
      
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.green);
         
        Paragraph p = new Paragraph("Your Vaccine Slot Confirmation Report", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 2.5f});
        table.setSpacingBefore(40);
         
        writeTable(table);
       // writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
