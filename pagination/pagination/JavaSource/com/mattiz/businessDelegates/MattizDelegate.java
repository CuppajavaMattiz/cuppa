package com.mattiz.businessDelegates;

import java.util.ArrayList;

import com.mattiz.Exception.MattizException;
import com.mattiz.beans.AuthorDTO;
import com.mattiz.dao.MattizDAO;

public class MattizDelegate {
	MattizDAO mattizDAO;

	public MattizDelegate() {
		mattizDAO = new MattizDAO();
	}

	public void addAuthor(AuthorDTO author) throws MattizException {
		mattizDAO.addAuthor(author);
	}

	public ArrayList getAuthors(int start, int end) throws MattizException {
		ArrayList authorArray = mattizDAO.getAuthors(start, end);
		return authorArray;
	}

	public int getNumberOfRows() throws MattizException {
		int rowCount = mattizDAO.getNumberOfRows();
		return rowCount;
	}
}
