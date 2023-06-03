package deseralization_pojo;

import java.util.List;

public class Get_list_users {

	//	{
	//	    "page": 2,
	//	    "per_page": 6,
	//	    "total": 12,
	//	    "total_pages": 2,
	//	    "data": [
	//	        {
	//	            "id": 7,
	//	            "email": "michael.lawson@reqres.in",
	//	            "first_name": "Michael",
	//	            "last_name": "Lawson",
	//	            "avatar": "https://reqres.in/img/faces/7-image.jpg"
	//	        },
	//		{
	//        "id": 12,
	//        "email": "rachel.howell@reqres.in",
	//        "first_name": "Rachel",
	//        "last_name": "Howell",
	//        "avatar": "https://reqres.in/img/faces/12-image.jpg"
	//    	}
	//			],
	//		"support": {
	//    		"url": "https://reqres.in/#support-heading",
	//    		"text": "To keep ReqRes free, contributions towards server costs are appreciated!"
	//}

	private String page;
	private String per_page;
	private String total;
	private String total_pages;
	private List <DataPOJO> data;
	private SupportPOJO support;
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPer_page() {
		return per_page;
	}
	public void setPer_page(String per_page) {
		this.per_page = per_page;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(String total_pages) {
		this.total_pages = total_pages;
	}
	public List<DataPOJO> getData() {
		return data;
	}
	public void setData(List<DataPOJO> data) {
		this.data = data;
	}
	public SupportPOJO getSupport() {
		return support;
	}
	public void setSupport(SupportPOJO support) {
		this.support = support;
	}
	@Override
	public String toString() {
		return "Get_list_users [page=" + this.page + ", per_page=" + this.per_page + ", total=" + this.total + ", total_pages="
				+ this.total_pages + ", data=" + this.data + ", support=" + this.support + "]";
	}	
}
