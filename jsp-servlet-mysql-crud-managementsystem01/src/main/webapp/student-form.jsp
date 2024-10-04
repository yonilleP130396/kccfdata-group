<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Student Management Application</title>
           <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    <!-- Custom CSS -->
		    <style>
		        /* Custom styles */
		        body, h1, h2, h3, h4, h5, h6, p, a, button, input, select, textarea {
		            font-family: 'Roboto', sans-serif !important;
		        }
		       
			</style>
        </head>

        <body>
        
        <jsp:include page="header.jsp" />

            <br>
            <div class="container is-max-desktop">
			    <div class="card">
			        <div class="card-content">
			            <c:if test="${user != null}">
			                <form action="update" method="post">
			            </c:if>
			            <c:if test="${user == null}">
			                <form action="insert" method="post">
			            </c:if>
			
			            <div class="content">
			                <h2 class="title is-4">
			                    <c:if test="${user != null}">
			                        Edit Student
			                    </c:if>
			                    <c:if test="${user == null}">
			                        Add New Student
			                    </c:if>
			                </h2>
			            </div>
			
			            <c:if test="${user != null}">
			                <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
			            </c:if>
			
			            <div class="field">
			                <label class="label">User Name</label>
			                <div class="control">
			                    <input class="input" type="text" value="<c:out value='${user.name}' />" name="name" required="required">
			                </div>
			            </div>
			
			            <div class="field">
			                <label class="label">Address</label>
			                <div class="control">
			                    <input class="input" type="text" value="<c:out value='${user.address}' />" name="address">
			                </div>
			            </div>
			
			            <div class="field">
			                <label class="label">Course</label>
			                <div class="control">
			                    <input class="input" type="text" value="<c:out value='${user.course}' />" name="course">
			                </div>
			            </div>
			
			            <div class="field">
			                <label class="label">Gender</label>
			                <div class="control">
			                    <input class="input" type="text" value="<c:out value='${user.gender}' />" name="gender">
			                </div>
			            </div>
			
			            <div class="field">
			                <label class="label">Position</label>
			                <div class="control">
			                    <input class="input" type="text" value="<c:out value='${user.position}' />" name="posistion">
			                </div>
			            </div>
			
			            <div class="field">
			                <label class="label">Remarks</label>
			                <div class="control">
			                    <input class="input" type="text" value="<c:out value='${user.remarks}' />" name="remarks">
			                </div>
			            </div>
			
			            <div class="field">
			                <label class="label">Photo URL</label>
			                <div class="control">
			                    <input class="input" type="text" value="<c:out value='${user.picturelocation}' />" name="picturelocation">
			                </div>
			            </div>
			
			            <div class="control">
			                <button type="submit" class="button is-success">Save</button>
			            </div>
			            </form>
			        </div>
			    </div>
			</div>

        </body>

        </html>