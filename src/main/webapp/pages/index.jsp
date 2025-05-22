<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Report Application</title>
    <!-- Bootstrap CSS for styling -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <h3 class="pb-3 pt-3 text-primary">Report Application</h3>

    <!-- Search Form -->
    <form:form action="search" method="post" modelAttribute="search">
        <table class="table">
            <tr>
                <td><b>Plan Name:</b></td>
                <td>
                    <form:select path="planName">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${names}" />
                    </form:select>
                </td>
                <td><b>Plan Status:</b></td>
                <td>
                    <form:select path="planStatus">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${status}" />
                    </form:select>
                </td>
                <td><b>Gender:</b></td>
                <td>
                    <form:select path="gender">
                        <form:option value="">-Select-</form:option>
                        <form:option value="Male">Male</form:option>
                        <form:option value="Female">Female</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><b>Start Date:</b></td>
                <td><form:input path="startDate" type="date" /></td>
                <td><b>End Date:</b></td>
                <td><form:input path="endDate" type="date" /></td>
            </tr>
            <tr>
                <td>
                    <a href="/" class="btn btn-secondary">Reset</a>
                </td>
                <td colspan="4">
                    <input type="submit" value="Search" class="btn btn-primary" />
                </td>
                
            </tr>
        </table>
    </form:form>

    <hr/>

    <!-- Display Results if any -->
    <c:if test="${not empty plans}">
        <table class="table table-striped ">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Holder Name</th>
                    <th>Gender</th>
                    <th>Plan Name</th>
                    <th>Plan Status</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Benefit Amount</th>
                  
                </tr>
            </thead>
            <tbody>
                <c:forEach var="plan" items="${plans}">
                    <tr>
                        <td>${plan.citizenId}</td>
                        <td>${plan.citizenName}</td>
                        <td>${plan.gender}</td>
                        <td>${plan.planName}</td>
                        <td>${plan.planStatus}</td>
                        <td>${plan.planStartDate}</td>
                        <td>${plan.planEndDate}</td>
                        <td>${plan.benefitAmount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <!-- No Data Message -->
    <c:if test="${empty plans}">
        <p>No records found for the selected filters. Please try again with different criteria.</p>
    </c:if>

    <hr/>
    <p>Export: <a href="#">Excel</a> | <a href="#">PDF</a></p>
</div>
</body>
</html>
