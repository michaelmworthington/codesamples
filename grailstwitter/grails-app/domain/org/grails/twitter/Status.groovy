package org.grails.twitter

import org.grails.twitter.auth.Person

class Status {

	String message
	Person author
	Date dateCreated
	//static belongsTo = Person //if status was linked to persons, this cascades deletes if the person is deleted
	
	//sample possibly dumb validations
	static constraints = 
	{
		message size: 2..141, matches: /q.*/
	}
}
