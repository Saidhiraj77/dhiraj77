package com.cts.hms.pac.controller;

import java.io.IOException;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hms.pac.entity.Slots;
import com.cts.hms.pac.service.SlotsService;
import com.itextpdf.text.DocumentException;


@RestController
@CrossOrigin({"http://localhost:4200","*"})
public class SlotsController {
	@Autowired
	private SlotsService ss;
	private Object Slots;
	
	@PostMapping("/Slots")
	public int addSlots(@RequestBody Slots slots)
	{
		
		return ss.create(slots);
	}
	
	@GetMapping("/Slots")
	public List<Slots> getAllSlotss()
	{
		return ss.read();
	}
	
	//@GetMapping("/Slots/{id}")
	//public Slots findSlotsById(@PathVariable Long id)
	///{
	//	return ss.read(id);
	//}
	

	@GetMapping("/Slots/{userName}")
	public Slots findSlotsByUsername(@PathVariable String userName)
	{
		return ss.readbyUsername(userName);
	}
	
//	@GetMapping("/report/slots/{userName}")
//	public Slots findSlotsByUsername(@PathVariable String userName,HttpServletResponse response) throws IOException, DocumentException {
//	//	List<Product> products = repository.findAll();
//
//		Document document = new Document(PageSize.A4, 20, 20, 20, 20);
//
//		ByteArrayOutputStream os = new ByteArrayOutputStream();
//
//		PdfWriter.getInstance(document, os);

//		document.open();
//
//		Paragraph title = new Paragraph(" Information for slots",
//				FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new BaseColor(0, 255, 255)));
//
//		document.add(title);
//
//		PdfPTable table = new PdfPTable(6);
//		table.setSpacingBefore(20);
//		table.setSpacingAfter(20);
//
//		PdfPCell c1 = new PdfPCell(new Phrase("Id"));
//		table.addCell(c1);
//
//		PdfPCell c2 = new PdfPCell(new Phrase("Slot Date"));
//		table.addCell(c2);
//
//		PdfPCell c3 = new PdfPCell(new Phrase("Slot Time"));
//		table.addCell(c3);
//
//		PdfPCell c4 = new PdfPCell(new Phrase("User Name"));
//		table.addCell(c4);
//
//		PdfPCell c5 = new PdfPCell(new Phrase("center name"));
//		table.addCell(c5);
//
//		PdfPCell c6 = new PdfPCell(new Phrase("vaccine type"));
//		table.addCell(c6);
//
//	
//	//		table.addCell(String.valueOf(Slots.getId()));
//	//		table.addCell(String.valueOf(Slots.getSlotDate()));
//	//	table.addCell(Slots.getSlotTime());
//	//	table.addCell(Slots.getUserName());
//	//		table.addCell(Slots.getCenterName());
//	//		table.addCell(String.valueOf(Slots.getVType()));
//	
//
//		document.add(table);
//		
//		document.close();
//
//		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.parseMediaType("application/pdf"));
//	headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//	headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProductPdfReport.pdf");
//		response.setContentType("application/pdf");
		  
    //    String headerKey = "Content-Disposition";
     //   String headerValue = "attachment; filename=users.pdf ";
    //    response.setHeader(headerKey, headerValue);
		//return ss.readbyUsername(userName);
	

//}
	
	
	
	 @GetMapping("/users/export/pdf/{userName}")
	    public void exportToPDF(@PathVariable String userName,HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime=dateFormatter.format(new Date());
	       // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    //    String localDate = sdf.format(new Date(0));
	       // LocalDateTime now = LocalDateTime.now(); 
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=MyReport_"+currentDateTime +".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	      //  List<User> listUsers = service.listAll();
	         Slots slot= ss.readbyUsername(userName);
	        UserPDFExporter exporter = new UserPDFExporter(slot);
	        exporter.export(response);
	         
	    }
	

	

	@PutMapping("/Slots")
	public int modifySlots(@RequestBody Slots slots)
	{
		return ss.update(slots);
	}
	
	@DeleteMapping("/Slots/{id}")
	public int removeSlots(@PathVariable Long id)
	{
		return ss.delete(id);
	}
}

