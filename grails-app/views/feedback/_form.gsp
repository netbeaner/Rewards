<div class="fieldcontain">
	<labelfor"firstName"> First Name </label> 
	<g:textField name="firstName" value="${firstName}" />
</div>

<div class="fieldcontain">
	<labelfor"comments"> Comments </label> 
	<g:textArea name="comments" value="${comments}" />
</div>

<div class="fieldcontain">
	<labelfor"password">Password</label> 
	<g:passwordField name="password" value="${password}" />
</div>

<div class="fieldcontain">
	<labelfor"notify">Do you want to receive e-mail notifications?</label> 
	<g:checkBox name="notify" value="${notify}" />
</div>

<div class="fieldcontain">
	<labelfor"notify">Gender</label> 
	<g:radioGroup name="gender" labels="['Male','Female']" values="['M','F']" value="${gender}">
	${it.label} ${it.radio}
	 </g:radioGroup>
</div>

<div class="fieldcontain">
	<labelfor"marketing">How did you hear about us?</label> 
	<g:select from="['Internet','Friend','Other']" name ="marketing" value="${marketing}"/>
	
</div>