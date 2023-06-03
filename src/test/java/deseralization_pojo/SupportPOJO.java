package deseralization_pojo;

public class SupportPOJO {
	
//	"support": {
//	"url": "https://reqres.in/#support-heading",
//	"text": "To keep ReqRes free, contributions towards server costs are appreciated!"
	
	private String url;
	private String text;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	@Override
	public String toString() {
		return "SupportPOJO [url=" + this.url + ", text=" + this.text + "]";
	}	
}
