package com.mattiz.web.managedBeans;

import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mattiz.Exception.MattizException;
import com.mattiz.beans.AuthorDTO;
import com.mattiz.businessDelegates.MattizDelegate;

public class AuthorBean {
	private String isbnCode;

	private String author;

	private HttpServletRequest request;

	private HttpSession session;

	ArrayList authorsList;

	boolean hideNext;

	boolean hidePrevious;

	public boolean isHideNext() {
		return hideNext;
	}

	public void setHideNext(boolean hideNext) {
		this.hideNext = hideNext;
	}

	public boolean isHidePrevious() {
		return hidePrevious;
	}

	public void setHidePrevious(boolean hidePrevious) {
		this.hidePrevious = hidePrevious;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public String addAuthor() {
		AuthorDTO authorDTO = new AuthorDTO(getIsbnCode());
		authorDTO.setAuthor(getAuthor());
		MattizDelegate mattizDelegate = new MattizDelegate();
		try {
			mattizDelegate.addAuthor(authorDTO);
		} catch (MattizException me) {

		}
		return "authorAdded";
	}

	public String displayAuthors() {
		FacesContext context = FacesContext.getCurrentInstance();
		request = (HttpServletRequest) context.getExternalContext()
				.getRequest();
		session = request.getSession();
		MattizDelegate mattizDelegate = new MattizDelegate();
		try {
			int start = 1;
			int end = 10;
			if (request.getParameter("begin") != null) {
				start = Integer.parseInt(request.getParameter("begin"));
			}
			if (request.getParameter("finish") != null) {
				end = Integer.parseInt(request.getParameter("finish"));
			}
			authorsList = mattizDelegate.getAuthors(start, end);
			int count = 0;
			String change = "incr";
			if (request.getParameter("no") != null) {
				count = Integer.parseInt(request.getParameter("no"));
			}
			int totalRows = mattizDelegate.getNumberOfRows();
			if (request.getParameter("change") != null) {
				change = request.getParameter("change").toString();
			}
			if (change.equals("incr")) {
				request.setAttribute("count", new Integer(count
						+ authorsList.size()));
			} else if (change.equals("decr")) {
				request.setAttribute("count", new Integer(end));
			}
			request.setAttribute("start", new Integer(start));
			request.setAttribute("end", new Integer(end));
			request.setAttribute("totRows", new Integer(totalRows));
		} catch (MattizException me) {

		}
		return "paginateAuthors";
	}

	public ArrayList getAuthorsList() {
		return authorsList;
	}

	public void setAuthorsList(ArrayList authorsList) {
		this.authorsList = authorsList;
	}
}
