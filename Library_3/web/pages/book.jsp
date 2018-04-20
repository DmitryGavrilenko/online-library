<%-- 
    Document   : book
    Created on : Jan 11, 2018, 11:02:17 AM
    Author     : diskj
--%>

<%@page import="com.enums.SearchType"%>
<%@page import="com.database.Book"%>
<%@page import="com.database.BookList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../WEB-INF/jspf/left_bar.jspf"%>
<!DOCTYPE html>
<div id="content">
    <%request.setCharacterEncoding("UTF-8");%>
    <jsp:useBean id="bookList" class="com.database.BookList" scope="page">
        <%
            session = request.getSession();
            long genreId = 0L;
            String genreName = new String();
            String letter = new String();
            String search = new String();
            String select = new String();
            ArrayList<Book> list = new ArrayList<Book>();
        %>
        
        <%
            if (request.getParameter("genreId") != null) {
                genreId = Long.valueOf(request.getParameter("genreId"));
                genreName = request.getParameter("genreName");
                list = bookList.getBooksByGenre(genreId);
        %> 
        <h2 id="genreName"><%=genreName%></h2>
        <%
        } else if (request.getParameter("letter") != null) {
            letter = request.getParameter("letter");
            list = bookList.getBooksByLetter(letter);
        %> 
        <h2 id="genreName">Найдено <%=list.size()%></h2>
        <%
        } else if (request.getParameter("search") != null) {
            search = request.getParameter("search");
            SearchType type = SearchType.TITLE;
            if (request.getParameter("select").equals("Автор")) {
                type = SearchType.AUTHOR;
            }
            list = bookList.getBooksBySearch(search, type);
        %> 
        <h2 id="genreName">Найдено <%=list.size()%></h2>
        <%}%>
        <%
            session.setAttribute("bookList", list);
            for (Book books : list) {%>
                <div id="content_books">
                <div id="title"><strong><%=books.getName()%></strong></div>
                <img src="<%=request.getContextPath()%>/GetImage?index=<%=list.indexOf(books)%>"  height="175px" width="125px" alt="<%=books.getName()%>" id="book_image">
                <div id="book_desc">
                    <strong>Жанр:</strong><%=books.getGenre()%><br>
                    <strong>Автор:</strong><%=books.getAuthor()%><br>
                    <strong>К-во страниц:</strong><%=books.getPageCount()%><br>
                    <strong>ISBN:</strong><%=books.getIsbn()%><br>
                </div>
                <p class="read">
                    <a class="read" href="<%=request.getContextPath()%>/GetBook?index=<%=list.indexOf(books)%>">Читать</a>
                </p>
                </div>
        <%}%>
    </div>
</jsp:useBean>


