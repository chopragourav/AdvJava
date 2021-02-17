<%@page import="java.util.Date"%>
<%!public String generateWishMessage(String user) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
		//generate wish message
		if (hour < 12)
			return "Good Morning  :  " + user;
		else if (hour < 16)
			return "Good Afternoon  :  " + user;
		else if (hour < 20)
			return "Good Evening  :  " + user;
		else
			return "Good Night  :  " + user;
	}
	%>
	<body bgcolor="black">
	<h1 style="color: red; text-align: center;">WelCome to Jsp</h1>
	<br>
	<h2 style="color: blue; text-align: center;">Date and Time is :: <%=new java.util.Date() %>
	<br>
	<% String user=request.getParameter("uname"); %>
	<br>
	<h3 style="color: green; text-align: center;">The Wish Message is :: <%=generateWishMessage(user) %></h3>
	</body>