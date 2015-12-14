<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adventures of Kobe</title>
<link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.5/darkly/bootstrap.min.css" rel="stylesheet" integrity="sha256-IsefKVCcMUlgpXQgIMRsqbIqC6aP153JkybxTa7W7/8= sha512-mCNEsmR1i3vWAq8hnHfbCCpc6V5fP9t0N1fEZ1wgEPF/IKteFOYZ2uk7ApzMXkT71sDJ00f9+rVMyMyBFwsaQg==" crossorigin="anonymous">
<link href="style.css" rel="stylesheet" type="text/css">

</head>

<body>
	<section id="top">
		<h1>Adventures of Kobe</h1>
	</section>


	<div class="tbl">
		<h1>Leader Board</h1>
		<table class="table table-hover">
			<thead>
	      		<tr>
	        		<th id="name">NAME</th>
	        		<th>GOLD</th>
	       			<th>SCORE</th>
	      		</tr>
	    	</thead>
	    	<tbody>
     		<c:forEach items="${players}" var="player">
				<tr>
					<td id="name"><c:out value="${player.getName()}" /></td>
					<td><c:out value="${player.getGold()}" /></td>
					<td><c:out value="${player.getScore()}" /></td>
				</tr>
			</c:forEach>
	    	</tbody>
    	</table>
	</div>
	
	<section id="bottom">
		    	<a href="https://play.google.com/store/apps/details?id=com.mygdx.runrunrun.android&utm_source=global_co&utm_medium=prtnr&utm_content=Mar2515&utm_campaign=PartBadge&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1" target="_blank"><img alt="Get it on Google Play" src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" /></a>
	</section>

</body>
</html>