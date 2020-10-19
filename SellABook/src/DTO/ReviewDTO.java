package DTO;

public class ReviewDTO {

	private int num;
	private String writer;
	private String content;
	private String date;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setComment(String content) {
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
		return "CommentDTO [num=" + num + ", writer=" + writer + ", comment=" + content + ", date=" + date + "]";
	}
	
	
	
}