<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE html>
        <html>

        <head>
            <title>Gratefulness Management System</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    <!-- Custom CSS -->
		    <style>
		        /* Custom styles */
		        body, h1, h2, h3, h4, h5, h6, p, a, button, input, select, textarea {
		            font-family: 'Roboto', sans-serif !important;
		        }
		        table.is-bordered {
				    border: 1px solid #ccc; /* Add border to the table */
				}
				
				table.is-bordered th,
				table.is-bordered td {
				    border: 1px solid #ccc; /* Add border to table headers and cells */
				}
		    </style>
        </head>

        <body>
        	<jsp:include page="check-session.jsp" />
			<jsp:include page="header.jsp" />
            
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                   <div class="columns is-vcentered">
				        <div class="column is-four-fifths">
				            <h1 class="title is-4">List of Students</h1>
				        </div>
				        <div class="column">
				            <!-- Search form -->
				            <form class="form-inline" id="searchForm">
				                <div class="field has-addons">
				                    <div class="control">
				                        <input class="input" type="search" placeholder="Search" aria-label="Search" id="searchInput">
				                    </div>
				                    <div class="control">
				                        <button class="button is-success" type="submit">Search</button>
				                    </div>
				                </div>
				            </form>
				        </div>
				    </div>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Student</a>
                    </div>
                    <br>
                    <table class="table is-striped is-bordered" id="dataTable">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Course</th>
                                <th>Gender</th>
                                <th>Position</th>
                                <th>Remarks</th>
                                <th>Photo</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="student" items="${listUser}">

                                <tr>
                                    <td>
                                        <c:out value="${student.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.address}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.course}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.gender}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.position}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.remarks}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.picturelocation}" />
                                    </td>
                                   <td>
									    <form action="<%=request.getContextPath()%>/edit" method="post">
									        <input type="hidden" name="id" value="${student.id}">
									        <button type="submit" class="button is-primary">Edit</button>
									    </form>
									</td>
									<td>
									    <form action="<%=request.getContextPath()%>/delete" method="post">
									        <input type="hidden" name="id" value="${student.id}">
									        <button type="submit" class="button is-danger">Delete</button>
									    </form>
									</td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
            
            
            
            
            <script>
				//JavaScript for filtering data based on search input
				document.getElementById('searchForm').addEventListener('submit', function(e) {
				    e.preventDefault(); // Prevent form submission
				    
				    let searchInput = document.getElementById('searchInput').value.toLowerCase();
				    let tableRows = document.querySelectorAll('#dataTable tbody tr');
				    
				    tableRows.forEach(function(row) {
				        let rowData = row.textContent.toLowerCase();
				        if (rowData.includes(searchInput)) {
				            row.style.display = ''; // Show row if match is found
				        } else {
				            row.style.display = 'none'; // Hide row if no match is found
				        }
				    });
				});
				</script>
            
            
            
            
        </body>

        </html>