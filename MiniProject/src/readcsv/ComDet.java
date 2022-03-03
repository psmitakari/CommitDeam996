package readcsv;

public class ComDet {

	String dateReceived;
	String product;
	String subProduct;
	String issue;
	String subIssue;
	String company;
	String state;
	String ZIPcode;
	String submittedVia;
	String dateSentToCompany;
	String companyResponseToConsumer;
	String timelyResponse;
	String consumerDisputed;

	@Override
	public String toString() {
		return "" +
				"dateReceived='" + dateReceived + '\'' +
				", product='" + product + '\'' +
				", subProduct='" + subProduct + '\'' +
				", issue='" + issue + '\'' +
				", subIssue='" + subIssue + '\'' +
				", company='" + company + '\'' +
				", state='" + state + '\'' +
				", ZIPcode='" + ZIPcode + '\'' +
				", submittedVia='" + submittedVia + '\'' +
				", dateSentToCompany='" + dateSentToCompany + '\'' +
				", companyResponseToConsumer='" + companyResponseToConsumer + '\'' +
				", timelyResponse='" + timelyResponse + '\'' +
				", consumerDisputed='" + consumerDisputed + '\'' +
				'}';
	}
}
