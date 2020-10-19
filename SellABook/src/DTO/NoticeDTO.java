package DTO;

public class NoticeDTO {
	
	String content;
	String date;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "NoticeDTO [content=" + content + ", date=" + date + "]";
	}
	
	
	
	
}
