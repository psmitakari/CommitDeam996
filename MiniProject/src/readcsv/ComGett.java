package readcsv;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.*;

public class ComGett<bankfileR> {
	
	DataRead bankfileR= new DataRead();
	Scanner sc=new Scanner(System.in);
	void loadData()
	{
		bankfileR.fileLoader();
	}	
	void complaintsBasedOnYear(String year)
	{
		Set<String>st=new HashSet<String>();
		for (HashMap.Entry<String,ComDet> entry :bankfileR.GetMapBankobjcompdet().entrySet()) 
		{
			if(entry.getValue().dateReceived.contains(year))
				  { 
				st.add(entry.getValue().issue);
			  		System.out.println(entry.getValue().issue);
				  }
		}
		for(String i:st) {
			System.out.println(i);
		}
	}
	void complaintsBasedOnCompany(String u_company)
	{
		Set<String>st=new HashSet<String>();
		for (HashMap.Entry<String,ComDet> entry :bankfileR.GetMapBankobjcompdet().entrySet())
	 
	{
	  if(entry.getValue().company.equalsIgnoreCase(u_company))
	  {
		  st.add(entry.getValue().issue + " "+ u_company);
//		  System.out.println(entry.getValue().issue + " "+ u_company);
	  }

	}
		  for(String i:st) {
			  System.out.println(i);
		  }
	}
	void complaintsBasedOnComplaintID(String id)
	{
		if(bankfileR.GetMapBankobjcompdet().containsKey(id)){
			ComDet Complain = bankfileR.GetMapBankobjcompdet().get(id);

			System.out.println( Complain);

		}
		return;
	}
	void NoOfDaysTOCloseComplaint(String compid)
	{
		try {
			if (bankfileR.GetMapBankobjcompdet().containsKey(compid)) {
				ComDet Complain = bankfileR.GetMapBankobjcompdet().get(compid);

				String d1s = Complain.dateSentToCompany;
				String d2s = Complain.dateReceived;
				Date d2 = new SimpleDateFormat("MM/dd/yyyy").parse(d1s);
				Date d1 = new SimpleDateFormat("MM/dd/yyyy").parse(d2s);

				long difference_In_Time
						= d2.getTime() - d1.getTime();
				long difference_In_Days
						= (difference_In_Time
						/ (1000 * 60 * 60 * 24))
						% 365;
				System.out.println(difference_In_Days + "   days");


			}
		}
		catch (Exception e){
			System.out.println(e);
		}

	}
	void complaintsClosed()
	{
	for (HashMap.Entry<String,ComDet> entry :bankfileR.GetMapBankobjcompdet().entrySet()) 
	{
		String compResp=entry.getValue().companyResponseToConsumer;
		
	  if(compResp.equalsIgnoreCase("Closed") || compResp.equalsIgnoreCase("Closed with explanation"))
	  {
		  System.out.println(entry.getValue().dateReceived + " "+ entry.getValue().product+" "+entry.getValue().subProduct+" "+entry.getValue().issue+" "+entry.getValue().subIssue+" "+entry.getValue().company+" "+entry.getValue().ZIPcode+" "+entry.getValue().state+" "+entry.getValue().submittedVia+" "+entry.getValue().dateSentToCompany+" "+entry.getValue().companyResponseToConsumer+" "+entry.getValue().timelyResponse+" "+entry.getValue().consumerDisputed);
	  }

	}

	}
	void complaintsReceivingTimelyResponse()
	{
	for (HashMap.Entry<String,ComDet> entry :bankfileR.GetMapBankobjcompdet().entrySet()) 
	{
		if(entry.getValue().timelyResponse.equals("Yes"))
		{
			System.out.println(entry.getValue().dateReceived + " "+ entry.getValue().product+" "+entry.getValue().subProduct+" "+entry.getValue().issue+" "+entry.getValue().subIssue+" "+entry.getValue().company+" "+entry.getValue().ZIPcode+" "+entry.getValue().state+" "+entry.getValue().submittedVia+" "+entry.getValue().dateSentToCompany+" "+entry.getValue().companyResponseToConsumer+" "+entry.getValue().timelyResponse+" ");
		}
	}
	}
	void add() throws FileNotFoundException {
		try(PrintWriter writer = new PrintWriter("C:\\Users\\Pratiksha\\Documents\\complaints.csv")){
			StringBuilder sb = new StringBuilder();
			sb.append("Date Received");
			sb.append(',');
			sb.append("Product");
			sb.append(',');
			sb.append("Sub Product");
			sb.append(',');
			sb.append("Issuse");
			sb.append(',');
			sb.append("Sub Issuse");
			sb.append(',');
			sb.append("Company");
			sb.append(',');
			sb.append("State");
			sb.append(',');
			sb.append("ZIP code");
			sb.append(',');
			sb.append("Submitted");
			sb.append(',');
			sb.append("Datesent");
			sb.append(',');
			sb.append("CompanyRes");
			sb.append(',');
			sb.append("Timely");
			sb.append(',');
			sb.append("Customer");
			sb.append(',');
			sb.append("Complt");
			sb.append('\n');
			sb.append("10/10/2000");
			sb.append(',');
			sb.append("444");
			sb.append('\n');
			
			writer.write(sb.toString());
			System.out.println("Done!");
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public ComGett() {
		super();
	}

}
