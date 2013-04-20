<html>
<head>
<meta name="layout" content="main" />
<title>What Are You Doing?</title>
<g:javascript library="prototype" />
</head>
<body>
	<h1>Search For People To Follow</h1>
	<div class="searchForm">
		<g:form controller="searchable" name="userSearchForm">
			<g:textField name="q" value="" />
			<g:submitButton name="Search For Users" id="search_for_users_button" />
		</g:form>
	</div>

	<h1>What Are You Doing?</h1>

	<div class="updateStatusForm">
		<g:formRemote url="[action: 'updateStatus']" update="messages"
			name="updateStatusForm"
			onSuccess="document.updateStatusForm.message.value='';">
			<g:textArea name="message" value=""></g:textArea>
			<br />
			<g:submitButton name="Update Status" id="update_status_button" />
		</g:formRemote>
	</div>
	<div id="messages">
		<g:render template="messages" collection="${messages}" var="message" />
	</div>

</body>
</html>