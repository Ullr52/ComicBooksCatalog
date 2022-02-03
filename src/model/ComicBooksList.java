package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jword - jord CIS175 - Spring - 2022 Jan 28, 2022
 */
@Entity
@Table(name = "comicbooks")
public class ComicBooksList {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "ISSUENUM")
	private String issueNum;
	@Column(name = "PUBLISHER")
	private String publisher;
	@Column(name = "SERIESTITLE")
	private String seriesTitle;
	@Column(name = "AUTHOR")
	private String author;
	@Column(name = "ILLUSTRATOR")
	private String illustrator;

	/**
	 * 
	 */
	public ComicBooksList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param issueNum
	 * @param publisher
	 * @param seriesTitle
	 * @param author
	 * @param illustrator
	 */
	public ComicBooksList(int id, String issueNum, String publisher, String seriesTitle, String author,
			String illustrator) {
		super();
		this.id = id;
		this.issueNum = issueNum;
		this.publisher = publisher;
		this.seriesTitle = seriesTitle;
		this.author = author;
		this.illustrator = illustrator;
	}

	public ComicBooksList(String issueNum, String publisher, String seriesTitle, String author, String illustrator) {
		super();
		this.issueNum = issueNum;
		this.publisher = publisher;
		this.seriesTitle = seriesTitle;
		this.author = author;
		this.illustrator = illustrator;
	}

	/**
	 * @param issueNum
	 * @param publisher
	 * @param seriesTitle
	 */
	public ComicBooksList(String issueNum, String publisher, String seriesTitle) {
		// TODO Auto-generated constructor stub
		super();
		this.issueNum = issueNum;
		this.publisher = publisher;
		this.seriesTitle = seriesTitle;

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the issueNum to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the issueNum
	 */
	public String getIssueNum() {
		return issueNum;
	}

	/**
	 * @param issueNum the issueNum to set
	 */
	public void setIssueNum(String issueNum) {
		this.issueNum = issueNum;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the seriesTitle
	 */
	public String getSeriesTitle() {
		return seriesTitle;
	}

	/**
	 * @param seriesTitle the seriesTitle to set
	 */
	public void setSeriesTitle(String seriesTitle) {
		this.seriesTitle = seriesTitle;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the illustrator
	 */
	public String getIllustrator() {
		return illustrator;
	}

	/**
	 * @param illustrator the illustrator to set
	 */
	public void setIllustrator(String illustrator) {
		this.illustrator = illustrator;
	}

	@Override
	public String toString() {
		return "[ID] " + id + "Comics Found:  " + "Published by: " + publisher + ", Series Title: " + seriesTitle
				+ "Issue# " + issueNum + ", Written by: " + author + ", Illustrated by: " + illustrator + "]";
	}

	public String returnComicDetails() {
		return "Published by: " + this.publisher + ", Series Title: " + this.seriesTitle + ", Issue# " + this.issueNum
				+ ", Written By: " + this.author + ", Illustrated By: " + this.illustrator;
	}

}
