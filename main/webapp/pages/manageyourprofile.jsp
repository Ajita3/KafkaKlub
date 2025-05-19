<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Your Profile</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/styles.css">
    <link rel="stylesheet" type="text/css" href="../css/manageyourprofile.css" />
</head>
<body>
     <jsp:include page="header.jsp" />
    <div class="container">
        <div class="profile-container">
            <h1>Manage Your Profile</h1>

            <c:if test="${not empty success}">
                <p class="success-message"><c:out value="${success}" /></p>
            </c:if>
            <c:if test="${not empty error}">
                <p class="error-message"><c:out value="${error}" /></p>
            </c:if>

            <div class="profile-image-container">
                <c:if test="${not empty loggedInUser.profileImage}">
                    <img src="<%=request.getContextPath()%>/resources/images/profile_images/${loggedInUser.profileImage}" alt="Profile Image" class="profile-image">
                </c:if>
            </div>

            <form action="<%=request.getContextPath()%>/profile/update" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" value="${loggedInUser.name}" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" value="${loggedInUser.email}" required readonly>
                    <small>Email cannot be changed.</small>
                </div>
                <div class="form-group">
                    <label for="profileImageFile">Upload New Profile Image:</label>
                    <input type="file" id="profileImageFile" name="profileImageFile">
                </div>
                <div class="button-container">
                    <button type="submit" class="button">Update Profile</button>
                </div>
            </form>

            <div class="change-password">
                <h2>Change Password</h2>
                <form action="<%=request.getContextPath()%>/profile/updatePassword" method="post">
                    <div class="form-group">
                        <label for="currentPassword">Current Password:</label>
                        <input type="password" id="currentPassword" name="currentPassword" required>
                    </div>
                    <div class="form-group">
                        <label for="newPassword">New Password:</label>
                        <input type="password" id="newPassword" name="newPassword" required>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm New Password:</label>
                        <input type="password" id="confirmPassword" name="confirmPassword" required>
                    </div>
                    <div class="button-container">
                        <button type="submit" class="button">Change Password</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>