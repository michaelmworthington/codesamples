package org.grails.twitter

import org.grails.twitter.auth.Person

class StatusController {

	def springSecurityService

	def index = {
		def messages = currentUserTimeline()
		[ messages: messages ]
	}

	def updateStatus = {
		def status = new Status(message: params.message) //from the gsp form
		status.author = lookupPerson()
		//GORM automatically initializes the "dateCreated" property
		status.save()
		def messages = currentUserTimeline()
		render template: 'messages', collection: messages, var: 'message'
	}

	def follow = {
		def per = Person.get(params.id)
		if(per){
			def currentUser = lookupPerson()
			currentUser.addToFollowed(per)
			currentUser.save()
		}
		redirect action: 'index'
	}


	private currentUserTimeline() {
		def per = lookupPerson()
		def messages = Status.withCriteria {
			or {
				author {  eq 'username', springSecurityService.principal.username  }
				if(per.followed){
					inList 'author', per.followed
				}
			}
			maxResults(10)
			order 'dateCreated', 'desc'
		}
		messages
	}

	private lookupPerson() {
		Person.get(springSecurityService.principal.id) //the currently logged in user
	}
}
