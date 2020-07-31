package com.mattiz.persistence.data;

import java.util.Set;

import com.mattiz.persistence.beans.BookWithMultipleAuthors;
import com.mattiz.persistence.beans.ContributingAuthor;

public interface MappingDAO {

	public Set<ContributingAuthor> getContributingAuthors(long isbnCode);

	public BookWithMultipleAuthors getBookForAuthor(long authorId);

	public void initializeDB();

}
